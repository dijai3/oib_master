package com.ikea.oibmb.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.ikea.oibmb.constants.OIBConstants;
import com.ikea.oibmb.mapper.POAMDataMapper;
import com.ikea.oibmb.mapper.PayrollDataMapper;
import com.ikea.oibmb.pojo.PAOMResponse;
import com.ikea.oibmb.pojo.Paom;
import com.ikea.oibmb.pojo.Person;
import com.ikea.oibmb.pojo.TokenRequest;
import com.ikea.oibmb.pojo.TokenResponse;
import com.ikea.oibmb.schema.OIBSchema;
import com.ikea.oibmb.service.PAOMService;
import com.ikea.oibmb.utils.SecretManagerUtils;

import org.springframework.http.HttpHeaders;
import java.util.Collections;
import org.springframework.http.MediaType;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.InsertAllRequest.Builder;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;

@Service
public class PAOMServiceImpl implements PAOMService {

    @Autowired
    private SecretManagerUtils utils;

    private String clientId;

    private String clientSecret;

    @Value("${application.client.audience}")
    private String audience;

    @Value("${application.client.granttype}")
    private String grantType;

    @Value("${application.client.contettype}")
    private String contentType;

    @Value("${application.auth.url}")
    private String authUrl;

    @Value("${application.paom.url}")
    private String poamURL;

    @Value("${spring.cloud.gcp.project-id}")
    private String projectId;

    @Autowired
    private BigQuery bigquery;

    @Value("${spring.cloud.gcp.bigquery.dataset-name}")
    private String dataSetName;

    @Value("${spring.cloud.gcp.poam.table-name}")
    private String paomTableName;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Person> getPAOMData() {
        try {
            OIBSchema schema = new OIBSchema();
            TableResult tableData = bigquery.listTableData(dataSetName, paomTableName, schema.getPAOMShema());
            POAMDataMapper mapper = new POAMDataMapper();
            return mapper.getPersonsFromQueryResult(tableData);
        } catch (BigQueryException e) {
            System.out.println("Query not performed \n" + e.toString());
        }
        return null;
    }


    private String getClientId(){
        Optional<String> checkNull = Optional.ofNullable(this.clientId);  
        if(!checkNull.isPresent()){
            this.clientId=utils.getSecretValue(OIBConstants.APPLICATION_OIB_API_KEY);
        }
        return this.clientId;
    }

    private String getClientSecret(){
        Optional<String> checkNull = Optional.ofNullable(this.clientSecret);
        if(!checkNull.isPresent()){
            this.clientSecret=utils.getSecretValue(OIBConstants.APPLICATION_OIB_CLIENT_KEY);
        }
        return this.clientSecret;
    }

    private TokenResponse getTokenResponse() {
        TokenRequest request = new TokenRequest();
        request.setClient_id(getClientId());
        request.setClient_secret(getClientSecret());
        request.setAudience(audience);
        request.setGrant_type(grantType);
        request.setContent_type(contentType);
        ResponseEntity<TokenResponse> postForEntity = restTemplate.postForEntity(authUrl, request, TokenResponse.class,
                new HashMap<String, String>());
        TokenResponse tokenResponse = postForEntity.getBody();
        tokenResponse.setTokenExpirationTime(
                LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond() + tokenResponse.getExpires_in());
        return tokenResponse;
    }

    private boolean isTokenExpired(TokenResponse tokenResponse) {
        return tokenResponse.getTokenExpirationTime() <= LocalDateTime.now().atZone(ZoneId.systemDefault())
                .toEpochSecond();
    }

    private String getToken() {
        TokenResponse tokenResponse = getTokenResponse();
        String token = tokenResponse.getAccess_token();
        if (isTokenExpired(tokenResponse)) {
            token = getTokenResponse().getAccess_token();
        }
        return token;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(getToken());
        headers.add(OIBConstants.API_KEY, getClientId());
        return headers;
    }

    private HttpEntity<String> getEntity() {
        return new HttpEntity<>("body", getHeaders());
    }

    @Override
    public void fetchDataFromPAOM() {

        boolean allPagesVisited = false;
        Long delta = 0L;
        for(int i=0;i<1;i++){
        // while (!allPagesVisited) {
            ResponseEntity<PAOMResponse> forEntity = restTemplate.exchange(
                    poamURL + "?recordLimit={limit}&delta={dValue}", HttpMethod.GET,
                    getEntity(), PAOMResponse.class, OIBConstants.PAGE_SIZE, delta);

            Long totalRecords = forEntity.getBody().getPeopleDomain().getPaom().getData().getTotalRecords();
            Long recordsFetched = forEntity.getBody().getPeopleDomain().getPaom().getData().getRecordsFetched();

            delta = forEntity.getBody().getPeopleDomain().getPaom().getData().getDelta();
            if (totalRecords <= recordsFetched) {
                allPagesVisited = true;
            }

            List<Person> persons = forEntity.getBody().getPeopleDomain().getPaom().getData().getPersons();
            InsertAllRequest.Builder builder = getBuilder(persons);
            InsertAllResponse response = bigquery.insertAll(builder.build());

            if (response.hasErrors()) {
                for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
                    System.out.println("Response error: \n" + entry.getValue());
                }
            }
        }
    }

    private Builder getBuilder(List<Person> persons) {
        TableId tableId = TableId.of(projectId, dataSetName, paomTableName);
        InsertAllRequest.Builder builder = InsertAllRequest.newBuilder(tableId);

        persons.forEach(person -> {
            Map<String, Object> rowContent = new HashMap<String, Object>();
            
            rowContent.put(OIBConstants.CountryCode, person.getCountryCode());
            rowContent.put(OIBConstants.PersonnelNumber, person.getPersonnelArea());
            rowContent.put(OIBConstants.GlobalID, person.getGlobalID());
            rowContent.put(OIBConstants.Firstname, person.getFirstName());
            rowContent.put(OIBConstants.Surname, person.getSurname());
            rowContent.put(OIBConstants.BirthDate, person.getBirthDate());
            rowContent.put(OIBConstants.JobTitle, person.getJobTitle());
            rowContent.put(OIBConstants.WorkEmailAddress, person.getWorkEmailAddress());
            rowContent.put(OIBConstants.JoiningDate, person.getJoiningDate());
            rowContent.put(OIBConstants.ServiceYearEntry, person.getServiceYearEntry());
            rowContent.put(OIBConstants.LeavingDate, person.getLeavingDate());
            rowContent.put(OIBConstants.IT01StartDate, person.getIt01StartDate());
            rowContent.put(OIBConstants.IT01EndDate, person.getIt01EndDate());
            rowContent.put(OIBConstants.PayrollArea, person.getPayrollArea());
            rowContent.put(OIBConstants.CompanyCode, person.getCompanyCode());
            rowContent.put(OIBConstants.CompanyName, person.getCompanyName());
            rowContent.put(OIBConstants.PersonnelArea, person.getPersonnelArea());
            rowContent.put(OIBConstants.PersonnelAreaName, person.getPersonnelAreaName());
            rowContent.put(OIBConstants.PersonnelSubarea, person.getPersonnelSubarea());
            rowContent.put(OIBConstants.EmployeeGroup, person.getEmployeeGroup());
            rowContent.put(OIBConstants.EmployeeSubgroup, person.getEmployeeSubgroup());
            rowContent.put(OIBConstants.CostCentre, person.getCostCentre());            
            rowContent.put(OIBConstants.GroupFunction, person.getGroupFunction());
            rowContent.put(OIBConstants.OIBLevel, person.getOibLevel());
            rowContent.put(OIBConstants.OIBLevelStartDate, person.getOIBLevelStartDate());
            rowContent.put(OIBConstants.OIBLevelEndDate, person.getOIBLevelEndDate());
            rowContent.put(OIBConstants.TackStatus, person.getTackStatus());
             // rowContent.put(OIBConstants.EmploymentStatus, person.ge());

            builder.addRow(rowContent);
        });

        return builder;
    }

}

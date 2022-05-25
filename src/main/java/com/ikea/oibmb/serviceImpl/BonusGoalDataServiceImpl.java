package com.ikea.oibmb.serviceImpl;

import com.ikea.oibmb.constants.OIBConstants;
import com.ikea.oibmb.mapper.BonusGoalDataMapper;
import com.ikea.oibmb.pojo.CapingHrs;
import com.ikea.oibmb.schema.OIBSchema;
import com.ikea.oibmb.service.BonusGoalDataService;

import com.ikea.oibmb.utils.FileUtility;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.InsertAllRequest.Builder;


@Service
public class BonusGoalDataServiceImpl implements BonusGoalDataService {

    @Autowired
    private Storage storage;

    @Value("${spring.cloud.gcp.cappinghrs.bucket-name}")
    private String bucketName;

    @Value("${spring.cloud.gcp.cappinghrs.file-name}")
    private String objectName;

    @Value("${spring.cloud.gcp.project-id}")
    private String projectId;

    @Value("${spring.cloud.gcp.bigquery.dataset-name}")
    private String dataSetName;

    @Value("${spring.cloud.gcp.cappinghrs.table-name}")
    private String tableName;

       
    @Override
    public List<CapingHrs> getCapingHrsList() {
        Blob blob = storage.get(BlobId.of(bucketName, objectName));
        BonusGoalDataMapper mapper = new BonusGoalDataMapper();
        File tempFile = FileUtility.getTempFileFromString(new String(blob.getContent()));
        CSVReader reader;
        List<CapingHrs> foreCastDataList = new ArrayList<>();
        try {
            reader = new CSVReader(new FileReader(tempFile));
            reader.skip(1);
            String [] nextLine;  
            while ((nextLine = reader.readNext()) != null)  {
                foreCastDataList.add(mapper.getCapingHrsFromString(nextLine));
            }         
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }       
        return foreCastDataList;
    }

    /*
    private void insertRecords(InsertAllRequest.Builder builder) {
        InsertAllResponse response = bigquery.insertAll(builder.build());
        if (response.hasErrors()) {
            for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
                System.out.println("Response error: \n" + entry.getValue());
            }
        }
    }

    private Builder getBuilder(List<CapingHrs> capingHrs) {
        TableId tableId = TableId.of(projectId, dataSetName, tableName);
        InsertAllRequest.Builder builder = InsertAllRequest.newBuilder(tableId);
        capingHrs.forEach(capingHr -> {
            Map<String, Object> rowContent = new HashMap<String, Object>();    
            rowContent.put(OIBConstants.Business_Unit, capingHr.getBusiness_Unit());
            rowContent.put(OIBConstants.FTE_Threshold, capingHr.getFTE_Threshold());
            rowContent.put(OIBConstants.Country, capingHr.getCountry());
            builder.addRow(rowContent);
        });
        return builder;
    }
    */ 
}

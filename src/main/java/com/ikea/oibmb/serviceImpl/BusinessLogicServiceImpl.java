package com.ikea.oibmb.serviceImpl;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.bigquery.core.BigQueryTemplate;
import org.springframework.stereotype.Service;

import com.google.cloud.Timestamp;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.ikea.oibmb.mapper.PayrollDataMapper;
import com.ikea.oibmb.pojo.Payroll;
import com.ikea.oibmb.schema.OIBSchema;
import com.ikea.oibmb.service.BusinessLogicService;

@Service
public class BusinessLogicServiceImpl implements BusinessLogicService {

    @Autowired
    private BigQuery bigquery;

    @Value("${spring.cloud.gcp.project-id}")
    private String projectId;

    @Value("${spring.cloud.gcp.bigquery.dataset-name}")
    private String dataSetName;

    @Value("${spring.cloud.gcp.payroll.table-name}")
    private String payrollTableName;

    @Value("${spring.cloud.gcp.output.table-name}")
    private String outputTable;


    @Override
    public List<Payroll> readDataFromBigquery() {

        String payrollQuery = "SELECT * \n"
                + " FROM `"
                + projectId
                + "."
                + dataSetName
                + "."
                + payrollTableName
                + "`"
                + " LIMIT 100";
        return readPayrollData(payrollQuery);

    }

    private List<Payroll> readPayrollData(String query) {
        try {
            QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
            OIBSchema schema = new OIBSchema();

            // TableResult results = bigquery.query(queryConfig);

            // TableResult tableData = bigquery.listTableData(dataSetName, payrollTableName, schema.getPayrollShema());
            PayrollDataMapper mapper = new PayrollDataMapper();

            // List<Payroll> list = mapper.getPayrollFromQueryResult(tableData);
             insertRecord();
            return null;
        } catch (BigQueryException e) {
            System.out.println("Query not performed \n" + e.toString());
        }
        // insertRecord();
        return null;
    }

    public void insertRecord() {
        TableId tableId = TableId.of(projectId, dataSetName, outputTable);

        InsertAllRequest.Builder builder = InsertAllRequest.newBuilder(tableId);
        

        for(int i=0;i<3;i++){
            Map<String, Object> rowContent = new HashMap<String, Object>();
            rowContent.put("EmployeeNumber", "MyTest_"+i);
            rowContent.put("BonusAmount", 100);
            rowContent.put("CurrentTime", Math.floor(new Date().getTime()/1000));
           
            builder.addRow(rowContent); 
        }
              

        InsertAllResponse response = bigquery.insertAll(builder.build());
        if (response.hasErrors()) {
            for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
              System.out.println("Response error: \n" + entry.getValue());
            }
          }

    }

}

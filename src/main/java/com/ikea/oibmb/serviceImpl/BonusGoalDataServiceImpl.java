package com.ikea.oibmb.serviceImpl;

import com.ikea.oibmb.constants.OIBConstants;
import com.ikea.oibmb.mapper.BonusGoalDataMapper;
import com.ikea.oibmb.pojo.CapingHrs;
import com.ikea.oibmb.service.BonusGoalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.TableId;
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

    @Autowired
    private BigQuery bigquery;

    @Override
    public void readfile() {
        Blob blob = storage.get(BlobId.of(bucketName, objectName));
        BonusGoalDataMapper mapper = new BonusGoalDataMapper();
        List<CapingHrs> capingHrs= mapper.getCapingHrsListFromFileContent(new String(blob.getContent()));       
        insertRecord(capingHrs);

    }

    private void insertRecord(List<CapingHrs> capingHrs) {
        InsertAllRequest.Builder builder = getBuilder(capingHrs);
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


    
}

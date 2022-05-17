package com.ikea.oibmb.serviceImpl;

import com.ikea.oibmb.constants.OIBConstants;
import com.ikea.oibmb.mapper.ForeCastDataMapper;
import com.ikea.oibmb.pojo.ForeCastData;
import com.ikea.oibmb.service.ForecastDataService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;
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
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.InsertAllRequest.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;


@Service
public class ForecastDataSeviceImpl implements ForecastDataService {

    @Autowired
    private Storage storage;

    @Value("${spring.cloud.gcp.forecast.bucket-name}")
    private String bucketName;

    @Value("${spring.cloud.gcp.forecast.file-name}")
    private String objectName;

    @Value("${spring.cloud.gcp.project-id}")
    private String projectId;

    @Value("${spring.cloud.gcp.bigquery.dataset-name}")
    private String dataSetName;

    @Value("${spring.cloud.gcp.forecast.table-name}")
    private String tableName;

    @Autowired
    private BigQuery bigquery;

    @Override
    public void readfile() {
        Blob blob = storage.get(BlobId.of(bucketName, objectName));
        ForeCastDataMapper mapper = new ForeCastDataMapper();
        File tempFile = getTempFileFromString(new String(blob.getContent()));
        CSVReader reader;
        List<ForeCastData> foreCastDataList = new ArrayList<>();
        try {
            reader = new CSVReader(new FileReader(tempFile));
            reader.skip(1);
            String [] nextLine;  
            while ((nextLine = reader.readNext()) != null)  {
                foreCastDataList.add(mapper.getForeCastFromString(nextLine));
            }         
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        insertRecord(foreCastDataList);
    }

    private File getTempFileFromString(String fileContent){
        File file=null;
        try {
            file = File.createTempFile("temp", ".csv");
            FileUtils.writeStringToFile(file, fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return file;
    }

    private void insertRecord(List<ForeCastData> foreCastData) {
        InsertAllRequest.Builder builder = getBuilder(foreCastData);
        InsertAllResponse response = bigquery.insertAll(builder.build());
        if (response.hasErrors()) {
            for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
                System.out.println("Response error: \n" + entry.getValue());
            }
        }
    }

    private Builder getBuilder(List<ForeCastData> foreCastData) {
        TableId tableId = TableId.of(projectId, dataSetName, tableName);
        InsertAllRequest.Builder builder = InsertAllRequest.newBuilder(tableId);
        foreCastData.forEach(data -> {
            Map<String, Object> rowContent = new HashMap<String, Object>();
            rowContent.put(OIBConstants.Business_Unit, data.getBusiness_Unit());
            rowContent.put(OIBConstants.Value, data.getValue());
            rowContent.put(OIBConstants.Country, data.getCountry());
            builder.addRow(rowContent);
        });
        return builder;
    }

}

package com.ikea.oibmb.serviceImpl;

import java.util.List;
import com.ikea.oibmb.pojo.Payroll;
import com.ikea.oibmb.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.TableResult;
import com.ikea.oibmb.mapper.PayrollDataMapper;
import com.ikea.oibmb.schema.OIBSchema;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private BigQuery bigquery;

    @Value("${spring.cloud.gcp.bigquery.dataset-name}")
    private String dataSetName;

    @Value("${spring.cloud.gcp.payroll.table-name}")
    private String payrollTableName;

    @Override
    public List<Payroll> getPayrollData() {
        try {
            OIBSchema schema = new OIBSchema();
            TableResult tableData = bigquery.listTableData(dataSetName, payrollTableName, schema.getPayrollShema());
            PayrollDataMapper mapper = new PayrollDataMapper();
            return mapper.getPayrollFromQueryResult(tableData);
        } catch (BigQueryException e) {
            System.out.println("Query not performed \n" + e.toString());
        }
        return null;
    }
}

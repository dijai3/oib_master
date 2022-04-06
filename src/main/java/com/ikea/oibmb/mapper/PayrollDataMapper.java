package com.ikea.oibmb.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.TableResult;
import com.ikea.oibmb.constants.OIBConstants;
import com.ikea.oibmb.pojo.Payroll;

public class PayrollDataMapper {

    public List<Payroll> getPayrollFromQueryResult(TableResult results) {
        List<Payroll> payrollList = new ArrayList<>();
        results.iterateAll().forEach(line -> {
            payrollList.add(getPayrollObject(line));
        });
        return payrollList;
    }

    private Payroll getPayrollObject(FieldValueList line) {
        Payroll payroll = new Payroll();
        payroll.setEmployeeNumber(line.get(OIBConstants.EMPLOYEENUMBER).getValue().toString());
        payroll.setM9C1BU(line.get(OIBConstants.M9C1BU).getValue().toString());
        payroll.setM9C1CostCentre(line.get(OIBConstants.M9C1COSTCENTRE).getValue().toString());
        payroll.setM9C1HourlyRate(Integer.parseInt(line.get(OIBConstants.M9C1HOURLYRATE).getValue().toString()));
        payroll.setM9C1TWH(Float.parseFloat(line.get(OIBConstants.M9C1TWH).getValue().toString()));
        if (Optional.ofNullable(line.get(OIBConstants.M9C1DEDUCTEDHOURS).getValue()).isPresent())
            payroll.setM9C1DeductedHours(line.get(OIBConstants.M9C1DEDUCTEDHOURS).getValue().toString());
        else
            payroll.setM9C1DeductedHours(null);
        payroll.setM9C1Level(Integer.parseInt(line.get(OIBConstants.M9C1LEVEL).getValue().toString()));
        payroll.setM10C1BU(line.get(OIBConstants.M10C1BU).getValue().toString());
        payroll.setM10C1CostCentre(line.get(OIBConstants.M10C1COSTCENTRE).getValue().toString());
        if (Optional.ofNullable(line.get(OIBConstants.M10C1HOURLYRATE).getValue()).isPresent())
            payroll.setM10C1HourlyRate(Integer.parseInt(line.get(OIBConstants.M10C1HOURLYRATE).getValue().toString()));
        else
            payroll.setM10C1HourlyRate(0);
        payroll.setM10C1TWH(Float.parseFloat(line.get(OIBConstants.M10C1TWH).getValue().toString()));
        return payroll;
    }

}

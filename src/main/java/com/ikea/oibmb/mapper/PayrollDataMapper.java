package com.ikea.oibmb.mapper;

import java.util.ArrayList;
import java.util.List;
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
        payroll.setPersonalNumber(Integer.parseInt(line.get(OIBConstants.PERSONNEL_NUMBER).getValue().toString()));
        payroll.setPersonnelArea(Integer.parseInt(line.get(OIBConstants.PERSONNEL_AREA).getValue().toString()));
        payroll.setPersonnelSubArea(Integer.parseInt(line.get(OIBConstants.PERSONNEL_SUBAREA).getValue().toString()));
        payroll.setCostCenter(line.get(OIBConstants.COST_CENTER).getValue().toString());
        payroll.setForPeriodPayroll(Integer.parseInt(line.get(OIBConstants.FOR_PERIOD_PAYROLL).getValue().toString()));
        payroll.setPC205Assignment(Integer.parseInt(line.get(OIBConstants.PC205_ASSIGNMENT).getValue().toString()));
        payroll.setWageType(line.get(OIBConstants.WAGE_TYPE).getValue().toString());
        payroll.setNumberOfHours(Float.parseFloat(line.get(OIBConstants.NUMBER_OF_HOURS).getValue().toString()));
        payroll.setRate(Float.parseFloat(line.get(OIBConstants.RATE).getValue().toString()));
        payroll.setAmount(Float.parseFloat(line.get(OIBConstants.AMOUNT).getValue().toString()));
        return payroll;
    }

}

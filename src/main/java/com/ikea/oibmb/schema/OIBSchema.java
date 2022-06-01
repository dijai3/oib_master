package com.ikea.oibmb.schema;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.ikea.oibmb.constants.OIBConstants;

public class OIBSchema {

    public Schema getPayrollShema() {
        Schema schema = Schema.of(
                Field.of(OIBConstants.PERSONNEL_NUMBER, StandardSQLTypeName.INT64),
                Field.of(OIBConstants.PERSONNEL_AREA, StandardSQLTypeName.INT64),
                Field.of(OIBConstants.PERSONNEL_SUBAREA, StandardSQLTypeName.INT64),
                Field.of(OIBConstants.COST_CENTER, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.FOR_PERIOD_PAYROLL, StandardSQLTypeName.INT64),
                Field.of(OIBConstants.PC205_ASSIGNMENT, StandardSQLTypeName.INT64),
                Field.of(OIBConstants.WAGE_TYPE, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.NUMBER_OF_HOURS, StandardSQLTypeName.FLOAT64),
                Field.of(OIBConstants.RATE, StandardSQLTypeName.FLOAT64),
                Field.of(OIBConstants.AMOUNT, StandardSQLTypeName.FLOAT64));
        return schema;
    }

    public Schema getPAOMShema() {
        Schema schema = Schema.of(
                Field.of(OIBConstants.CountryCode, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.PersonnelNumber, StandardSQLTypeName.INT64),                
                Field.of(OIBConstants.GlobalID, StandardSQLTypeName.INT64),
                Field.of(OIBConstants.Firstname, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.Surname, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.BirthDate, StandardSQLTypeName.DATETIME),
                Field.of(OIBConstants.JobTitle, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.WorkEmailAddress, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.JoiningDate, StandardSQLTypeName.DATETIME),
                Field.of(OIBConstants.ServiceYearEntry, StandardSQLTypeName.DATETIME),         
                Field.of(OIBConstants.LeavingDate, StandardSQLTypeName.DATETIME),                
                Field.of(OIBConstants.IT01StartDate, StandardSQLTypeName.DATETIME),                
                Field.of(OIBConstants.IT01EndDate, StandardSQLTypeName.DATETIME),
                Field.of(OIBConstants.PayrollArea, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.CompanyCode, StandardSQLTypeName.INT64),
                Field.of(OIBConstants.CompanyName, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.PersonnelArea, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.PersonnelAreaName, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.PersonnelSubarea, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.EmployeeGroup, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.EmployeeSubgroup, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.CostCentre, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.GroupFunction, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.OIBLevel, StandardSQLTypeName.INT64),
                Field.of(OIBConstants.OIBLevelStartDate, StandardSQLTypeName.DATETIME),
                Field.of(OIBConstants.OIBLevelEndDate, StandardSQLTypeName.DATETIME),
                Field.of(OIBConstants.TackStatus, StandardSQLTypeName.STRING)        
                );
        return schema;
    }

    public Schema getForeCastShema() {
        Schema schema = Schema.of(
                Field.of(OIBConstants.Country, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.Business_Unit, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.Value, StandardSQLTypeName.FLOAT64));
        return schema;
    }

    public Schema getCapingHrsShema() {
        Schema schema = Schema.of(
                Field.of(OIBConstants.Country, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.Business_Unit, StandardSQLTypeName.INT64),
                Field.of(OIBConstants.FTE_Threshold, StandardSQLTypeName.INT64));
        return schema;
    }
}

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
                Field.of(OIBConstants.PersonId, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.EmployeeId, StandardSQLTypeName.STRING),                
                Field.of(OIBConstants.EmploymentStatus, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.CountryKey, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.CostCentre, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.BusinessUnit, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.EmailId, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.TerminationDate, StandardSQLTypeName.DATETIME),
                Field.of(OIBConstants.LegalFirstName, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.LegalLastName, StandardSQLTypeName.STRING),         
                Field.of(OIBConstants.CompanyCode, StandardSQLTypeName.STRING),                
                Field.of(OIBConstants.JobTitle, StandardSQLTypeName.STRING),                
                Field.of(OIBConstants.BusinessUnitType, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.DateOfBirth, StandardSQLTypeName.DATETIME),
                Field.of(OIBConstants.CompanyName, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.PersonalArea, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.PersonalAreaName, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.PersonalSubArea, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.EmployeeGroup, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.EmployeeSubGroup, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.TackStatus, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.JoiningDate, StandardSQLTypeName.DATETIME),
                Field.of(OIBConstants.OIBLevel, StandardSQLTypeName.STRING),
                Field.of(OIBConstants.OIBLevelStartDate, StandardSQLTypeName.DATETIME),
                Field.of(OIBConstants.OIBLevelEndDate, StandardSQLTypeName.DATETIME),
                Field.of(OIBConstants.GroupFunction, StandardSQLTypeName.STRING)            
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

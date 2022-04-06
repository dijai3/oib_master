package com.ikea.oibmb.schema;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.ikea.oibmb.constants.OIBConstants;

public class OIBSchema {
    
    public Schema getPayrollShema(){

        Schema schema =
            Schema.of(
            Field.of(OIBConstants.EMPLOYEENUMBER, StandardSQLTypeName.STRING),
            Field.of(OIBConstants.M9C1BU, StandardSQLTypeName.STRING),
            Field.of(OIBConstants.M9C1COSTCENTRE, StandardSQLTypeName.STRING),
            Field.of(OIBConstants.M9C1HOURLYRATE, StandardSQLTypeName.INT64),
            Field.of(OIBConstants.M9C1TWH, StandardSQLTypeName.FLOAT64),
            Field.of(OIBConstants.M9C1DEDUCTEDHOURS, StandardSQLTypeName.STRING),
            Field.of(OIBConstants.M9C1LEVEL, StandardSQLTypeName.INT64),
            Field.of(OIBConstants.M10C1BU, StandardSQLTypeName.STRING),
            Field.of(OIBConstants.M10C1COSTCENTRE, StandardSQLTypeName.STRING),
            Field.of(OIBConstants.M10C1HOURLYRATE, StandardSQLTypeName.INT64),
            Field.of(OIBConstants.M10C1TWH, StandardSQLTypeName.FLOAT64));
            
            return schema;
    }

}

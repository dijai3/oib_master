package com.ikea.oibmb.mapper;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.TableResult;
import com.ikea.oibmb.constants.OIBConstants;
import com.ikea.oibmb.pojo.CapingHrs;

public class BonusGoalDataMapper {
    
    public CapingHrs getCapingHrsFromString(String[] strings){
        CapingHrs capingHrs = new CapingHrs();
        capingHrs.setBusiness_Unit(Integer.parseInt(strings[0]));
        capingHrs.setFTE_Threshold(Integer.parseInt(strings[1]));
        capingHrs.setCountry(strings[2]);
        return capingHrs;
    }

    public List<CapingHrs> getCapingHrsFromQueryResult(TableResult results) {
        List<CapingHrs> capingHrsList = new ArrayList<>();
        results.iterateAll().forEach(line -> {
            capingHrsList.add(getCapingHrsObject(line));
        });
        return capingHrsList;
    
      }
    
      private CapingHrs getCapingHrsObject(FieldValueList line) {
        CapingHrs capingHrs = new CapingHrs();
        capingHrs.setBusiness_Unit(Integer.parseInt(line.get(OIBConstants.Business_Unit).getValue().toString()));
        capingHrs.setCountry(line.get(OIBConstants.Country).getValue().toString());
        capingHrs.setFTE_Threshold(Integer.parseInt(line.get(OIBConstants.FTE_Threshold).getValue().toString()));
        return capingHrs;
      }
}

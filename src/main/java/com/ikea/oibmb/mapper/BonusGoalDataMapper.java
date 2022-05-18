package com.ikea.oibmb.mapper;

import com.ikea.oibmb.pojo.CapingHrs;

public class BonusGoalDataMapper {
    
    public CapingHrs getCapingHrsFromString(String[] strings){
        CapingHrs capingHrs = new CapingHrs();
        capingHrs.setBusiness_Unit(Integer.parseInt(strings[0]));
        capingHrs.setFTE_Threshold(Integer.parseInt(strings[1]));
        capingHrs.setCountry(strings[2]);
        return capingHrs;
    }
}

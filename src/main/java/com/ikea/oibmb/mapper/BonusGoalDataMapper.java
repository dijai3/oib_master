package com.ikea.oibmb.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.ikea.oibmb.pojo.CapingHrs;

public class BonusGoalDataMapper {
    
    public List<CapingHrs> getCapingHrsListFromFileContent(String content){
        String[] strarray= content.split("\n") ;
        String[] arrayWithoutFirstElement = Arrays.copyOfRange(strarray, 1, strarray.length);
        List<CapingHrs> list = new ArrayList<>();
        for (String row : arrayWithoutFirstElement) {
            CapingHrs capingHrs = getCapingHrsFromString(row.split(","));
            list.add(capingHrs);
        }
        return list;
    }

    private CapingHrs getCapingHrsFromString(String[] strings){
        CapingHrs capingHrs = new CapingHrs();
        capingHrs.setBusiness_Unit(Integer.parseInt(strings[0]));
        capingHrs.setFTE_Threshold(Integer.parseInt(strings[1]));
        capingHrs.setCountry(strings[2]);
        return capingHrs;
    }
}

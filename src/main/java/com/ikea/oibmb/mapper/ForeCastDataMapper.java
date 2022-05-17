package com.ikea.oibmb.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ikea.oibmb.pojo.ForeCastData;

public class ForeCastDataMapper {

    public List<ForeCastData> getForeCastListFromFileContent(String content) {
        String[] strarray = content.split("\n");
        String[] arrayWithoutFirstElement = Arrays.copyOfRange(strarray, 1, strarray.length);
        List<ForeCastData> list = new ArrayList<>();
        for (String row : arrayWithoutFirstElement) {
            ForeCastData foreCastData = getCapingHrsFromString(row.split(","));
            list.add(foreCastData);
        }
        return list;
    }


    

    private ForeCastData getCapingHrsFromString(String[] strings) {
        ForeCastData foreCastData = new ForeCastData();
        foreCastData.setCountry(strings[0]);
        foreCastData.setBusiness_Unit(strings[1]);
        foreCastData.setValue(Float.parseFloat(strings[2]));
        return foreCastData;
    }




    public ForeCastData getForeCastFromString(String[] nextLine) {
        ForeCastData foreCastData = new ForeCastData();
        foreCastData.setCountry(nextLine[0]);
        foreCastData.setBusiness_Unit(nextLine[1]);
        foreCastData.setValue(Float.parseFloat(nextLine[2]));
        return foreCastData;
    }

}

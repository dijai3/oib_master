package com.ikea.oibmb.mapper;

import com.ikea.oibmb.pojo.ForeCastData;

public class ForeCastDataMapper {

      public ForeCastData getForeCastFromString(String[] nextLine) {
        ForeCastData foreCastData = new ForeCastData();
        foreCastData.setCountry(nextLine[0]);
        foreCastData.setBusiness_Unit(nextLine[1]);
        foreCastData.setValue(Float.parseFloat(nextLine[2]));
        return foreCastData;
    }

}

package com.ikea.oibmb.mapper;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.TableResult;
import com.ikea.oibmb.constants.OIBConstants;
import com.ikea.oibmb.pojo.ForeCastData;

public class ForeCastDataMapper {

  public ForeCastData getForeCastFromString(String[] nextLine) {
    ForeCastData foreCastData = new ForeCastData();
    foreCastData.setCountry(nextLine[0]);
    foreCastData.setBusiness_Unit(nextLine[1]);
    foreCastData.setValue(Float.parseFloat(nextLine[2]));
    return foreCastData;
  }

  public List<ForeCastData> getForeCastDataFromQueryResult(TableResult results) {
    List<ForeCastData> foreCastList = new ArrayList<>();
    results.iterateAll().forEach(line -> {
      foreCastList.add(getForeCastObject(line));
    });
    return foreCastList;

  }

  private ForeCastData getForeCastObject(FieldValueList line) {
    ForeCastData foreCast = new ForeCastData();
    foreCast.setBusiness_Unit(line.get(OIBConstants.Business_Unit).getValue().toString());
    foreCast.setCountry(line.get(OIBConstants.Country).getValue().toString());
    foreCast.setValue(Float.parseFloat(line.get(OIBConstants.Value).getValue().toString()));
    return foreCast;
  }

}

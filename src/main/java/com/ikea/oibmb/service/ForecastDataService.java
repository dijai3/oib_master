package com.ikea.oibmb.service;

import java.util.List;

import com.ikea.oibmb.pojo.ForeCastData;

public interface ForecastDataService {
    public void readfile();
    public List<ForeCastData> getForeCastData();
}

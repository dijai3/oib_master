package com.ikea.oibmb.service;

import java.util.List;

import com.ikea.oibmb.pojo.Payroll;

public interface BusinessLogicService {
    public List<Payroll> readDataFromBigquery();
}

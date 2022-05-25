package com.ikea.oibmb.service;

import java.util.List;

import com.ikea.oibmb.pojo.Payroll;

public interface BonusLogicService {
    public List<Payroll> readDataFromBigquery();
}

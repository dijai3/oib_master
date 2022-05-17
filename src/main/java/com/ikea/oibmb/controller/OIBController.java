package com.ikea.oibmb.controller;
import java.util.List;

import com.ikea.oibmb.pojo.Payroll;
import com.ikea.oibmb.service.BonusGoalDataService;
import com.ikea.oibmb.service.BusinessLogicService;
import com.ikea.oibmb.service.ForecastDataService;
import com.ikea.oibmb.service.PAOMService;
import com.ikea.oibmb.utils.SecretManagerUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OIBController {

    @Autowired
    private BusinessLogicService service;

    @Autowired
    private PAOMService pService;

    @Autowired
    private BonusGoalDataService bService;

    @Autowired
    private ForecastDataService fService;


    @GetMapping("/processPAOM")
    public String fetchPAOMData(){
        pService.fetchDataFromPAOM();
        return "PAOM data has been process successfully!!!";
    }

    @GetMapping("/processcappinghrs")
    public String readCappingHrsData(){
        bService.readfile();
        return "Capping hrs data has been process successfully!!!";
    }

    @GetMapping("/processForecast")
    public String readForeCastData(){
        fService.readfile();
        return "ForeCast data has been process successfully!!!";
    }

    
    
}

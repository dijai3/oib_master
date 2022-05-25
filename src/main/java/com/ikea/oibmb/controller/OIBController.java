package com.ikea.oibmb.controller;

import com.ikea.oibmb.service.BonusGoalDataService;
import com.ikea.oibmb.service.BonusLogicService;
import com.ikea.oibmb.service.ForecastDataService;
import com.ikea.oibmb.service.PAOMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OIBController {

    @Autowired
    private BonusLogicService service;

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

    @GetMapping("/calculateBonus")
    public String calculateBonus(){
        service.readDataFromBigquery();
        return "ForeCast data has been process successfully!!!";
    }


    
}

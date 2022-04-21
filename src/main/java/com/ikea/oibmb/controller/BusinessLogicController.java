package com.ikea.oibmb.controller;
import java.util.List;

import com.ikea.oibmb.pojo.Payroll;
import com.ikea.oibmb.service.BusinessLogicService;
import com.ikea.oibmb.service.PAOMService;
import com.ikea.oibmb.utils.SecretManagerUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessLogicController {

    @Autowired
    private BusinessLogicService service;

    @Autowired
    private PAOMService pService;

    @Autowired
    private SecretManagerUtils utils;

    @GetMapping("/hello")
    public  List<Payroll> helloWorld(){
        
        return service.readDataFromBigquery();
    }

    @GetMapping("/testPAOM")
    public void test(){
        pService.fetchDataFromPAOM();
    }
    
}

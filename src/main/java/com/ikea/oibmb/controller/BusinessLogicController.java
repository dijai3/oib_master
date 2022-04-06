package com.ikea.oibmb.controller;
import java.util.List;

import com.ikea.oibmb.pojo.Payroll;
import com.ikea.oibmb.service.BusinessLogicService;
import com.ikea.oibmb.serviceImpl.BusinessLogicServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessLogicController {

    @Autowired
    private BusinessLogicServiceImpl service;

    @GetMapping("/hello")
    public  List<Payroll> helloWorld(){
        
        return service.readDataFromBigquery();
    }
    
}

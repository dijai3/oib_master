package com.ikea.oibmb.service;

import java.util.List;

import com.ikea.oibmb.pojo.Person;

public interface PAOMService {
    public void fetchDataFromPAOM();
    public List<Person> getPAOMData();
}

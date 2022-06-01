package com.ikea.oibmb.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.api.client.util.DateTime;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.TableResult;
import com.ikea.oibmb.constants.OIBConstants;
import com.ikea.oibmb.pojo.Person;

public class POAMDataMapper {
    
    public List<Person> getPersonsFromQueryResult(TableResult results) {
        List<Person> personList = new ArrayList<>();
        results.iterateAll().forEach(line -> {
            personList.add(getPersonObject(line));
        });
        return personList;
    }

    private Person getPersonObject(FieldValueList line) {
        Person person = new Person();
        person.setCountryCode(line.get(OIBConstants.CountryCode).getValue().toString());
        person.setPersonnelNumber(Integer.parseInt(line.get(OIBConstants.PersonnelNumber).getValue().toString()));   
        person.setGlobalID(Integer.parseInt(line.get(OIBConstants.GlobalID).getValue().toString()));
        person.setFirstName(line.get(OIBConstants.Firstname).getValue().toString());
        person.setSurname(line.get(OIBConstants.Surname).getValue().toString());
        person.setBirthDate(new DateTime(line.get(OIBConstants.BirthDate).getValue().toString()));
        person.setJobTitle(line.get(OIBConstants.JobTitle).getValue().toString());
        person.setWorkEmailAddress(line.get(OIBConstants.WorkEmailAddress).getValue().toString());
        person.setJoiningDate(new DateTime(line.get(OIBConstants.JoiningDate).getValue().toString())); 
        person.setServiceYearEntry(new DateTime(line.get(OIBConstants.ServiceYearEntry).getValue().toString()));   
        person.setLeavingDate(new DateTime(line.get(OIBConstants.LeavingDate).getValue().toString()));   
        person.setIt01StartDate(new DateTime(line.get(OIBConstants.IT01StartDate).getValue().toString()));
        person.setIt01EndDate(new DateTime(line.get(OIBConstants.IT01EndDate).getValue().toString()));
        person.setPayrollArea(line.get(OIBConstants.PayrollArea).getValue().toString());
        person.setCompanyCode(Integer.parseInt(line.get(OIBConstants.CompanyCode).getValue().toString()));
        person.setCompanyName(line.get(OIBConstants.CompanyName).getValue().toString());
        person.setPersonnelArea(line.get(OIBConstants.PersonnelArea).getValue().toString());
        person.setPersonnelAreaName(line.get(OIBConstants.PersonnelAreaName).getValue().toString());
        person.setPersonnelSubarea(line.get(OIBConstants.PersonnelSubarea).getValue().toString());
        person.setEmployeeGroup(line.get(OIBConstants.EmployeeGroup).getValue().toString());
        person.setEmployeeSubgroup(line.get(OIBConstants.EmployeeSubgroup).getValue().toString());
        person.setCostCentre(line.get(OIBConstants.CostCentre).getValue().toString());
        Optional<Object> groupFunction = Optional.ofNullable(line.get(OIBConstants.GroupFunction).getValue());
        if(groupFunction.isPresent()){
            person.setGroupFunction(line.get(OIBConstants.GroupFunction).getValue().toString());
        }
        person.setOibLevel(Integer.parseInt(line.get(OIBConstants.OIBLevel).getValue().toString()));
        person.setOIBLevelStartDate(new DateTime(line.get(OIBConstants.OIBLevelStartDate).getValue().toString()));
        person.setOIBLevelEndDate(new DateTime(line.get(OIBConstants.OIBLevelEndDate).getValue().toString()));
        Optional<Object> tackStatus = Optional.ofNullable(line.get(OIBConstants.TackStatus).getValue());
        if(tackStatus.isPresent()){
            person.setTackStatus(line.get(OIBConstants.TackStatus).getValue().toString());
        }

        return person;
    }

}

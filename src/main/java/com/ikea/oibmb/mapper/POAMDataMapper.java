package com.ikea.oibmb.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        person.setPersonId(line.get(OIBConstants.PersonId).getValue().toString());
        person.setEmployeeId(line.get(OIBConstants.EmployeeId).getValue().toString());   
        person.setEmploymentStatus(line.get(OIBConstants.EmploymentStatus).getValue().toString());
        person.setCountryKey(line.get(OIBConstants.CountryKey).getValue().toString());
        person.setCostCentre(line.get(OIBConstants.CostCentre).getValue().toString());
        person.setBusinessUnit(line.get(OIBConstants.BusinessUnit).getValue().toString());
        person.setEmailId(line.get(OIBConstants.EmailId).getValue().toString());
        person.setTerminationDate(new DateTime(line.get(OIBConstants.TerminationDate).getValue().toString()));
        person.setLegalFirstName(line.get(OIBConstants.LegalFirstName).getValue().toString());
        person.setLegalLastName(line.get(OIBConstants.LegalLastName).getValue().toString()); 
        person.setCompanyCode(line.get(OIBConstants.CompanyCode).getValue().toString());   
        person.setJobTitle(line.get(OIBConstants.JobTitle).getValue().toString());   
        person.setBusinessUnitType(line.get(OIBConstants.BusinessUnitType).getValue().toString());
        person.setDateOfBirth(new DateTime(line.get(OIBConstants.DateOfBirth).getValue().toString()));
        person.setCompanyName(line.get(OIBConstants.CompanyName).getValue().toString());
        person.setPersonalArea(line.get(OIBConstants.PersonalArea).getValue().toString());
        person.setPersonalAreaName(line.get(OIBConstants.PersonalAreaName).getValue().toString());
        person.setPersonalSubArea(line.get(OIBConstants.PersonalSubArea).getValue().toString());
        person.setEmployeeGroup(line.get(OIBConstants.EmployeeGroup).getValue().toString());
        person.setEmployeeSubGroup(line.get(OIBConstants.EmployeeSubGroup).getValue().toString());
        person.setTackStatus(line.get(OIBConstants.TackStatus).getValue().toString());
        person.setJoiningDate(new DateTime(line.get(OIBConstants.JoiningDate).getValue().toString()));
        person.setOibLevel(line.get(OIBConstants.OIBLevel).getValue().toString());
        person.setOIBLevelStartDate(new DateTime(line.get(OIBConstants.OIBLevelStartDate).getValue().toString()));
        person.setOIBLevelEndDate(new DateTime(line.get(OIBConstants.OIBLevelEndDate).getValue().toString()));
        person.setGroupFunction(line.get(OIBConstants.GroupFunction).getValue().toString());

        return person;
    }

}

package com.ikea.oibmb.mapper;

import java.util.ArrayList;
import java.util.List;

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
        person.setEmailId(line.get(OIBConstants.EmailId).getValue().toString());
        person.setEmploymentStatus(line.get(OIBConstants.EmploymentStatus).getValue().toString());
        person.setTerminationDate(line.get(OIBConstants.TerminationDate).getValue().toString());
        person.setLegalFirstName(line.get(OIBConstants.LegalFirstName).getValue().toString());
        person.setLegalLastName(line.get(OIBConstants.LegalLastName).getValue().toString());
        person.setCountryKey(line.get(OIBConstants.CountryKey).getValue().toString());
        person.setCompanyCode(line.get(OIBConstants.CompanyCode).getValue().toString());
        person.setCostCentre(line.get(OIBConstants.CostCentre).getValue().toString());
        person.setJobTitle(line.get(OIBConstants.JobTitle).getValue().toString());
        person.setBusinessUnit(line.get(OIBConstants.BusinessUnit).getValue().toString());
        person.setBusinessUnitType(line.get(OIBConstants.BusinessUnitType).getValue().toString());
        person.setDateOfBirth(line.get(OIBConstants.DateOfBirth).getValue().toString());
        person.setCompanyName(line.get(OIBConstants.CompanyName).getValue().toString());
        person.setPersonalArea(line.get(OIBConstants.PersonalArea).getValue().toString());
        person.setPersonalAreaName(line.get(OIBConstants.PersonalAreaName).getValue().toString());
        person.setPersonalSubArea(line.get(OIBConstants.PersonalSubArea).getValue().toString());
        person.setEmployeeGroup(line.get(OIBConstants.EmployeeGroup).getValue().toString());
        person.setEmployeeSubGroup(line.get(OIBConstants.EmployeeSubGroup).getValue().toString());
        return person;
    }

}

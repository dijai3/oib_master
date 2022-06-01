package com.ikea.oibmb.pojo;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.api.client.util.DateTime;


public class Person {

    @JsonProperty("employeeId")
    private int personnelNumber;

    @JsonProperty("personId")
    private int globalID;

    @JsonProperty("countryKey")
    private String countryCode;

    @JsonProperty("legalFirstName")
    private String firstName;
    
    @JsonProperty("legalLastName")
    private String surname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("dateOfBirth")
    private DateTime birthDate;

    private String jobTitle;

    @JsonProperty("emailId")
    private String workEmailAddress;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("firstDayAtIKEA")
    private DateTime joiningDate;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    // @JsonProperty("firstDayAtIKEA")
    private DateTime serviceYearEntry;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("terminationDate")
    private DateTime leavingDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    // @JsonProperty("Organization.BeginDate")
    private DateTime it01StartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    // @JsonProperty("Organization.EndDate")
    private DateTime it01EndDate;


    private String payrollArea;

    private int companyCode;

    private String companyName;

    @JsonProperty("personalArea")
    private String personnelArea;

    @JsonProperty("personalAreaName")
    private String personnelAreaName;

    @JsonProperty("personalSubArea")
    private String personnelSubarea;

    private String employeeGroup;

    @JsonProperty("employeeSubGroup")    
    private String employeeSubgroup;

    private String costCentre;

    private String groupFunction;
    
    private int oibLevel;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private DateTime OIBLevelStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private DateTime OIBLevelEndDate;

    private String tackStatus;

    public int getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(int personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public int getGlobalID() {
        return globalID;
    }

    public void setGlobalID(int globalID) {
        this.globalID = globalID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getWorkEmailAddress() {
        return workEmailAddress;
    }

    public void setWorkEmailAddress(String workEmailAddress) {
        this.workEmailAddress = workEmailAddress;
    }

    public DateTime getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(DateTime joiningDate) {
        this.joiningDate = joiningDate;
    }

    public DateTime getServiceYearEntry() {
        return serviceYearEntry;
    }

    public void setServiceYearEntry(DateTime serviceYearEntry) {
        this.serviceYearEntry = serviceYearEntry;
    }

    public DateTime getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(DateTime leavingDate) {
        this.leavingDate = leavingDate;
    }

    public DateTime getIt01StartDate() {
        return it01StartDate;
    }

    public void setIt01StartDate(DateTime it01StartDate) {
        this.it01StartDate = it01StartDate;
    }

    public DateTime getIt01EndDate() {
        return it01EndDate;
    }

    public void setIt01EndDate(DateTime it01EndDate) {
        this.it01EndDate = it01EndDate;
    }

    public String getPayrollArea() {
        return payrollArea;
    }

    public void setPayrollArea(String payrollArea) {
        this.payrollArea = payrollArea;
    }

    public int getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPersonnelArea() {
        return personnelArea;
    }

    public void setPersonnelArea(String personnelArea) {
        this.personnelArea = personnelArea;
    }

    public String getPersonnelAreaName() {
        return personnelAreaName;
    }

    public void setPersonnelAreaName(String personnelAreaName) {
        this.personnelAreaName = personnelAreaName;
    }

    public String getPersonnelSubarea() {
        return personnelSubarea;
    }

    public void setPersonnelSubarea(String personnelSubarea) {
        this.personnelSubarea = personnelSubarea;
    }

    public String getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(String employeeGroup) {
        this.employeeGroup = employeeGroup;
    }

    public String getEmployeeSubgroup() {
        return employeeSubgroup;
    }

    public void setEmployeeSubgroup(String employeeSubgroup) {
        this.employeeSubgroup = employeeSubgroup;
    }

    public String getCostCentre() {
        return costCentre;
    }

    public void setCostCentre(String costCentre) {
        this.costCentre = costCentre;
    }

    public String getGroupFunction() {
        return groupFunction;
    }

    public void setGroupFunction(String groupFunction) {
        this.groupFunction = groupFunction;
    }

    public int getOibLevel() {
        return oibLevel;
    }

    public void setOibLevel(int oibLevel) {
        this.oibLevel = oibLevel;
    }

    public DateTime getOIBLevelStartDate() {
        return OIBLevelStartDate;
    }

    public void setOIBLevelStartDate(DateTime oIBLevelStartDate) {
        OIBLevelStartDate = oIBLevelStartDate;
    }

    public DateTime getOIBLevelEndDate() {
        return OIBLevelEndDate;
    }

    public void setOIBLevelEndDate(DateTime oIBLevelEndDate) {
        OIBLevelEndDate = oIBLevelEndDate;
    }

    public String getTackStatus() {
        return tackStatus;
    }

    public void setTackStatus(String tackStatus) {
        this.tackStatus = tackStatus;
    }

    
   

}


package com.ikea.oibmb.pojo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Person {
       
    private String personId;
    private String employeeId;
    private String networkId;
    private String emailId;
    
    private String employmentStatus;
   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
    
    private String terminationDate;
    
    private String legalFirstName;
    
    private String legalLastName;
    private String legalMiddleName;
    private String gender;
    
    private String countryKey;
    private String companyCode;
    private String costCentre;
    private String departmentName;
    private String jobTitle;
    
    
    private String dateOfBirth;
    private String nationality;
    private String companyName;
    
    private String personalArea;
    private String personalSubArea;
    private String personalAreaName;
    private String employeeGroup;
    private String departmentCode;
    private Integer job;
    private Integer position;
    private String positionName;
    private String orgUnitAbbreviation;
    
    private String managerEmployeeId;
    private String businessUnit;
    private String businessUnitType;
    private String employeeSubGroup;
   
    public String getEmployeeSubGroup() {
        return employeeSubGroup;
    }
    public void setEmployeeSubGroup(String employeeSubGroup) {
        this.employeeSubGroup = employeeSubGroup;
    }
    public String getPersonalAreaName() {
        return personalAreaName;
    }
    public void setPersonalAreaName(String personalAreaName) {
        this.personalAreaName = personalAreaName;
    }
    public String getBusinessUnitType() {
        return businessUnitType;
    }
    public void setBusinessUnitType(String businessUnitType) {
        this.businessUnitType = businessUnitType;
    }
    public String getPersonId() {
        return personId;
    }
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getNetworkId() {
        return networkId;
    }
    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getEmploymentStatus() {
        return employmentStatus;
    }
    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
   
    public String getLegalFirstName() {
        return legalFirstName;
    }
    public void setLegalFirstName(String legalFirstName) {
        this.legalFirstName = legalFirstName;
    }
    public String getLegalLastName() {
        return legalLastName;
    }
    public void setLegalLastName(String legalLastName) {
        this.legalLastName = legalLastName;
    }
    public String getLegalMiddleName() {
        return legalMiddleName;
    }
    public void setLegalMiddleName(String legalMiddleName) {
        this.legalMiddleName = legalMiddleName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCountryKey() {
        return countryKey;
    }
    public void setCountryKey(String countryKey) {
        this.countryKey = countryKey;
    }
  
    public String getCompanyCode() {
        return companyCode;
    }
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
    public String getCostCentre() {
        return costCentre;
    }
    public void setCostCentre(String costCentre) {
        this.costCentre = costCentre;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getPersonalArea() {
        return personalArea;
    }
    public void setPersonalArea(String personalArea) {
        this.personalArea = personalArea;
    }
 
    public String getPersonalSubArea() {
        return personalSubArea;
    }
    public void setPersonalSubArea(String personalSubArea) {
        this.personalSubArea = personalSubArea;
    }
    public String getEmployeeGroup() {
        return employeeGroup;
    }
    public void setEmployeeGroup(String employeeGroup) {
        this.employeeGroup = employeeGroup;
    }
    public String getDepartmentCode() {
        return departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    public Integer getJob() {
        return job;
    }
    public void setJob(Integer job) {
        this.job = job;
    }
    public Integer getPosition() {
        return position;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }
    public String getPositionName() {
        return positionName;
    }
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
    public String getOrgUnitAbbreviation() {
        return orgUnitAbbreviation;
    }
    public void setOrgUnitAbbreviation(String orgUnitAbbreviation) {
        this.orgUnitAbbreviation = orgUnitAbbreviation;
    }
    public String getManagerEmployeeId() {
        return managerEmployeeId;
    }
    public void setManagerEmployeeId(String managerEmployeeId) {
        this.managerEmployeeId = managerEmployeeId;
    }
    public String getBusinessUnit() {
        return businessUnit;
    }
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }
    public String getTerminationDate() {
        return terminationDate;
    }
    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    

   

}


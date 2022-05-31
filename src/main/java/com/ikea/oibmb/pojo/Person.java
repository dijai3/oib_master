package com.ikea.oibmb.pojo;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.api.client.util.DateTime;


public class Person {
       
    private String personId;
    private String employeeId;
    private String networkId;
    private String emailId;
    
    private String employmentStatus;
   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private DateTime hireDate;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private DateTime terminationDate;
    
    private String legalFirstName;
    
    private String legalLastName;
    private String legalMiddleName;
    private String gender;
    
    private String countryKey;
    private String companyCode;
    private String costCentre;
    private String departmentName;
    private String jobTitle;
    
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private DateTime dateOfBirth;
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

    private String tackStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private DateTime joiningDate;
    private String oibLevel;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private DateTime OIBLevelStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private DateTime OIBLevelEndDate;
    private String groupFunction;
    
    
  
    public String getTackStatus() {
        return tackStatus;
    }
    public void setTackStatus(String tackStatus) {
        this.tackStatus = tackStatus;
    }
    public DateTime getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(DateTime joiningDate) {
        this.joiningDate = joiningDate;
    }
    public String getOibLevel() {
        return oibLevel;
    }
    public void setOibLevel(String oibLevel) {
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
    public String getGroupFunction() {
        return groupFunction;
    }
    public void setGroupFunction(String groupFunction) {
        this.groupFunction = groupFunction;
    }
  
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
    public DateTime getHireDate() {
        return hireDate;
    }
    public void setHireDate(DateTime hireDate) {
        this.hireDate = hireDate;
    }
    public DateTime getTerminationDate() {
        return terminationDate;
    }
    public void setTerminationDate(DateTime terminationDate) {
        this.terminationDate = terminationDate;
    }
    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
   
    
 

    
    

   

}


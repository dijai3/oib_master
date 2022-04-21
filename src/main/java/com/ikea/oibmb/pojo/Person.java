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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate terminationDate;
    
    private String legalFirstName;
    
    private String legalLastName;
    private String legalMiddleName;
    private String gender;
    
    private String countryKey;
    private Integer companyCode;
    private String costCentre;
    private String departmentName;
    private String jobTitle;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String nationality;
    private String companyName;
    
    private String personalArea;
    private String personalSubAreaName;
    private String employeeGroup;
    private String departmentCode;
    private Integer job;
    private Integer position;
    private String positionName;
    private String orgUnitAbbreviation;
    
    private String managerEmployeeId;
    private String bussinessUnit;
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
    public LocalDate getTerminationDate() {
        return terminationDate;
    }
    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
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
    public Integer getCompanyCode() {
        return companyCode;
    }
    public void setCompanyCode(Integer companyCode) {
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
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
    public String getPersonalSubAreaName() {
        return personalSubAreaName;
    }
    public void setPersonalSubAreaName(String personalSubAreaName) {
        this.personalSubAreaName = personalSubAreaName;
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
    public String getBussinessUnit() {
        return bussinessUnit;
    }
    public void setBussinessUnit(String bussinessUnit) {
        this.bussinessUnit = bussinessUnit;
    }

    

   

}


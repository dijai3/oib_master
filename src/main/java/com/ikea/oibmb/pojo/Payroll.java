package com.ikea.oibmb.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {
    
    private int personalNumber;
    private int personnelArea;
    private int personnelSubArea;
    private String costCenter;
    private int ForPeriodPayroll;
    private int PC205Assignment;
    private String wageType;
    private float numberOfHours;
    private float rate;
    private float amount;
    
    public int getPersonalNumber() {
        return personalNumber;
    }
    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }
    public int getPersonnelArea() {
        return personnelArea;
    }
    public void setPersonnelArea(int personnelArea) {
        this.personnelArea = personnelArea;
    }
    public int getPersonnelSubArea() {
        return personnelSubArea;
    }
    public void setPersonnelSubArea(int personnelSubArea) {
        this.personnelSubArea = personnelSubArea;
    }
    public String getCostCenter() {
        return costCenter;
    }
    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }
    public int getForPeriodPayroll() {
        return ForPeriodPayroll;
    }
    public void setForPeriodPayroll(int forPeriodPayroll) {
        ForPeriodPayroll = forPeriodPayroll;
    }
    public int getPC205Assignment() {
        return PC205Assignment;
    }
    public void setPC205Assignment(int pC205Assignment) {
        PC205Assignment = pC205Assignment;
    }
    public String getWageType() {
        return wageType;
    }
    public void setWageType(String wageType) {
        this.wageType = wageType;
    }
    public float getNumberOfHours() {
        return numberOfHours;
    }
    public void setNumberOfHours(float numberOfHours) {
        this.numberOfHours = numberOfHours;
    }
    public float getRate() {
        return rate;
    }
    public void setRate(float rate) {
        this.rate = rate;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }

    
    
    
}

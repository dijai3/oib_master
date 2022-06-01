package com.ikea.oibmb.utils;

import java.util.Calendar;

import com.google.api.client.util.DateTime;

public class DateUtility {

    public static DateTime getCurrentFiscalYearStartDate() {
        Calendar calendar = Calendar.getInstance();
        // calendar.set(Calendar.HOUR_OF_DAY, 0);  
        calendar.set(2020, Calendar.SEPTEMBER, 1,00,00,00);
        DateTime startDate = new DateTime(calendar.getTime());
        return startDate;
    }

    public static DateTime getCurrentFiscalYearEndDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.AUGUST, 31);
        calendar.set(Calendar.HOUR_OF_DAY, 0);      
        DateTime startDate = new DateTime(calendar.getTime());
        return startDate;
    }

    public static DateTime getJoiningEligibilityDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.get (Calendar.YEAR);
        calendar.set(2021, Calendar.MARCH, 5,23,59,59);
        // calendar.set(Calendar.HOUR_OF_DAY, 0);
        DateTime startDate = new DateTime(calendar.getTime());
        return startDate;
    }

    public static DateTime getTerminateEligibilityDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.AUGUST, 31);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        DateTime startDate = new DateTime(calendar.getTime());
        return startDate;
    }

    public static DateTime getInfiniteDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(9999, Calendar.DECEMBER, 31,23,59,59);
        DateTime startDate = new DateTime(calendar.getTime());
        return startDate;
    }
}

package com.ikea.oibmb.utils;

import java.util.Calendar;

import com.google.api.client.util.DateTime;

public class DateUtility {

    public static DateTime getJoiningEligibilityDate() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = getCurrentYear();
        int year = currentYear;
        if(getCurrentMonth() <= calendar.AUGUST+1){
            year = currentYear - 1;
        }      
        calendar.set(year, Calendar.MARCH, 5,23,59,59);
        DateTime date = new DateTime(calendar.getTime());
        return date;
    }

    public static DateTime getTerminateEligibilityDate() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = getCurrentYear();
        int year = currentYear;
        if(getCurrentMonth() <= calendar.AUGUST+1){
            year = currentYear - 1;
        }
        calendar.set(year, Calendar.AUGUST, 31);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        DateTime date = new DateTime(calendar.getTime());
        return date;
    }

    public static DateTime getInfiniteDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(9999, Calendar.DECEMBER, 31,23,59,59);
        DateTime date = new DateTime(calendar.getTime());
        return date;
    }

    private static int getCurrentMonth(){
        return Calendar.getInstance().get (Calendar.MONTH);
    }

    private static int getCurrentYear(){
        return Calendar.getInstance().get (Calendar.YEAR);
    }
}

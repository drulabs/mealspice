package com.talenitca.mealspiceandroid.utils;

import java.util.Calendar;

public class MyUtils {

    private Calendar calendar = Calendar.getInstance();

    public String welcomeCustomer(String name) {
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        if (hourOfDay >= 6 && hourOfDay <= 12) {
            return "Good morning " + name;
        } else if (hourOfDay >= 12 && hourOfDay <= 18) {
            return "Good afternoon " + name;
        } else {
            return "Good evening " + name;
        }
    }

}

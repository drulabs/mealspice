package com.talenitca.mealspiceandroid.utils;

import com.talenitca.mealspiceandroid.data.models.Restaurant;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utils {
    public static int addition(int a, int b) {
        return a + b;
    }

    public static List<Restaurant> sortRestaurantAlphabetically(List<Restaurant> list) {
        Collections.sort(list, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant r1, Restaurant r2) {
                return r1.getName().compareToIgnoreCase(r2.getName());
            }
        });
        return list;
    }
}

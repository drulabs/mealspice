package com.talenitca.mealspiceandroid;

import com.talenitca.mealspiceandroid.data.models.Restaurant;
import com.talenitca.mealspiceandroid.utils.Utils;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    static List<Restaurant> unsortedRestaurants;
    static List<Restaurant> alreadySortedrestaurants;

    @BeforeClass
    public static void setup() {
        unsortedRestaurants = new ArrayList<>();
        unsortedRestaurants.add(new Restaurant("D"));
        unsortedRestaurants.add(new Restaurant("A"));
        unsortedRestaurants.add(new Restaurant("Z"));
        alreadySortedrestaurants = new ArrayList<>();
        alreadySortedrestaurants.add(new Restaurant("A"));
        alreadySortedrestaurants.add(new Restaurant("D"));
        alreadySortedrestaurants.add(new Restaurant("Z"));
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void utils_addition() {
        assertEquals(7, Utils.addition(3, 2));
    }

    @Test
    public void sorting_test() {
        Utils.sortRestaurantAlphabetically(unsortedRestaurants);
        for (int i = 0; i < 3; i++)
            assertEquals(alreadySortedrestaurants.get(i).getName(),unsortedRestaurants.get(i).getName());
    }

}
package com.talenitca.mealspiceandroid.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.talenitca.mealspiceandroid.data.models.Restaurant;

@Database(entities = {Restaurant.class}, version = 1, exportSchema = false)
public abstract class RestauranDB extends RoomDatabase {

    private static final Object lock = new Object();
    private static final String DATABASE_NAME = "restaurant_db";

    private static RestauranDB sInstance;

    public static RestauranDB getInstance(@NonNull Context context) {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, RestauranDB.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return sInstance;
    }

    public abstract RestaurantDAO restaurantDAO();

}

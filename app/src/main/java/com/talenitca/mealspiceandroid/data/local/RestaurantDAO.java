package com.talenitca.mealspiceandroid.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.talenitca.mealspiceandroid.data.models.Restaurant;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface RestaurantDAO {

    @Query("SELECT * FROM restaurants")
    Single<List<Restaurant>> getFavouriteRestaurants();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addRestaurant(Restaurant restaurant);

    @Query(value = "SELECT * FROM restaurants WHERE slug=:restaurantSlug")
    Single<Restaurant> getRestaurant(String restaurantSlug);

    @Delete
    void deleteRestaurant(Restaurant restaurant);
}

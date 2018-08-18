package com.talenitca.mealspiceandroid.data;

import com.talenitca.mealspiceandroid.data.models.Restaurant;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface DataManager {

    Observable<Restaurant> fetchRestaurantDetails(String slug);

    Observable<List<Restaurant>> fetchAllRestaurants(int page);

    Completable favouriteRestaurant(Restaurant restaurant);

    Observable<List<Restaurant>> getFavouriteRestaurants();

    Observable<Restaurant> getRestaurant(String restaurantSlug);

    Completable deleteRestaurant(Restaurant restaurant);

    Completable updateRestaurant(Restaurant restaurant);

    interface Callback<T> {
        void onResponse(T result);

        void onError(Throwable throwable);
    }

}

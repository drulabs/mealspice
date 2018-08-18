package com.talenitca.mealspiceandroid.data;

import android.support.annotation.NonNull;
import android.util.Log;

import com.talenitca.mealspiceandroid.data.local.RestaurantDAO;
import com.talenitca.mealspiceandroid.data.models.Restaurant;
import com.talenitca.mealspiceandroid.data.network.retrofit.RestaurantService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;

public class AppDataManager implements DataManager {

    private RestaurantService restaurantService;
    private RestaurantDAO restaurantDAO;

    @Inject
    AppDataManager(RestaurantService restaurantService, RestaurantDAO restaurantDAO) {
        this.restaurantService = restaurantService;
        this.restaurantDAO = restaurantDAO;
    }

    @Override
    public Observable<Restaurant> fetchRestaurantDetails(String slug) {
        return restaurantService.fetchRestaurantDetails(slug);
    }

    @Override
    public Observable<List<Restaurant>> fetchAllRestaurants(int page) {
        return restaurantService.fetchAllRestaurants();
    }

    private void fetchAllRestaurantsAsync(int page) {
        Call<List<Restaurant>> call = restaurantService.fetchAllRestaurants2();
        call.enqueue(new retrofit2.Callback<List<Restaurant>>() {
            @Override
            public void onResponse(@NonNull Call<List<Restaurant>> call,
                                   @NonNull Response<List<Restaurant>> response) {
                List<Restaurant> restaurants = response.body();
                Log.d("restaurants", "onResponse: " + restaurants);
            }

            @Override
            public void onFailure(@NonNull Call<List<Restaurant>> call,
                                  @NonNull Throwable t) {
                // handle error
            }
        });
    }

    private List<Restaurant> fetchAllRestaurantsSync(int page) throws IOException {
        return restaurantService
                .fetchAllRestaurants2()
                .execute()
                .body();
    }

    @Override
    public Completable favouriteRestaurant(Restaurant restaurant) {
        return Completable.fromAction(() -> restaurantDAO.addRestaurant(restaurant));
    }

    @Override
    public Observable<List<Restaurant>> getFavouriteRestaurants() {
        return restaurantDAO.getFavouriteRestaurants().toObservable();
    }

    @Override
    public Observable<Restaurant> getRestaurant(String restaurantSlug) {
        return restaurantDAO.getRestaurant(restaurantSlug).toObservable();
    }

    @Override
    public Completable deleteRestaurant(Restaurant restaurant) {
        return Completable.fromAction(() -> restaurantDAO.deleteRestaurant(restaurant));
    }

    @Override
    public Completable updateRestaurant(Restaurant restaurant) {
        return Completable.fromObservable(
                restaurantService.updateRestaurant(restaurant.getSlug(), restaurant)
        );
    }
}

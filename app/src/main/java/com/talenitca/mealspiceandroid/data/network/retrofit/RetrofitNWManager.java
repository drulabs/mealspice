package com.talenitca.mealspiceandroid.data.network.retrofit;

import com.talenitca.mealspiceandroid.data.DataManager;
import com.talenitca.mealspiceandroid.data.models.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitNWManager {

    //TODO : add callback
    public void updateRestaurant(String slug) {

    }

    public void deleteRestaurant(String slug) {

    }

    public void addComment(String slug, String comment) {

    }

    public void addReaction(String slug) {

    }

    public void fetchRestaurantDetails(String slug, final DataManager.Callback<Restaurant> callback) {
//        RestaurantService restaurantService = RestaurantService.retrofit.create(RestaurantService.class);
//        Call<Restaurant> restaurantDetailsCall = restaurantService.fetchRestaurantDetails("restaurant/"+slug);
//        restaurantDetailsCall.enqueue(new Callback<Restaurant>() {
//            @Override
//            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
//                callback.onResponse(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Restaurant> call, Throwable t) {
//                callback.onError(t);
//            }
//        });
    }


    public void fetchAllRestaurants(int page, final DataManager.Callback<List<Restaurant>> callback) {
//        RestaurantService restaurantService = RestaurantService.retrofit.create(RestaurantService.class);
//        Call<List<Restaurant>> restaurantCall = restaurantService.fetchAllRestaurants();
//        restaurantCall.enqueue(new Callback<List<Restaurant>>() {
//            @Override
//            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
//                callback.onResponse(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
//                callback.onError(t);
//            }
//        });

    }
}

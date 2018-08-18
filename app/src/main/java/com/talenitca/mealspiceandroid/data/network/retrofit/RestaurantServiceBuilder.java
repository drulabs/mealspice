package com.talenitca.mealspiceandroid.data.network.retrofit;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantServiceBuilder {

    private final Retrofit.Builder restaurantServiceBuilder;

    public RestaurantServiceBuilder() {
        restaurantServiceBuilder = new Retrofit.Builder()
                .baseUrl("https://pmd-test-app-001.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    public RestaurantService build() {
        OkHttpClient okHttpClient = buildOkHttpClient();
        Retrofit retrofit = restaurantServiceBuilder.client(okHttpClient).build();
        return retrofit.create(RestaurantService.class);
    }

    /**
     * Customise this method for logging and intercepting network calls
     *
     * @return a non null {@link OkHttpClient} instance
     */
    private @NonNull
    OkHttpClient buildOkHttpClient() {
        return new OkHttpClient();
    }
}

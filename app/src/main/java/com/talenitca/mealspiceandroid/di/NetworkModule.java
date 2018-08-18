package com.talenitca.mealspiceandroid.di;

import com.talenitca.mealspiceandroid.data.network.retrofit.RestaurantService;
import com.talenitca.mealspiceandroid.data.network.retrofit.RestaurantServiceBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    RestaurantService providesRestaurantService() {
        return (new RestaurantServiceBuilder().build());
    }

}

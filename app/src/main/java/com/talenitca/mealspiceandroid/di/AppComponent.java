package com.talenitca.mealspiceandroid.di;

import android.app.Application;
import android.content.Context;

import com.talenitca.mealspiceandroid.data.DataManager;
import com.talenitca.mealspiceandroid.data.local.RestaurantDAO;
import com.talenitca.mealspiceandroid.data.network.retrofit.RestaurantService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.Scheduler;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    RestaurantService getRestaurantService();

    Context getContext();

    Application getApplication();

    @Background
    Scheduler getBackGroundScheduler();

    @Foreground
    Scheduler getForeGroundScheduler();

    RestaurantDAO getRestaurantDao();

}

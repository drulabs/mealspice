package com.talenitca.mealspiceandroid.app;

import android.app.Application;

import com.talenitca.mealspiceandroid.di.AppComponent;
import com.talenitca.mealspiceandroid.di.AppModule;
import com.talenitca.mealspiceandroid.di.DaggerAppComponent;
import com.talenitca.mealspiceandroid.di.NetworkModule;

public class MealSpiceApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

package com.talenitca.mealspiceandroid.di;

import com.talenitca.mealspiceandroid.data.AppDataManager;
import com.talenitca.mealspiceandroid.data.DataManager;
import com.talenitca.mealspiceandroid.screens.details.DetailsContract;
import com.talenitca.mealspiceandroid.screens.details.DetailsPresenter;
import com.talenitca.mealspiceandroid.screens.home.HomeContract;
import com.talenitca.mealspiceandroid.screens.home.HomePresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PresenterModule {

    @Binds
    abstract HomeContract.Presenter bindHomePresenter(HomePresenter homePresenter);

    @Binds
    abstract DetailsContract.Presenter bindDetailsPresenter(DetailsPresenter detailsPresenter);

    @Binds
    abstract DataManager bindDataManager(AppDataManager appDataManager);
}

package com.talenitca.mealspiceandroid.di;

import com.talenitca.mealspiceandroid.screens.details.DetailsActivity;
import com.talenitca.mealspiceandroid.screens.details.DetailsContract;
import com.talenitca.mealspiceandroid.screens.home.HomeActivity;
import com.talenitca.mealspiceandroid.screens.home.HomeContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    private HomeActivity homeActivity;

    private DetailsActivity detailsActivity;

    public ViewModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    public ViewModule(DetailsActivity detailsActivity) {
        this.detailsActivity = detailsActivity;
    }

    @ActivityScope
    @Provides
    HomeContract.View providesHomeView() {
        return homeActivity;
    }

    @ActivityScope
    @Provides
    DetailsContract.View provicesDetailsView() {
        return detailsActivity;
    }
}

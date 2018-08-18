package com.talenitca.mealspiceandroid.di;

import com.talenitca.mealspiceandroid.screens.details.DetailsActivity;
import com.talenitca.mealspiceandroid.screens.home.HomeActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {ViewModule.class, PresenterModule.class})
public interface ViewComponent {

    void inject(HomeActivity homeActivity);

    void inject(DetailsActivity detailsActivity);

}

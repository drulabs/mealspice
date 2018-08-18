package com.talenitca.mealspiceandroid.screens.details;

import com.talenitca.mealspiceandroid.screens.BasePresenter;
import com.talenitca.mealspiceandroid.screens.BaseView;

public interface DetailsContract {

    interface View extends BaseView<Presenter> {
        void loadRestaurantPic(String url);

        void loadRestaurantName(String name);

        void loadRatings(String rating);

        void loadTagline(String tagline);

        void loadAddress(String address);

        void loadCuisine(String cuisine);

        void onError(Throwable throwable);

        void setFavouriteStatus(boolean status);

        void dismissWithMessage(String message);
    }

    interface Presenter extends BasePresenter {
        void start(String restaurantSlug);

        void onSaveTapped(String name, String tagLine, String location, String cuisine);

        void onFavouriteTapped();
    }
}

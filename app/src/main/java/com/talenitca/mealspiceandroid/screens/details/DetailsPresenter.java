package com.talenitca.mealspiceandroid.screens.details;

import com.talenitca.mealspiceandroid.data.DataManager;
import com.talenitca.mealspiceandroid.data.models.Restaurant;
import com.talenitca.mealspiceandroid.di.Background;
import com.talenitca.mealspiceandroid.di.Foreground;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DetailsPresenter implements DetailsContract.Presenter {

    private DetailsContract.View view;
    private DataManager dataManager;

    private Scheduler backgroundScheduler, foregroundScheduler;

    private CompositeDisposable compositeDisposable;

    private Restaurant currentRestaurant;

    @Inject
    DetailsPresenter(DetailsContract.View view, DataManager dataManager,
                     @Background Scheduler backgroundScheduler,
                     @Foreground Scheduler foregroundScheduler) {
        this.view = view;
        this.dataManager = dataManager;
        this.backgroundScheduler = backgroundScheduler;
        this.foregroundScheduler = foregroundScheduler;

        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void start(String restaurantSlug) {
        view.showLoading();

        Disposable restaurantDisposable = dataManager.fetchRestaurantDetails(restaurantSlug)
                .subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
                .doOnComplete(() -> view.hideLoading())
                .subscribe(restaurant -> {
                    this.currentRestaurant = restaurant;
                    view.loadRestaurantPic(restaurant.getPic());
                    view.loadAddress(restaurant.getAddress() + " " + restaurant.getCountry());
                    view.loadCuisine(restaurant.getCuisine());
                    view.loadRatings(String.valueOf(restaurant.getRating()));
                    view.loadRestaurantName(restaurant.getName());
                    view.loadTagline(restaurant.getTagline());
                }, throwable -> {
                    view.hideLoading();
                    view.onError(throwable);
                });
        compositeDisposable.add(restaurantDisposable);


        Disposable d = dataManager.getRestaurant(restaurantSlug)
                .subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
                .subscribe(restaurant -> view.setFavouriteStatus(restaurant != null),
                        throwable -> view.setFavouriteStatus(false));
        compositeDisposable.add(d);

    }

    @Override
    public void onSaveTapped(String name, String tagLine, String location, String cuisine) {
        currentRestaurant.setAddress(location);
        currentRestaurant.setCuisine(cuisine);
        currentRestaurant.setName(name);
        currentRestaurant.setTagline(tagLine);

        Disposable updateRestaurantDisposable = dataManager.updateRestaurant(currentRestaurant)
                .subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
                .subscribe(() -> view.dismissWithMessage("Changes saved"),
                        throwable -> view.dismissWithMessage("Unable to save. Try later"));
        compositeDisposable.add(updateRestaurantDisposable);
    }

    @Override
    public void onFavouriteTapped() {

        Disposable restaurantDisposable = dataManager.getRestaurant(currentRestaurant
                .getSlug())
                .subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
                .subscribe(this::deleteRestaurant,
                        throwable -> addRestaurant(currentRestaurant));
        compositeDisposable.add(restaurantDisposable);

    }

    private void addRestaurant(Restaurant restaurant) {

        Disposable favDisposable = dataManager.favouriteRestaurant(restaurant)
                .subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
                .subscribe(() -> view.setFavouriteStatus(true),
                        throwable -> view.setFavouriteStatus(false));

        compositeDisposable.add(favDisposable);
    }

    private void deleteRestaurant(Restaurant restaurant) {

        Disposable deleteDisposable = dataManager.deleteRestaurant(restaurant)
                .subscribeOn(backgroundScheduler)
                .observeOn(foregroundScheduler)
                .subscribe(() -> view.setFavouriteStatus(false),
                        throwable -> view.setFavouriteStatus(true));

        compositeDisposable.add(deleteDisposable);
    }


    @Override
    public void destroy() {
        this.view = null;
        compositeDisposable.dispose();
    }

    public DetailsContract.View getView() {
        return view;
    }
}

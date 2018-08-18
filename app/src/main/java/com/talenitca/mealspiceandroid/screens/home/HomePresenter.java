package com.talenitca.mealspiceandroid.screens.home;

import com.talenitca.mealspiceandroid.data.DataManager;
import com.talenitca.mealspiceandroid.data.models.Restaurant;
import com.talenitca.mealspiceandroid.di.Background;
import com.talenitca.mealspiceandroid.di.Foreground;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private DataManager dataManager;
    private Scheduler backgroundScheduler, foregroundScheduler;

    private CompositeDisposable compositeDisposable;

    @Inject
    public HomePresenter(HomeContract.View view, DataManager dataManager,
                         @Background Scheduler backgroundScheduler,
                         @Foreground Scheduler foregroundScheduler) {
        this.view = view;
        this.dataManager = dataManager;
        this.backgroundScheduler = backgroundScheduler;
        this.foregroundScheduler = foregroundScheduler;
        compositeDisposable = new CompositeDisposable();
    }


    @Override
    public void fetchAllData() {
        view.showLoading();
        compositeDisposable.add(
                dataManager.fetchAllRestaurants(1)
                        .subscribeOn(backgroundScheduler)
                        .observeOn(foregroundScheduler)
                        .doOnComplete(() -> view.hideLoading())
                        .subscribe(restaurants -> view.loadRestaurants(restaurants),
                                throwable -> {
                                    view.onError(throwable);
                                    view.hideLoading();
                                })
        );
    }

    @Override
    public void onRestaurantClicked(Restaurant restaurant) {
        view.navigateToDetails(restaurant);
    }

    @Override
    public void destroy() {
        view = null;
        compositeDisposable.dispose();
    }

    public HomeContract.View getView() {
        return view;
    }
}

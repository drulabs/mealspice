package com.talenitca.mealspiceandroid.screens;

public interface BaseView<T> {
    void showLoading();
    void hideLoading();
    T getPresenter();
}

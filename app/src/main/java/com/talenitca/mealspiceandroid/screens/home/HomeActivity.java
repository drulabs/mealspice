package com.talenitca.mealspiceandroid.screens.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.talenitca.mealspiceandroid.R;
import com.talenitca.mealspiceandroid.app.MealSpiceApp;
import com.talenitca.mealspiceandroid.data.models.Restaurant;
import com.talenitca.mealspiceandroid.di.DaggerViewComponent;
import com.talenitca.mealspiceandroid.di.HomeActivityScope;
import com.talenitca.mealspiceandroid.di.ViewModule;
import com.talenitca.mealspiceandroid.screens.details.DetailsActivity;
import com.talenitca.mealspiceandroid.screens.details.DetailsContract;

import java.util.List;

import javax.inject.Inject;

@HomeActivityScope
public class HomeActivity extends AppCompatActivity implements HomeContract.View,
        HomeAdapter.IRestaurantListClickListener {

    private HomeAdapter mAdapter;
    private ProgressBar mProgressBar;

    @Inject
    HomeContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        RecyclerView mRecyclerView = findViewById(R.id.activity_home_recyclerview);
        mProgressBar = findViewById(R.id.activity_home_progressbar);

        mAdapter = new HomeAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        DaggerViewComponent.builder()
                .appComponent(((MealSpiceApp) getApplication()).getAppComponent())
                .viewModule(new ViewModule(this))
                .build()
                .inject(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.txt_restautant_list);
        }

        mPresenter.fetchAllData();
    }

    @Override
    public void loadRestaurants(List<Restaurant> restaurantList) {
        if (mAdapter != null) mAdapter.setData(restaurantList);
    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(this, throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToDetails(Restaurant restaurant) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("slug", restaurant.getSlug());
        startActivity(intent);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public DetailsContract.Presenter getPresenter() {
        return null;
    }

    @Override
    public void onRestaurantClicked(Restaurant restaurant) {
        mPresenter.onRestaurantClicked(restaurant);
    }
}

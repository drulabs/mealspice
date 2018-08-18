package com.talenitca.mealspiceandroid.screens.home;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.squareup.picasso.Picasso;
import com.talenitca.mealspiceandroid.R;
import com.talenitca.mealspiceandroid.data.models.Restaurant;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.FeedViewHolder> {
    private List<Restaurant> mRestaurants;
    private IRestaurantListClickListener mListener;

    public HomeAdapter(IRestaurantListClickListener listener) {
        mListener = listener;
    }

    public void setData(List<Restaurant> restaurants) {
        this.mRestaurants = restaurants;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.feed_item, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        if (mRestaurants != null) holder.bind(mRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return mRestaurants == null ? 0 : mRestaurants.size();
    }

    class FeedViewHolder extends RecyclerView.ViewHolder {

        private TextView restaurantName;
        private TextView restaurantAddress;
        private TextView restaurantDetails;
        private ImageView restaurantImage;
        private CardView mCardView;

        FeedViewHolder(View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurant_name);
            restaurantAddress = itemView.findViewById(R.id.restaurant_address);
            restaurantDetails = itemView.findViewById(R.id.restaurant_info);
            restaurantImage = itemView.findViewById(R.id.restaurant_image);
            mCardView = itemView.findViewById(R.id.parent_cardview);
        }

        @SuppressLint("CheckResult")
        void bind(final Restaurant restaurant) {
            restaurantName.setText(restaurant.getName());
            restaurantAddress.setText(restaurant.getAddress());
            restaurantDetails.setText(String.format(itemView.getContext().getString(R.string
                            .txt_established_on), restaurant.getEstablished()));
            Picasso.with(restaurantImage.getContext())
                    .load(restaurant.getPic())
                    .placeholder(R.mipmap.ic_launcher)
                    .centerCrop().fit().into(restaurantImage);

            RxView.clicks(mCardView)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .throttleFirst(1000, TimeUnit.MILLISECONDS)
                    .subscribe(o -> mListener.onRestaurantClicked(restaurant),
                            throwable -> Log.e("Adapter", "bind: error"));
        }
    }

    interface IRestaurantListClickListener {
        void onRestaurantClicked(Restaurant restaurant);
    }
}

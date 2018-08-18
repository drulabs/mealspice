package com.talenitca.mealspiceandroid.data.network.httpurl;
import com.talenitca.mealspiceandroid.data.DataManager;
import com.talenitca.mealspiceandroid.data.models.Comment;
import com.talenitca.mealspiceandroid.data.models.Restaurant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

interface INetworkServiceCallback {
    void onDataReceived(String result);
}

public class HttpUrlNWManager {

    private List<Restaurant> mRestaurantList;
    public static final String URL_FETCH_ALL_RESTAURANTS = "https://pmd-test-app-001.herokuapp.com/restaurants";
    public static final String URL_FETCH_RESTAURANT_DETAIL = "https://pmd-test-app-001.herokuapp.com/restaurant/";

    //TODO : add callback
    public void updateRestaurant(String slug){

    }

    public void deleteRestaurant(String slug){

    }

    public void addComment(String slug,String comment){

    }

    public void addReaction(String slug){

    }

    public void fetchRestaurantDetails(String slug, final DataManager.Callback<Restaurant> restaurantCallback) {
        new HttpUrlNWService(URL_FETCH_RESTAURANT_DETAIL + slug, new INetworkServiceCallback() {
            @Override
            public void onDataReceived(String result) {
                try {
                    JSONObject restaurantJson = new JSONObject(result);
                    restaurantCallback.onResponse(getRestaurantObject(restaurantJson));
                } catch (JSONException e) {
                    restaurantCallback.onError(new Throwable("Json parsing exception !!"));
                }

            }
        }).execute();
    }

    public void fetchAllRestaurants(int page, final DataManager.Callback<List<Restaurant>> callback) {
        mRestaurantList = new ArrayList<>();
        new HttpUrlNWService(URL_FETCH_ALL_RESTAURANTS, new INetworkServiceCallback() {
            @Override
            public void onDataReceived(String result) {
                parseRestaurantList(result, callback);
            }
        }).execute();
    }

    //parse all restaurant list
    private void parseRestaurantList(String result, DataManager.Callback<List<Restaurant>> callback) {
        try {
            JSONArray restaurantArray = new JSONArray(result);
            for (int i = 0; i < restaurantArray.length(); i++) {
                JSONObject restaurantJson = restaurantArray.getJSONObject(i);
                Restaurant restaurant = getRestaurantObject(restaurantJson);
                mRestaurantList.add(restaurant);
            }

        } catch (JSONException e) {
            callback.onError(new Throwable("Json parsing error"));
            e.printStackTrace();
        }

        callback.onResponse(mRestaurantList);
    }

    private Restaurant getRestaurantObject(JSONObject restaurantJson) throws JSONException {
        Restaurant restaurant = new Restaurant();

        restaurant.setAddress(restaurantJson.getString("address"));
        restaurant.setCity(restaurantJson.getString("city"));
        restaurant.setCountry(restaurantJson.getString("country"));
        restaurant.setCuisine(restaurantJson.getString("cuisine"));
        restaurant.setEmail(restaurantJson.getString("email"));
        restaurant.setEstablished(restaurantJson.getLong("established"));
        restaurant.setHasBranches(restaurantJson.getBoolean("hasBranches"));
        restaurant.setLatitude(restaurantJson.getString("latitude"));
        restaurant.setLongitude(restaurantJson.getString("longitude"));
        restaurant.setName(restaurantJson.getString("name"));
        restaurant.setPic(restaurantJson.getString("pic"));
        restaurant.setSlug(restaurantJson.getString("slug"));
        restaurant.setRating(restaurantJson.getLong("rating"));
        restaurant.setTagline(restaurantJson.getString("tagline"));
        restaurant.setUpdated(restaurantJson.getString("updated"));
        restaurant.setId(restaurantJson.getString("_id"));

        JSONArray commentsArray = restaurantJson.getJSONArray("comments");

        for (int j = 0; j < commentsArray.length(); j++) {
            JSONObject commentJson = commentsArray.getJSONObject(j);

            Comment comment = new Comment();
            comment.setBody(commentJson.getString("body"));
            comment.setCommentedBy(commentJson.getString("commented_by"));
            comment.setDate(commentJson.getString("date"));
            comment.setId(commentJson.getString("_id"));

            restaurant.addComment(comment);
        }
        return restaurant;
    }
}

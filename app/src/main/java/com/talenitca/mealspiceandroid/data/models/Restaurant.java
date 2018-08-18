
package com.talenitca.mealspiceandroid.data.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "restaurants")
public class Restaurant {

    @PrimaryKey
    @SerializedName("_id")
    private @NonNull
    String id;

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private String city;

    @Ignore
    @SerializedName("comments")
    private List<Comment> comments;

    @SerializedName("country")
    private String country;

    @SerializedName("cuisine")
    private String cuisine;

    @SerializedName("email")
    private String email;

    @SerializedName("established")
    private Long established;

    @SerializedName("hasBranches")
    private Boolean hasBranches;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("name")
    private String name;

    @SerializedName("pic")
    private String pic;

    @SerializedName("rating")
    private Long rating;

    @SerializedName("slug")
    private String slug;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("updated")
    private String updated;

    public Restaurant() {

    }

    @Ignore
    public Restaurant(String name) {
        this.name = name;
    }

    public void addComment(Comment comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEstablished() {
        return established;
    }

    public void setEstablished(Long established) {
        this.established = established;
    }

    public Boolean getHasBranches() {
        return hasBranches;
    }

    public void setHasBranches(Boolean hasBranches) {
        this.hasBranches = hasBranches;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        id = _id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;

        Restaurant that = (Restaurant) o;

        if (!address.equals(that.address)) return false;
        if (!city.equals(that.city)) return false;
        if (!country.equals(that.country)) return false;
        if (!cuisine.equals(that.cuisine)) return false;
        if (!email.equals(that.email)) return false;
        if (!established.equals(that.established)) return false;
        if (!hasBranches.equals(that.hasBranches)) return false;
        if (!latitude.equals(that.latitude)) return false;
        if (!longitude.equals(that.longitude)) return false;
        if (!name.equals(that.name)) return false;
        if (!pic.equals(that.pic)) return false;
        if (!rating.equals(that.rating)) return false;
        if (!slug.equals(that.slug)) return false;
        if (!tagline.equals(that.tagline)) return false;
        if (!updated.equals(that.updated)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int result = address.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + cuisine.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + established.hashCode();
        result = 31 * result + hasBranches.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + pic.hashCode();
        result = 31 * result + rating.hashCode();
        result = 31 * result + slug.hashCode();
        result = 31 * result + tagline.hashCode();
        result = 31 * result + updated.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}

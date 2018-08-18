
package com.talenitca.mealspiceandroid.data.models;

import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("body")
    private String mBody;
    @SerializedName("commented_by")
    private String mCommentedBy;
    @SerializedName("date")
    private String mDate;
    @SerializedName("_id")
    private String m_id;

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public String getCommentedBy() {
        return mCommentedBy;
    }

    public void setCommentedBy(String commentedBy) {
        mCommentedBy = commentedBy;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getId() {
        return m_id;
    }

    public void setId(String _id) {
        m_id = _id;
    }

}
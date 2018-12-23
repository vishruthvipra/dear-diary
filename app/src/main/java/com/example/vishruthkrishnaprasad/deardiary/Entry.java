package com.example.vishruthkrishnaprasad.deardiary;

/**
 * Created by vishruthkrishnaprasad on 31/1/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Entry {

    @SerializedName("date")
    @Expose
    public Date date;

    @SerializedName("content")
    @Expose
    public String content;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
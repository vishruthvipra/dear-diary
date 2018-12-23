package com.example.vishruthkrishnaprasad.deardiary;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Url;

/**
 * Created by vishruthkrishnaprasad on 7/2/17.
 */

public interface RetrofitObjectAPI {
    @GET()
    Call<Entry> getEntryDetails(@Url String url);
}
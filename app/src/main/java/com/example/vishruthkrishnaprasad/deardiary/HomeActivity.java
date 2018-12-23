package com.example.vishruthkrishnaprasad.deardiary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.vishruthkrishnaprasad.deardiary.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class HomeActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ProgressDialog pdLoading;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // A custom styled toolbar is added at the top of the screen
//        setSupportActionBar(activityMainBinding.toolbar);

        activityMainBinding.recyclerView.setAdapter(adapter);
        activityMainBinding.fabPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NewEntryActivity.class);
                startActivity(intent);
            }
        });
    }


    void getRetrofitObject(String searchQuery) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.zappos.com/Search?term=&key=b743e26728e16b81da139182bb2094357c31d331")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);

        // A dialog box for the user to know that data is being fetched from the remote database.
        pdLoading = new ProgressDialog(HomeActivity.this);
        pdLoading.setTitle("Loading");
        pdLoading.setMessage("Loading data for your query...");
        pdLoading.setCancelable(false);
        pdLoading.show();

        // the search query is appended to the url and then the Call is made
        Call<Entry> call
                = service.getEntryDetails("https://api.zappos.com/Search?term="
                + searchQuery
                + "&key=b743e26728e16b81da139182bb2094357c31d331");

        call.enqueue(new Callback<Entry>() {
            @Override
            public void onResponse(Response<Entry> response, Retrofit retrofit) {
                List<Entry> resultOfProducts = new ArrayList<>();

                try {
                    Entry entry = new Entry();
                    entry.setDate(response.body().getDate());
                    entry.setContent(response.body().getContent());

                    resultOfProducts.add(entry);
                    adapter = new RecyclerViewAdapter(resultOfProducts);
                    recyclerView.setAdapter(adapter);

                    // dismiss the dialog
                    pdLoading.dismiss();
                } catch (Exception e) {
                    Log.e("onResponse", "There is an error" + e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("onResponse", "There is an error" + t);
            }
        });
    }
}

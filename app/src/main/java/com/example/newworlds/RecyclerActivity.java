package com.example.newworlds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerResults);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Declare some data - just use current time for now
        final Controller aController = (Controller) getApplicationContext();
        ArrayList<Resturant> restaurantData = aController.getRestaurants();
        Log.d("NUMBER OF RESTAURANTS", String.valueOf(restaurantData.size()));

        // specify an adapter
        adapter = new RecyclerViewAdapter(restaurantData,this);
        recyclerView.setAdapter(adapter);

    }
}

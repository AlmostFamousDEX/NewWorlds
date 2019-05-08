package com.example.newworlds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private RecyclerView.Adapter adapter1;
    private RecyclerView.Adapter adapter2;
    private RecyclerView.Adapter adapter3;
    private RecyclerView.LayoutManager layoutManager1;
    private RecyclerView.LayoutManager layoutManager2;
    private RecyclerView.LayoutManager layoutManager3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerRestaurants);
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerEntertainment);
        recyclerView3 = (RecyclerView) findViewById(R.id.recyclerEducation);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView1.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView3.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager1 = new LinearLayoutManager(this);
        layoutManager2 = new LinearLayoutManager(this);
        layoutManager3 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView3.setLayoutManager(layoutManager3);

        // Declare some data - just use current time for now
        final Controller aController = (Controller) getApplicationContext();
        ArrayList<Resturant> restaurantData = aController.getRestaurants();
        Log.d("NUMBER OF RESTAURANTS", String.valueOf(restaurantData.size()));

        ArrayList<Resturant> selectedRestaurants = aController.getResturantsFromName(aController.getCurrentResturantType());
        ArrayList<Entertainment> selectedEntertainment = aController.getEntertainmentSitesFromType(aController.getCurrentEntertainmentType());
        ArrayList<Education> selectedEducation = aController.getEducationSitesFromType(aController.getCurrentEducationType());
        //ArrayList<Place> selectedEverything = aController.getPlacesfromTypes?(aController.getCurrentType()); //idk if this is possible???

        //IS IT POSSIBLE TO GET THESE METHODS? ^^^

        // specify an adapter
        //adapter = new RecyclerViewAdapter(selectedRestaurants,selectedEntertainment, selectedEducation, this);
        adapter1 = new RecyclerViewAdapterRestaurant(selectedRestaurants, this); //this one works to some extent
        adapter2 = new RecyclerViewAdapterEntertainment(selectedEntertainment, this);
        adapter3 = new RecyclerViewAdapterEducation(selectedEducation, this);
        recyclerView1.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);
        recyclerView3.setAdapter(adapter3);

        final Button buttonOp1 = (Button) findViewById(R.id.genButton);
        buttonOp1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerActivity.this,RecyclerItinerariesActivity.class);
                startActivity(intent);
            }
        });
    }
}

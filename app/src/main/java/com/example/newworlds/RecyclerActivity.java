package com.example.newworlds;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * This class creates RecyclerViews for each category from which users can select places to add to their itinerary
 */
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

        /**
         * Sets up three RecyclerViews for the restaurants, entertainment sites, and education sites
         */
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerRestaurants);
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerEntertainment);
        recyclerView3 = (RecyclerView) findViewById(R.id.recyclerEducation);

        /**
         * Improves the performance since changes in content do not change the layout size of the RecyclerView
         */
        recyclerView1.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView3.setHasFixedSize(true);

        /**
         * Sets up the linear layout manager
         */
        layoutManager1 = new LinearLayoutManager(this);
        layoutManager2 = new LinearLayoutManager(this);
        layoutManager3 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView3.setLayoutManager(layoutManager3);

        /**
         * Creates three array lists of each placed based on the types selected in the Preferences ACtivity
         */
        final Controller aController = (Controller) getApplicationContext();
        ArrayList<Restaurant> selectedRestaurants = aController.getResturantsFromName(aController.getCurrentResturantType());
        ArrayList<Entertainment> selectedEntertainment = aController.getEntertainmentSitesFromType(aController.getCurrentEntertainmentType());
        ArrayList<Education> selectedEducation = aController.getEducationSitesFromType(aController.getCurrentEducationType());


        /**
         * Creates and sets three new adapters for displaying restaurants, entertainment sites, and education sites
         */
        adapter1 = new RecyclerViewAdapterRestaurant(selectedRestaurants, this);
        adapter2 = new RecyclerViewAdapterEntertainment(selectedEntertainment, this);
        adapter3 = new RecyclerViewAdapterEducation(selectedEducation, this);
        recyclerView1.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);
        recyclerView3.setAdapter(adapter3);

        /**
         * Directs to the Recycler Itineraries Activity Class and passes in the places selected when
         * the "Generate Itineraries" Button is clicked
         */
        final Button buttonOp1 = (Button) findViewById(R.id.genButton);
        buttonOp1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent=new Intent(RecyclerActivity.this,RecyclerItinerariesActivity.class);
                intent.putExtra("Arjun Education",aController.getArjunEducation());
                Log.d("yay",aController.getArjunEducation().toString());
                intent.putExtra("Arjun Entertainment",aController.getArjunEntertainment());
                Log.d("yay2",aController.getArjunEntertainment().toString());
                intent.putExtra("Arjun Restaurant",aController.getArjunResturant());
                Log.d("yay3",aController.getArjunResturant().toString());

                startActivity(intent);
            }
        });
    }

}

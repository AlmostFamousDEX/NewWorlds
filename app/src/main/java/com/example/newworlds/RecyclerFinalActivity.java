package com.example.newworlds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * This class creates a RecyclerView for displaying a user's final itinerary(or itineraries)
 */
public class RecyclerFinalActivity extends AppCompatActivity {
    private RecyclerView recyclerView4;
    private RecyclerView.Adapter adapter4;
    private RecyclerView.LayoutManager layoutManager4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_final_itinerary);

        /**
         * Sets up a RecyclerView for the itinerary (or itineraries)
         */
        recyclerView4 = (RecyclerView) findViewById(R.id.recyclerFinal2);

        /**
         * Improves the performance since changes in content do not change the layout size of the RecyclerView
         */
        recyclerView4.setHasFixedSize(true);

        /**
         * Sets up the linear layout manager
         */
        layoutManager4 = new LinearLayoutManager(this);
        recyclerView4.setLayoutManager(layoutManager4);

        final Controller aController = (Controller) getApplicationContext();

        /**
         * Gets the schedule the user selected passed by from intents
         */
        Bundle bundle = getIntent().getExtras();
        ArrayList<ArrayList<Itenerary>> finalItinerary = (ArrayList<ArrayList<Itenerary>>) bundle.get("yolo");

        /**
         * Creates and sets an adapter for displaying the itineraries
         */
        adapter4 = new RecyclerViewAdapterFinal(finalItinerary, this);
        recyclerView4.setAdapter(adapter4);
    }
}

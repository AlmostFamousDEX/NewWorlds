package com.example.newworlds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerFinalActivity extends AppCompatActivity {
    private RecyclerView recyclerView4;
    private RecyclerView.Adapter adapter4;
    private RecyclerView.LayoutManager layoutManager4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_final_itinerary);

        recyclerView4 = (RecyclerView) findViewById(R.id.recyclerFinal);

        recyclerView4.setHasFixedSize(true);

        layoutManager4 = new LinearLayoutManager(this);
/*
        final Controller aController = (Controller) getApplicationContext();
        ArrayList<Itenerary> finalItinerary = chosenItinerary;
        //we probably need methods to get the chosenItinerary

        adapter4 = new RecyclerViewAdapterFinal(finalItinerary, this);
        recyclerView4.setAdapter(adapter4);
        */
    }
}

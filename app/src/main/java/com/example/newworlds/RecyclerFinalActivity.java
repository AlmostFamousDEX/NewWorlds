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

        recyclerView4 = (RecyclerView) findViewById(R.id.recyclerFinal2);

        recyclerView4.setHasFixedSize(true);

        layoutManager4 = new LinearLayoutManager(this);
        recyclerView4.setLayoutManager(layoutManager4);

        final Controller aController = (Controller) getApplicationContext();
        Bundle bundle = getIntent().getExtras();
        ArrayList<Itenerary> finalItinerary = (ArrayList<Itenerary>) bundle.get("yolo");
        //^^will implement once methods are written


        adapter4 = new RecyclerViewAdapterFinal(finalItinerary, this);
        recyclerView4.setAdapter(adapter4);
        //^^will implement once methods are written
    }
}

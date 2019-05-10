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
import java.util.Arrays;

public class RecyclerItinerariesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_itineraries);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerFinal);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        final Controller aController = (Controller) getApplicationContext();
        Bundle bundle = getIntent().getExtras();
        ArrayList<String> educations2 = (ArrayList<String>) bundle.get("I hope this works!!");
        ArrayList<String> entertainments2 = (ArrayList<String>) bundle.get("Array List Entertainment!!2");
        /*
        ArrayList<String> restaurants = (ArrayList<String>) bundle.get("Array List Restaurant!!");
        */
        if (educations2!=null) {
            Log.d("does this workkkkk???", Arrays.toString(educations2.toArray()));
        }
        if (entertainments2!=null) {
            Log.d("does this workkkkk???2", Arrays.toString(entertainments2.toArray()));
        }
        /*
        Log.d("does this workkkkk???3", Arrays.toString(restaurants.toArray()));
        */
        ArrayList<Education> itinerariesEducations = new ArrayList<Education>();
        ArrayList<Entertainment> itinerariesEntertainments = new ArrayList<Entertainment>();
        /*
        ArrayList<Resturant> itinerariesRestaurants = new ArrayList<Resturant>();
*/
        for (int j = 0;j<itinerariesEducations.size();j++){
            itinerariesEducations.set(j,aController.getObjectFromEducationName(educations2.get(j)));
        }

        for (int j = 0;j<itinerariesEntertainments.size();j++){
            itinerariesEntertainments.set(j,aController.getObjectFromEntertainmentName(entertainments2.get(j)));
        }
        /*
        for (int j = 0;j<itinerariesRestaurants.size();j++){
            itinerariesRestaurants.set(j,aController.getObjectFromResturantName(restaurants.get(j)));
        }
        /*
        ArrayList<ArrayList<Itenerary>> itineraries = aController.permutate(ArrayList<Resturant> itineraryRestaurants,
                ArrayList<Entertainment>itineraryEntertainment,ArrayList<Education>itineraryEducation);
        //we need to figure out how to use methods to get the above ArrayLists
        //these methods exist. However, we would need to use them in the Adapter classes and we have not figured out
        //how to use the controller in Adapter classes

        adapter = new RecycleViewAdapterItineraries(itineraries, this);
        recyclerView.setAdapter(adapter);
*/
        final Button buttonOp2 = (Button) findViewById(R.id.final_itinerary);
        buttonOp2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerItinerariesActivity.this,RecyclerFinalActivity.class);
                startActivity(intent);
            }
        });
    }
}

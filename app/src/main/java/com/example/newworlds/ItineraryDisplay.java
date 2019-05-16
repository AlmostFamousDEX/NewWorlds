package com.example.newworlds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * This class is not being used. Originally, it was being used to display the itinerary.
 */
public class ItineraryDisplay extends AppCompatActivity {

    final Controller aController = (Controller) getApplicationContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_display);





    }

    public void addResturant(String name)
    {
        aController.addObjectToResturantDisplay(name);
    }
    public void addEducation(String name)
    {
        aController.addObjectToEducationDisplay(name);
    }
    public void addEntertainment (String name)
    {
        aController.addObjectToEntertainmentDisplay(name);
    }
}

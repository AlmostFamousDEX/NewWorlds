package com.example.newworlds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * This class is currently not being used. However, it could be used in the future to direct to a screen
 * where users can input their location, and the app would provide places for them to go based on where they are.
 */
public class LocationInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_input);
    }
}

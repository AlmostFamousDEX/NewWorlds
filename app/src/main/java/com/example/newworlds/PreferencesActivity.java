package com.example.newworlds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This class is used to direct to the preferences activity screen. It contains code for the spinners from which
 * users can select types.
 */
public class PreferencesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        final ArrayList<String> restaurantType = new ArrayList<>();
        final ArrayList<String> entertainmentType = new ArrayList<>();
        final ArrayList<String> educationType = new ArrayList<>();

        final Controller aController = (Controller) getApplicationContext();

        String[] diners=aController.getResturantType();
        String[] shows=aController.getEntertainmentType();
        String[] sites=aController.getEducationType();

        /**
         * This code sets up the first spinner, fills it with restaurant types, and gets the type the user selected.
         */
        Spinner spinner = findViewById(R.id.foodChoices);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PreferencesActivity.this,android.R.layout.simple_spinner_item, diners);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String foodSelection = parent.getItemAtPosition(position).toString();
                final Controller aController = (Controller) getApplicationContext();
                aController.setCurrentResturantType(foodSelection);
                Log.d("foodSelection",foodSelection);
                Toast.makeText(parent.getContext(), foodSelection, Toast.LENGTH_SHORT).show();
                restaurantType.add(foodSelection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        /**
         * This code sets up the second spinner, fills it with entertainment types, and gets the type the user selected.
         */
        Spinner spinner2 = findViewById(R.id.entertainmentChoices);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(PreferencesActivity.this,android.R.layout.simple_spinner_item, shows);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String entertainmentSelection = parent.getItemAtPosition(position).toString();
                aController.setCurrentEntertainmentType(entertainmentSelection);
                Log.d("entertainmentSelection",entertainmentSelection);
                Toast.makeText(parent.getContext(), entertainmentSelection, Toast.LENGTH_SHORT).show();
                entertainmentType.add(entertainmentSelection);
            }

            //@Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         * This code sets up the third spinner, fills it with education types, and gets the type the user selected.
         */
        Spinner spinner3 = findViewById(R.id.educationalChoices);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(PreferencesActivity.this, android.R.layout.simple_spinner_item, sites);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String educationSelection = parent.getItemAtPosition(position).toString();
                aController.setCurrentEducationType(educationSelection);
                Log.d("educationSelection",educationSelection);
                Toast.makeText(parent.getContext(), educationSelection, Toast.LENGTH_SHORT).show();
                educationType.add(educationSelection);
            }

            //@Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        final Button buttonOp = (Button) findViewById(R.id.nextOp);
        buttonOp.setOnClickListener(new View.OnClickListener() {
            /**
             * This button directs to the RecyclerActivity class, which displays places to the user based on their
             * selections from the spinners
             * @param v the view
             */
            public void onClick(View v) {
                Intent intent=new Intent(PreferencesActivity.this,RecyclerActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

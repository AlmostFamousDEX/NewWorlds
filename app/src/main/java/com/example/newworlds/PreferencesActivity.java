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

        //String[] restaurantType;
        //String[] entertainmentType;
        //String[] educationType;

        /*
        String[] diners = bundle.getStringArray("diner");
        if (diners[0]!="")
        {
            Log.d("MyTest", "good1");
        }
        String[] shows = bundle.getStringArray("show");
        if (shows[0]!="")
        {
            Log.d("MyTest", "good2");
        }
        String[] sites = bundle.getStringArray("site");
        if (sites[0]!="")
        {
            Log.d("MyTest", "good3");
        }
        */

        //String[] diners1 = aController.getResturantType();
        //String[] shows1 = aController.getEntertainmentType();
        //String[] sites1 = aController.getEducationType();



        final Controller aController = (Controller) getApplicationContext();

        String[] diners=aController.getResturantType();
        String[] shows=aController.getEntertainmentType();
        String[] sites=aController.getEducationType();


        Spinner spinner = findViewById(R.id.foodChoices);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PreferencesActivity.this,android.R.layout.simple_spinner_item, diners);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String foodSelection = parent.getItemAtPosition(position).toString();
                final Controller aController = (Controller) getApplicationContext();
                aController.setCurrentResturantType(foodSelection);
                //String text2 = parent.getSelectedItem().toString();
                Log.d("foodSelection",foodSelection);
                //Log.d("my selectionnnn",text2);
                Toast.makeText(parent.getContext(), foodSelection, Toast.LENGTH_SHORT).show();
                restaurantType.add(foodSelection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinner2 = findViewById(R.id.entertainmentChoices);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(PreferencesActivity.this,android.R.layout.simple_spinner_item, shows);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String entertainmentSelection = parent.getItemAtPosition(position).toString();
                aController.setCurrentEntertainmentType(entertainmentSelection);
                //String text2 = parent.getSelectedItem().toString();
                Log.d("entertainmentSelection",entertainmentSelection);
                //Log.d("my selectionnnn",text2);
                Toast.makeText(parent.getContext(), entertainmentSelection, Toast.LENGTH_SHORT).show();
                entertainmentType.add(entertainmentSelection);
            }

            //@Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinner3 = findViewById(R.id.educationalChoices);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(PreferencesActivity.this, android.R.layout.simple_spinner_item, sites);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String educationSelection = parent.getItemAtPosition(position).toString();
                aController.setCurrentResturantType(educationSelection);
                //String text2 = parent.getSelectedItem().toString();
                Log.d("educationSelection",educationSelection);
                //Log.d("my selectionnnn",text2);
                Toast.makeText(parent.getContext(), educationSelection, Toast.LENGTH_SHORT).show();
                educationType.add(educationSelection);
            }

            //@Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ;

        //fixed
        final Button buttonOp = (Button) findViewById(R.id.nextOp);
        buttonOp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(PreferencesActivity.this,OptionsActivity.class);
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
/*
    private void initRecyclerView(){
        //Log.d(TAG,"initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, )
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initRecyclerView(){
        //Log.d(TAG,"initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
*/
}

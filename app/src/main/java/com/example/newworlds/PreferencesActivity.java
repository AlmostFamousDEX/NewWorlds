package com.example.newworlds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String[] diners = bundle.getStringArray("diner");
        if (diners[0]!="")
        {
            Log.d("MyTest", "good");
        }
        String[] shows = bundle.getStringArray("show");
        if (shows[0]!="")
        {
            Log.d("MyTest", "good");
        }
        String[] sites = bundle.getStringArray("site");
        if (sites[0]!="")
        {
            Log.d("MyTest", "good");
        }

        Spinner spinner = findViewById(R.id.foodChoices);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PreferencesActivity.this,android.R.layout.simple_spinner_item, diners);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.entertainmentChoices);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(PreferencesActivity.this,android.R.layout.simple_spinner_item, shows);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 = findViewById(R.id.educationalChoices);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(PreferencesActivity.this, android.R.layout.simple_spinner_item, sites);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

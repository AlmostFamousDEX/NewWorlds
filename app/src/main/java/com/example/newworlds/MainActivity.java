package com.example.newworlds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Resturant> resturants = new ArrayList<Resturant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Hello", "Alex is active");
        Log.d("Sup","Hi this is Alex!!!!");
        Log.d("tets","tets");
        Log.d("test", "arjun test");
        Log.d("test","once againn");

        resturants();
         final String[] Diners = new String[resturants.size()];

        for (int i=0; i<resturants.size(); i++)
        {
            Resturant diner = resturants.get(i);
            Diners[i]=diner.getType();
        }
        final String[] info1 = Diners;

        final Button button = (Button) findViewById(R.id.planTripView);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),PreferencesActivity.class);
                intent.putExtra("diner", Diners);
                startActivity(intent);
            }
        });

    }


    public void resturants(){
        InputStream is = getResources().openRawResource(R.raw.restaurants);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));


        boolean skip =false;

        String line ="";
        try {
            while ((line=reader.readLine()) != null){
                if (skip)
                {
                    //split by ,
                    String[] fields = line.split(",");

                    //read data
                    resturants.add(new Resturant(fields[0],fields[1],fields[2],fields[3],fields[4]));
                }
                else {
                    skip = true;
                }
            }
        }
        catch (IOException e){
            Log.wtf("MainActivity","ERROR reading data on line: "+line);
        }
    }

}


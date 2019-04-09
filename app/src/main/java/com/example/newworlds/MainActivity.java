package com.example.newworlds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View;
import android.widget.Button;

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
    }

    public  void onClick(View v)
    {
        Intent intent = new Intent(this,MapsActivityTester.class);
        startActivity(intent);
    }
    public void resturants(){
        InputStream is = getResources().openRawResource(R.raw.restaurants);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String songStr ="";
        for (Resturant r : resturants) {
            songStr += r.getName()+r.getType()+r.getAddress()+r.getOhours()+r.getChours()+"\n";
        }

        boolean skip =false;

        String line ="";
        try {
            while ((line=reader.readLine()) != null){
                if (skip)
                {
                    //split by ,
                    String[] fields = line.split(",");

                    //read data
                    resturants.add(new Resturant(fields[0],fields[1],fields[2],Double.parseDouble(fields[3]),Double.parseDouble(fields[4])));
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


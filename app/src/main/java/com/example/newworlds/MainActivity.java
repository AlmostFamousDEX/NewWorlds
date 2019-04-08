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

public class MainActivity extends AppCompatActivity {

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
        InputStream is = getResources().openRawResource(R.raw.Restaurants);
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
                    //ADD LINE HERE
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


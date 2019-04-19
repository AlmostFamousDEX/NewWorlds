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
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Resturant> resturants = new ArrayList<Resturant>();
    private ArrayList<Entertainment> entertainment = new ArrayList<Entertainment>();
    private ArrayList<Education> education = new ArrayList<Education>();

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
        entertainment();
        education();

        final String[] Diners = new String[resturants.size()];
        final String[] Shows = new String[entertainment.size()];
        final String[] Sites = new String[education.size()];

        for (int i=0; i<resturants.size(); i++)
        {
            Resturant diner = resturants.get(i);
            Diners[i]=diner.getType();
            //Arrays.sort(Diners);
        }
        for (int i=0; i<entertainment.size(); i++)
        {
            Entertainment show = entertainment.get(i);
            Shows[i]=show.getType();
            //Arrays.sort(Shows);
        }
        for (int i=0; i<education.size(); i++)
        {
            Education site = education.get(i);
            Sites[i]=site.getType();
            //Arrays.sort(Sites);
        }
/*
        List<String> diners = new ArrayList<>();
        List<String> shows = new ArrayList<>();
        List<String> sites = new ArrayList<>();


        for (int i=0; i<Diners.length; i++)
        {
            for (int j=0;j<Diners.length;j++) {
                if (Diners[i] != Diners[j]) {
                    diners.add(Diners[i]);
                }
            }
        }
        for (int i=0; i<Shows.length; i++)
        {
            for (int j=0;j<Shows.length;j++) {
                if (Shows[i] != Shows[j]) {
                    shows.add(Shows[i]);
                }
            }
        }
        for (int i=0; i<Sites.length; i++)
        {
            for (int j=0;j<Sites.length;j++) {
                if (Sites[i] != Sites[j]) {
                    sites.add(Sites[i]);
                }
            }
        }
        */
        final String[] info1 = Diners;

        final Button button = (Button) findViewById(R.id.planTripView);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),PreferencesActivity.class);
                intent.putExtra("diner", Diners);
                intent.putExtra("show", Shows);
                intent.putExtra("site", Sites);
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
            Log.wtf("MainActivity-restaurants","ERROR reading data on line: "+line);
        }
    }
    public void entertainment(){
        InputStream is = getResources().openRawResource(R.raw.entertainment);
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
                    entertainment.add(new Entertainment(fields[0],fields[1],fields[2],fields[3],fields[4]));
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
    public void education(){
        InputStream is = getResources().openRawResource(R.raw.educational);
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
                    education.add(new Education(fields[0],fields[1],fields[2],fields[3],fields[4]));
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


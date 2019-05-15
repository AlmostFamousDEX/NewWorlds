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

    private String TAG="MainActivity";

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
        }
        Arrays.sort(Diners);
        Log.d("stressed", String.valueOf(Diners));
        for (int i=0; i<entertainment.size(); i++)
        {
            Entertainment show = entertainment.get(i);
            Shows[i]=show.getType();
        }
        Arrays.sort(Shows);
        for (int i=0; i<education.size(); i++)
        {
            Education site = education.get(i);
            Sites[i]=site.getType();
        }
        Arrays.sort(Sites);
/*
        List<String> diners = new ArrayList<>();
        List<String> shows = new ArrayList<>();
        List<String> sites = new ArrayList<>();
        */
        display(Diners);



        //restaurants
        int delete;
        delete=0;

        for (int i=1; i<Diners.length; i++)
        {
            if (Diners[i].equals(Diners[i-1])) {
                Log.d("a repeat!!","yeee");
                Diners[i] = "XX";
            }
            else{
                Log.d("not a repeat","yerrrr");
            }
        }
        for (int l=0;l<Diners.length;l++){
            if (Diners[l].equals(("XX"))){
                delete++;
            }
        }

        display(Diners);

        String[] diners = new String[Diners.length-delete+1];
        Log.d("AlexLength",String.valueOf(Diners.length-delete));

        diners[0]="None Selected";

        int counter=1;

        for (int j=0;j<Diners.length;j++)
        {
            if (!(Diners[j].equals("XX")))
            {
                diners[counter]=Diners[j];
                counter++;
            }
        }

        final String[] diners1 = diners;

        //entertainment
        int delete2;
        delete2=0;

        for (int i=1; i<Shows.length; i++)
        {
            if (Shows[i].equals(Shows[i-1])) {
                Log.d("a repeat!!","yeee");
                Shows[i] = "XX";
            }
            else{
                Log.d("not a repeat","yerrrr");
            }
        }
        for (int l=0;l<Shows.length;l++){
            if (Shows[l].equals(("XX"))){
                delete2++;
            }
        }

        display(Shows);

        String[] shows = new String[Shows.length-delete2+1];
        Log.d("AlexLength2",String.valueOf(Shows.length-delete2));

        shows[0]="None Selected";

        int counter2=1;

        for (int j=0;j<Shows.length;j++)
        {
            if (!(Shows[j].equals("XX")))
            {
                shows[counter2]=Shows[j];
                counter2++;
            }
        }
        final String[] shows1 = shows;

        //education
        int delete3;
        delete3=0;

        for (int i=1; i<Sites.length; i++)
        {
            if (Sites[i].equals(Sites[i-1])) {
                Log.d("a repeat!!","yeee");
                Sites[i] = "XX";
            }
            else{
                Log.d("not a repeat","yerrrr");
            }
        }
        for (int l=0;l<Sites.length;l++){
            if (Sites[l].equals(("XX"))){
                delete3++;
            }
        }

        display(Sites);

        String[] sites = new String[Sites.length-delete3+1];
        Log.d("AlexLength3",String.valueOf(Sites.length-delete3));

        sites[0]="None Selected";

        int counter3=1;

        for (int j=0;j<Sites.length;j++)
        {
            if (!(Sites[j].equals("XX")))
            {
                sites[counter3]=Sites[j];
                counter3++;
            }
        }

        final String[] sites1 = sites;

        final String[] info1 = Diners;

        final Button planTrip = (Button) findViewById(R.id.planTripView);
        planTrip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),PreferencesActivity.class);
                //intent.putExtra("diner", diners1);
                //intent.putExtra("show", shows1);
                //intent.putExtra("site", sites1);
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
    public static void display(String[] array){
        for (int j=0;j<array.length;j++){
            Log.d("EdenAllen",array[j]);
        }
    }
    public static void display2(String[] array){
        for (int j=0;j<array.length;j++){
            Log.d("AllenEden",array[j]);
        }
    }

}


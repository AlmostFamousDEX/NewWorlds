package com.example.newworlds;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Controller extends Application {
    private ArrayList<Resturant> resturants = new ArrayList<Resturant>();
    private ArrayList<Entertainment> entertainment = new ArrayList<Entertainment>();
    private ArrayList<Education> education = new ArrayList<Education>();

    protected void onCreate(Bundle savedInstanceState) {

        resturants();
        entertainment();
        education();

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
    //final Controller aController = (Controller) getApplicationContext();
    //
    //        String outputData = aController.getData().getProductName()
    //getData() will  return an object in this case
    //Add methods as needed

}

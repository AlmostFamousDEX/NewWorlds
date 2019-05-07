package com.example.newworlds;

//rework method names

import android.app.Application;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller extends Application {
    private ArrayList<Resturant> resturants = new ArrayList<Resturant>();
    private ArrayList<Entertainment> entertainment = new ArrayList<Entertainment>();
    private ArrayList<Education> education = new ArrayList<Education>();

    private ArrayList<Resturant> resturantsDisplay = new ArrayList<Resturant>();
    private ArrayList<Entertainment> entertainmentDisplay = new ArrayList<Entertainment>();
    private ArrayList<Education> educationDisplay = new ArrayList<Education>();

    private ArrayList<Resturant> edenResturants = new ArrayList<Resturant>();
    private ArrayList<Entertainment> edenEntertainment = new ArrayList<Entertainment>();
    private ArrayList<Education> edenEducation = new ArrayList<Education>();

    private String currentResturantType;
    private String currentEducationType;
    private String currentEntertainmentType;

    public void onCreate() {

        super.onCreate();

        resturants();
        entertainment();
        education();

        Log.d("AlexTestController","Good");

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
    public String[] getEducationType(){
        String[] Sites = new String[education.size()];
        for (int i=0; i<education.size(); i++)
        {
            Education site = education.get(i);
            Sites[i]=site.getType();
        }
        Arrays.sort(Sites);
        int delete3=0;

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
        String[] sites = new String[Sites.length-delete3+1];
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

        return sites;
    }
    public String[] getResturantType(){
        String[] Sites = new String[resturants.size()];
        for (int i=0; i<resturants.size(); i++)
        {
            Resturant site = resturants.get(i);
            Sites[i]=site.getType();
        }
        Arrays.sort(Sites);
        int delete3=0;

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
        String[] sites = new String[Sites.length-delete3+1];
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

        return sites;
    }
    public String[] getEntertainmentType(){
        String[] Sites = new String[entertainment.size()];
        for (int i=0; i<entertainment.size(); i++)
        {
            Entertainment site = entertainment.get(i);
            Sites[i]=site.getType();
        }
        Arrays.sort(Sites);
        int delete3=0;

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
        String[] sites = new String[Sites.length-delete3+1];
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

        return sites;
    }
    public ArrayList<Resturant> getRestaurants(){
        return resturants;
    }

    public String[] getNameFromResturantType(String type)
    {
        int counter=0;
        for (int i=0; i<resturants.size(); i++)
        {
            Resturant site = resturants.get(i);
            if (site.getType().equals(type))
            {
                counter++;
            }
        }
        int counter2=0;
        String[] dummy = new String[counter];
        for (int k=0; k<resturants.size(); k++)
        {
            Resturant site = resturants.get(k);
            if (site.getType().equals(type))
            {
                dummy[counter2]=site.getName();
                counter2++;
            }
        }
        return dummy;
    }

    public String[] getNameFromEducationType(String type)
    {
        int counter=0;
        for (int i=0; i<education.size(); i++)
        {
            Education site = education.get(i);
            if (site.getType().equals(type))
            {
                counter++;
            }
        }
        int counter2=0;
        String[] dummy = new String[counter];
        for (int k=0; k<education.size(); k++)
        {
            Education site = education.get(k);
            if (site.getType().equals(type))
            {
                dummy[counter2]=site.getName();
                counter2++;
            }
        }
        return dummy;
    }

    public String[] getNameFromEntertainmentType(String type)
    {
        int counter=0;
        for (int i=0; i<entertainment.size(); i++)
        {
            Entertainment site = entertainment.get(i);
            if (site.getType().equals(type))
            {
                counter++;
            }
        }
        int counter2=0;
        String[] dummy = new String[counter];
        for (int k=0; k<entertainment.size(); k++)
        {
            Entertainment site = entertainment.get(k);
            if (site.getType().equals(type))
            {
                dummy[counter2]=site.getName();
                counter2++;
            }
        }
        return dummy;
    }

    public String[] getInfoResturant(String name)
    {
        String[] dummy = new String[3];
        for (int i=0; i<resturants.size(); i++)
        {
            Resturant site = resturants.get(i);
            if (site.getName().equals(name))
            {
                dummy[0]=site.getAddress();
                dummy[1]=site.getOhours();
                dummy[2]=site.getChours();
            }
        }
        return dummy;
    }

    public String[] getInfoEntertainment(String name)
    {
        String[] dummy = new String[3];
        for (int i=0; i<entertainment.size(); i++)
        {
            Entertainment site = entertainment.get(i);
            if (site.getName().equals(name))
            {
                dummy[0]=site.getAddress();
                dummy[1]=site.getOhours();
                dummy[2]=site.getChours();
            }
        }
        return dummy;
    }

    public String[] getInfoEducation(String name)
    {
        String[] dummy = new String[3];
        for (int i=0; i<education.size(); i++)
        {
            Education site = education.get(i);
            if (site.getName().equals(name))
            {
                dummy[0]=site.getAddress();
                dummy[1]=site.getOhours();
                dummy[2]=site.getChours();
            }
        }
        return dummy;
    }

    public void addObjectToResturantDisplay( String name)
    {
        for (int i=0; i<resturants.size(); i++)
        {
            if (resturants.get(i).getName().equals(name))
            {
                resturantsDisplay.add(resturants.get(i));
            }
        }
    }

    public void addObjectToEducationDisplay( String name)
    {
        for (int i=0; i<education.size(); i++)
        {
            if (education.get(i).getName().equals(name))
            {
                educationDisplay.add(education.get(i));
            }
        }
    }

    public void addObjectToEntertainmentDisplay( String name)
    {
        for (int i=0; i<entertainment.size(); i++)
        {
            if (entertainment.get(i).getName().equals(name))
            {
                entertainmentDisplay.add(entertainment.get(i));
            }
        }
    }

    public ArrayList<Resturant> getResturantsFromName(String type)
    {
        for (int i=0; i<resturants.size(); i++)
        {
            if (resturants.get(i).getType().equals(type))
            {
                edenResturants.add(resturants.get(i));
            }
        }
        return edenResturants;
    }

    public void setCurrentEducationType(String currentEducationType) {
        this.currentEducationType = currentEducationType;
    }
    public void setCurrentResturantType (String currentResturantType)
    {
        this.currentResturantType=currentResturantType;
    }

    public void setCurrentEntertainmentType(String currentEntertainmentType) {
        this.currentEntertainmentType = currentEntertainmentType;
    }

    public String getCurrentEducationType() {
        return currentEducationType;
    }

    public String getCurrentEntertainmentType() {
        return currentEntertainmentType;
    }

    public String getCurrentResturantType() {
        return currentResturantType;
    }
    //final Controller aController = (Controller) getApplicationContext();
    //
    //        String outputData = aController.getData().getProductName()
    //getData() will  return an object in this case
    //Add methods as needed


    /*
    Algorithm Plan...

    Take information from preferences/options activity
       - this will basically find the type(s) selected from the spinners

    Then formulate arrays/arrayList based off the information for each type

    Limit options from each type to maybe 3-5

    Repeat process for all categories (restaurants, entertainment, education)



    public void restaurantItineraryDisplay()
        {
            diners;
        }
    public void entertainmentItineraryDisplay()
        {
            shows;
        }
    public void educationItineraryDisplay()
        {
            sites;
        }
        */
}

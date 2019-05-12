package com.example.newworlds;

//rework method names

import android.app.Application;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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

    private ArrayList<Resturant> arjunResturant = new ArrayList<Resturant>();
    private ArrayList<Entertainment> arjunEntertainment = new ArrayList<Entertainment>();
    private ArrayList<Education> arjunEducation = new ArrayList<Education>();

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

    public ArrayList<Resturant> getResturantsDisplay() {
        return resturantsDisplay;
    }

    public void addObjectToEducationDisplay(String name)
    {
        for (int i=0; i<education.size(); i++)
        {
            if (education.get(i).getName().equals(name))
            {
                educationDisplay.add(education.get(i));
            }
        }
    }

    public ArrayList<Education> getEducationDisplay() {
        return educationDisplay;
    }


    public void addObjectToEntertainmentDisplay(String name)
    {
        for (int i=0; i<entertainment.size(); i++)
        {
            if (entertainment.get(i).getName().equals(name))
            {
                entertainmentDisplay.add(entertainment.get(i));
            }
        }
    }

    public ArrayList<Entertainment> getEntertainmentDisplay() {
        return entertainmentDisplay;
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

    public ArrayList<Education> getEducationSitesFromType(String type)
    {
        for (int i=0; i<education.size(); i++)
        {
            if (education.get(i).getType().equals(type))
            {
                edenEducation.add(education.get(i));
            }
        }
        return edenEducation;
    }

    public ArrayList<Entertainment> getEntertainmentSitesFromType(String type)
    {
        for (int i=0; i<entertainment.size(); i++)
        {
            if (entertainment.get(i).getType().equals(type))
            {
                edenEntertainment.add(entertainment.get(i));
            }
        }
        return edenEntertainment;
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
        if (currentEducationType!=null)
        {
            return currentEducationType;

        }
        else
        {
            return "No type has been selected";
        }
    }

    public String getCurrentEntertainmentType() {
        if (currentEntertainmentType!=null)
        {
            return currentEntertainmentType;

        }
        else
        {
            return "No type has been selected";
        }
    }

    public String getCurrentResturantType() {
        if (currentResturantType!=null)
        {
            return currentResturantType;

        }
        else
        {
            return "No type has been selected";
        }
    }

    public ArrayList<ArrayList<Itenerary>> permutate(ArrayList<Resturant> res, ArrayList<Education> edu, ArrayList<Entertainment> ent)
    {
        int counter=0;

        if (res.size()==0)
        {
            counter++;
        }
        if (edu.size()==0)
        {
            counter++;
        }
        if (ent.size()==0)
        {
            counter++;
        }

        ArrayList<ArrayList<Itenerary>> dummy =new ArrayList<ArrayList<Itenerary>>();

        if (counter==3)
        {
            for (int i=0; i<res.size(); i++)
            {
                for (int j=0; j<edu.size(); j++)
                {
                    for (int k=0; k<ent.size(); k++)
                    {
                        Itenerary it1 = new Itenerary(res.get(i).getName(),res.get(i).getType(),res.get(i).getAddress(),res.get(i).getOhours(),res.get(i).getChours());
                        Itenerary it2 = new Itenerary(edu.get(j).getName(),edu.get(j).getType(),edu.get(j).getAddress(),edu.get(j).getOhours(),edu.get(j).getChours());
                        Itenerary it3 = new Itenerary(ent.get(k).getName(),ent.get(k).getType(),ent.get(k).getAddress(),ent.get(k).getOhours(),ent.get(k).getChours());

                        ArrayList<Itenerary> itOfficial=new ArrayList<Itenerary>();

                        itOfficial.add(it1);
                        itOfficial.add(it2);
                        itOfficial.add(it3);

                        dummy.add(itOfficial);
                    }
                }
            }
            return dummy;
        }
        if (counter==2)
        {
            if (res.size()==0)
            {

                    for (int j=0; j<edu.size(); j++)
                    {
                        for (int k=0; k<ent.size(); k++)
                        {

                            Itenerary it2 = new Itenerary(edu.get(j).getName(),edu.get(j).getType(),edu.get(j).getAddress(),edu.get(j).getOhours(),edu.get(j).getChours());
                            Itenerary it3 = new Itenerary(ent.get(k).getName(),ent.get(k).getType(),ent.get(k).getAddress(),ent.get(k).getOhours(),ent.get(k).getChours());

                            ArrayList<Itenerary> itOfficial=new ArrayList<Itenerary>();


                            itOfficial.add(it2);
                            itOfficial.add(it3);

                            dummy.add(itOfficial);
                        }
                    }

            }
            if (edu.size()==0)
            {
                for (int i=0; i<res.size(); i++)
                {

                        for (int k=0; k<ent.size(); k++)
                        {
                            Itenerary it1 = new Itenerary(res.get(i).getName(),res.get(i).getType(),res.get(i).getAddress(),res.get(i).getOhours(),res.get(i).getChours());

                            Itenerary it3 = new Itenerary(ent.get(k).getName(),ent.get(k).getType(),ent.get(k).getAddress(),ent.get(k).getOhours(),ent.get(k).getChours());

                            ArrayList<Itenerary> itOfficial=new ArrayList<Itenerary>();

                            itOfficial.add(it1);

                            itOfficial.add(it3);

                            dummy.add(itOfficial);
                        }

                }
            }
            if (ent.size()==0)
            {
                for (int i=0; i<res.size(); i++)
                {
                    for (int j=0; j<edu.size(); j++)
                    {

                            Itenerary it1 = new Itenerary(res.get(i).getName(),res.get(i).getType(),res.get(i).getAddress(),res.get(i).getOhours(),res.get(i).getChours());
                            Itenerary it2 = new Itenerary(edu.get(j).getName(),edu.get(j).getType(),edu.get(j).getAddress(),edu.get(j).getOhours(),edu.get(j).getChours());

                            ArrayList<Itenerary> itOfficial=new ArrayList<Itenerary>();

                            itOfficial.add(it1);
                            itOfficial.add(it2);


                            dummy.add(itOfficial);

                    }
                }
            }
            return dummy;
        }
        if (counter==1)
        {
            if (res.size()!=0)
            {
                for (int i=0; i<res.size(); i++)
                {

                            Itenerary it1 = new Itenerary(res.get(i).getName(),res.get(i).getType(),res.get(i).getAddress(),res.get(i).getOhours(),res.get(i).getChours());

                            ArrayList<Itenerary> itOfficial=new ArrayList<Itenerary>();

                            itOfficial.add(it1);

                            dummy.add(itOfficial);

                }
            }
            if (edu.size()!=0)
            {

                    for (int j=0; j<edu.size(); j++)
                    {


                            Itenerary it2 = new Itenerary(edu.get(j).getName(),edu.get(j).getType(),edu.get(j).getAddress(),edu.get(j).getOhours(),edu.get(j).getChours());

                            ArrayList<Itenerary> itOfficial=new ArrayList<Itenerary>();


                            itOfficial.add(it2);


                            dummy.add(itOfficial);

                    }

            }
            if (ent.size()!=0)
            {

                        for (int k=0; k<ent.size(); k++)
                        {

                            Itenerary it3 = new Itenerary(ent.get(k).getName(),ent.get(k).getType(),ent.get(k).getAddress(),ent.get(k).getOhours(),ent.get(k).getChours());

                            ArrayList<Itenerary> itOfficial=new ArrayList<Itenerary>();


                            itOfficial.add(it3);

                            dummy.add(itOfficial);
                        }
            }
                return dummy;
        }

        return dummy;
    }

    public Entertainment getObjectFromEntertainmentName(String name)
    {
        for (int i=0; i<entertainment.size(); i++)
        {
            if (entertainment.get(i).getName().equals(name))
            {
                return entertainment.get(i);
            }
        }
        return null;
    }

    public Resturant getObjectFromResturantName(String name)
    {
        for (int i=0; i<resturants.size(); i++)
        {
            if (resturants.get(i).getName().equals(name))
            {
                return resturants.get(i);
            }
        }
        return null;
    }

    public Education getObjectFromEducationName(String name)
    {
        for (int i=0; i<education.size(); i++)
        {
            if (education.get(i).getName().equals(name))
            {
                return education.get(i);
            }
        }
        return null;
    }

    public void addItemToArjunResturant (ArrayList<String> res)
    {
        for (int i=0; i<res.size(); i++)
        {
            String dummy = res.get(i);
            boolean test = true;

            for (int k=0; k<arjunResturant.size(); k++)
            {
                if (arjunResturant.get(k).getName().equals(dummy))
                {
                    test=false;
                }
            }
            if (test)
            {
                for (int k=0; k<resturants.size(); k++)
                {
                    if (resturants.get(k).getName().equals(dummy))
                    {
                        arjunResturant.add(resturants.get(k));
                    }
                }
            }
        }
    }
    public void addItemToArjunEducation (ArrayList<String> edu)
    {
        for (int i=0; i<edu.size(); i++)
        {
            String dummy = edu.get(i);
            boolean test = true;

            for (int k=0; k<arjunEducation.size(); k++)
            {
                if (arjunEducation.get(k).getName().equals(dummy))
                {
                    test=false;
                }
            }
            if (test)
            {
                for (int k=0; k<education.size(); k++)
                {
                    if (education.get(k).getName().equals(dummy))
                    {
                        arjunEducation.add(education.get(k));
                    }
                }
            }
        }
    }
    public void addItemToArjunEntertainment (ArrayList<String> ent)
    {
        for (int i=0; i<ent.size(); i++)
        {
            String dummy = ent.get(i);
            boolean test = true;

            for (int k=0; k<arjunEntertainment.size(); k++)
            {
                if (arjunEntertainment.get(k).getName().equals(dummy))
                {
                    test=false;
                }
            }
            if (test)
            {
                for (int k=0; k<entertainment.size(); k++)
                {
                    if (entertainment.get(k).getName().equals(dummy))
                    {
                        arjunEntertainment.add(entertainment.get(k));
                    }
                }
            }
        }
    }

    public ArrayList<Education> getArjunEducation() {
        return arjunEducation;
    }

    public ArrayList<Entertainment> getArjunEntertainment() {
        return arjunEntertainment;
    }

    public ArrayList<Resturant> getArjunResturant() {
        return arjunResturant;
    }

    public void removeElementFromArjunResturant (String name)
    {
        for (int i=0; i<arjunResturant.size(); i++)
        {
            if (arjunResturant.get(i).getName().equals(name))
            {
                arjunResturant.remove(i);
            }
        }
    }
    public void removeElementFromArjunEducation (String name)
    {
        for (int i=0; i<arjunEducation.size(); i++)
        {
            if (arjunEducation.get(i).getName().equals(name))
            {
                arjunEducation.remove(i);
            }
        }
    }
    public void removeElementFromArjunEntertainment (String name)
    {
        for (int i=0; i<arjunEntertainment.size(); i++)
        {
            if (arjunEntertainment.get(i).getName().equals(name))
            {
                arjunEntertainment.remove(i);
            }
        }
    }

    //public void setItinerary(ArrayList<Itenerary>)
    //public ArrayList<Itenerary> getItinerary


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

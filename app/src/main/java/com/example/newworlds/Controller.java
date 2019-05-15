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

import static android.media.CamcorderProfile.get;

public class Controller extends Application {

    //List of private variable

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


    private ArrayList<Itenerary> it=new ArrayList<Itenerary>();

    private ArrayList<ArrayList<Itenerary>> alexsItenerary = new ArrayList<ArrayList<Itenerary>>();

    private ArrayList<String> dummy2 = new ArrayList<String>();

    private ArrayList<Itenerary> alexDummyIRanOutOfOriginalNames = new ArrayList<Itenerary>();

    public void onCreate() {

        super.onCreate();
        //run this method when MainActivity is created

        resturants();
        entertainment();
        education();

        Log.d("AlexTestController","Good");

    }

    //Next three methods fill out original class arrays
    public void resturants(){
        InputStream is = getResources().openRawResource(R.raw.restaurants);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        //This variable is created to skip the first line of the CSV file
        //Same for next two methods
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
        //catch exceptions
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
    //returns a sorted array of education types
    public String[] getEducationType(){
        String[] Sites = new String[education.size()];
        for (int i=0; i<education.size(); i++)
        {
            Education site = education.get(i);
            Sites[i]=site.getType();
            //populate Sites[]
        }
        Arrays.sort(Sites);
        //Sort array
        int delete3=0;

        for (int i=1; i<Sites.length; i++)
        {
            if (Sites[i].equals(Sites[i-1])) {
                Log.d("a repeat!!","yeee");
                Sites[i] = "XX";
                //If an element in the sites array is the same as the one before it, change it to XX
            }
            else{
                Log.d("not a repeat","yerrrr");
            }
        }
        for (int l=0;l<Sites.length;l++){
            if (Sites[l].equals(("XX"))){
                delete3++;
                //find number of elements that are XX
            }
        }
        String[] sites = new String[Sites.length-delete3+1];
        sites[0]="None Selected";
        //create new array with none selected as first element

        int counter3=1;

        for (int j=0;j<Sites.length;j++)
        {
            if (!(Sites[j].equals("XX"))) //If element in Sites[] is not XX assign it to a corresponding value in sites[] and increment a counter
            {
                sites[counter3]=Sites[j];
                counter3++;
            }
        }

        return sites; //output
    }
    //For the next two methods see previous
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

    //returns a String[] of entertainment venues of a certain type

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

    //get info for res based off name

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

    //see above for next two methods

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

    //add object to an ArrayList of resturants that will be used to display the itenerary

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

    //get Array list

    public ArrayList<Resturant> getResturantsDisplay() {
        return resturantsDisplay;
    }

    //For next 4 see previous 2

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

    //This next method is misnamed OPPS!
    //It should read getResturants from type
    //Basically it adds all resturants of a certain type to an ArrayList
    //Next 2 also do the same thing for different objects

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

    //Stores the String off current education type
    //Next 2 follow similar pattern

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

    //If there is a current education type return it, otherwise return an error message
    //Same for next two

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

    //permuatation method to show all permutations of 3 given sets of ArrayLists

    public ArrayList<ArrayList<Itenerary>> permutate(ArrayList<Resturant> res, ArrayList<Education> edu, ArrayList<Entertainment> ent)
    {
        int counter=0;

        //See how many ArrayLists contain stuff

        if (res.size()>0)
        {
            counter++;
        }
        if (edu.size()>0)
        {
            counter++;
        }
        if (ent.size()>0)
        {
            counter++;
        }

        //create dummy variable

        ArrayList<ArrayList<Itenerary>> dummy =new ArrayList<ArrayList<Itenerary>>();

        if (counter==3)//if 3 ArrayLists contain stuff...
        {
            for (int i=0; i<res.size(); i++)
            {
                for (int j=0; j<edu.size(); j++)
                {
                    for (int k=0; k<ent.size(); k++)
                    {
                        //loop though each possibility and convert the individual elements selcted to Itenerary objects
                        Itenerary it1 = new Itenerary(res.get(i).getName(),res.get(i).getType(),res.get(i).getAddress(),res.get(i).getOhours(),res.get(i).getChours());
                        Itenerary it2 = new Itenerary(edu.get(j).getName(),edu.get(j).getType(),edu.get(j).getAddress(),edu.get(j).getOhours(),edu.get(j).getChours());
                        Itenerary it3 = new Itenerary(ent.get(k).getName(),ent.get(k).getType(),ent.get(k).getAddress(),ent.get(k).getOhours(),ent.get(k).getChours());

                        ArrayList<Itenerary> itOfficial=new ArrayList<Itenerary>();

                        itOfficial.add(it1);
                        itOfficial.add(it2);
                        itOfficial.add(it3);

                        dummy.add(itOfficial);
                        //add the combination just made to the dummy variable
                    }
                }
            }
            return dummy;
        }
        if (counter==2)//same idea for this case as well
                        //The main differnce is th I now need to figure out which one does not contain stuff and loop accordingly
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
        if (counter==1)//Only have to figure out which one contains stuff
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

    //Returns entertainment object based off a name
    //Same for next 2 (different class types)

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

    //adds items to ArrayList when given an array list of names
    //Same for next 2

    public void addItemToArjunResturant (ArrayList<String> res)
    {
        for (int i=0; i<res.size(); i++)//loop thru given array list
        {
            String dummy = res.get(i);
            boolean test = true;

            for (int k=0; k<arjunResturant.size(); k++)//make sure the element we are adding does not already exist in the ArrayList
            {
                if (arjunResturant.get(k).getName().equals(dummy))
                {
                    test=false;
                }
            }
            if (test)//if test passes
            {
                for (int k=0; k<resturants.size(); k++)
                {
                    if (resturants.get(k).getName().equals(dummy))
                    {
                        arjunResturant.add(resturants.get(k));//add item
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

    //get metrhods

    public ArrayList<Education> getArjunEducation() {
        return arjunEducation;
    }

    public ArrayList<Entertainment> getArjunEntertainment() {
        return arjunEntertainment;
    }

    public ArrayList<Resturant> getArjunResturant() {
        return arjunResturant;
    }

    //remove element form ArrayList based off name

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

    //setter and getter for Itenerary ArrayList

    public void setIt(ArrayList<Itenerary> it) {
        this.it = it;
    }

    public ArrayList<Itenerary> getIt() {
        return it;
    }

    //permutation method for an Itenerary ArrayList
    public ArrayList<ArrayList<Itenerary>> permutate2(ArrayList<Itenerary> it)
    {
        dummy2.clear(); //clear ArrayList used to store permutations
        ArrayList<ArrayList<Itenerary>> dummy = new ArrayList<ArrayList<Itenerary>>();

        //determine size and then get permutation possibilities
        if (it.size()==1)
        {
            permutate3("","0");
        }
        if (it.size()==2)
        {
            permutate3("","01");
        }
        if (it.size()==3)
        {
            permutate3("","012");
        }
        for (int i=0; i<dummy2.size(); i++)
        {
            alexDummyIRanOutOfOriginalNames.clear();
            String str = dummy2.get(i);
            Log.d("AlexSaysWork",str);
            //loop to get each permutation
            for (int k=0; k<str.length(); k++)
            {
                /*
                * This works because each permutation is essentially 012, 021, 102 ...
                * What I do is to convert the string into characters
                * Each of these characters are converted to an int which is then used to reference
                 * the original ArrayList passed as an argument
                *
                * */
                char c = str.charAt(k);
                int z = Character.getNumericValue(c);
                alexDummyIRanOutOfOriginalNames.add(it.get(z));
            }
            dummy.add(alexDummyIRanOutOfOriginalNames);

        }
        return dummy;
    }

    //Recursive method that stores all permutations of a String in an Arraylist

    private void permutate3(String pre, String rest) {
        if (rest.length()==1)
        {
            String str = pre+rest;
            dummy2.add(str);
            //add Strings to String ArrayList
        }
        else
        {
            for (int i=0; i<rest.length(); i++)
            {
                //loop thru all characters in remaining string
                //select character, add it to pre and the delete it from rest
                //then recursively call the method
                char c = rest.charAt(i);
                String str1 = String.valueOf(c);
                String str2=pre+str1;
                StringBuilder sb = new StringBuilder(rest);
                sb.deleteCharAt(i);
                String str3 = sb.toString();

                permutate3(str2,str3);
            }
        }
    }
/*
    public ArrayList<ArrayList<Itenerary>> edenPermutate(ArrayList<Itenerary>it){
        ArrayList<ArrayList<Itenerary>> combinations = new ArrayList<ArrayList<Itenerary>>();
        ArrayList<Itenerary> option = new ArrayList<Itenerary>();
        for (int i = 0;i<it.size();i++){
            for (int j = 0;j<it.size();j++){
                for (int k = 0;k<it.size();k++){
                    option.add(it.get(i));
                    option.add(it.get(j));
                    option.add(it.get(k));
                    for (int w =1;w<option.size();w++){
                        if (option.get(w).equals(option.get(w-1))){
                            option.remove(w);
                        }
                    }
                    if (option.size()==3){
                        if (option.get(0).equals(option.get(2))){
                            option.remove(2);
                        }
                    }
                    combinations.add(option);
                }
            }
        }
        return combinations;
    }
*/

    //setter and getter method
    public void addItemToAlexsItenerary(ArrayList<Itenerary> itLives)
    {
        alexsItenerary.add(itLives);
    }

    public ArrayList<ArrayList<Itenerary>> getAlexsItenerary() {
        return alexsItenerary;
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

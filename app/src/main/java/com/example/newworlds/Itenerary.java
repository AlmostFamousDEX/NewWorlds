package com.example.newworlds;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class represents an Itinerary consisting of a name, an address, a type, closing hours, and opening hours.
 */
public class Itenerary implements Parcelable {
    private String name;
    private String address;
    private String type;
    private String ohours;
    private String chours;

    /**
     * Creates a new Itinerary object
     * @param name is the name of the Itinerary object
     * @param type is the type of the Itinerary object
     * @param address is the address of the Itinerary object
     * @param ohours is the opening hours of the Itinerary object
     * @param chours is the closing hours of the Itinerary object
     */
    public Itenerary (String name,String type, String address, String ohours, String chours)
    {
        this.name=name;
        this.address =address;
        this.type=type;
        this.chours=chours;
        this.ohours=ohours;
    }

    /**
     * Accesses the name of the Itinerary object
     * @return the name
     */
    public String getName()
    {
        return  name;
    }

    /**
     * Accesses the address of the Itinerary object
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }
    /**
     * Accesses the type of Itinerary object
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Accesses the closing hours of Itinerary object
     * @return the closing hours
     */
    public String getChours() {
        return  chours;
    }

    /**
     * Accesses the opening hours of Itinerary object
     * @return the opening hours
     */
    public String getOhours() {
        return ohours;
    }

    /**
     * Allows the Itinerary object to be converted to a string
     * @return the name
     */
    public String toString(){
        return name;
    }

    //The following methods make the Itinerary object parcelable.
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {name,address,type,chours,ohours});
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public Itenerary createFromParcel(Parcel in){
            String[] string = in.createStringArray();
            Itenerary toReturn = new Itenerary(string[0],string[1],string[2],string[3],string[4]);
            return toReturn;
        }
        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };
    }

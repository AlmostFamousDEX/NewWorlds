package com.example.newworlds;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class represents a Restaurant consisting of a name, an address, a type, closing hours, and opening hours.
 */
public class Restaurant implements Parcelable {
    private String name;
    private String address;
    private String type;
    private String ohours;
    private String chours;

    /**
     * Creates a new Restaurant object
     * @param name is the name of the Restaurant
     * @param type is the type of Restaurant
     * @param address is the address of the Restaurant
     * @param ohours is the opening hours of the Restaurant
     * @param chours is the closing hours of the Restaurant
     */
    public Restaurant(String name, String type, String address, String ohours, String chours)
    {
        this.name=name;
        this.address =address;
        this.type=type;
        this.chours=chours;
        this.ohours=ohours;
    }

    /**
     * Accesses the name of the restaurant
     * @return the name
     */
    public String getName()
    {
        return  name;
    }

    /**
     * Accesses the address of the restaurant
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Accesses the type of the restaurant
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Accesses the closing hours of the restaurant
     * @return the closing hours
     */
    public String getChours() {
        return  chours;
    }

    /**
     * Accesses the opening hours of the restaurant
     * @return the opening hours
     */
    public String getOhours() {
        return ohours;
    }

    /**
     * Allows the restaurant to be converted to a string
     * @return the name
     */
    public String toString(){
            return name;
    }

    //The following methods make the Restaurant parcelable.
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {name,address,type,chours,ohours});
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        @Override
        public Restaurant createFromParcel(Parcel in) {
            String[] string = in.createStringArray();
            Restaurant toReturn = new Restaurant(string[0],string[1],string[2],string[3],string[4]);
            return toReturn;
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };
}

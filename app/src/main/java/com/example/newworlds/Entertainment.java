package com.example.newworlds;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class represents an Entertainment site consisting of a name, an address, a type, closing hours, and opening hours.
 */
public class Entertainment implements Parcelable {
    private String name;
    private String address;
    private String type;
    private String ohours;
    private String chours;

    /**
     * Creates a new Entertainment object
     * @param name is the name of the Entertainment site
     * @param type is the type of Entertainment site
     * @param address is the address of the Entertainment site
     * @param ohours is the opening hours of the Entertainment site
     * @param chours is the closing hours of the Entertainment site
     */
    public Entertainment (String name,String type, String address, String ohours, String chours)
    {
        this.name=name;
        this.address =address;
        this.type=type;
        this.chours=chours;
        this.ohours=ohours;
    }

    /**
     * Accesses the name of the Entertainment site
     * @return the name
     */
    public String getName()
    {
        return  name;
    }

    /**
     * Accesses the address of the Entertainment site
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Accesses the type of Entertainment site
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Accesses the closing hours of the Entertainment site
     * @return the closing hours
     */
    public String getChours() {
        return  chours;
    }

    /**
     * Accesses the opening hours of the Entertainment site
     * @return the opening hours
     */
    public String getOhours() {
        return ohours;
    }
    /**
     * Allows the Entertainment site to be converted to a string
     * @return the name
     */
    public String toString(){
        return name;
    }

    //The following methods make the Entertainment site parcelable.
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
        public Entertainment createFromParcel(Parcel in) {
            String[] string = in.createStringArray();
            Entertainment toReturn = new Entertainment(string[0],string[1],string[2],string[3],string[4]);
            return toReturn;
        }

        @Override
        public Entertainment[] newArray(int size) {
            return new Entertainment[size];
        }
    };
/*
    @Override
    public int getPlaceType() {
        return Place.TYPE_ENTERTAINMENT;
    }
    */

}

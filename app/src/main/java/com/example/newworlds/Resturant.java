package com.example.newworlds;

import android.os.Parcel;
import android.os.Parcelable;

public class Resturant implements Parcelable {
    private String name;
    private String address;
    private String type;
    private String ohours;
    private String chours;

    public Resturant (String name,String type, String address, String ohours, String chours)
    {
        this.name=name;
        this.address =address;
        this.type=type;
        this.chours=chours;
        this.ohours=ohours;
    }

    public String getName()
    {
        return  name;
    }
    public String getAddress()
    {
        return address;
    }

    public String getType() {
        return type;
    }
    public String getChours() {return  chours;}
    public String getOhours() {return ohours;}

    /*
    @Override
    public int getPlaceType() {
        return Place.TYPE_RESTAURANT;
    }
*/
    public String toString(){
            return name;
    }

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
        public Resturant createFromParcel(Parcel in) {
            String[] string = in.createStringArray();
            Resturant toReturn = new Resturant(string[0],string[1],string[2],string[3],string[4]);
            return toReturn;
        }

        @Override
        public Resturant[] newArray(int size) {
            return new Resturant[size];
        }
    };
}

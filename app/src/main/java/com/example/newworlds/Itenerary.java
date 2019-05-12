package com.example.newworlds;

import android.os.Parcel;
import android.os.Parcelable;

public class Itenerary implements Parcelable {
    private String name;
    private String address;
    private String type;
    private String ohours;
    private String chours;

    public Itenerary (String name,String type, String address, String ohours, String chours)
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

    public String toString(){
        return name;
        //return "Name: " + getName() + "\nAddress: " + getAddress() + "\nType: " + getType();
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

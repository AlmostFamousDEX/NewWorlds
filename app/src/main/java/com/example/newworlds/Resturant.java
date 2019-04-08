package com.example.newworlds;

public class Resturant {
    private String name;
    private String address;
    private String type;
    private int ohours;
    private int chours;

    public Resturant (String name,String type, String address, int ohours, int chours) //constructs a song object with a give title, artist, and year produced
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
    public int getChours() {return  chours;}
}

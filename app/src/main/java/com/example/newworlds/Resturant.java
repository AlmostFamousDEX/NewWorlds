package com.example.newworlds;

public class Resturant {
    private String name;
    private String address;
    private String type;
    private double ohours;
    private double chours;

    public Resturant (String name,String type, String address, double ohours, double chours)
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
    public double getChours() {return  chours;}
    public double getOhours() {return ohours;}
}

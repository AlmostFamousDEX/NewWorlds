package com.example.newworlds;

public class Itenerary {
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
        return "Name: " + getName() + "\nAddress: " + getAddress() + "\nType: " + getType();
    }

}

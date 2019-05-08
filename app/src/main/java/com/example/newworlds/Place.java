package com.example.newworlds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public interface Place {
    int TYPE_RESTAURANT = 101;
    int TYPE_ENTERTAINMENT = 102;
    int TYPE_EDUCATION = 103;

    int getPlaceType();

    public String getName();
    public String getType();
    public String getAddress();
    public String getOhours();
    public String getChours();

}

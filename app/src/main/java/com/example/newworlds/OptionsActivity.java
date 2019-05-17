package com.example.newworlds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * This class is not currently being used. It was originally being used to direct to the options activity screen.
 */
public class OptionsActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Intent intent2 = getIntent();
        Bundle bundle2 = intent2.getExtras();

        ArrayList<String> restaurantType = bundle2.getStringArrayList("restaurant type");
        ArrayList<String> entertainmentType = bundle2.getStringArrayList("entertainment type");
        ArrayList<String> educationType = bundle2.getStringArrayList("education type");


        ArrayList<String> restType;
        ArrayList<String> entType;
        ArrayList<String> eduType;

        ArrayList<String> yourRestaurantOptions;
        ArrayList<String> yourEntertainmentOptions;
        ArrayList<String> yourEducationOptions;

        /*
        public void algorithm(<String> restType, <String> entType, <String> eduType){
            for (int i=0;i<restaurantType.size();i++){
                for (int j=0;j<array list of restaurants.size();j++){
                    if (restaurantType.equals(array list[j])){
                        yourRestaurantOptions.add(array list[j].getName())
                    }
                }
            }
            for (int i=0;i<entertainmentType.size();i++){
                for (int j=0;j<array list of entertainment stuff.size();j++){
                    if (entertainmentType.equals(array list[j])){
                        yourEntertainmentOptions.add(array list[j].getName())
                    }
                }
            }
            for (int i=0;i<educationType.size();i++){
                for (int j=0;j<array list of educational sites.size();j++){
                    if (educationType.equals(array list[j])){
                        yourEducationOptions.add(array list[j].getName())
                    }
                }
            }
        }
        */
        /*
        final Button button2 = (Button) findViewById(R.id.next);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(),OptionsActivity.class);
                intent2.putExtra("does this", "work?");
                intent2.putExtra("restaurant type",restaurantType);
                intent2.putExtra("entertainment type",entertainmentType);
                intent2.putExtra("education type",educationType);
                startActivity(intent2);
            }
        });
    }
*/
    }
}
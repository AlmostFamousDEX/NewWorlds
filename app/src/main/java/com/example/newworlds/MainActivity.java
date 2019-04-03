package com.example.newworlds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Hello", "Alex is active");
        Log.d("Sup","Hi this is Alex!!!!");
        Log.d("tets","tets");
        Log.d("test", "arjun test");
        Log.d("test","once againn");
    }

    public  void onClick(View v)
    {
        Intent intent = new Intent(this,MapsActivityTester.class);
        startActivity(intent);
    }
}


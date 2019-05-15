package com.example.newworlds;

//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.newworlds.Controller;

import java.util.ArrayList;

public class RecyclerViewAdapterRestaurant extends RecyclerView.Adapter<RecyclerViewAdapterRestaurant.ViewHolder> {
    public static final String TAG = "RecyclerViewAdapter";
    private ArrayList<Restaurant> allRestaurants;
    //private ArrayList<Resturant> itineraryRestaurants;
    private Context mContext;
    private ArrayList<String> arr= new ArrayList<String>();
    private ArrayList<String> arr2= new ArrayList<String>();
    private ArrayList<String> alexString = new ArrayList<String>();

    public RecyclerViewAdapterRestaurant(ArrayList<Restaurant> data, Context context) {
        //mPreferencesCategories=preferencesCategories;
        //mChoices=choices;
        //restaurantData=idk;
        //myDataSet2=idk2;
        allRestaurants = data;
        for (int i=0; i<allRestaurants.size(); i++)
        {
            arr.add(allRestaurants.get(i).getName());
            arr2.add("False");
        }
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        CardView cardView = view.findViewById(R.id.cardRestaurant);
        ViewHolder holder = new RecyclerViewAdapterRestaurant.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        final Restaurant restaurant = allRestaurants.get(position);
        //Entertainment entertainment = allEntertainments.get(position);
        //Education education = allEducations.get(position);
        holder.Name.setText(restaurant.getName());
        holder.Type.setText(restaurant.getType());
        holder.Address.setText(restaurant.getAddress());

        final Controller aController = (Controller) mContext.getApplicationContext();

        holder.selectRestaurant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    String dummy=restaurant.getName();
                    for (int i=0; i<arr.size(); i++)
                    {
                        if (arr.get(i).equals(dummy))
                        {
                            arr2.set(i,"True");

                        }
                    }
                    for (int i=0; i<arr2.size();i++)
                    {
                        Log.d("itineraryRestaurant",arr2.get(i));

                    }
                    Log.d("itineraryRestaurant",dummy);
                    for (int i = 0; i<arr2.size();i++){
                        if (arr2.get(i).equals("True")){
                            alexString.add(arr.get(i));
                        }
                    }
                    aController.addItemToArjunResturant(alexString);

                    //String str=education.getName();
                    //Intent intent = new Intent(mContext,RecyclerItinerariesActivity.class);
                    //intent.putExtra("Array List Restaurant!!",alexString);
                    //mContext.startActivity(intent);
                }
            }

        });
/*
        holder.selectRestaurant.setOnClickListener(new View.onClickListener() {
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    itineraryRestaurants.add(allRestaurants.get(getAdapterPosition()));
                }
            }

        });
        //we still have to debug the onClick method and onClickListeners for the check boxes to work.
        */
    }

    @Override


    public int getItemCount() {
        return allRestaurants.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Name, Type, Address;
        CheckBox selectRestaurant;

        public ViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.placeName);
            Type = itemView.findViewById(R.id.placeType);
            Address = itemView.findViewById(R.id.address);
            selectRestaurant = itemView.findViewById(R.id.checkbox_addToItinerary);
        }
    }
}
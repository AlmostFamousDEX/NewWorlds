package com.example.newworlds;

//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterRestaurant extends RecyclerView.Adapter<RecyclerViewAdapterRestaurant.ViewHolder> {
    public static final String TAG="RecyclerViewAdapter";

    //final Controller aController = (Controller) getApplicationContext();
    // ArrayList<Resturant> restaurantData = aController.getRestaurants();
    //private ArrayList<Resturant>myDataSet2;
    private ArrayList<Resturant> allRestaurants;
    //private ArrayList<String> mPreferencesCategories=new ArrayList<>();
    //private Spinner mChoices = new Spinner();
    //private String stringEden;
    private Context mContext;

    /*
    public RecyclerViewAdapter(ArrayList<String> preferencesCategories, Spinner choices,Context context){
        //mPreferencesCategories=preferencesCategories;
        //mChoices=choices;
        mContext=context;
    }
    */
    public RecyclerViewAdapterRestaurant(ArrayList<Resturant> data, Context context){
        //mPreferencesCategories=preferencesCategories;
        //mChoices=choices;
        //restaurantData=idk;
        //myDataSet2=idk2;
        allRestaurants=data;
        mContext=context;
    }

    //public RecyclerViewAdapter( RecyclerActivity recyclerActivity) {
    //}

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card,parent,false);
        CardView cardView = view.findViewById(R.id.cardRestaurant);
        ViewHolder holder = new RecyclerViewAdapterRestaurant.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: called");
        Resturant restaurant = allRestaurants.get(position);
        //Entertainment entertainment = allEntertainments.get(position);
        //Education education = allEducations.get(position);
        holder.Name.setText(restaurant.getName());
        holder.Type.setText(restaurant.getType());
        holder.Address.setText(restaurant.getAddress());
    }

    @Override


    public int getItemCount() {
        return allRestaurants.size();
        //return myDataSet2.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Name, Type, Address;

        public ViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.placeName);
            Type = itemView.findViewById(R.id.placeType);
            Address = itemView.findViewById(R.id.address);
        }
    }

}

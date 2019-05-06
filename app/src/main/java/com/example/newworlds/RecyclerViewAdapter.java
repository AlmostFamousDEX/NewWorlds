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
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    public static final String TAG="RecyclerViewAdapter";

    private ArrayList<Resturant> allRestaurants;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<Resturant> data, Context context){
        allRestaurants=data;
        mContext=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card,parent,false);
        CardView cardView = view.findViewById(R.id.cardRestaurant);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: called");
        Resturant restaurant = allRestaurants.get(position);
        holder.restaurantName.setText(restaurant.getName());
        holder.restaurantType.setText(restaurant.getType());
        holder.restaurantAddress.setText(restaurant.getAddress());
    }

    @Override


    public int getItemCount() {
        return allRestaurants.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView restaurantName, restaurantType, restaurantAddress;

        public ViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurantName);
            restaurantType = itemView.findViewById(R.id.restaurantType);
            restaurantAddress = itemView.findViewById(R.id.address);
        }
    }
}

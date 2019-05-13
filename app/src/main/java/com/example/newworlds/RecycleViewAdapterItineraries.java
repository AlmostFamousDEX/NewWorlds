package com.example.newworlds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleViewAdapterItineraries extends RecyclerView.Adapter<RecycleViewAdapterItineraries.ViewHolder> {
    public static final String TAG = "RecyclerViewAdapter";
    private ArrayList<ArrayList<Itenerary>> allItineraries;
    private ArrayList<Itenerary> chosenItinerary = new ArrayList<Itenerary>();
    private Context mContext;
    private ArrayList<String> arr = new ArrayList<String>();
    private ArrayList<String> arr2 = new ArrayList<String>();
    private ArrayList<String> alexString = new ArrayList<String>();

    //private SparseBooleanArray itemStateArray = new SparseBooleanArray();

    public RecycleViewAdapterItineraries(ArrayList<ArrayList<Itenerary>> data, Context context) {
        allItineraries = data;
        mContext = context;
    }

    @Override
    public RecycleViewAdapterItineraries.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_itinerary_permutation, parent, false);
        CardView cardView = view.findViewById(R.id.cardPermutations);
        RecycleViewAdapterItineraries.ViewHolder holder = new RecycleViewAdapterItineraries.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapterItineraries.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        final ArrayList<Itenerary> itinerary = allItineraries.get(position);
        for (int i = 0;i<itinerary.size();i++){
            if (i==0){
                holder.place1.setText(itinerary.get(i).getName());
                Log.d("i'm quite confused", itinerary.get(i).getName());
            }
            else
                if (i==1){
                    holder.place2.setText(itinerary.get(i).getName());
                    Log.d("i'm quite confused", itinerary.get(i).getName());
                }
                else
                    if (i==2){
                        holder.place3.setText(itinerary.get(i).getName());
                        Log.d("i'm quite confused", itinerary.get(i).getName());
                    }
        }
        /*
        if (itinerary.get(0) != null) {
            holder.place1.setText(itinerary.get(0).getName());
            Log.d("i'm quite confused", itinerary.get(0).getName());
        } else
            holder.place1.setText("");
        if (itinerary.get(1) != null) {
            holder.place2.setText(itinerary.get(1).getName());
        } else
            holder.place2.setText("");
        if (itinerary.get(2) != null) {
            holder.place3.setText(itinerary.get(2).getName());
        } else
            Log.d("this element","doesn't exist");
            holder.place3.setText("");
*/
        final Controller aController = (Controller) mContext.getApplicationContext();
        Log.d("size of itinerary", String.valueOf(itinerary.size()));
        Log.d("what is itinerary",itinerary.toString());

        holder.selectItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    for (int i = 0; i < itinerary.size(); i++) {
                        if (itinerary.get(i)!=null){
                            chosenItinerary.add(itinerary.get(i));
                            aController.setIt(chosenItinerary);
                        }
                    }

                    if (aController.getIt()!=null){
                        Log.d("i'm tired of this",aController.getIt().toString());
                    }
                    else
                        Log.d("welp","idk what the problem is");

                    //^^this method will be made
                }
            }
        });
    }

/*
        holder.selectItinerary.setOnClickListener(new View.onClickListener() {
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    chosenItinerary.add(allItineraries.get(getAdapterPosition()));
                }
            }
        });
        //we still have to debug the onClick method and onClickListeners for the check boxes to work.
        */


    @Override


    public int getItemCount() {
        return allItineraries.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView place1, place2, place3;
        CheckBox selectItinerary;

        public ViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            place1 = itemView.findViewById(R.id.place1);
            place2 = itemView.findViewById(R.id.place2);
            place3 = itemView.findViewById(R.id.place3);
            selectItinerary = itemView.findViewById(R.id.choose_itinerary);
        }
    }
}


package com.example.newworlds;

import android.content.Context;
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

import java.util.ArrayList;

/**
 * This class is the adapter for the entertainment RecyclerView
 */
public class RecyclerViewAdapterEntertainment extends RecyclerView.Adapter<RecyclerViewAdapterEntertainment.ViewHolder> {
    public static final String TAG="RecyclerViewAdapter";
    private ArrayList<Entertainment> allEntertainment;
    private Context mContext;
    private ArrayList<String> arr= new ArrayList<String>();
    private ArrayList<String> arr2= new ArrayList<String>();
    private ArrayList<String> alexString = new ArrayList<String>();

    /**
     * Creates an entertainment RecyclerView
     * @param data array list of entertainment sites created from the type the user selected
     * @param context the context of the class
     */
    public RecyclerViewAdapterEntertainment(ArrayList<Entertainment> data, Context context){
        allEntertainment=data;
        for (int i=0; i<allEntertainment.size(); i++)
        {
            arr.add(allEntertainment.get(i).getName());
            arr2.add("False");
        }
        mContext=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card,parent,false);
        CardView cardView = view.findViewById(R.id.cardRestaurant);
        ViewHolder holder = new RecyclerViewAdapterEntertainment.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: called");
        final Entertainment entertainment = allEntertainment.get(position);
        holder.Name.setText(entertainment.getName());
        holder.Type.setText(entertainment.getType());
        holder.Address.setText(entertainment.getAddress());

        final Controller aController = (Controller) mContext.getApplicationContext();

        holder.selectEntertainment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    String dummy=entertainment.getName();
                    for (int i=0; i<arr.size(); i++)
                    {
                        if (arr.get(i).equals(dummy))
                        {
                            arr2.set(i,"True");

                        }
                    }
                    for (int i=0; i<arr2.size();i++)
                    {
                        Log.d("itineraryEntertainment",arr2.get(i));

                    }
                    Log.d("itineraryEntertainment",dummy);
                    for (int i = 0; i<arr2.size();i++){
                        if (arr2.get(i).equals("True")){
                            alexString.add(arr.get(i));
                        }
                    }
                    aController.addItemToArjunEntertainment(alexString);

                }
            }

        });

    }

    @Override
    public int getItemCount() {
        return allEntertainment.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Name, Type, Address;
        CheckBox selectEntertainment;

        public ViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.placeName);
            Type = itemView.findViewById(R.id.placeType);
            Address = itemView.findViewById(R.id.address);
            selectEntertainment = itemView.findViewById(R.id.checkbox_addToItinerary);
        }
    }
}

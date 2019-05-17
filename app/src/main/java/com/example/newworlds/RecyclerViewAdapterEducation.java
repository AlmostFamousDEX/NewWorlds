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
 * This class is the adapter for the education RecyclerView
 */
public class RecyclerViewAdapterEducation extends RecyclerView.Adapter<RecyclerViewAdapterEducation.ViewHolder> {
    public static final String TAG="RecyclerViewAdapter";
    private ArrayList<Education> allEducation;
    private Context mContext;
    private ArrayList<String> arr= new ArrayList<String>();
    private ArrayList<String> arr2= new ArrayList<String>();
    private ArrayList<String> alexString = new ArrayList<String>();

    /**
     * Creates an education RecyclerView
     * @param data array list of education sites created from the type the user selected
     * @param context the context of the class
     */
    public RecyclerViewAdapterEducation(ArrayList<Education> data, Context context){
        allEducation=data;
        for (int i=0; i<allEducation.size(); i++)
        {
            arr.add(allEducation.get(i).getName());
            arr2.add("False");
        }
        mContext=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card,parent,false);
        CardView cardView = view.findViewById(R.id.cardRestaurant);
        ViewHolder holder = new RecyclerViewAdapterEducation.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder: called");
        final Education education = allEducation.get(position);
        holder.Name.setText(education.getName());
        holder.Type.setText(education.getType());
        holder.Address.setText(education.getAddress());

        final Controller aController = (Controller) mContext.getApplicationContext();

        holder.selectEducation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    String dummy=education.getName();
                    for (int i=0; i<arr.size(); i++)
                    {
                        if (arr.get(i).equals(dummy))
                        {
                            arr2.set(i,"True");

                        }
                    }
                    for (int i=0; i<arr2.size();i++)
                    {
                        Log.d("itineraryEducation",arr2.get(i));

                    }
                    Log.d("itineraryEducation",dummy);
                    for (int i = 0; i<arr2.size();i++){
                        if (arr2.get(i).equals("True")){
                            alexString.add(arr.get(i));
                        }
                    }

                    aController.addItemToArjunEducation(alexString);

                }
            }

        });

    }

    @Override


    public int getItemCount() {
        return allEducation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Name, Type, Address;
        CheckBox selectEducation;

        public ViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.placeName);
            Type = itemView.findViewById(R.id.placeType);
            Address = itemView.findViewById(R.id.address);
            selectEducation = itemView.findViewById(R.id.checkbox_addToItinerary);
        }
    }

}

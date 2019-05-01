package com.example.newworlds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    public static final String TAG="RecyclerViewAdapter";

    private String stringEden = new String();
    //private ArrayList<String> mPreferencesCategories=new ArrayList<>();
    //private Spinner mChoices = new Spinner();
    private Context mContext;

    /*
    public RecyclerViewAdapter(ArrayList<String> preferencesCategories, Spinner choices,Context context){
        //mPreferencesCategories=preferencesCategories;
        //mChoices=choices;
        mContext=context;
    }
    */
    public RecyclerViewAdapter(String eden,Context context){
        //mPreferencesCategories=preferencesCategories;
        //mChoices=choices;
        stringEden=eden;
        mContext=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: called");

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG,"onClick: clicked on: " + mChoices.get(position));
                Log.d(TAG,"onClick: clicked on: " + stringEden);
                Toast.makeText(mContext,stringEden,Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override

    public int getItemCount() {
        return stringEden.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView food;
        Spinner foodChoices;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            food =itemView.findViewById(R.id.food);
            foodChoices=itemView.findViewById(R.id.foodChoices);
            parentLayout=itemView.findViewById(R.id.parent_layout);
        }
    }
}

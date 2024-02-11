package com.example.theofficecharacters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<DataModel> dataSet;
    public CustomAdapter(ArrayList<DataModel> dataSet)
    {
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView);
            textViewDescription = itemView.findViewById((R.id.textView2));
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_card_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder((view));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.textViewName.setText(dataSet.get(position).getName());
        holder.textViewDescription.setText(dataSet.get(position).getDescription());
        holder.imageView.setImageResource(dataSet.get(position).getImage());
    }

    @Override
    public int getItemCount()
    {
        return dataSet.size();
    }
}

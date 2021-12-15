package com.example.food.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Model.Store;
import com.example.food.R;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    private ArrayList<Store> storeArrayList;
    private Context context;

    public StoreAdapter(ArrayList<Store> storeArrayList, Context context) {
        this.storeArrayList = storeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store,parent,false);
        return new StoreAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.ViewHolder holder, int position) {
        holder.location.setText(storeArrayList.get(position).getLocation());
        holder.img.setImageResource(storeArrayList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return storeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView location;
        ImageView img;
        ImageButton deleteButton;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            location = itemView.findViewById(R.id.store_location);
            img = itemView.findViewById(R.id.store_image);
        }
    }
}

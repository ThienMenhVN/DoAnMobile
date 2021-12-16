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

import com.example.food.Model.History_item;
import com.example.food.R;

import java.util.ArrayList;

public class HistoryItemAdapter  extends RecyclerView.Adapter<HistoryItemAdapter.ViewHolder> {
    private ArrayList<History_item> historyArrayList;
    private Context context;

    public HistoryItemAdapter(ArrayList<History_item> historyArrayList, Context context) {
        this.historyArrayList = historyArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,parent,false);
        return new HistoryItemAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryItemAdapter.ViewHolder holder, int position) {
        holder.quantity.setText(historyArrayList.get(position).getQuantity());
        holder.price.setText(historyArrayList.get(position).getPrice());
        holder.date.setText(historyArrayList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return historyArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView quantity,price,date;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            quantity = itemView.findViewById(R.id.history_quantity);
            price = itemView.findViewById(R.id.money);
            date = itemView.findViewById(R.id.date);
        }
    }
}

package com.example.food.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.Model.Order_item;
import com.example.food.R;

import java.util.ArrayList;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ViewHolder> {
    ArrayList<Order_item> orderItemArrayList;

    public OrderItemAdapter(ArrayList<Order_item> orderItemArrayList) {
        this.orderItemArrayList = orderItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_detail_item,parent,false);
        return new OrderItemAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.orderQuantity.setText(orderItemArrayList.get(position).getQuantity());
        holder.orderName.setText(orderItemArrayList.get(position).getName());
        holder.orderSize.setText(orderItemArrayList.get(position).getSize());
        holder.orderPrice.setText(orderItemArrayList.get(position).getPrice());
        holder.deleteItemOnClick(orderItemArrayList, position);
    }

    @Override
    public int getItemCount() {
        return orderItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView orderQuantity;
        TextView orderName;
        TextView orderSize;
        TextView orderPrice;
        ImageButton deleteButton;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            orderQuantity = itemView.findViewById(R.id.text_item_quantity);
            orderName = itemView.findViewById(R.id.text_item_quantity);
            orderSize = itemView.findViewById(R.id.text_item_quantity);
            orderPrice = itemView.findViewById(R.id.text_item_quantity);
        }

        public void deleteItemOnClick(ArrayList<Order_item> orderItemArrayList, int position) {
            deleteButton = itemView.findViewById(R.id.text_item_quantity);
            deleteButton.setOnClickListener(view -> {
                orderItemArrayList.remove(position);
                notifyDataSetChanged();
            });
        }
    }
}

package com.example.food.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.Model.Bill;
import com.example.food.Model.Order_item;
import com.example.food.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ViewHolder> {
    ArrayList<Bill> orderItemArrayList;
    Bill bill = new Bill();
    public OrderItemAdapter(ArrayList<Bill> orderItemArrayList) {
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
        holder.orderQuantity.setText(orderItemArrayList.get(position).getSoLuong());
        holder.orderName.setText(orderItemArrayList.get(position).getName());
        holder.orderSize.setText(orderItemArrayList.get(position).getNameSize());
        holder.orderPrice.setText(orderItemArrayList.get(position).getMoney());
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
            orderName = itemView.findViewById(R.id.text_itemname);
            orderSize = itemView.findViewById(R.id.text_itemsize);
            orderPrice = itemView.findViewById(R.id.text_itemprice);

        }

        public void deleteItemOnClick(ArrayList<Bill> orderItemArrayList, int position) {
            deleteButton = itemView.findViewById(R.id.bush);
            deleteButton.setOnClickListener(view -> {
                bill = orderItemArrayList.get(position);
                Log.d("test", bill.getName());
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef1 = database.getReference("Order_view");
                myRef1.child(bill.getName()).removeValue();
                orderItemArrayList.remove(position);
                notifyDataSetChanged();
            });
        }
    }
}

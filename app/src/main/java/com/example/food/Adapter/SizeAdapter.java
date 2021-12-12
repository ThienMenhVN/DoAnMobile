package com.example.food.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Model.Product_order;
import com.example.food.Model.Size;
import com.example.food.Order_view;
import com.example.food.R;

import java.util.ArrayList;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.ViewHolder>{
    ArrayList<Size> sizeArrayList;
    Context context;
    private int lastCheckedPosition = 0;

    public SizeAdapter(ArrayList<Size> sizeArrayList, Context context) {
        this.sizeArrayList = sizeArrayList;
        this.context = context;
    }

    public int getLastCheckedPosition() {
        return lastCheckedPosition;
    }

    public void setLastCheckedPosition(int lastCheckedPosition) {
        this.lastCheckedPosition = lastCheckedPosition;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_size_product,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.size.setText(sizeArrayList.get(position).getName());
        holder.price.setText(sizeArrayList.get(position).getPrice());
        holder.radioButton.setChecked(position == getLastCheckedPosition());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                setLastCheckedPosition(holder.getAdapterPosition());
                notifyDataSetChanged();
                int priceSize;
                try {
                    priceSize = Integer.parseInt(sizeArrayList.get(position).getPrice());
                }catch (NumberFormatException e){
                    priceSize = 0;
                }
                Product_order product_order = ProductAdapter.product_order;
                product_order.setPriceSize(priceSize);
                ProductAdapter.totalMoney.setText(String.valueOf(product_order.getTotalMoney()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return sizeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        private TextView size;
        private TextView price;
        private RadioButton radioButton;
        private ItemClickListener itemClickListener;
        private int lastSelectedPosition = 1;

        public ItemClickListener getItemClickListener() {
            return itemClickListener;
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            size = itemView.findViewById(R.id.nameSize);
            price = itemView.findViewById(R.id.priceSize);
            radioButton = itemView.findViewById(R.id.radiobutton);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            return true;
        }
    }
}

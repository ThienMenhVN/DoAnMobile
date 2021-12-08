package com.example.food.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Model.Product_order;
import com.example.food.Model.Topping;
import com.example.food.R;

import java.util.ArrayList;

public class ToppingAdapter extends RecyclerView.Adapter<ToppingAdapter.ViewHolder>{
    ArrayList<Topping> toppingArrayList;
    Context context;

    public ToppingAdapter(ArrayList<Topping> toppingArrayList, Context context) {
        this.toppingArrayList = toppingArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topping_product,parent,false);
        return new ToppingAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(toppingArrayList.get(position).getName());
        holder.price.setText(toppingArrayList.get(position).getPrice());

        holder.setItemClickListener(new ItemClickListener() {
            Topping topping = toppingArrayList.get(position);
            Product_order product_order = ProductAdapter.product_order;
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!holder.checkBox.isChecked() && view!=null){
                    holder.checkBox.setChecked(true);
                    product_order.getToppingArrayList().add(topping);
                    ProductAdapter.totalMoney.setText(String.valueOf(product_order.getTotalMoney()));
                }else{
                    holder.checkBox.setChecked(false);
                    product_order.getToppingArrayList().remove(topping);
                    ProductAdapter.totalMoney.setText(String.valueOf(product_order.getTotalMoney()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return toppingArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        private TextView name;
        private TextView price;
        private CheckBox checkBox;
        private ItemClickListener itemClickListener;

        public ItemClickListener getItemClickListener() {
            return itemClickListener;
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTopping);
            price = itemView.findViewById(R.id.priceTopping);
            checkBox = itemView.findViewById(R.id.checkBox);
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

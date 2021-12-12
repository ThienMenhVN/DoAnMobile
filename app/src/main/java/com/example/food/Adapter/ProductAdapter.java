package com.example.food.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.MainActivity;
import com.example.food.Model.Bill;
import com.example.food.Model.Product;
import com.example.food.Model.Product_order;
import com.example.food.Order_view;
import com.example.food.R;
import com.example.food.View.Fragment_order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private ArrayList<Product> productArrayList;
    private Context context;
    public static Dialog productDetails;
    public static TextView totalMoney;
    public static Product_order product_order;


    SizeAdapter sizeAdapter;
    public ProductAdapter(ArrayList<Product> productArrayList, Context context) {
        this.productArrayList = productArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new ProductAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productArrayList.get(position);
        holder.name.setText(product.getName());
        holder.price.setText(product.getPrice());
        holder.image.setImageResource(product.getImg());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                productDetails = new Dialog(context);
                productDetails.setContentView(R.layout.dialog_product_detail);
                TextView name = productDetails.findViewById(R.id.nameProductDetail);
                TextView price = productDetails.findViewById(R.id.priceProductDetail);
                ImageView image = productDetails.findViewById(R.id.imageProductDetail);
                TextView description =productDetails.findViewById(R.id.description);
                totalMoney = productDetails.findViewById(R.id.totalMoney);
                TextView numberProductDetail = productDetails.findViewById(R.id.numberProductDetail);
                Button Add = productDetails.findViewById(R.id.buttonBuyDetail);

                name.setText(product.getName());
                price.setText(product.getPrice());
                image.setImageResource(product.getImg());
                totalMoney.setText(product.getPrice());
                description.setText(product.getDescription());
                int priceProductDetail =Integer.parseInt(product.getPrice()) ;

                product_order = new Product_order();
                product_order.setPrice(priceProductDetail);
                product_order.setQuantity(Integer.parseInt((String) numberProductDetail.getText()));
                product_order.setPriceSize(0);

                if (product.getSize().isEmpty()){
                    productDetails.findViewById(R.id.Size).setVisibility(View.GONE);
                }
                RecyclerView listSize = productDetails.findViewById(R.id.list_size_product);
                sizeAdapter = new SizeAdapter(product.getSize(),context);
                LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                listSize.setLayoutManager(layoutManager);
                listSize.setAdapter(sizeAdapter);

                listSize.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                productDetails.findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(product_order.getQuantity()>1){
                            product_order.setQuantity(product_order.getQuantity()-1);
                        }
                        totalMoney.setText(String.valueOf(product_order.getTotalMoney()));
                        TextView numberProductDetail = productDetails.findViewById(R.id.numberProductDetail);
                        numberProductDetail.setText(String.valueOf(product_order.getQuantity()) );
                        if (product_order.getQuantity()==1){
                            productDetails.findViewById(R.id.remove).setClickable(false);
                        }
                    }
                });
                productDetails.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        product_order.setQuantity(product_order.getQuantity()+1);
                        totalMoney.setText(String.valueOf(product_order.getTotalMoney()));
                        TextView numberProductDetail = productDetails.findViewById(R.id.numberProductDetail);
                        numberProductDetail.setText(String.valueOf(product_order.getQuantity()) );
                        if (product_order.getQuantity()>1){
                            productDetails.findViewById(R.id.remove).setClickable(true);
                        }
                    }
                });
                Add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer m = product_order.getTotalMoney();
                        String s = product.getName();
                        String s1 = m.toString();
                        String s2 = numberProductDetail.getText().toString();
                        String s3 = sizeAdapter.sizeArrayList.get(position).getName();
                        Bill bill = new Bill();
                        bill.setName(s);
                        bill.setMoney(s1);
                        bill.setSoLuong(s2);
//                        bill.setNameSize("Vừa");
                        bill.setNameSize(s3);
                        putData(bill);
                        productDetails.dismiss();
                    }
                });
                productDetails.show();
            }

        });


    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        private TextView name;
        private TextView price;
        private ImageView image;
        private ItemClickListener itemClickListener;

        public ItemClickListener getItemClickListener() {
            return itemClickListener;
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.productPrice);
            image = itemView.findViewById(R.id.productPic);
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
    private void putData(Bill product) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Order_view");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                myRef.child(product.getName()).setValue(product);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }

}

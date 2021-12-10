package com.example.food.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Model.Product;
import com.example.food.Model.Product_order;
import com.example.food.Model.Topping;
import com.example.food.R;

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
                product_order.setToppingArrayList(new ArrayList<Topping>());

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

                if (product.getTopping().isEmpty()){
                    productDetails.findViewById(R.id.Topping).setVisibility(View.GONE);
                }
                RecyclerView listTopping = productDetails.findViewById(R.id.list_topping_product);
                ToppingAdapter toppingAdapter = new ToppingAdapter(product.getTopping(),context);
                listTopping.setAdapter(toppingAdapter);
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                listTopping.setLayoutManager(layoutManager1);
                listTopping.setOnClickListener(new View.OnClickListener() {
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

}

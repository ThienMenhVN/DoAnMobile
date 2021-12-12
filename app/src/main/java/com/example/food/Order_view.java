package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Adapter.OrderItemAdapter;
import com.example.food.Model.Order_item;
import com.example.food.databinding.OrderDetailBinding;

import java.util.ArrayList;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Order_view extends AppCompatActivity {
    private OrderDetailBinding binding;
    private RecyclerView.Adapter adapter;
    String s, quantity, name, size, price = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);
        getSupportActionBar().hide();

        binding = OrderDetailBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        Intent intent = getIntent();

        
        binding.closeCartInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        quantity = intent.getStringExtra("quantity");
        name = intent.getStringExtra("name");
        size = intent.getStringExtra("size");
        price = intent.getStringExtra("price");
        cartViewItem(quantity,name,size,price);
    }

    private void cartViewItem(String quantity, String name, String size, String price){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.cartRecyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Order_item> orderItems=new ArrayList<>();
        orderItems.add(new Order_item(quantity,name,size,price));

        adapter = new OrderItemAdapter(orderItems);
        binding.cartRecyclerView.setAdapter(adapter);
    }
}

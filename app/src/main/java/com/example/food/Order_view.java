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
    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);
        getSupportActionBar().hide();

        binding = OrderDetailBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        Intent intent = getIntent();
        s = intent.getStringExtra("key");
        Log.d("key", s);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User  user = snapshot.child(s).getValue(User.class);
                binding.textName.setText(user.getName());
                binding.textPhoneNumber.setText(user.getPhone());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        
        binding.closeCartInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void cartViewItem(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.cartRecyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Order_item> orderItems=new ArrayList<>();
        orderItems.add(new Order_item("Pumpkin Hummus", "shop1", "Beyti Restaurant, Taksim", "4.8","(233 ratings)"));
        orderItems.add(new Order_item("Sweets Baklava with Nuts", "shop2", "Karaköy Güllüoğlu, Beyoğlu", "4.8","(233 ratings)"));
        orderItems.add(new Order_item("Fish", "shop3", "Mercan, Kadıköy", "4.8","(233 ratings)"));
        orderItems.add(new Order_item("Meat Pizza With Chicken", "shop4", "Karaköy Güllüoğlu, Beyoğlu", "4.8","(233 ratings)"));
        orderItems.add(new Order_item("Wood Fired Pizza", "shop5", "Beyti Restaurant, Taksim", "4.8","(233 ratings)"));

        adapter = new OrderItemAdapter(orderItems);
        binding.cartRecyclerView.setAdapter(adapter);
    }
}

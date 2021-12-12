package com.example.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.food.Model.Product;
import com.example.food.View.Fragment_membership;
import com.example.food.View.Fragment_order;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Context context;
    String data;

    public static CardView orderDetail;
    public static BottomNavigationView bottomNav;

    protected void onCreate(Bundle savedInstanceState) {
        Fragment_order fragment_order = new Fragment_order();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Trang_chu()).commit();
        }

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportActionBar().hide();

        context = this;
        Intent intent = getIntent();
        String Phone = intent.getStringExtra("PhoneAccount");
        if (Phone == null){
            Log.d("5678", "rong ");
        }
        if (Phone != null){
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Trang_chu()).commit();
            }
            data = Phone;
        }

        orderDetail = findViewById(R.id.order_view);
        orderDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Order_view.class);
                if (data != null){
                    intent.putExtra("key",data);
                }
                startActivity(intent);
            }
        });

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new Trang_chu();
                            break;
                        case R.id.nav_order:
                            selectedFragment = new Fragment_order();
                            break;
                        case R.id.nav_store:
                            break;
                        case R.id.nav_coupon:
                            selectedFragment = new Fragment_membership();
                            break;
                        case R.id.nav_else:
                            selectedFragment = new Fragment_user();
                            break;
                    }
                    try {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                    }catch (Exception e){

                    }
                    return true;
                }
            };

    private void getData(String product) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Order_view");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                myRef.child(product).setValue(product);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}

package com.example.food;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.food.View.Fragment_order;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Context context;

    public static CardView orderDetail;
    public static BottomNavigationView bottomNav;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();

            fragmentManager.replace(R.id.main, new Fragment_order()).commit();


            Log.d("1234", Phone);
        }

        orderDetail = findViewById(R.id.order_view);
        orderDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Order_view.class);
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
}

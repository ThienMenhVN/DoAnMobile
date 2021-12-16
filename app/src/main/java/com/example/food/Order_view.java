package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Adapter.OrderItemAdapter;
import com.example.food.Model.Bill;
import com.example.food.Model.History_item;
import com.example.food.databinding.OrderDetailBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Order_view extends AppCompatActivity {
    private OrderDetailBinding binding;
    private RecyclerView.Adapter adapter;
    private ArrayList<Bill> mListBill;

    String s = "";
    int s2,s3 = 0;
    EditText nameUser,phone;
    TextView sp,money,money2,money3,dathang,diachi,delBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail);
        getSupportActionBar().hide();

        binding = OrderDetailBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        nameUser = findViewById(R.id.text_name);
        phone= findViewById(R.id.text_phone_number);
        sp = findViewById(R.id.text_orderamount);
        money = findViewById(R.id.text_orderprice);
        money2 = findViewById(R.id.text_itempricetotal);
        money3 = findViewById(R.id.text_itempricetotal2);
        dathang = findViewById(R.id.image_finalorder);
        diachi = findViewById(R.id.text_destination_detail);
        delBill = findViewById(R.id.delBill);
        mListBill = new ArrayList<>();

        Intent intent = getIntent();
        s = intent.getStringExtra("key");
        Log.d("key", s);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User  user = snapshot.child(s).getValue(User.class);
                nameUser.setText(user.getName());
                phone.setText(user.getPhone());
                diachi.setText(user.getAddress());
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


        DatabaseReference myRef1 = database.getReference("Order_view");
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapShot) {
                for (DataSnapshot dataSnapshot : snapShot.getChildren() ){
                    Bill bill = dataSnapshot.getValue(Bill.class);
                    mListBill.add(bill);
                    s2 += Integer.parseInt(bill.getMoney());
                    s3 += Integer.parseInt(bill.getSoLuong());

                }
                sp.setText(String.valueOf(s3)+" Sản phẩm");
                money.setText(String.valueOf(s2));
                money2.setText(String.valueOf(s2));
                money3.setText(String.valueOf(s2));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

        cartViewItem( mListBill);
        dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListBill.size() != 0){
                Toast.makeText(Order_view.this, "Đặt hàng thành công !!!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Order_view.this,MainActivity.class);
                intent1.putExtra("PhoneAccount",phone.getText().toString());
                Date currentTime = Calendar.getInstance().getTime();
                History_item history = new History_item(String.valueOf(s3),String.valueOf(s2),String.valueOf(currentTime));

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef1 = database.getReference("User/"+phone.getText().toString()+"/History/"+history.getDate());
                myRef1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        myRef1.setValue(history);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


                });

                startActivity(intent1);
                }else {
                    Toast.makeText(Order_view.this, "Bạn chưa chọn món !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef1 = database.getReference("Order_view");
                myRef1.removeValue();
                FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            }
        });

    }

    private void cartViewItem(ArrayList<Bill> Bill){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.cartRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new OrderItemAdapter(Bill);
        binding.cartRecyclerView.setAdapter(adapter);
    }


}

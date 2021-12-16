package com.example.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfomationActivity extends AppCompatActivity {
    private ImageView imgCancelInfo, imgInfo;
    private TextView txtNameInfo, txtNameDetail, txtPhoneDetail, txtEmailDetail;
    String Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomation);

        imgCancelInfo = findViewById(R.id.imgCancelInfo);
        txtNameInfo = findViewById(R.id.txtNameInfo);

        txtNameDetail = findViewById(R.id.txtNameDetail);
        txtPhoneDetail = findViewById(R.id.txtDetailPhone);
        txtEmailDetail = findViewById(R.id.txtEmailDetail);

        imgCancelInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfomationActivity.this, MainActivity.class);
                i.putExtra("PhoneAccount",Phone);
                startActivity(i);
            }

        });
        Intent intent = getIntent();
        Phone = intent.getStringExtra("Phone");
        getData(Phone);


    }
    public void getData(String Phone){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User  user = snapshot.child(Phone).getValue(User.class);
                    txtNameDetail.setText(user.getName());
                    txtPhoneDetail.setText(user.getPhone());
                    txtEmailDetail.setText(user.getAddress());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private  void returnMain(){
        Intent intent = new Intent(InfomationActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
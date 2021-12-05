package com.example.food;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DangKy extends AppCompatActivity {

    Button OK,Cancel;
    EditText DKphone,DKpasswork,DKaddress,DKname;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_ky);

        OK = findViewById(R.id.OK);
        Cancel = findViewById(R.id.Cancel);
        DKpasswork = findViewById(R.id.DKpasswork);
        DKaddress = findViewById(R.id.DKaddress);
        DKphone = findViewById(R.id.DKphone);
        DKname = findViewById(R.id.DKname);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                }
        });
    }

    private void getData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(DKphone.getText().toString()).exists()) {
                    Toast.makeText(DangKy.this, "Số điện thoại này đã đăng ký rồi !", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(DKpasswork.getText().toString(),DKname.getText().toString(),DKaddress.getText().toString());
                    myRef.child(DKphone.getText().toString()).setValue(user);
                    Toast.makeText(DangKy.this, "Đăng ký thành công ", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        }
}

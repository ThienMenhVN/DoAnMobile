package com.example.food;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dang_ky extends Fragment {
    Button OK,Cancel;
    EditText DKphone,DKpasswork,DKaddress,DKname;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dang_ky, container, false);
        OK = view.findViewById(R.id.OK);
        Cancel = view.findViewById(R.id.Cancel);
        DKpasswork = view.findViewById(R.id.DKpasswork);
        DKaddress = view.findViewById(R.id.DKaddress);
        DKphone = view.findViewById(R.id.DKphone);
        DKname = view.findViewById(R.id.DKname);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Sign_in.class);
                startActivity(intent);
            }
        });

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });

        return view;
    }
    private void getData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child(DKphone.getText().toString()).exists()) {
                        Toast.makeText(getActivity(), "Số điện thoại này đã đăng ký rồi !", Toast.LENGTH_SHORT).show();
                    } else {
                        User user = new User(DKpasswork.getText().toString(),DKname.getText().toString(),DKaddress.getText().toString(),DKphone.getText().toString());
                        myRef.child(DKphone.getText().toString()).setValue(user);
                        Toast.makeText(getActivity(), "Đăng ký thành công ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(),Sign_in.class);
                        startActivity(intent);
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}
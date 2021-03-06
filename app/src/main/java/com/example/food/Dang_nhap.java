package com.example.food;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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

import java.net.URISyntaxException;


public class Dang_nhap extends Fragment {
    Button btnDN;
    EditText Phone,Passwork;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dang_nhap, container, false);
        btnDN = view.findViewById(R.id.DN);
        Phone = view.findViewById(R.id.SDT);
        Passwork = view.findViewById(R.id.passwork);

        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("User");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.child(Phone.getText().toString()).exists() && Phone.getText().toString().trim() != null) {
                            User  user = snapshot.child(Phone.getText().toString()).getValue(User.class);
                            if (user.getPasswork().equals(Passwork.getText().toString())){
                                Intent intent = new Intent(getActivity(),MainActivity.class);
                                intent.putExtra("PhoneAccount",user.getPhone());
                                startActivity(intent);

                                Toast.makeText(getActivity(), "????ng nh???p th??nh c??ng", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getActivity(), "Nh???p sai m???t kh???u", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "S??? ??i???n tho???i ch??a ????ng k??", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        return view;
    }

}
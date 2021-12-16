package com.example.food;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Fragment_user extends Fragment {

    private RelativeLayout relaInfo;
    private TextView txtSignIn, txtSignOut, txtInfoAccount, txtOrderAccount;
    private String a = "Đăng nhập";

    public Fragment_user(String data) {
        if (data == null){

            Log.d("111", "Fragment_user: ");
        }
        else{
            a = data;
            Log.d("111", a);
        }
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_user, container, false);
        txtSignOut = view.findViewById(R.id.txtSignOut);
        txtSignIn = view.findViewById(R.id.txtSignIn);
        txtOrderAccount = view.findViewById(R.id.txtOrderAccount);

        Bundle bundle = getArguments();

        if (bundle != null){
            txtSignIn.setText(bundle.getString("PhoneAccount"));
        }


        relaInfo = view.findViewById(R.id.relaInfoAccount);
        relaInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( a== "Đăng nhập"){
                    Toast.makeText(getContext(), "Bạn cần đăng nhập trước !!!", Toast.LENGTH_SHORT).show();
                }else {
                    Intent i = new Intent(getActivity(), InfomationActivity.class);
                    i.putExtra("Phone",a);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });
        txtInfoAccount = view.findViewById(R.id.txtInfoAccount);
        txtInfoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( a == "Đăng nhập"){
                    Toast.makeText(getContext(), "Bạn cần đăng nhập trước !!!", Toast.LENGTH_SHORT).show();
                }else {
                    Intent i = new Intent(getActivity(), InfomationActivity.class);
                    i.putExtra("Phone",a);
                    startActivity(i);
                    getActivity().finish();
                }
            }
        });

        txtSignIn = view.findViewById(R.id.txtSignIn);
        if (a == "Đăng nhập") {
            txtSignOut.setText("");
            txtSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), Sign_in.class);
                    startActivity(i);
                }
            });
        }else{
            getData(a);
            txtSignOut.setText("Đăng xuất");
        }

        txtSignOut = view.findViewById(R.id.txtSignOut);
        txtSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),MainActivity.class);
                i.putExtra("Null","");
                startActivity(i);
                getActivity().finish();
            }
        });

        txtOrderAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( a == "Đăng nhập"){
                    Toast.makeText(getContext(), "Bạn cần đăng nhập trước !!!", Toast.LENGTH_SHORT).show();
                }else{
                Intent i = new Intent(getActivity(), HistoryActivity.class);
                i.putExtra("key",a);
                startActivity(i);
                }
            }
        });

        return view;
    }
    private void getData(String s){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User  user = snapshot.child(s).getValue(User.class);
                txtSignIn.setText("Xin chào "+user.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
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

public class Fragment_user extends Fragment {
    private static final int key = 1;
    private RelativeLayout relaInfo;
    private TextView txtSignIn, txtSignOut, txtInfoAccount, txtOrderAccount;
    private ImageView imgGoogle, imgIconSignIn;
    private String imgUrl,test ;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_user, container, false);
        imgGoogle = view.findViewById(R.id.imgGoogle);
        txtSignOut = view.findViewById(R.id.txtSignOut);
        imgIconSignIn = view.findViewById(R.id.imgIconSignIn);
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
                Intent i = new Intent(getActivity(), InfomationActivity.class);
                startActivity(i);
            }
        });
        txtInfoAccount = view.findViewById(R.id.txtInfoAccount);
        txtInfoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), InfomationActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        txtSignIn = view.findViewById(R.id.txtSignIn);

            txtSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), Sign_in.class);
                    startActivity(i);
                }
            });

        txtOrderAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), HistoryActivity.class);
                startActivity(i);
            }
        });

        return view;
    }
}
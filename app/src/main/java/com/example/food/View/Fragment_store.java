package com.example.food.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Adapter.StoreAdapter;
import com.example.food.Model.Store;
import com.example.food.R;

import java.util.ArrayList;

public class Fragment_store extends Fragment {
    private RecyclerView.Adapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_store, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.store_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Store> storeArrayList=new ArrayList<>();
        storeArrayList.add(new Store("46 Nguyễn Lương Bằng",R.drawable.store1));
        storeArrayList.add(new Store("54 Võ Nguyên Giáp",R.drawable.store2));
        storeArrayList.add(new Store("65 Nguyễn Văn Linh",R.drawable.store3));
        storeArrayList.add(new Store("78 Lý Thường Kiệt",R.drawable.store4));

        adapter = new StoreAdapter(storeArrayList);
        recyclerView.setAdapter(adapter);

        return v;
    }
}

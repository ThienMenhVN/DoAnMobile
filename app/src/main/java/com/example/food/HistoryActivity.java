package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.food.Adapter.HistoryItemAdapter;
import com.example.food.Model.History_item;
import com.example.food.databinding.ActivityHistoryBinding;
import com.example.food.databinding.RowDataNewsProductBinding;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    private ActivityHistoryBinding binding;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        binding.imgCloseAccumulatePoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerViewHistory();
    }

    private void recyclerViewHistory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.recycleViewHistory.setLayoutManager(linearLayoutManager);

        ArrayList<History_item> historyItem=new ArrayList<>();
        historyItem.add(new History_item("1", "100000","15:00 - 16/12/2021"));
        historyItem.add(new History_item("2", "100000","15:00 - 16/12/2021"));
        historyItem.add(new History_item("3", "100000","15:00 - 16/12/2021"));
        historyItem.add(new History_item("4", "100000","15:00 - 16/12/2021"));

        adapter = new HistoryItemAdapter(historyItem,this);
        binding.recycleViewHistory.setAdapter(adapter);
    }
}
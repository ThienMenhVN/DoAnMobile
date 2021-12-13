package com.example.food.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food.Model.News;
import com.example.food.R;
import com.example.food.databinding.OrderDetailBinding;
import com.example.food.databinding.RowDataNewsProductBinding;

public class Row_data_news_product extends AppCompatActivity {
    private RowDataNewsProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_data_news_product);

        binding = RowDataNewsProductBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        getSupportActionBar().hide();

        binding.imgCloseAccumulatePoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        News news = (News) getIntent().getSerializableExtra("News");

        binding.title.setText(news.getTitle());
        binding.content.setText(news.getDescription());
        binding.titleProduct.setText(news.getTitle());
        binding.image.setImageResource(news.getImage());
    }
}
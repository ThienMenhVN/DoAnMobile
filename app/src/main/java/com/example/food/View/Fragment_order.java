package com.example.food.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.food.Adapter.PageSavedAdapter;
import com.example.food.MainActivity;
import com.example.food.Order_view;
import com.example.food.R;
import com.google.android.material.tabs.TabLayout;

public class Fragment_order extends Fragment {

    public static CardView orderDetail;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, container, false);
        TabLayout tabLayout = v.findViewById(R.id.tab_history);
        final ViewPager viewPager = v.findViewById(R.id.view_page_order);
        PageSavedAdapter pageSavedAdapter = new PageSavedAdapter(getChildFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageSavedAdapter);
        viewPager.setCurrentItem(viewPager.getCurrentItem());
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return v;
    }
}

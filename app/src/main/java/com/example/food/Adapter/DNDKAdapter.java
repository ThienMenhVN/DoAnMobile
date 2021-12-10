package com.example.food.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class DNDKAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> FragamentList =  new ArrayList<>();
    private final ArrayList<String> FragamenName =  new ArrayList<>();

    public DNDKAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FragamentList.get(position);
    }

    @Override
    public int getCount() {
        return FragamentList.size();
    }
    public void addFragament(Fragment fragment, String name){
        FragamentList.add(fragment);
        FragamenName.add(name);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return FragamenName.get(position);
    }
}

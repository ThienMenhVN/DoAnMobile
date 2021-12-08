package com.example.food.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.food.View.Item_order_coffee;
import com.example.food.View.Item_order_food;

public class PageSavedAdapter extends FragmentStatePagerAdapter {
    private int numOfTabs;
    String title[]={"Phổ biến","Cà phê","Trà \\ Trà sữa","Đá xay","Đồ ăn","Thức uống tại nhà"};
    public PageSavedAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs=numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Item_order_coffee();
            case 1:
                return new Item_order_coffee();
            case 2:
                return new Item_order_coffee();
            case 3:
                return new Item_order_coffee();
            case 4:
                return new Item_order_food();
            case 5:
                return new Item_order_coffee();
            default:
                return null;
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}

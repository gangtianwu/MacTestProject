package com.example.mactestproject.sunflower;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class SunFlowerPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> list ;

    public SunFlowerPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
        list = new ArrayList<>();
        list.add(new GardenFragment());
        list.add(new PlaintFragment());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

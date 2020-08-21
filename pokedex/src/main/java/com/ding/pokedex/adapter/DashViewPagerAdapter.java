package com.ding.pokedex.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.ding.pokedex.ui.AboutFragment;
import com.ding.pokedex.ui.StatsFragment;

import java.util.ArrayList;
import java.util.List;

public class DashViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> list;
    private List<String> titleList;
    public DashViewPagerAdapter(@NonNull FragmentManager fm,String id) {
        super(fm);
        list = new ArrayList<>();
        list.add(AboutFragment.newInstance(id,""));
        list.add(StatsFragment.newInstance(id,""));
        list.add(AboutFragment.newInstance(id,""));
        list.add(AboutFragment.newInstance(id,""));
        titleList = new ArrayList<>();
        titleList.add("About");
        titleList.add("Base Stats");
        titleList.add("Evolution");
        titleList.add("Moves");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}

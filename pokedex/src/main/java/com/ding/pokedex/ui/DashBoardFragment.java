package com.ding.pokedex.ui;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ding.pokedex.ColorConvertUtil;
import com.ding.pokedex.R;
import com.ding.pokedex.adapter.DashViewPagerAdapter;
import com.ding.pokedex.databinding.FragmentDashBoardBinding;
import com.ding.pokedex.entity.Pokemon;
import com.ding.pokedex.viewmodel.DashViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashBoardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashBoardFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private FragmentDashBoardBinding binding;
    private DashViewModel dashViewModel;

    public DashBoardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashBoardFragment.
     */
    public static DashBoardFragment newInstance(String param1, String param2) {
        DashBoardFragment fragment = new DashBoardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardBinding.inflate(inflater, container, false);
        ViewModelProvider viewModelProvider = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory());
        dashViewModel = viewModelProvider.get(DashViewModel.class);
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    //binding.tabs
       binding.viewPager.setAdapter(new DashViewPagerAdapter(getParentFragmentManager(),mParam1));
       binding.tabs.setupWithViewPager(binding.viewPager);
       dashViewModel.getPokemon(mParam1).observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
           @Override
           public void onChanged(Pokemon pokemon) {
               binding.textViewID.setText(pokemon.getId());
               binding.textViewName.setText(pokemon.getName());
               binding.appBar.getBackground().setColorFilter(new PorterDuffColorFilter(getResources().getColor(ColorConvertUtil.convertColor(pokemon.getTypeofpokemon())), PorterDuff.Mode.SRC_ATOP));
               List<String> typeofpokemon = pokemon.getTypeofpokemon();
               if (typeofpokemon != null){
                   if (typeofpokemon.size()> 0 && typeofpokemon.get(0) != null){
                       binding.textViewType3.setVisibility(View.VISIBLE);
                       binding.textViewType3.setText(typeofpokemon.get(0));
                   }
                   if (typeofpokemon.size()> 1 && typeofpokemon.get(1) != null){
                       binding.textViewType2.setVisibility(View.VISIBLE);
                       binding.textViewType2.setText(typeofpokemon.get(1));
                   }
                   if (typeofpokemon.size()> 2 && typeofpokemon.get(2) != null){
                       binding.textViewType1.setVisibility(View.VISIBLE);
                       binding.textViewType1.setText(typeofpokemon.get(2));
                   }
               }
               Glide.with(getContext())
                       .load(pokemon.getImageurl())
                       .placeholder(android.R.color.transparent)
                       .into((ImageView) binding.imageView);
           }
       });


    }
}
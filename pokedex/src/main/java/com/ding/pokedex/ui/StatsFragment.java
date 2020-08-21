package com.ding.pokedex.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ding.pokedex.databinding.FragmentStatsBinding;
import com.ding.pokedex.entity.Pokemon;
import com.ding.pokedex.viewmodel.DashViewModel;

public class StatsFragment extends Fragment {

    private FragmentStatsBinding statsBinding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private DashViewModel dashViewModel;

    public static StatsFragment newInstance(String param1, String param2) {
        StatsFragment fragment = new StatsFragment();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        statsBinding = FragmentStatsBinding.inflate(inflater, container, false);
        dashViewModel = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get(DashViewModel.class);
        return statsBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dashViewModel.getPokemon(mParam1)
                .observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
                    @Override
                    public void onChanged(Pokemon pokemon) {
                        statsBinding.textViewTypeDefenses.setText(pokemon.getYdescription());
                        statsBinding.textViewHP.setText(pokemon.getHp() + "");
                        statsBinding.textViewAttack.setText(pokemon.getAttack() + "");
                        statsBinding.textViewDefense.setText(pokemon.getDefense() + "");
                        statsBinding.textViewSpAtk.setText(pokemon.getSpecial_attack() + "");
                        statsBinding.textViewSpDef.setText(pokemon.getSpecial_defense() + "");
                        statsBinding.textViewSpeed.setText(pokemon.getSpeed() + "");
                        statsBinding.textViewTotal.setText(pokemon.getTotal() + "");

                        statsBinding.progressBarHP.setProgress(pokemon.getHp());
                        statsBinding.progressBarAttack.setProgress(pokemon.getAttack());
                        statsBinding.progressBarDefense.setProgress(pokemon.getDefense());
                        statsBinding.progressBarSpAtk.setProgress(pokemon.getSpecial_attack());
                        statsBinding.progressBarSpDef.setProgress(pokemon.getSpecial_defense());
                        statsBinding.progressBarSpeed.setProgress(pokemon.getSpeed());
                        statsBinding.progressBarTotal.setProgress(pokemon.getTotal());
                    }
                });
    }
}

package com.ding.pokedex.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ding.pokedex.R;
import com.ding.pokedex.adapter.PokemonAdapter;
import com.ding.pokedex.databinding.FragmentHomeBinding;
import com.ding.pokedex.databinding.FragmentPokeDexBinding;
import com.ding.pokedex.entity.Pokemon;
import com.ding.pokedex.viewmodel.PokeViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PokeDexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokeDexFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private FragmentPokeDexBinding homeBinding;
    private PokeViewModel pokeViewModel;

    public PokeDexFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokeDexFragment.
     */
    public static PokeDexFragment newInstance(String param1, String param2) {
        PokeDexFragment fragment = new PokeDexFragment();
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
        homeBinding = FragmentPokeDexBinding.inflate(inflater, container, false);
//        return inflater.inflate(R.layout.fragment_poke_dex, container, false);
        return homeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory());
        pokeViewModel = viewModelProvider.get(PokeViewModel.class);
        PokemonAdapter pokemonAdapter = new PokemonAdapter();
        homeBinding.recyclerView.setAdapter(pokemonAdapter);

        MutableLiveData<List<Pokemon>> data = pokeViewModel.getData();
        data.observe(getViewLifecycleOwner(), new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(List<Pokemon> pokemons) {
                homeBinding.progressCircular.setVisibility(View.GONE);
                pokemonAdapter.setData(pokemons);
            }
        });
    }
}
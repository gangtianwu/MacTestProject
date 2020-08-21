package com.ding.pokedex.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ding.pokedex.R;
import com.ding.pokedex.databinding.FragmentAboutBinding;
import com.ding.pokedex.entity.Pokemon;
import com.ding.pokedex.viewmodel.DashViewModel;
import com.ding.pokedex.viewmodel.PokeViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentAboutBinding aboutBinding;
   private DashViewModel dashViewModel;
    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
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
        aboutBinding = FragmentAboutBinding.inflate(inflater, container, false);
        ViewModelProvider viewModelProvider = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory());
        dashViewModel = viewModelProvider.get(DashViewModel.class);
        return aboutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dashViewModel.getPokemon(mParam1).observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon pokemon) {
                aboutBinding.textViewDescription.setText(pokemon.getXdescription());
                aboutBinding.textViewHeight.setText(pokemon.getHeight());
                aboutBinding.textViewWeight.setText(pokemon.getWeight());
                aboutBinding.textViewEggCycle.setText(pokemon.getCycles());
                aboutBinding.textViewEggGroups.setText(pokemon.getEgg_groups());
                aboutBinding.textViewBaseEXP.setText(pokemon.getBase_exp());
            }
        });

    }
}
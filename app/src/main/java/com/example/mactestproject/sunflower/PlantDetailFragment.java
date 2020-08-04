package com.example.mactestproject.sunflower;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mactestproject.databinding.FragmentPlantDetailBinding;

import java.io.Serializable;

public class PlantDetailFragment extends Fragment {

    private FragmentPlantDetailBinding binding;
    private DetailViewModel detailViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentPlantDetailBinding.inflate(inflater, container, false);
        PlantBean data = (PlantBean) getArguments().getSerializable("data");
        ViewModelProvider viewModelProvider = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()));
        detailViewModel = viewModelProvider.get(DetailViewModel.class);
        detailViewModel.setData(data);




        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.setData(detailViewModel.getData());
    }
}

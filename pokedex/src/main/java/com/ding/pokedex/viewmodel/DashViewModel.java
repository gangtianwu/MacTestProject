package com.ding.pokedex.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ding.pokedex.entity.Pokemon;

public class DashViewModel extends ViewModel {
 private MutableLiveData<Pokemon> data;

    public DashViewModel() {
        this.data = new MutableLiveData<>();
    }

    public MutableLiveData<Pokemon> getPokemon(String mParam1){
     for (int i = 0; i < PokeViewModel.sData.size(); i++) {
         if (PokeViewModel.sData.get(i).getId().equals(mParam1)){
                data.setValue(PokeViewModel.sData.get(i));
                break;
         }
     }
     return data;
 }

}

package com.ding.pokedex.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ding.pokedex.entity.Pokemon;
import com.ding.pokedex.repository.RetrofitApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokeViewModel extends ViewModel {
    private MutableLiveData<List<Pokemon>> list = new MutableLiveData<>();

    public MutableLiveData<List<Pokemon>> getData() {
        Call<List<Pokemon>> data = RetrofitApi.getInstance().getData();
        data.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if (response != null) {
                    List<Pokemon> body = response.body();
                    Log.i("PokeFragment", "getData onResponse success : " + Thread.currentThread().getName());
                    for (int i = 0; i < body.size(); i++) {
                        Log.i("PokeFragment", "iterator: " + body.get(i).getName());
                    }
                    list.setValue(body);
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                Log.i("PokeFragment", "getData onResponse failed : " + t.getMessage() + Thread.currentThread().getName());
                List<Pokemon> value = list.getValue();
                if (value == null){
                    value = new ArrayList<>();
                }
                value.clear();
                list.setValue(value);
            }
        });
        return list;
    }
}

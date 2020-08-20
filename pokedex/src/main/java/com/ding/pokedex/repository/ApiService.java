package com.ding.pokedex.repository;

import com.ding.pokedex.entity.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService  {
    @GET("pokemon.json")
    Call<List<Pokemon>> getData();
}

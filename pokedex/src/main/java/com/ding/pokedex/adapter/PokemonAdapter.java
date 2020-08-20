package com.ding.pokedex.adapter;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ding.pokedex.ColorConvertUtil;
import com.ding.pokedex.R;
import com.ding.pokedex.entity.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {
    private List<Pokemon> list;

    public PokemonAdapter() {
        this.list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<Pokemon> pokemons) {
        list = pokemons;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

       public void bindView(Pokemon pokemon){
            //name
           TextView tvName = itemView.findViewById(R.id.textViewName);
           tvName.setText(pokemon.getName());
           //layout background color
          RelativeLayout relativeLayout =  itemView.findViewById(R.id.relativeLayoutBackground);
          relativeLayout.getBackground().setColorFilter(new PorterDuffColorFilter(itemView.getResources().getColor(ColorConvertUtil.convertColor(pokemon.getTypeofpokemon())), PorterDuff.Mode.SRC_ATOP));
           List<String> typeofpokemon = pokemon.getTypeofpokemon();
           if (typeofpokemon != null){
               if (typeofpokemon.size()> 0 && typeofpokemon.get(0) != null){
                   TextView tv3 = itemView.findViewById(R.id.textViewType3);
                   tv3.setVisibility(View.VISIBLE);
                   tv3.setText(typeofpokemon.get(0));
               }
               if (typeofpokemon.size()> 1 && typeofpokemon.get(1) != null){
                   TextView tv2 = itemView.findViewById(R.id.textViewType2);
                   tv2.setVisibility(View.VISIBLE);
                   tv2.setText(typeofpokemon.get(1));
               }
               if (typeofpokemon.size()> 2 && typeofpokemon.get(2) != null){
                   TextView tv1 = itemView.findViewById(R.id.textViewType1);
                   tv1.setVisibility(View.VISIBLE);
                   tv1.setText(typeofpokemon.get(2));
               }
           }
           Glide.with(itemView.getContext())
                   .load(pokemon.getImageurl())
                   .placeholder(android.R.color.transparent)
                   .into((ImageView) itemView.findViewById(R.id.imageView));
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Navigation.findNavController(itemView).navigate(R.id.action_pokeDexFragment_to_dashBoardFragment);
               }
           });


       }
    }
}

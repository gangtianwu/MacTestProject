package com.ding.pokedex.adapter;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.ding.pokedex.BR;
import com.ding.pokedex.R;
import com.ding.pokedex.databinding.ItemMenuBinding;
import com.ding.pokedex.entity.Menu;

import java.util.List;

public class HomeRyAdapter extends RecyclerView.Adapter<HomeRyAdapter.ViewHolder> {

    private List<Menu> dataList;

    public HomeRyAdapter(List<Menu> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu, parent, false);
        ItemMenuBinding menuBinding = ItemMenuBinding.inflate(inflater, parent, false);
//        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_menu, parent, false);
        return new ViewHolder(menuBinding);
//        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        private ItemMenuBinding menuBinding;
        public ViewHolder(ItemMenuBinding menuBinding) {
            super(menuBinding.getRoot());
            this.menuBinding = menuBinding;
        }

        void bindView(Menu menu){
            //viewBinding
            if (menuBinding != null){
                menuBinding.getRoot().getBackground().setColorFilter(new PorterDuffColorFilter(itemView.getResources().getColor(menu.getColor()), PorterDuff.Mode.SRC_ATOP));
                menuBinding.setClikcListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_pokeDexFragment);
                    }
                });
                menuBinding.setVariable(BR.menu,menu);
                menuBinding.executePendingBindings();

            }else {
                //非viewBinding
                TextView leftText = itemView.findViewById(R.id.textViewName);
                leftText.setText(menu.getName());
                Log.i("PokeDex ", "bindView: " + menu.getColor());
                itemView.getBackground().setColorFilter(new PorterDuffColorFilter(itemView.getResources().getColor(menu.getColor()), PorterDuff.Mode.SRC_ATOP));
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_pokeDexFragment);
                    }
                });
            }

        }
    }
}

package com.example.mactestproject.sunflower;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mactestproject.R;
import com.example.mactestproject.databinding.ItemGardenBinding;
import com.example.mactestproject.databinding.ItemPlantBinding;

import static com.example.mactestproject.sunflower.Config.TAG;

public class PlaintRecyclerAdapter extends ListAdapter<PlantBean, PlaintRecyclerAdapter.GardenViewHolder> {


    protected PlaintRecyclerAdapter(@NonNull DiffUtil.ItemCallback<PlantBean> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public GardenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GardenViewHolder(ItemPlantBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
//        return new GardenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_garden,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GardenViewHolder holder, int position) {
        holder.bind(getItem(position));

    }

    static class GardenViewHolder extends RecyclerView.ViewHolder{

//        private final ViewDataBinding binding;
        public final ItemPlantBinding bind;

        public GardenViewHolder( ItemPlantBinding bind2) {
            super(bind2.getRoot());
            this.bind = bind2;
            this.bind.setClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = bind.getPlantBean().getName();
                    Log.i("点击事件", "onClick: "+name);

                    navigateToPlant(bind.getPlantBean(),v);

                }
            });
        }

        private void navigateToPlant(PlantBean plantBean, View v) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("data",plantBean);
            Navigation.findNavController(v).navigate(R.id.action_firstFragment2_to_plantDetailFragment,bundle);
        }

//        public GardenViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            bind = ItemGardenBinding.bind(itemView);
////            binding = DataBindingUtil.getBinding(itemView);
//            bind.setClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String name = bind.getViewModel().getName();
//                    Log.i("点击事件", "onClick: "+name);
//                }
//            });
//        }

        public void bind(PlantBean bean){
            Log.i(TAG, "bind: "+ bean.getName());
            bind.setPlantBean(bean);
//            binding.executePendingBindings();
        }
    }
}

package com.ding.pokedex.bindadpter;

import android.media.Image;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ViewBindAdapter {
    @BindingAdapter("imageFromUrl")
    public static void bindImageFromUrl(ImageView view,String url) {
        Glide.with(view.getContext())
                .load(url)
                .into(view);
    }
}

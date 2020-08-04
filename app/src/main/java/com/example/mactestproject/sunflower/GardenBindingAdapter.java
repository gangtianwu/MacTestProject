package com.example.mactestproject.sunflower;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.mactestproject.R;

import static com.example.mactestproject.sunflower.Config.TAG;


public class GardenBindingAdapter {
    @BindingAdapter("imageFromUrl")
   public static void bindImageFromUrl(ImageView view,String url){
        Glide.with(view.getContext())
//                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596115451405&di=d8b00657725fa9e5534199fb08de2b84&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F55%2F58%2F19300001338703133421580854358_950.jpg")
                .load(R.drawable.timg)
                .into(view);
        Log.i(TAG, "图片加载bindImageFromUrl: " + url);
    }


    @BindingAdapter("wateringText")
    public static void  bindWateringText(TextView view,int text){
        view.setText("每隔"+text+"天浇水");
    }

}


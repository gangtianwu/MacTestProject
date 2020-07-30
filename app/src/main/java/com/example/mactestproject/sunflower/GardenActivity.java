package com.example.mactestproject.sunflower;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mactestproject.R;

public class GardenActivity extends AppCompatActivity {
    public static final String TAG ="测试Fragment Garden :";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: 1 ");
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this,R.layout.activity_garden);
//        try {
//            Thread.sleep((long) (3.5 *1000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Log.i(TAG, "onCreate: 2");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: " + this.toString());
    }
}

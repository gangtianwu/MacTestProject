package com.example.mactestproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mactestproject.databinding.ActivityBindBinding;

public class BindTestClass extends AppCompatActivity {

    private ActivityBindBinding bind;
    volatile boolean loop = true;
    public static final String TAG  = "BindTestClass";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityBindBinding.inflate(getLayoutInflater());
        View root = bind.getRoot();
        setContentView(root);
//        bind.textview.setText();

    }

    @Override
    protected void onStart() {
        super.onStart();
        while (loop){
            Log.i(TAG, "onStart:  ====== ");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        loop = false;
    }
}

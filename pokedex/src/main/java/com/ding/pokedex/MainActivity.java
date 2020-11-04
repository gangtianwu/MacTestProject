package com.ding.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.yunjichina.ai.config.YjConstants;
import com.yunjichina.ai.entity.AISelfBean;
import com.yunjichina.ai.utils.Tools;
import com.yunjichina.ai.YunJiAiUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);


    }
}

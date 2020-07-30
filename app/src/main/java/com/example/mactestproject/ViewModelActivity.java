package com.example.mactestproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mactestproject.viewmodel.CountViewModel;

import java.security.KeyFactory;

public class ViewModelActivity extends AppCompatActivity {

    private TextView content;
    public static final String TAG = "ViewModelActivity";
    private CountViewModel countViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodel);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication()));
        countViewModel = viewModelProvider.get(CountViewModel.class);
        content = findViewById(R.id.textview);
        countViewModel.getCountNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                content.setText(integer.intValue()+"");
            }
        });
        findViewById(R.id.minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                countViewModel.count--;
//                setText(countViewModel);
                countViewModel.setCountNum(countViewModel.getCountNum().getValue().intValue()-1);
            }
        });
//        setText(countViewModel);

        Log.i(TAG, "onCreate: " + this.toString() +" === "+ countViewModel.toString()+" === viewModelProvider : "+ viewModelProvider.toString() + " ===ViewModelSrore: " + getViewModelStore().toString());

        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                countViewModel.count = 0;
//                setText(countViewModel);
            }
        });

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                countViewModel.count++;
//                setText(countViewModel);
                countViewModel.setCountNum(countViewModel.getCountNum().getValue().intValue()+1);


            }
        });

//        下一个
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewModelActivity.this,FirstActivity.class) );
            }
        });
    }

    private void setText(CountViewModel countViewModel) {
        content.setText(countViewModel.count+"");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: " + countViewModel.toString());

    }
}

package com.example.mactestproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {
    public int count = 0;
    private MutableLiveData<Integer> countNum;

    public MutableLiveData<Integer> getCountNum() {
        if (countNum == null){
            countNum = new MutableLiveData<>();
            countNum.setValue(0);
        }
        return countNum;
    }

    public void setCountNum(int num) {
        this.countNum.setValue(num);
    }
}

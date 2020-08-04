package com.example.mactestproject.sunflower;

import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {
    private PlantBean data;
    public void setData(PlantBean data) {
        this.data = data;
    }

    public PlantBean getData() {
        return data;
    }
}

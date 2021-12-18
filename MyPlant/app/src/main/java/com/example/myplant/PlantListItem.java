package com.example.myplant;

import android.media.Image;

public class PlantListItem {

    public Integer plant_img;
    public String plant_name, plant_date;

    public int getPlant_img() {
        return plant_img;
    }

    public void setPlant_img(int plant_img) {
        this.plant_img = plant_img;
    }

    public String getPlant_name() {
        return plant_name;
    }

    public void setPlant_name(String plant_name) {
        this.plant_name = plant_name;
    }

    public String getPlant_date() {
        return plant_date;
    }

    public void setPlant_date(String plant_date) {
        this.plant_date = plant_date;
    }
}

package com.aolimpio.models.beans;

import com.aolimpio.models.repositories.Api;

import androidx.databinding.BaseObservable;
import retrofit2.Callback;

public class CatBreed extends BaseObservable {
    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void fetchImages(Callback<CatBreedImages> callback){
        Api.getApi().getImagesByBreed(this.breed).enqueue(callback);
    }
}

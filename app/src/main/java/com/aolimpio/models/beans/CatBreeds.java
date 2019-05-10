package com.aolimpio.models.beans;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatBreeds {
    private String status;
    private List<CatBreed> breedList = new ArrayList<>();
    private MutableLiveData<List<CatBreed>> breeds = new MutableLiveData<>();

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public MutableLiveData<List<CatBreed>> getBreeds() { return breeds; }

    public void addBreed(CatBreed bd)   {   breedList.add(bd); }

    public void fetchList(){
        Callback<CatBreeds> callback = new Callback<CatBreeds>() {
            @Override
            public void onResponse(Call<CatBreeds> call, Response<CatBreeds> response) {
                CatBreeds body =response.body();
            }

            @Override
            public void onFailure(Call<CatBreeds> call, Throwable t) {

            }
        };
    }
}

package com.aolimpio.models.repositories;

import com.aolimpio.models.beans.CatBreedImages;
import com.aolimpio.models.beans.CatBreeds;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Api {
    private static ApiInterface api;
    private final static String BASE_URL = "https://dog.ceo";

    public static ApiInterface getApi(){
        if (api == null){
            HttpLoggingInterceptor logiing = new HttpLoggingInterceptor();
            logiing.setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logiing).build();

            Gson gson = new GsonBuilder().registerTypeAdapter(CatBreeds.class,
                    new JsonCatBreedsDeserializer()).create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            api = retrofit.create(ApiInterface.class);
        }

        return api;
    }

    public interface ApiInterface{
        @GET("/api/breeds/list/all")
        Call<CatBreeds> getBreeds();

        @GET("/api/breed/{breed}/images/random")
        Call<CatBreedImages> getImagesByBreed(@Path("breed") String breed);
    }
}

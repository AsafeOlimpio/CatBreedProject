package com.aolimpio.models.beans;

import com.google.gson.annotations.SerializedName;

public class CatBreedImages {

    private String status;

    @SerializedName("message")
    private String [] images;

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String[] getImages() { return images; }

    public void setImages(String[] images) { this.images = images; }
}
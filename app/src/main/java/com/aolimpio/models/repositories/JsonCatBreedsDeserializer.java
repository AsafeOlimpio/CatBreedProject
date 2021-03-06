package com.aolimpio.models.repositories;

import android.util.Log;

import com.aolimpio.models.beans.CatBreed;
import com.aolimpio.models.beans.CatBreeds;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Map;

class JsonCatBreedsDeserializer implements JsonDeserializer<CatBreeds> {
    @Override
    public CatBreeds deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CatBreeds breeds = new CatBreeds();
        if (json.isJsonObject()) {
            for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
                if (entry.getKey().equals("status")) {
                    Log.d("Test", "Primitive: " + entry.getKey() + " = " + entry.getValue().getAsString());
                    breeds.setStatus(entry.getValue().getAsString());
                } else if (entry.getKey().equals("message")) {
                    Log.d("Test", "Object: key: " + entry.getKey() + " = " + entry.getValue());
                    JsonObject jsonObject = entry.getValue().getAsJsonObject();
                    for (Map.Entry<String, JsonElement> subEntry : jsonObject.entrySet()) {
                        CatBreed cb = new CatBreed();
                        cb.setBreed(subEntry.getKey());
                        breeds.addBreed(cb);
                    }
                }
            }
        }
        return breeds;
    }
}

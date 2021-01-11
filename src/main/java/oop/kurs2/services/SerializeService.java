package oop.kurs2.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class SerializeService<T> {
    public String serialize(T object) {
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();
        return gson.toJson(object);
    }

    public T deserialize(String json, T clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, (Type) clazz.getClass());
    }
}

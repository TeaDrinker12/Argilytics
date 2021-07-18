package com.argilytics.gateway;

import java.io.IOException;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class MonitorServer {
    Service service;
    public MonitorServer() {
        System.out.println("monitor server class");
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        
        this.service = retrofit.create(Service.class);
        
    }

    public static interface Service {
        @GET("api/breeds/image/random")
        Call<JsonObject> getDog();
    }

    public String updateReading(Reading reading) {
        try {
            return service.getDog().execute().body().toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "null";
    }
}

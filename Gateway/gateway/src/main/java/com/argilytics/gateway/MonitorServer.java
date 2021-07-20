package com.argilytics.gateway;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class MonitorServer {
    Service service;
    public MonitorServer() {
        System.out.println("monitor server class");
        var retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:9000")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        
        this.service = retrofit.create(Service.class);
        
    }

    public static interface Service {
        @POST("/reading")
        Call<JsonObject> sendReading(@Body JsonObject json);
    }

    public void sendReading(Reading reading) {
        try {
            var jsonPrototype = new ReadingJsonPrototype(reading);
            var json = new Gson().toJsonTree(jsonPrototype).getAsJsonObject();
            var call = this.service.sendReading(json);
            call.enqueue(new Callback<JsonObject>(){
                @Override
                public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
                    System.out.println("response! " + response.body());
                }
                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    System.out.println("failure! " + t);
                }
            });
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static final class ReadingJsonPrototype {
        Date timestamp;
        Double temprature;
        ReadingJsonPrototype(Reading reading) {
            this.timestamp = reading.timestamp();
            this.temprature = reading.temprature();
        }
    }
}

package com.argilytics.gateway;

import java.util.Date;

public final class SensorReading implements Reading {
    Date date;
    Double temprature;
    private SensorReading(Sensor sensor) {
        this.date = new Date();
        this.temprature = sensor.temprature();
    }
    public static SensorReading from(Sensor sensor) {
        return new SensorReading(sensor);
    }
    @Override
    public Date timestamp() {
        return date;
    }
    @Override
    public Double temprature() {
        return temprature;
    }


}

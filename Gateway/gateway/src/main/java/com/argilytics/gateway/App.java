package com.argilytics.gateway;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Sensor sensor = new VirtualSensor();
        try {
            while (true) {
                Double temprature = sensor.getTemprature();
                Date date = new Date();
                System.out.println(String.format("Temprature: %s - Date: %s", temprature, date));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

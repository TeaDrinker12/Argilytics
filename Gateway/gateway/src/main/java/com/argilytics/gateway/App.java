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
        Sensor virtualSensor = new VirtualSensor();
        try {
            while (true) {
                Reading reading = SensorReading.from(virtualSensor);
                System.out.println(formatReading(reading));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static String formatReading(Reading reading) {
        return String.format("Temprature: %s - Date: %s", reading.temprature(), reading.date());
    }
}

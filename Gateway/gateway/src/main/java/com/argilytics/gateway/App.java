package com.argilytics.gateway;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var virtualSensor = new VirtualSensor();
        var server = new MonitorServer();
        try {
            while (true) {
                var reading = SensorReading.from(virtualSensor);
                server.sendReading(reading);
                System.out.println(formatReading(reading));
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static String formatReading(Reading reading) {
        return String.format("Temprature: %s - Date: %s", reading.temprature(), reading.timestamp());
    }
}

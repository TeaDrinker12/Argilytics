package com.argilytics.gateway;

import org.zeroturnaround.exec.*;
import org.zeroturnaround.exec.stream.LogOutputStream;

public final class VirtualSensor implements Sensor {
    Double temprature = null;
    public VirtualSensor() {
        System.out.println( "Hello World!" );
        try {
            new ProcessExecutor()
            .command("python", "-u", "./Sensor/sensor.py")
            .redirectOutput(new LogOutputStream(){
                @Override
                protected void processLine(String arg0) {
                    VirtualSensor.this.temprature = Double.parseDouble(arg0);
                }
            })
            .destroyOnExit()
            .start()
            .getProcess();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Double temprature() {
        return temprature;
    }
    
}

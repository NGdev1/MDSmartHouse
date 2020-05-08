package com.md.smarthouse.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocketData {
    private float lastTemperatureFromSensor;
    private boolean isOn;

    public SocketData() {
        this.lastTemperatureFromSensor = 0;
        this.isOn = true;
    }
}

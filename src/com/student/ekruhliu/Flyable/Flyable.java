package com.student.ekruhliu.Flyable;

import com.student.ekruhliu.Tower.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}

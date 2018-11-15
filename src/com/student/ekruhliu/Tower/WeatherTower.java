package com.student.ekruhliu.Tower;

import com.student.ekruhliu.Flyable.Coordinates;
import com.student.ekruhliu.MainPackage.WeatherProvider;

public class WeatherTower extends Tower {
    public  String  getWeather(Coordinates coordinates){
        WeatherProvider weather = WeatherProvider.getProvider();
        return weather.getCurrentWeather(coordinates);
    }
    public  void    changeWeather(){
        conditionsChanged();
    }
}

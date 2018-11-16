package com.student.ekruhliu.Tower;

import com.student.ekruhliu.Flyable.Coordinates;
import com.student.ekruhliu.MainPackage.WeatherProvider;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class WeatherTower extends Tower {

    public  String  getWeather(Coordinates coordinates){
        WeatherProvider weather = WeatherProvider.getProvider();
        return weather.getCurrentWeather(coordinates);
    }
    public  void    changeWeather(){
        conditionsChanged();
    }
}

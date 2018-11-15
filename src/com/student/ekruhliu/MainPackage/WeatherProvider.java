package com.student.ekruhliu.MainPackage;

import com.student.ekruhliu.Flyable.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[]        weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider   getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int i = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        Random  rand = new Random();
        int num = rand.nextInt(20);
        i *= num;
        return (this.weather[i % 4]);
    }
}

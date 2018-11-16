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
        int i = (coordinates.getHeight() + (int)(Math.random() * (Math.random() * 100))) +
                (coordinates.getLatitude() + (int)(Math.random() * (Math.random() * 100))) +
                (coordinates.getLongitude() + (int)(Math.random() * (Math.random() * 100)));
        return (this.weather[i % 4]);
    }
}

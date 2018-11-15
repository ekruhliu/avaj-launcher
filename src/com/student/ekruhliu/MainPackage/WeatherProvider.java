package com.student.ekruhliu.MainPackage;

import com.student.ekruhliu.Flyable.Coordinates;

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
        return (this.weather[i % 4]);
    }
}

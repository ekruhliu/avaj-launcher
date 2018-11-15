package com.student.ekruhliu.Flyable;

import com.student.ekruhliu.MainPackage.WeatherProvider;
import com.student.ekruhliu.Tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower _weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = _weatherTower.getWeather(this._coordinates);
        int longitude = _coordinates.getLongitude();
        int latitude = _coordinates.getLatitude();
        int height = _coordinates.getHeight();
        switch (weather){
            case "SUN":
                longitude += 2;
                height += 4;
                System.out.println("Baloon#" + this._name + "(" + this._id + "): Супер, в такую погоду летать замечательно!");
                break;
            case "RAIN":
                height -= 5;
                System.out.println("Baloon#" + this._name + "(" + this._id + "): Бля, сейчас полную корзину воды нальет!");
                break;
            case "FOG":
                height -= 3;
                System.out.println("Baloon#" + this._name + "(" + this._id + "): Туман очень густой, мы тут совершенно ничего не видим.");
                break;
            default: //SNOW
                height -= 15;
                System.out.println("Baloon#" + this._name + "(" + this._id + "): Нас засыпало снегом, нам СМЭРТЬ.");
                break;
        }
        if (height > 100)
            height = 100;
        if (height <= 0){
            System.out.println("\\u001B[31mError\\u001B[0m  Tower says: Baloon#" + this._name + "(" + this._id + ")" + " unregistered from the tower.");
            _weatherTower.unregister(this);
        }
        else {
            _coordinates = new Coordinates(longitude, latitude, height);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        _weatherTower = weatherTower;
    }
}

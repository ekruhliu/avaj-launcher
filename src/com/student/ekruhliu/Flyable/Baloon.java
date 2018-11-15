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
                System.out.println("Baloon#" + this._name + "(" + this._id + "): Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                height -= 5;
                System.out.println("Baloon#" + this._name + "(" + this._id + "): Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                height -= 3;
                System.out.println("Baloon#" + this._name + "(" + this._id + "): SMERT.");
                break;
            default: //SNOW
                height -= 15;
                System.out.println("Baloon#" + this._name + "(" + this._id + "): It's snowing. We're gonna crash.");
                break;
        }
        if (height > 100)
            height = 100;
        if (height <= 0){
            System.out.println("Tower says: Baloon#" + this._name + "(" + this._id + ")" + " unregistered from the tower.");
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

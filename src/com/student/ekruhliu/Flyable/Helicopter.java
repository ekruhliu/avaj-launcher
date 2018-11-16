package com.student.ekruhliu.Flyable;

import com.student.ekruhliu.MainPackage.WeatherProvider;
import com.student.ekruhliu.Tower.WeatherTower;
import com.student.ekruhliu.MainPackage.Main;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower _weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = WeatherProvider.getProvider().getCurrentWeather(this._coordinates);
        int longitude = _coordinates.getLongitude();
        int latitude = _coordinates.getLatitude();
        int height = _coordinates.getHeight();
        switch (weather){
            case "SUN":
                longitude += 10;
                height += 2;
                Main.toFile.add("Helicopter#" + this._name + "(" + this._id + "): Найс, летим на пляж ебать шлюх!");
                break;
            case "RAIN":
                longitude += 5;
                Main.toFile.add("Helicopter#" + this._name + "(" + this._id + "): Доджичек это канэшна не приятно!");
                break;
            case "FOG":
                longitude += 1;
                Main.toFile.add("Helicopter#" + this._name + "(" + this._id + "): Нихуя не видно, как лететь вообще?!");
                break;
            default: //SNOW
                height -= 12;
                Main.toFile.add("Helicopter#" + this._name + "(" + this._id + "): Пизда, а откуда в Калифорнии снег?!");
                break;
        }
        if (height > 100)
            height = 100;
        if (height <= 0){
            Main.toFile.add("Tower says: Helicopter#" + this._name + "(" + this._id + ")" + " unregistered from the tower.");
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

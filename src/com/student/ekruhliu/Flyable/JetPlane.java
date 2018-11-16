package com.student.ekruhliu.Flyable;

import com.student.ekruhliu.MainPackage.WeatherProvider;
import com.student.ekruhliu.Tower.WeatherTower;
import com.student.ekruhliu.MainPackage.Main;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower _weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = WeatherProvider.getProvider().getCurrentWeather(this._coordinates);
        int longitude = _coordinates.getLongitude();
        int latitude = _coordinates.getLatitude();
        int height = _coordinates.getHeight();
        switch (weather){
            case "SUN":
                latitude += 10;
                height += 2;
                Main.toFile.add("JetPlane#" + this._name + "(" + this._id + "): 5 минут, полет нормальный!");
                break;
            case "RAIN":
                latitude += 5;
                Main.toFile.add("JetPlane#" + this._name + "(" + this._id + "): Миша включи дворники, заебал! В смысле у нас самолет без дворников!?");
                break;
            case "FOG":
                latitude += 1;
                Main.toFile.add("JetPlane#" + this._name + "(" + this._id + "): Народ, это у всех туман или мы в кабине так надули?!");
                break;
            default: //SNOW
                height -= 7;
                Main.toFile.add("JetPlane#" + this._name + "(" + this._id + "): Ну нахуй ваш снег, полетел я отсюда в теплые края!");
                break;
        }
        if (height > 100)
            height = 100;
        if (height <= 0){
            Main.toFile.add("Tower says: JetPlane#" + this._name + "(" + this._id + ")" + " unregistered from the tower.");
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

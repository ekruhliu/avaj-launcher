package com.student.ekruhliu.Flyable;

import com.student.ekruhliu.MainPackage.WeatherProvider;
import com.student.ekruhliu.Tower.WeatherTower;

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
                longitude += 10;
                height += 2;
                System.out.println("JetPlane#" + this._name + "(" + this._id + "): 5 минут, полет нормальный!");
                break;
            case "RAIN":
                height += 5;
                System.out.println("JetPlane#" + this._name + "(" + this._id + "): Миша включи дворники, заебал! В смысле у нас самолет без дворников!?");
                break;
            case "FOG":
                height += 1;
                System.out.println("JetPlane#" + this._name + "(" + this._id + "): Народ, это у всех туман или мы в кабине так надули?!");
                break;
            default: //SNOW
                height -= 7;
                System.out.println("JetPlane#" + this._name + "(" + this._id + "): Ну нахуй ваш снег, полетел я отсюда в теплые края!");
                break;
        }
        if (height > 100)
            height = 100;
        if (height <= 0){
            System.out.println("Tower says: JetPlane#" + this._name + "(" + this._id + ")" + " unregistered from the tower.");
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

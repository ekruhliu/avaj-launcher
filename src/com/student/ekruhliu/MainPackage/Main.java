package com.student.ekruhliu.MainPackage;

import com.student.ekruhliu.Flyable.Flyable;
import com.student.ekruhliu.Tower.Tower;
import com.student.ekruhliu.Tower.WeatherTower;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Flyable> fl = new ArrayList<>();
        Flyable            buff;
        int                numOfSimulations = 0;
        int                numOfShips = 1;
        boolean            checkFlyable = true;
        WeatherTower    weatherTower = new WeatherTower();

        try(Scanner scan = new Scanner(new File(args[0])))
        {
            Reader          reader = new Reader(args[0]);
            Tower           tower = new Tower();

            reader.readFile();
            Parcer parcer = new Parcer(reader);
            for (String toSplit : reader.myFile){
                buff = parcer.spliter(toSplit);
                fl.add(buff);
                buff.registerTower(weatherTower);
                weatherTower.register(buff);
                parcer.towerSay(toSplit, numOfShips);
                numOfShips++;
            }
            numOfSimulations = reader.simulations;
            checkFlyable = weatherTower.checkFlyable();
            while(numOfSimulations > 0 && !checkFlyable){
                weatherTower.changeWeather();
//              checkFlyable = tower.checkFlyable();
                numOfSimulations--;
            }
        }
        catch (Exception ex){
            System.out.println("ERROR! Can`t run program!");
        }
    }

}

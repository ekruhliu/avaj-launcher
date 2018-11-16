package com.student.ekruhliu.MainPackage;

import com.student.ekruhliu.Flyable.Flyable;
import com.student.ekruhliu.Tower.Tower;
import com.student.ekruhliu.Tower.WeatherTower;

import java.util.ArrayList;
import java.io.*;

public class Main {

    public static ArrayList<String> toFile = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<Flyable> fl = new ArrayList<>();
        Flyable            buff;
        int                numOfShips = 1;
        WeatherTower       weatherTower = new WeatherTower();

        try {
            Reader reader = new Reader(args[0]);

            reader.readFile();
            Parcer parcer = new Parcer(reader);
            for (String toSplit : reader.myFile) {
                buff = parcer.spliter(toSplit);
                fl.add(buff);
                buff.registerTower(weatherTower);
                weatherTower.register(buff);
                toFile.add(parcer.towerSay(toSplit, numOfShips));
                numOfShips++;
            }
            while (reader.simulations > 0) {
                weatherTower.changeWeather();
                reader.simulations--;
            }
            try(FileWriter writer = new FileWriter("simulation.txt", false)){
                for (String toWrite : toFile){
                    writer.write(toWrite);
                    writer.append('\n');
                }
                writer.flush();
                writer.close();
            }
            catch (Exception ex){
                System.out.println("ERROR! Can`t write in file!");
            }
        }
        catch (Exception ex){
            System.out.println("ERROR! Can`t run program!");
        }
    }

}

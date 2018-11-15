package com.student.ekruhliu.MainPackage;

import com.student.ekruhliu.Flyable.AircraftFactory;
import com.student.ekruhliu.Flyable.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {
    Parcer(Reader reader)
    {
        if (checkIteration(reader.myFile.get(0)) == true) {
            try{

                reader.simulations = Integer.valueOf(reader.myFile.get(0));
                reader.myFile.remove(0);
            }
            catch (Exception ex){
                System.out.println("SOSI JOPY!");
            }
        }
        else {
            System.out.println("Invalid number of simulation times!");
            System.exit(1);
        }
        for (int i = 1; i < reader.myFile.size(); i++){
            if (checkStrings(reader.myFile.get(i)) == false){
                System.out.println("Invalid line structure!");
                System.exit(1);
            }
        }
    }

    private boolean checkIteration(String iterStr){
        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(iterStr);
        return m.matches();
    }

    private boolean checkStrings(String str){
        Pattern p = Pattern.compile("^(Baloon|JetPlane|Helicopter)([\\t\\s])(.*)([\\t\\s])([0-9]+)([\\t\\s])([0-9]+)([\\t\\s])([0-9]+)$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public Flyable spliter(String toSplit) {
        ArrayList<String> splited = new ArrayList<String>();
        for (String retval : toSplit.split("\\s+")) {
            splited.add(retval);
        }
        return AircraftFactory.newAircraft(splited.get(0), splited.get(1), Integer.valueOf(splited.get(2)), Integer.valueOf(splited.get(3)), Integer.valueOf(splited.get(4)));
    }

    public void towerSay(String str, int i) {
        ArrayList<String> splited = new ArrayList<String>();
        for (String retval : str.split("\\s+")) {
            splited.add(retval);
        }
        System.out.println("Tower says: " + splited.get(0) + "#" + splited.get(1) + "(" + i + ")" + " registered to weather tower.");
    }
}

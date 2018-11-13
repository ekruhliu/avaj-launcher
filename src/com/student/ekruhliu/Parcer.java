package com.student.ekruhliu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {

    Parcer(Reader reader)
    {
        if (checkIteration(reader.myFile.get(0)) == true) {
            reader.iterations = Integer.valueOf(reader.myFile.get(0));
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

    private static boolean checkIteration(String iterStr){
        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(iterStr);
        return m.matches();
    }

    private static  boolean checkStrings(String str){
        Pattern p = Pattern.compile("^(Baloon|JetPlane|Helicopter)([\\t\\s])(.*)([\\t\\s])([0-9]+)([\\t\\s])([0-9]+)([\\t\\s])([0-9]+)$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    Parcer() {}
}

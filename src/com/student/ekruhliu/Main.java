package com.student.ekruhliu;

import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        try(Scanner scan = new Scanner(new File(args[0])))
        {
            Reader  reader = new Reader(args[0]);

            reader.readFile();
            Parcer  parcer = new Parcer(reader);
            for (String kek : reader.myFile){
                System.out.println(kek);
            }
        }
        catch (IOException ex){
            System.out.println("OOPS");
        }
    }

}

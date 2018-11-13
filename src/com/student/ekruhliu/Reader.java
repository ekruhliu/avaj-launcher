package com.student.ekruhliu;

import java.io.*;
import java.util.ArrayList;

public class Reader {
    protected    String fileName;
    protected    int    iterations;
    protected    ArrayList<String> myFile;


    Reader(String args){
        this.fileName = args;
        this.iterations = 0;
        this.myFile = new ArrayList<String>();
    }

    void readFile(){
        try {
            String            line;
            FileInputStream   fstream = new FileInputStream(this.fileName);
            BufferedReader    buffer = new BufferedReader(new InputStreamReader(fstream));

            while((line = buffer.readLine()) != null) {
                myFile.add(line);
            }
        }
        catch (IOException ex){
            System.out.println("OOPS");
        }
    }

    Reader() {}
}

package com.student.ekruhliu;

import java.util.ArrayList;

public class FlyingObjects {

    protected   String type;
    protected   String name;
    protected   int    longitude;
    protected   int    latitude;
    protected   int    height;
    protected   ArrayList<String> splited;

    FlyingObjects(){
        this.splited = new ArrayList<String>();
    }

    void spliter(Reader reader, int i){
        for (String retval : reader.myFile.get(i).split("\\s+")){
            this.splited.add(retval);
        }
//        for (String kek : this.splited){
//            System.out.println(kek);
//        }

    }
}

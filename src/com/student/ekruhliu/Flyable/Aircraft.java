package com.student.ekruhliu.Flyable;

import com.student.ekruhliu.Flyable.Coordinates;

public class Aircraft {
    protected       long            _id;
    protected       String          _name;
    protected       Coordinates     _coordinates;
    static private  long            _idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates){
        _name = name;
        _coordinates = coordinates;
        _id = nextId();
    }
    private long    nextId() {return ++_idCounter;}
}

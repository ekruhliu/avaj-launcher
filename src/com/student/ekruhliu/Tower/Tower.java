package com.student.ekruhliu.Tower;

import com.student.ekruhliu.Flyable.Flyable;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Tower {
    private CopyOnWriteArrayList<Flyable> observers = new CopyOnWriteArrayList<Flyable>();

    public      void    register(Flyable flyable){ observers.add(flyable); }
    public      void    unregister(Flyable flyable){ observers.remove(flyable); }

    protected   void    conditionsChanged(){
        for (Flyable observ : observers) {
            try {
                observ.updateConditions();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public boolean checkFlyable() {
        return observers.isEmpty();
    }
}

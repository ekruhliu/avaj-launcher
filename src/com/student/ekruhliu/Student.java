package com.student.ekruhliu;

public class Student extends Person {
    private int course;

    public Student(int c, int h, float w) {
        super(h, w);
        this.course = c;
    }
}

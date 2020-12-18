package com.example.springwebapp;

import java.util.Arrays;

public class Student {
    private String name;
    private String lname;
    private int age;
    private int[] mark;

    public Student() {
    }

    public Student(String name, String lname, int age, int[] mark) {
        this.name = name;
        this.lname = lname;
        this.age = age;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getMark() {
        return mark;
    }

    public void setMark(int[] mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", mark=" + Arrays.toString(mark) +
                '}';
    }

    public double mijin() {
        int sum = 0;

        for (int i = 0; i < mark.length; i++) {
            sum = sum + mark[i];
        }
        return (double) sum / mark.length;
    }
}

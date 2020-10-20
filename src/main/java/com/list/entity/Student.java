package com.list.entity;

import java.io.Serializable;

public class Student implements Cloneable, Serializable {

    private String name;
    private int age;
    private Subject subject;
    private  int[] i;
    private  String[] s;
    private  int score;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student s= (Student) super.clone();
        s.setSubject((Subject)this.subject.clone());
        return super.clone();
    }

//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        Object o= super.clone();
//        return o;
//    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int[] getI() {
        return i;
    }

    public void setI(int[] i) {
        this.i = i;
    }

    public String[] getS() {
        return s;
    }

    public void setS(String[] s) {
        this.s = s;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

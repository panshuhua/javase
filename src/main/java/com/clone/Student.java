package com.clone;

public class Student implements Cloneable{
    private String name;
    private int age;
    private Teacher2 teacher2;

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

    public Teacher2 getTeacher2() {
        return teacher2;
    }

    public void setTeacher2(Teacher2 teacher2) {
        this.teacher2 = teacher2;
    }

    //浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

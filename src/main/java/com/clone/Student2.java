package com.clone;

public class Student2 implements Cloneable{
    private String name;
    private int age;
    private Teacher1 teacher1;

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

    public Teacher1 getTeacher1() {
        return teacher1;
    }

    public void setTeacher1(Teacher1 teacher1) {
        this.teacher1 = teacher1;
    }

    //深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //浅拷贝时：
//        Object object=super.clone();
//        return  object;
        //改完深拷贝时：
        Student2 student2= (Student2) super.clone();
        //本来是浅拷贝，现在降Teacher对象复制一份重新set进来-->这样就变成深拷贝了
        student2.setTeacher1((Teacher1) student2.getTeacher1().clone());
        return student2;
    }
}

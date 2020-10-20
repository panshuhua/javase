package com.list.test;

public class IntegerTest {

    public static void main(String[] args) {
         Integer i1=new Integer(100);
         Integer i2=new Integer(100);
         System.out.println(i1.equals(i2)); //true：比较的是Integer的数值
         System.out.println(i1=i2); //100
    }

}

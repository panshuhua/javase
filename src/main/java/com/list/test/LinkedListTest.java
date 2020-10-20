package com.list.test;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        int length=10000;
        LinkedList ll=new LinkedList();

        //循环加入数据
        for (int i=0;i<length;i++){
            ll.add(i);
        }

        //普通for循环
        long start5=System.currentTimeMillis();
        for(int i=0;i<length;i++){
            System.out.print(ll.get(i)+" ");  //随机访问，每次都要遍历，比较耗时
        }
        long end5=System.currentTimeMillis();
        System.out.println();
        System.out.println("for循环遍历访问元素所需时间:"+(end5-start5));

        //迭代器：所有高级语言都提供了迭代器用于遍历->迭代器模式
        long start6=System.currentTimeMillis();
        Iterator it=ll.listIterator(4);
        while (it.hasNext()){
            System.out.print(it.next()+" "); //最多一次遍历
            //ll.remove(2); //在迭代的时候remove元素会报错-fast failed机制
        }
        long end6=System.currentTimeMillis();
        System.out.println();
        System.out.println("迭代器遍历访问元素所需时间:"+(end6-start6));

        //语法糖：for-each
        //for-each其实只是java提供的语法糖。语法糖是编程语言提供的一些便于程序员书写代码的语法，是编译器提供给程序员的糖衣，
        // 编译时会对这些语法特殊处理。语法糖虽然不会带来实质性的改进，但是在提高代码可读性，提高语法严谨性，减少编码错误机会上确实做出了很大贡献

//        增强for循环：for-each
//        增强for循环(也称for each循环)是JDK1.5以后出来的一个高级for循环，专门用来遍历数组和集合的。
//        它的内部原理其实是个Iterator迭代器，所以在遍历的过程中，不能对集合中的元素进行增删操作。
        long start7=System.currentTimeMillis();
        for(Object j:ll){    //for-each遍历时间比普通for循环快，速度跟迭代器差不多，其本质也是迭代器
            System.out.print(j+" ");
        }
        long end7=System.currentTimeMillis();
        System.out.println();
        System.out.println("for-each遍历访问元素所需时间:"+(end7-start7));
    }

}

package com.list.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

    //volatile:可见性-使其他线程也能读取这个变量的值
    private static volatile CopyOnWriteArrayList<String> arrayList=new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        // test2();
        test(); //会出现ArrayIndexOutOfBoundsException
        //1、数据不一致
        //2、List数据量很大   会占用双倍内存
//        Collections.synchronizedList(new ArrayList<>()); //同步list，作用跟vector差不多（相当于加入了synchronized）

        //CopyOnWriteArrayList：写时复制
        //读的时候不需要加锁，如果读的时候有多个线程正在向CopyOnWriteArrayList添加数据，读还是会读到旧的数据，因为写的时候不会锁住旧的CopyOnWriteArrayList

        //写入时复制：
//        写入时复制（CopyOnWrite，简称COW）思想是计算机程序设计领域中的一种优化策略。其核心思想是，如果有多个调用者（Callers）同时要求相同的资源（如内存或者是磁盘上的数据存储），
//        他们会共同获取相同的指针指向相同的资源，直到某个调用者视图修改资源内容时，系统才会真正复制一份专用副本（private copy）给该调用者，而其他调用者所见到的最初的资源仍然保持不变。
//        这过程对其他的调用者都是透明的（transparently）。此做法主要的优点是如果调用者没有修改资源，就不会有副本（private copy）被创建，因此多个调用者只是读取操作时可以共享同一份资源。
    }

    public static void test2()throws InterruptedException{
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");

        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.set(0,"z");
                arrayList.remove(2);
                arrayList.remove(3);
                System.out.println("线程"+arrayList);
            }
        });

        Iterator<String> itr=arrayList.iterator();

        threadOne.start();
        threadOne.join(); //等待线程执行完毕之后，再执行下面的遍历代码
        //如果去除join()：会先执行下面的遍历代码再输出线程[z,b,d]

        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }

    public static  void test1(){
        for(int i=0;i<100;i++){
            arrayList.add("string"+i);
        }

        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+":"+arrayList.get(i));
            arrayList.remove(i);
        }
    }

    public static void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test1();
            }
        }).start();
    }

}

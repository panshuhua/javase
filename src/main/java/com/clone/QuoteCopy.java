package com.clone;

/**
 * 引用拷贝与对象拷贝
 */
public class QuoteCopy {
    /**
     * 引用拷贝
     */
    public void yinyongCopy(){
        Teacher teacher=new Teacher("riemann",28);
        //引用变量拷贝
        Teacher otherTeacher=teacher; //把teacher赋值给Teacher
        System.out.println(teacher);
        System.out.println(otherTeacher);
//        结果分析：由输出结果可以看出，它们的地址值是相同的，那么它们肯定是同一个对象。
//        teacher和otherTeacher的只是引用而已，他们都指向了一个相同的对象Teacher(“riemann”,28)。
//        这就叫做引用拷贝
    }

    /**
     * 对象拷贝
     */
    public void duixiangCopy() throws CloneNotSupportedException {
        Teacher1 teacher1=new Teacher1("riemann",28);
        Teacher1 otherTeacher1= (Teacher1) teacher1.clone();
        System.out.println(teacher1);
        System.out.println(otherTeacher1);
//        结果分析：由输出结果可以看出，它们的地址是不同的，也就是说创建了新的对象， 而不是把原对象的地址赋给了一个新的引用变量,这就叫做对象拷贝。
    }

    //注：深拷贝和浅拷贝都是对象拷贝

    public static void main(String[] args) throws CloneNotSupportedException {
        QuoteCopy quoteCopy=new QuoteCopy();
        quoteCopy.yinyongCopy();
        System.out.println("------------------------------");
        quoteCopy.duixiangCopy();
    }


}

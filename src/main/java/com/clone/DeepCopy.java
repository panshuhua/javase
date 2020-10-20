package com.clone;

/**
 * 深拷贝
 * 定义：
 * 深拷贝是一个整个独立的对象拷贝，深拷贝会拷贝所有的属性,并拷贝属性指向的动态分配的内存。当对象和它所引用的对象一起拷贝时即发生深拷贝。深拷贝相比于浅拷贝速度较慢并且花销较大。
 * 简而言之，深拷贝把要复制的对象所引用的对象都复制了一遍。
 */
public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher1 teacher1=new Teacher1();
        teacher1.setName("riemann");
        teacher1.setAge(28);
        System.out.println("原Teacher1对象："+teacher1);

        Student2 student1=new Student2();
        student1.setName("edgar");
        student1.setAge(18);
        student1.setTeacher1(teacher1);

        Student2 student2= (Student2) student1.clone();
        System.out.println("---------------------拷贝后--------------------");
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getTeacher1().getName());
        System.out.println(student2.getTeacher1().getAge());

        System.out.println("-----------------输出引用--------------------");
        //clone之后，学生对象是2个引用
        System.out.println("student1的引用："+student1);
        System.out.println("student2的引用："+student2);
        //clone之后，学生对象里边设置的教师对象也是两个引用了->深拷贝（因为clone方法重新了，里边的teacher又拷贝了一次，创建了新的Teacher1引用地址跟原来的不一样了）
        System.out.println("student1的teacher引用："+student1.getTeacher1());
        System.out.println("student2的teacher引用："+student2.getTeacher1());

        System.out.println("--------------------修改老师的信息后-------------------");
        //修改老师的信息
        teacher1.setName("jack");
        System.out.println("student1的teacher为："+student1.getTeacher1().getName());
        System.out.println("student2的teacher为："+student2.getTeacher1().getName());
        // 结果分析：
        //两个引用student1和student2指向不同的两个对象，两个引用student1和student2中的两个teacher引用指向的是两个对象，
        // 但对teacher对象的修改只能影响student1对象，不能影响clone出来的student2对象（因为深拷贝的时候，teacher对象也被clone了，创建了新的teacher对象引用，跟原来的不一样了）,所以说是深拷贝。

        //学生信息的修改不会影响其clone的对象，两者是独立的，不受影响
        System.out.println("--------------------修改学生1的信息后-------------------");
        student1.setAge(11);
        System.out.println("student1的age为："+student1.getAge());
        System.out.println("student2的age为："+student2.getAge());
    }

    //结论：深拷贝是属性里边引用的对象也clone，会产生新的属性对象，修改原属性对象不会影响clone对象中的结果
    //线拷贝中引用的属性对象都同一个，不对属性再次拷贝
}


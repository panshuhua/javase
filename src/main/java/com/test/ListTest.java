package com.test;

import com.entity.Student;
import com.entity.Subject;

import java.io.*;
import java.util.*;

public class ListTest {

    ArrayList<Integer> al=new ArrayList<Integer>();
    LinkedList<Integer> ll=new LinkedList<Integer>();

    //往list中添加数据
    void init(int len){
        for(int i=0;i<len;i++){
            al.add(i);
            ll.add(i);
        }
    }

    /**
     * 查询性能对比
     */
    public  void queryEffect(){
        int j=0;
        int len=5000000;
        init(len);
        //下标查找对比：
        long date1=System.currentTimeMillis();
        //普通for循环
        for(int i=0;i<len;i++){
            int a=al.get(i);
            if(a==50000){
                break;
            }
        }
        long date2=System.currentTimeMillis();
        System.out.println("arrayList普通for循环，下标查找耗时："+(date2-date1));

        for(int i=0;i<len;i++){
            int a=ll.get(i);
            if(a==50000){
                break;
            }
        }
        long date3=System.currentTimeMillis();
        System.out.println("linkedList普通for循环，下标查找耗时："+(date3-date2));

        //增强for循环  底层是迭代器
        for(int i:al){
            if(i==50000){
                j=i;
            }
        }
        long date4=System.currentTimeMillis();
        System.out.println("arrayList增强for循环，查找耗时："+(date4-date3));

        for(int i:ll){
            if(i==50000){
                j=i;
            }
        }
        long date5=System.currentTimeMillis();
        System.out.println("linkedList增强for循环，查找耗时："+(date5-date4));

        //迭代器iterator
        Iterator alt=al.iterator();
        while (alt.hasNext()){
            if((Integer) alt.next()==50000){
                j=0;
            }
        }
        long date6=System.currentTimeMillis();
        System.out.println("arrayList迭代器，查找耗时："+(date6-date5));
        Iterator llt=al.iterator();
        while (llt.hasNext()){
            if((Integer)llt.next()==50000){
                j=0;
            }
        }
        long date7=System.currentTimeMillis();
        System.out.println("linkedList迭代器，查找耗时："+(date7-date6));

        //foreach 底层增强for循环实现-lamda表达式
        final int j1=0;
        al.forEach(p->{
            if(p.equals(50000)){
                System.out.println();
            }
        });
        long date8=System.currentTimeMillis();
        System.out.println("arrayList foreach，查找耗时："+(date6-date5));

        ll.forEach(p->{
            if(p.equals(50000)){
                System.out.println();
            }
        });
        long date9=System.currentTimeMillis();
        System.out.println("linkedList foreach，查找耗时："+(date9-date8));
    }

    //查找速度比较输出结果样例如下：
//    arrayList普通for循环，下标查找耗时：3
//    linkedList普通for循环，下标查找耗时：3301
//    arrayList增强for循环，查找耗时：15
//    linkedList增强for循环，查找耗时：73
//    arrayList迭代器，查找耗时：26
//    linkedList迭代器，查找耗时：25
//    arrayList foreach，查找耗时：26
//    linkedList foreach，查找耗时：57

//    由此得出结论：
//    1.在普通for循环中，ArrayList速度比LinkedList快很多
//    2.在增强for循环中，ArrayList速度比LinkedList快
//    3.在迭代器循环中，两者速度差不多
//    4.在foreach循环(lamda表达式)中，ArrayList速度比LinkedList快

    public  void addEffect(){
        //在指定的位置插入数据
        init(10000000);
        long start3=System.currentTimeMillis();
        al.add(1,11);
        long end3=System.currentTimeMillis();
        System.out.println("在指定位置插入数据，使用ArrayList："+(end3-start3));

        long start4=System.currentTimeMillis();
        ll.add(1,11);
        long end4=System.currentTimeMillis();
        System.out.println("在指定位置插入数据，使用LinkedList："+(end4-start4));

        int length=10000000;
        List al=new ArrayList(length);
        List ll=new LinkedList();
        long start5=System.currentTimeMillis();
        for(int i=0;i<length;i++){
            al.add(i);
        }
        long end5=System.currentTimeMillis();
        System.out.println("在for循环中插入数据，使用ArrayList："+(end5-start5));

        long start6=System.currentTimeMillis();
        for(int i=0;i<length;i++){
            ll.add(i);
        }
        long end6=System.currentTimeMillis();
        System.out.println("在for循环中插入数据，使用LinkedList："+(end6-start6));
    }

//    测试结果：
//    在指定位置插入数据，使用ArrayList：4
//    在指定位置插入数据，使用LinkedList：0
//    在for循环中插入数据，使用ArrayList：236
//    在for循环中插入数据，使用LinkedList：755

//    结论：
//    1.在指定位置插入数据，数据量少的情况下，使用ArrayList和LinkedList的速度差不多，在数据量大的情况下，LinkedList的速度比ArrayList的快
//    2.在for循环中插入数据，使用ArrayList的速度比LinkedList快

    /**
     * 插入/删除数据
     */
    public void addOrDelete(){
        ArrayList<String> list=new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3"); //从前往后插入数据
        list.add(1,"4"); //在指定位置插入数据
        System.out.println(list.size());
        System.out.println(list);

        list.remove(2); //在指定位置删除数据
        System.out.println(list);
        list.remove("1");  //删除指定的数据（如果有多个相同的数据，只会删除第一个）
        System.out.println(list);
    }

    /**
     * 深浅拷贝：理解不够透彻，需深入研究 todo
     */
    public void cloneTest() throws CloneNotSupportedException {
        Student old=new Student("韩非",33);
        Subject suOld=new Subject();
        suOld.setMath("11");
        old.setSubject(suOld);

        System.out.println("old math String1:"+old.getSubject().getMath());
        System.out.println("old age int1:"+old.getAge());
        System.out.println("old subject1:"+old.getSubject());

        Student new1= (Student) old.clone();
        old.getSubject().setMath("22");
        old.setAge(20);

        System.out.println("old student:"+old);
        System.out.println("new1 student:"+new1);
        System.out.println("old math String:"+old.getSubject().getMath());
        System.out.println("new1 math String:"+new1.getSubject().getMath());
        System.out.println("old age int:"+old.getAge());
        System.out.println("new1 age int:"+new1.getAge());
        System.out.println("old subject:"+old.getSubject());
        System.out.println("new1 subject:"+new1.getSubject());


    }

    /**
     * 在 subList 中，高度注意对原集合元素个数的修改，
     * 会导致子list的遍历、增加、 删除均会产生ConcurrentModificationException 异常
     */
    public void testSubList(){
        ArrayList<String> list=new ArrayList<>(); //原list
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        List<String> strings=list.subList(0,3); //子list
        list.set(2,"6666"); //原list的set没有影响到元素个数，没影响
        System.out.println(strings.get(0));
        System.out.println(strings);

        //fail-fast 错误检测机制
//        list.add(3,"a"); //原List: add-新增元素
//        System.out.println(strings);
//        System.out.println(strings.get(2));
//        System.out.println(strings);

        list.remove(2); //子List: remove-删除元素
        System.out.println(strings);
        System.out.println(strings.get(2));
    }

    /**
     * 对象序列化
     */
    public void testSerialize() throws IOException, ClassNotFoundException {
        List<Student> list = new ArrayList<>(4);
        list.add(new Student("1",1));
        list.add(new Student("2",2));
        list.add(new Student("3",3));
        list.add(new Student("4",4));
        list.add(new Student("5",5));

        FileOutputStream fs=new FileOutputStream("list.txt");
        ObjectOutputStream os=new ObjectOutputStream(fs);
        os.writeObject(list); //把list写入到对象中
        os.close();

        FileInputStream fi=new FileInputStream("list.txt");
        ObjectInputStream oi=new ObjectInputStream(fi);
        List<Student> box = (List<Student>) oi.readObject();
        oi.close();
        System.out.println(box.get(0).getName());
        System.out.println(box.get(1).getName());
    }

    /**
     * 扩容
     */
    public  void testCopy(){
        ArrayList<String> list1=new ArrayList<>();
        for(int i=0;i<6;i++){
            list1.add(""+i);
        }
        System.out.println(list1);
        list1.add(3,"aaaaaaa");

        List list2=new ArrayList(list1);
        list1.add(0,"ddd");
        System.out.println(list2.get(0));

        List list3= (List) list1.clone();
        list1.set(0,"gggg");  //list3是先前的list1 clone的，现在list1修改不会影响list3
        System.out.println(list3.get(0));

        System.out.println(list1);

     //使用iterator()取出迭代器中的元素之后，就不能再add/remove list1了，会触发fast failed机制，出现ConcurrentModificationException异常
//        Iterator<String> it=list1.iterator();
//        list1.add("bbb");
//        list1.add("ccc");
//        while (it.hasNext()){
//            String str=it.next();
//            System.out.println(str);
//        }

        String[] str=new String[]{"a","b","c"};
        List l= Arrays.asList(str);
        l.set(0,"d");
        System.out.println(l);

        //unmodifiableList：传入一个List实例la，返回这个list的只读视图lb，类型依然是List（返回一个只读list，不允许修改/新增/删除-set/add/remove)
        //如果对unmodifiableList返回的list修改其中的元素，例如set就会触发UnsupportedOperationException异常
        List li=Collections.unmodifiableList(l);
       // li.set(0,"f"); //只读list是不允许被修改，新增或者删除的
       // li.add(1);
        li.remove(2);
        System.out.println(li);

    }

    /**
     * Arrays.asList
     */
    public  void testArrays(){
        //自动拆装箱
       long [] arr=new long[]{11,41,31,31};
       List list=Arrays.asList(arr); //数组转化为list
        //基本类型不支持泛型化  数组不支持向下转型
       System.out.println(list.get(0)); //输出结果是[J@1b6d3586，而不是具体元素，因为数组是一个引用数据类型，而不是基本数据类型

        String [] arr1=new String[] {"1","4","3","3"};
        List list1=Arrays.asList(arr1); //使用Arrays.asList把数组转换为List之后，不能再往list中add或者remove元素了，可以修改某个元素-set
        //list1.add(4); //报错：UnsupportedOperationException
//        list1.remove(1); //报错：UnsupportedOperationException
        System.out.println(list1.size());

       list1.set(0,"11"); //可以修改Arrays.asList中的元素
       System.out.println(Arrays.toString(arr1));

       List list2=Arrays.asList(4,3,3,4,5,6);
       System.out.println(list2.size());
       System.out.println(list2);

       List list3=new ArrayList(Arrays.asList(4,3,3,4,5,6));
       System.out.println(list3.size());
       System.out.println(list3);
    }

    /**
     * 不可变集合
     */
    public void unmofifinable(){
        List list=new ArrayList(Arrays.asList(4,3,3,4,5,6));
        //缓存不可变配置
        List modilist=Collections.unmodifiableList(list); //把一个list转化为只读的
        //modilist.set(0,1);                //unmodify的list只读，不能使用set修改
        //modilist.add(5,1);  //unmodify的list只读，不能使用add新增元素
        //modilist.remove(1); //unmodify的list只读，不能使用remove移除元素
        list.set(0,1); //原list的值可以修改
        System.out.println(modilist.get(0)); //修改了原list的值后，modify的list里边的元素也会随着原list的改变而改变
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        ListTest listTest=new ListTest();
//        listTest.queryEffect();
//        listTest.addEffect();
//        listTest.addOrDelete();
//        listTest.cloneTest();
//        listTest.testSubList();
//        listTest.testSerialize();
//        listTest.testCopy();
//        listTest.testArrays();
        listTest.unmofifinable();
    }

}

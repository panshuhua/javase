package com.queue;

import java.util.*;

/**
 * 优先级队列
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
//        autoSort();
        getKMax();
    }

    /**
     * 自动排序
     */
    public static void autoSort(){
        ArrayList<Integer> list=new ArrayList<>();
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        Random random=new Random();
        for(int i=0;i<7;i++){
            Integer j=new Integer(random.nextInt(100));
            System.out.println("j="+j);
            queue.add(j);
        }
        System.out.println("queue toArray:"+queue.toArray());

        Iterator it=queue.iterator();
        while (it.hasNext()){
            System.out.println("迭代器循环："+it.next());
        }

        int len=queue.size();
        for(int i=0;i<len;i++){
            //把被移除队列的元素加入到list中
            list.add(queue.poll()); //queue.poll()：出列-在队列中移除，poll()方法的返回值是被移出队列的元素
            //queque中remove和poll的区别
            //remove(): 如果队列为空的时候，则会抛出异常
            //poll(): 只会返回null
        }
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("出队后队列的大小："+queue.size());
    }

    /**
     * 取一个乱序数组的第K大的元素，不考虑重复
     * 对比排序算法
     */
    public static void getKMax(){
        int[] arr=new int[]{1,4,2,3,7,5,6,9,6,10};
        PriorityQueue<Integer> queue=new PriorityQueue<>(arr.length);
        for(int num:arr){
            queue.add(num);
            //当queue的大小>k，每次弹出堆顶(出列)的最小元素
            if(queue.size()>7){ //1,2,3最小，会被弹出，剩余7个比较大的元素
                queue.poll();
            }
        }

        Iterator it=queue.iterator();
        while (it.hasNext()){
            System.out.println("迭代器循环："+it.next());
        }
        System.out.println(queue.peek()); //peek()方法：返回队列的头元素
    }


}

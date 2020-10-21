package com.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列
 */
public class DalayQueueTest {
    public static void main(String[] args) {
        DelayQueue<Message> queue=new DelayQueue<>();

        long now=System.currentTimeMillis();
        new Thread(()->{
            while (true){
                try {
                    //将依次打印1000，2000，5000，7000，8000
                    System.out.println(queue.take().deadline - now);//queue.take()移除并返回队列头部的元素，如果队列为空，则阻塞（线程会一直挂在那里不动）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //添加5个元素到队列中
        queue.add(new Message(now+5000));
        queue.add(new Message(now+8000));
        queue.add(new Message(now+2000));
        queue.add(new Message(now+1000));
        queue.add(new Message(now+7000));
    }

}

class Message implements Delayed {
    long deadline;  //延迟时间

    public Message(long deadline) {
        this.deadline = deadline;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return deadline-System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return String.valueOf(deadline);
    }

}

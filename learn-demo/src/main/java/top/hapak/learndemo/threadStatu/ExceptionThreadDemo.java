package top.hapak.learndemo.threadStatu;

import java.util.concurrent.TimeUnit;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class ExceptionThreadDemo {

    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){//默认是false  _interrupted state?

                /*try {
                    TimeUnit.SECONDS.sleep(10); //中断一个处于阻塞状态的线程。join/wait/queue.take..
                    System.out.println("demo");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }*/
            }
            System.out.println("i:"+i);
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt(); //把isInterrupted设置成true

        System.out.println(thread.isInterrupted()); //true
    }
}
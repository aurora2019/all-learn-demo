package top.hapak.learndemo.threadStatu;

import java.util.concurrent.TimeUnit;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class ThreadRestDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
            while(true){
                //System.out.println(Thread.currentThread().isInterrupted());
                if(Thread.currentThread().isInterrupted()){  // 默认是false
                    System.out.println("before:" + Thread.currentThread().isInterrupted());
                    Thread.interrupted(); // 复位-回到初始状态
                    System.out.println("after:"+ Thread.currentThread().isInterrupted());
                }
            }
        },"reset interrupt");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }

}
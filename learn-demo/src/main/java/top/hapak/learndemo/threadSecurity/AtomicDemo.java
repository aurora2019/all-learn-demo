package top.hapak.learndemo.threadSecurity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class AtomicDemo {

    private static AtomicInteger count = new AtomicInteger(0);

    public static void incr(){
            count.incrementAndGet();
            //Thread.sleep(1);

    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            new Thread(()->AtomicDemo.incr()).start();
        }
        Thread.sleep(5000);
        System.out.println(count);
    }
}
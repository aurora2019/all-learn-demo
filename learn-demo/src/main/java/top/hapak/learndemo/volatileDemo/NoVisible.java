package top.hapak.learndemo.volatileDemo;

import java.util.concurrent.TimeUnit;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class NoVisible {
    private volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            int i = 1;
            while(!stop){  // 加入 volatile修饰符，可以及时得到修改值
                i++;
            }
            System.out.println("线程结束");
        });
        thread.start();

        Thread.sleep(1000);
        stop = true;
    }
}
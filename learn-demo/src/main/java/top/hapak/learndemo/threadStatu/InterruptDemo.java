package top.hapak.learndemo.threadStatu;

import java.util.concurrent.TimeUnit;

/**
 * @author aurora
 * @description 技术改变心态 [ˌɪntəˈrʌpt]打断
 */
public class InterruptDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){ // 默认不打断 false
                i++;
            }
            System.out.println("i:"+ i);                 // 中断 输出
        },"interrupt_thread");
        System.out.println("1"+thread.isInterrupted());  // false
        thread.start();
        System.out.println("2"+thread.isInterrupted());  // false
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();                              // true
        while(true){
            System.out.println("3"+thread.isInterrupted());
        }
    }

}
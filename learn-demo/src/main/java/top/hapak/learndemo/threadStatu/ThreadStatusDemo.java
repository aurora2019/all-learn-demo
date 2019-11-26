package top.hapak.learndemo.threadStatu;

import java.util.concurrent.TimeUnit;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class ThreadStatusDemo {

    public static void main(String[] args) {
        new Thread(()->{
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"time-waiting-thread").start();

        new Thread(()->{
            while (true){
                synchronized (ThreadStatusDemo.class){
                    try {
                        // wait方法需要先通过synchronized获得该地址对象的monitor
                        ThreadStatusDemo.class.wait();  // 调用wait()一定要获得锁，才能阻塞，否则报错
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"waiting-thread").start();

        // BLOCKED
        new Thread(new BlockedDemo(), "Blocked01_thread").start();
        new Thread(new BlockedDemo(), "Blocked02_thread").start();
    }

    static class BlockedDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
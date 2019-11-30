package top.hapak.learndemo.wait_notify;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock){
            // 线程a wait() 线程阻塞并且释放线程锁
            System.out.println("start ThreadB");

             lock.notify();

            System.out.println("end ThreadB");
        }
    }
}
package top.hapak.learndemo.wait_notify;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("start ThreadA");
            try {
                lock.wait();  // wait 第一实现线程的阻塞，第二会释放当前锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end ThreadA");
        }
    }
}
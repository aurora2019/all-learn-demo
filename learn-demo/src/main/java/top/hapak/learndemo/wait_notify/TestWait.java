package top.hapak.learndemo.wait_notify;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class TestWait {

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        threadA.start();
        ThreadB threadB = new ThreadB(lock);
        threadB.start();
    }
}
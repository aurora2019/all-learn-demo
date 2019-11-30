package top.hapak.learndemo.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class ReentrantLockDemo {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();  //获得一个锁
        // 通过api来控制锁，增加灵活性
        lock.unlock(); //释放锁
    }
}
package top.hapak.learndemo.ReentrantLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class RWLock {  // 读写锁
    static ReadWriteLock lock = new ReentrantReadWriteLock();

    static Map<String ,Object> cacheMap = new HashMap<>();
    static Lock read = lock.readLock();
    static Lock write = lock.writeLock();

    public static final Object get(String key) {
        System.out.println("begin read data:" + key);
        read.lock();// 获得读锁

        try {
            return cacheMap.get(key);
        } finally {
            read.unlock();
        }
    }

    public static final Object put(String key, Object val){
        write.lock();// 获取了写锁

        try {
            return cacheMap.put(key,val);
        } finally {
            write.unlock();
        }

    }

    public static void main(String[] args) {
        lock.readLock();  //读锁  当有写锁时，保证读取写的内容，会互斥
        lock.writeLock(); // 写锁
        // 读读 可以共享
        // 读写  互斥
        // 写读  互斥
        // 适用于读多写少的场景
    }
}
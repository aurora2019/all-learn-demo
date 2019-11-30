package top.hapak.learndemo.threadSecurity;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class SynDemo {
    public static int i = 0;

    /// test1 和 test2 对象锁
    public synchronized void  test1(){

    }

    public void test2(){
        // 控制粒度
        synchronized (this){
            // 保护存在线程安全的变量

        }
    }

    /// test3 和 test4对象锁
    public synchronized static void test3(){

    }

    public static void test4(){
        synchronized (SynDemo.class){

        }
    }





    public /*synchronized*/ static void incr(){
        synchronized (SynDemo.class){
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j <100000 ; j++) {
            new Thread(()-> SynDemo.incr()).start();
        }

        Thread.sleep(1000);
        System.out.println(i);


        SynDemo synDemo = new SynDemo();
        synDemo.test1();

    }
}
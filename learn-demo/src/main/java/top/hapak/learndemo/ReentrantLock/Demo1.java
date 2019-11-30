package top.hapak.learndemo.ReentrantLock;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class Demo1 {
    public synchronized void  test1(){
        System.out.println("1223");
        test2();
    }

    private void test2() {
        synchronized(this){
            System.out.println("34566");
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.test1();
    }
}
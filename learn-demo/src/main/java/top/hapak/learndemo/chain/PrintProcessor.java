package top.hapak.learndemo.chain;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class PrintProcessor extends Thread implements IProcessor {
    // 链式阻塞队列
    private LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private volatile boolean isFinish = true;

    private IProcessor nextProcessor;

    public PrintProcessor(){

    }

    public PrintProcessor(IProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void shutdown(){
        isFinish = false;
    }

    @Override
    public void run() {
        while(isFinish){
            try {
                Request request = requests.take();
                System.out.println(request);
                nextProcessor.process(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public void process(Request request) {
        requests.add(request);
    }
}
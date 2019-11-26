package top.hapak.learndemo.chain;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class SaveProcessor extends Thread implements IProcessor {
    // 链式阻塞队列
    private LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private IProcessor nextProcessor;

    private volatile boolean isFinish= true;

    public SaveProcessor(){

    }

    public SaveProcessor(IProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void shutdown(){
        isFinish = false;
    }

    @Override
    public void process(Request request) {
        requests.add(request);
    }

    @Override
    public void run() {
        while(isFinish){
            try {
                Request request = requests.take();
                System.out.println(request);
                if(nextProcessor != null){
                    nextProcessor.process(request);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
package top.hapak.learndemo.chain;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class PrevProcessor extends Thread implements IProcessor {
    // 阻塞队列
    private LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    private volatile boolean isFinish = true;

    private IProcessor nextProcessor;

    public PrevProcessor(){

    }

    public PrevProcessor(IProcessor nextProcessor){
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
        while (isFinish) {
            // TODO
            try {
                Request request = requests.take();
                System.out.println(request);
                nextProcessor.process(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
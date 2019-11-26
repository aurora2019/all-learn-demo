package top.hapak.learndemo.chain;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class TestApp {

    static PrevProcessor prevProcessor = null;

    public void start(){
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        PrintProcessor printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
        prevProcessor = new PrevProcessor(printProcessor);
        prevProcessor.start();
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName( args.length ==0 ? "1" :args[0]);

        TestApp app = new TestApp();
        app.start();
        prevProcessor.process(request);
    }
}
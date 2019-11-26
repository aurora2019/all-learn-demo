package top.hapak.learndemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnDemoApplication {

    @Value("${server.port")
    Integer httpPort;

    public static void main(String[] args) {
        println(System.getProperty("user"));

        SpringApplication.run(LearnDemoApplication.class, args);
    }

    private static void println(Object o) {
        System.out.println(o);
    }
}

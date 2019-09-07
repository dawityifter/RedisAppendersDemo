package com.dawityifter.sleuth.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //Comment the below lines if you are using stand alone redis server.
    private RedisServer redisServer;

    public DemoApplication() {
        try {
            this.redisServer = new RedisServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void postConstruct() {
        redisServer.start();
    }

    @PreDestroy
    public void preDestroy() {
        redisServer.stop();
    }
    // End of Embedded server setup.
}

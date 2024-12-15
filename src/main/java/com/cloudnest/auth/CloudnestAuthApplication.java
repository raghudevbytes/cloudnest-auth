package com.cloudnest.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.cloudnest.*")
@SpringBootApplication
public class CloudnestAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudnestAuthApplication.class, args);
    }

}

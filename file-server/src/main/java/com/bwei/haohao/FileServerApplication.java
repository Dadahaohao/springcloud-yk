package com.bwei.haohao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FileServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileServerApplication.class);
    }
}

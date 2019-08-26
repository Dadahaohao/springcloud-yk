package com.bwei.haohao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.swing.*;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FoodFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodFeignApplication.class);
    }
}

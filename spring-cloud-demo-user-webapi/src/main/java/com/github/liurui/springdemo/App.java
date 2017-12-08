package com.github.liurui.springdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
public class App {
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(App.class).run(args);
    }
}
package com.github.liurui.springdemo.user.controllers;

import com.github.liurui.springdemo.user.User;
import com.github.liurui.springdemo.user.UserApi;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;


@RestController
@RefreshScope
public class UserController implements UserApi {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Value("${name}")
    String name;

    @Autowired
    Environment environment;

    @Override
    public User info(@PathVariable long id) {
        User user = new User(id, "刘锐 " + id);
        LOGGER.error("user:{}  sleep:{} name:{} name:{}", user.toString(), -1, name, environment.getProperty("name"));
        return user;
    }

    @Override
    public String login(@RequestParam String name, @RequestParam String password) {
        String ret = String.format("name:%s password:%s sleep:%d  name:%s name:%s", name, password, -1, name, environment.getProperty("name"));
        LOGGER.error(ret);
        return ret;
    }

    private long sleep() {
        int sleep = ThreadLocalRandom.current().nextInt(3000);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sleep;
    }
}

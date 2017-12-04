package com.github.liurui.springdemo;


import com.github.liurui.springdemo.news.controllers.NewsController;
import io.swagger.annotations.Api;
import org.junit.Test;

public class AppTest
{
    @Test
    public void test(){
        Class<NewsController> c = NewsController.class;

        System.out.println(c.isAnnotationPresent(Api.class));
    }
}

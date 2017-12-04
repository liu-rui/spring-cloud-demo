package com.github.liurui.springdemo.news.controllers;

import com.github.liurui.springdemo.news.repositories.UserApiRepository;
import com.github.liurui.springdemo.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"新闻"}, description = "新闻基本操作")
@RequestMapping("/news")
public class NewsController {
    public static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    UserApiRepository userApiRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ApiParam(name = "userId", value = "用户编码", required = true)
                         @RequestParam
                                 long userId,
                         @RequestBody
                         @ApiParam(name = "news", value = "新闻", required = true)
                                 String news) {
        User user = userApiRepository.info(userId);
        String login = userApiRepository.login("sd", "sdd");

        return String.format("user:%s login:%s news:%s", user, login, news);
    }
}

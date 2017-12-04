package com.github.liurui.springdemo.news.repositories;

import com.github.liurui.springdemo.user.UserApi;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;


@Repository
@FeignClient(value = "user-v1", fallback = UserApiRepositoryFallback.class)
public interface UserApiRepository extends UserApi {
}
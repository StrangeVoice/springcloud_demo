package com.hx.customorder.feign;

import com.hx.FeignConfig;
import com.hx.customorder.model.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROVIDER-USER",configuration = FeignConfig.class)//请求服务名称
public interface FeignInterface2 {

    @RequestLine("GET /user/{id}")//组合注解，第一个参数是请求方式，第二个是请求参数，用空格分隔
    User getUser(@Param("id") Integer id);//使用@RequestLine的时候必须使用@Param代替@PathVariable

    @RequestLine("GET /getUser")
    User callbackUser(User user);
}




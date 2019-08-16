package com.hx.customorder.feign;

import com.hx.customorder.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("PROVIDER-USER")//请求服务名称
public interface FeignInterface {

    //相当于生产者的方法请求路径
    // 参数需要@PathVariable、@RequestBody、@RequestParam等注解
    // @RequestParam后面需要加上参数名
    @GetMapping("/user/{id}")
    User getUser(@PathVariable Integer id);

    @GetMapping(value = "/getUser")
    User callbackUser( User user);
}




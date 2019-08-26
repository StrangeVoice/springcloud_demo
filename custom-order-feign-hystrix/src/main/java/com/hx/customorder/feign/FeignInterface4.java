package com.hx.customorder.feign;

import com.hx.FeignConfig;
import com.hx.customorder.model.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROVIDER-USER",configuration = FeignConfig.class,fallback = FeignInterfacehystrix.class)//请求服务名称
public interface FeignInterface4 {
    @GetMapping("/user/{id}")
    User getUser(@PathVariable Integer id);

    @GetMapping(value = "/getUser")
    User callbackUser( User user);
}




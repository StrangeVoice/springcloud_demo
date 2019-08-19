package com.hx.customorder.feign;

import com.hx.FeignConfig;
import com.hx.customorder.model.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "sda",url = "http://localhost:8082/",configuration = FeignConfig.class)//请求服务名称
public interface FeignInterface3 {

    @RequestMapping("/eureka/apps/{serviceName}")
    String getServiceInfo(@PathVariable String serviceName);

}




package com.hx.customorder.controller;

import com.hx.customorder.feign.FeignInterface;
import com.hx.customorder.feign.FeignInterface2;
import com.hx.customorder.feign.FeignInterface3;
import com.hx.customorder.model.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

//    @Autowired
//    private FeignInterface feignInterface;
//
//    @GetMapping("/order/{id}")
//    public User getOrder(@PathVariable Integer id){
//        User user = feignInterface.getUser(id);
//        return user;
//    }
//
//    @GetMapping("/callback")
//    public User callbackOrder(@RequestBody User user){
//        return feignInterface.callbackUser(user);
//    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("PROVIDER-USER");//查找对应服务的实例，通过负载均衡算法返回一个实例

        return serviceInstance.getServiceId()+"-"+serviceInstance.getHost()+"-"+serviceInstance.getPort();
    }

//    @Autowired
//    private FeignInterface2 feignInterface2;
//
//    @GetMapping("/order2/{id}")
//    public User getOrder2(@PathVariable Integer id){
//        User user = feignInterface2.getUser(id);
//        return user;
//    }
//
//    @PostMapping("/callback2")
//    public User callbackOrder2(@RequestBody User user){
//        return feignInterface2.callbackUser(user);
//    }

    @Autowired
    private FeignInterface3 feignInterface3;

    @RequestMapping("/serviceInfo/{name}")
    public String getServiceInfo(@PathVariable String name){
        return feignInterface3.getServiceInfo(name);
    }


}

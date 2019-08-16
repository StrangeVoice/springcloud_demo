package com.hx.customorder.controller;

import com.hx.customorder.model.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private EurekaClient eurekaClient;

    private String url = "http://localhost:8080/user/";

    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable Integer id){

//        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
//        String homePageUrl = instance.getHomePageUrl();
        User user = restTemplate.getForObject("http://PROVIDER-USER/user/" + id, User.class);
        return user;
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("PROVIDER-USER");//查找对应服务的实例，通过负载均衡算法返回一个实例

        return serviceInstance.getServiceId()+"-"+serviceInstance.getHost()+"-"+serviceInstance.getPort();
    }
}

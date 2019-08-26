package com.hx.provideruser.controller;

import com.hx.provideruser.model.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User(id);
    }

    @PostMapping("/getUser")
    public User callbackUser(@RequestBody User user){
        return user;
    }

    @GetMapping("/eurekaInfo")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }
}

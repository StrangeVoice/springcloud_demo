package com.hx.customorder.feign;

import com.hx.customorder.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FeignInterfacehystrix implements FeignInterface4 {
    @Override
    public User getUser(Integer id) {
        User user = new User();
        user.setId(-100);
        user.setDate(new Date());
        return user;
    }

    @Override
    public User callbackUser(User user) {
        return null;
    }
}

package com.hx.customorder.feign;

import com.hx.customorder.model.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FeignInterfaceFallbackfactory implements FallbackFactory<FeignInterface4> {

    @Override
    public FeignInterface4 create(Throwable throwable) {
        return new FeignInterface4() {
            @Override
            public User getUser(Integer id) {
                User user = new User();
                user.setId(-200);
                user.setDate(new Date());
                return user;
            }

            @Override
            public User callbackUser(User user) {
                return null;
            }
        };
    }

}

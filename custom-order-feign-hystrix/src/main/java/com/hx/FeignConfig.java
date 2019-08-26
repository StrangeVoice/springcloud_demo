package com.hx;

import feign.Contract;
import feign.Logger;
import feign.Retryer;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class FeignConfig {

    /**
     * 用于创建用户名和密码的对象
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","123");
    }

    /**
     * 配置要输出的日志是哪些，必须在debug模式下才可以输出
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * Feign默认重试机制
     * @return
     */
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default();
    }

}

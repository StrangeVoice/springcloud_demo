package com.hx;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class MyPreZuulFilter extends ZuulFilter {
    /**
     * 类型包含 pre post route error
     * pre 代表在路由代理之前执行
     * route 代表代理的时候执行
     * error 代表出错的时候执行
     * post 代表在route 或者是 error 执行完成后执行
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter 是一个链式调用的，一个 filter 会调用下面的一个 filter
     * javaee 中是根据 filter 的配置先后顺序来决定
     * zuul 是根据 order 决定，越小的越先执行
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否使用这个过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器执行方法
     */
    @Override
    public Object run() throws ZuulException {
        System.err.println("执行过滤器");
        return null;
    }
}

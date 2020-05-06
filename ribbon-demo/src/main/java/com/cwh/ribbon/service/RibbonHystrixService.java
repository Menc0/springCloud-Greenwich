package com.cwh.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ______
 * _________      ____  /_
 * _  ___/_ | /| / /_  __ \
 * / /__ __ |/ |/ /_  / / /
 * \___/ ____/|__/ /_/ /_/
 */
@Service
public class RibbonHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     *
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public String index(String name) {
        String result = restTemplate.getForObject("http://server-demo/index?name=" + name, String.class);
        System.out.println(result);
        return result;
    }

    /**
     * hystrix fallback方法
     *
     * @return 默认返回数据
     */
    public String fallback(String name) {
        String result = "异常发生，进入fallback方法，接收的参数：name = " + name;
        System.out.println(result);
        return result;
    }
}

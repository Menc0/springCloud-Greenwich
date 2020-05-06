package com.cwh.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ______
 * _________      ____  /_
 * _  ___/_ | /| / /_  __ \
 * / /__ __ |/ |/ /_  / / /
 * \___/ ____/|__/ /_/ /_/
 */
@FeignClient(name = "server-demo", fallback = FeignInteface.HystrixClientFallback.class)//对应生产者服务名
public interface FeignInteface {
    @RequestMapping(value = "index", method = RequestMethod.GET)
    String index(@RequestParam String name);

    @Component
    class HystrixClientFallback implements FeignInteface {

        @Override
        public String index(String name) {
            String result = "from feign，异常发生，进入fallback方法，接收的参数：name = " + name;
            System.out.println(result);
            return result;
        }

    }
}

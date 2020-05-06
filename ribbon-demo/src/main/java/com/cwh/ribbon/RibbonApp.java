package com.cwh.ribbon;

import com.cwh.ribbon.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ______
 * _________      ____  /_
 * _  ___/_ | /| / /_  __ \
 * / /__ __ |/ |/ /_  / / /
 * \___/ ____/|__/ /_/ /_/
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient 与@EnableEurekaClient差不多，
            // 只不过EnableEurekaClient是基于spring-cloud-netflix，如果选用其他注册中心比如consul则选用EnableDiscoveryClient
@EnableCircuitBreaker//熔断器开启
@RestController
public class RibbonApp {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApp.class,args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Autowired
    RibbonHystrixService ribbonHystrixService;
    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return "ribbon:"+this.ribbonHystrixService.index(name);
    }
}

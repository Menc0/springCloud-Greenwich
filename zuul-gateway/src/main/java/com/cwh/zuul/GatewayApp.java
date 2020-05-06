package com.cwh.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ______
 * _________      ____  /_
 * _  ___/_ | /| / /_  __ \
 * / /__ __ |/ |/ /_  / / /
 * \___/ ____/|__/ /_/ /_/
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }
}

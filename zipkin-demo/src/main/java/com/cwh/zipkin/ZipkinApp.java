package com.cwh.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ______
 * _________      ____  /_
 * _  ___/_ | /| / /_  __ \
 * / /__ __ |/ |/ /_  / / /
 * \___/ ____/|__/ /_/ /_/
 */
@SpringBootApplication
@RestController
public class ZipkinApp {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApp.class,args);
    }
    @RequestMapping("hi")
    public String hi(){
        return "hi";
    }
}

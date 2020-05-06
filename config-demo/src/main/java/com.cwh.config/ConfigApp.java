package com.cwh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ______
 * _________      ____  /_
 * _  ___/_ | /| / /_  __ \
 * / /__ __ |/ |/ /_  / / /
 * \___/ ____/|__/ /_/ /_/
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp.class,args);
    }
}

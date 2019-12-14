package com.zhayujie.kit.springbootkit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootKitApplication {

    public static void main(String[] args) {
        log.info("Hello kit!");
        SpringApplication.run(SpringBootKitApplication.class, args);
    }
}

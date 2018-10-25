package com.imooc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
//// hystrix
//@EnableCircuitBreaker
@SpringCloudApplication
// 此版本该注解不可用
// @EnableHystrixDashboard
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}

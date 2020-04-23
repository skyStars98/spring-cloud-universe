package com.universe.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/29
 * @Time: 11:11 下午
 * @Version: spring-cloud-universe 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix //开启Hystrix断路器 这里也可以使用@EnableCircuitBreaker 两者皆可
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}

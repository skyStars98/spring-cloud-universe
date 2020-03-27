package com.universe.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/27
 * @Time: 10:58 下午
 * @Version: spring-cloud-universe 1.0
 */
@SpringBootApplication
@EnableFeignClients //开启 feign注解（开启feign客户端）
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}

package com.universe.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/22
 * @Time: 11:32 上午
 * @Version: spring-cloud-universe 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient //开启consul客户端用于向consul server注册服务
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class, args);
    }
}

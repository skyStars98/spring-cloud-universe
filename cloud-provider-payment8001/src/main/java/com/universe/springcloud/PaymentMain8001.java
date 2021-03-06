package com.universe.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/15
 * @Time: 9:37 下午
 * @Version: spring-cloud-universe 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //开启服务发现 获取eureka中微服务的信息
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}

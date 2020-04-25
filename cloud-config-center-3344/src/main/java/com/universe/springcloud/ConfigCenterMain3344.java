package com.universe.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: daiguoqing
 * @Date: 2020/4/25
 * @Time: 9:36 下午
 * @Version: spring-cloud-universe 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer //开启config配置中心服务端
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}

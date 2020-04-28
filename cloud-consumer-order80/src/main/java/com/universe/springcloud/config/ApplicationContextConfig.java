package com.universe.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/16
 * @Time: 11:28 下午
 * @Version: spring-cloud-universe 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //开启负载均衡 赋予restTemplate负载均衡的能力 如果某个服务为集群状态，不加入负载均衡会报错。因为eureka会返回多个ip，服务不知道调用那个
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

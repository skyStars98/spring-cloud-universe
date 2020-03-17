package com.universe.springcloud.config;

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
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

package com.universe.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/29
 * @Time: 12:33 上午
 * @Version: spring-cloud-universe 1.0
 */
@Configuration
public class FeignConfig {

    //配置feign日志打印（展示feign相关的调用信息）
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}

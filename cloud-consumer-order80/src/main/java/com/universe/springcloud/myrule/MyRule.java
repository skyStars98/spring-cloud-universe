package com.universe.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/25
 * @Time: 12:14 上午
 * @Version: spring-cloud-universe 1.0
 */
@Configuration
public class MyRule {

    @Bean
    public IRule customBalance(){
        return new RandomRule(); //负载均衡 随机访问规则
    }
}

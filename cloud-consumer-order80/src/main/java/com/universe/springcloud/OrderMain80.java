package com.universe.springcloud;

import com.universe.springcloud.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/15
 * @Time: 11:46 下午
 * @Version: spring-cloud-universe 1.0
 */
@SpringBootApplication
@ComponentScan(excludeFilters = { //排除指定包的扫描，自定义负载均衡的配置类不能放在@ComponentScan扫描到的地方，否则所有ribbon客户端都会共享，达不到特殊定制化的目的
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyRule.class)
})
//@RibbonClient(name = "cloud-payment-service", configuration = MyRule.class) //访问指定微服务时，使用自定义负载均衡策略
@EnableEurekaClient
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}

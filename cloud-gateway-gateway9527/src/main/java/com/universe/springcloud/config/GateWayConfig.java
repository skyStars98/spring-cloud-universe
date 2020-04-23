package com.universe.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: daiguoqing
 * @Date: 2020/4/12
 * @Time: 9:32 下午
 * @Version: spring-cloud-universe 1.0
 */
@Configuration
public class GateWayConfig {

    //编码的方式 实现网关路由
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_baidu",
                r -> r.path("/guonei").uri("http://www.baidu.com")).build();
        return routes.build();
    }
}

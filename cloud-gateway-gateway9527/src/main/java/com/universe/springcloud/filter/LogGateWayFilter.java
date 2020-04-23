package com.universe.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: daiguoqing
 * @Date: 2020/4/19
 * @Time: 4:44 下午
 * @Version: spring-cloud-universe 1.0
 */
@Component
@Slf4j
public class LogGateWayFilter implements GlobalFilter, Ordered {

    /**
     * @desc ServerWebExchange是一个HTTP请求-响应交互的契约。
     *       提供对HTTP请求和响应的访问，并公开额外的 服务器 端处理相关属性和特性，如请求属性。
     *       ServerWebExchange 命名为 服务网络交换器 ，存放着重要的请求-响应属性、请求实例和响应实例等等，有点像 Context 的角色。（可以理解为context上下文）
     *       GatewayFilterChain过滤器链，当前过滤器可以决定是否执行下一个过滤器的逻辑，由 GatewayFilterChain.filter() 来决定是否调用。
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("******come in LogGateWayFilter：{}", LocalDateTime.now());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if(Objects.isNull(username)){
            log.info("用户名为null，非法用户");
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }

    //定义Spring IOC容器中Bean执行顺序的优先级，数字越小优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}

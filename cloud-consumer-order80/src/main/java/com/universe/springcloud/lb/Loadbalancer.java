package com.universe.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/25
 * @Time: 10:26 下午
 * @Version: spring-cloud-universe 1.0
 */
public interface Loadbalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstance);
}

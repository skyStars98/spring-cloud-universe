package com.universe.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/25
 * @Time: 10:34 下午
 * @Version: spring-cloud-universe 1.0
 */
@Component
@Slf4j
public class MyLB implements Loadbalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        for(;;){
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1; //Integer.MAX_VALUE 2147483647
            if(atomicInteger.compareAndSet(current, next)){
                log.info("访问次数：{}", next);
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstance) {
        int index = getAndIncrement() % serviceInstance.size();
        return serviceInstance.get(index);
    }
}

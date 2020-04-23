package com.universe.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.universe.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/29
 * @Time: 9:27 下午
 * @Version: spring-cloud-universe 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Long id) {
        return String.format("线程池：%s paymentInfo_OK，id：%d", Thread.currentThread().getName(), id);
    }

    /**
     * @HystrixProperty 指定线程超时时间，value为超时时间（毫秒）
     *                  也可以理解为调用此方法的超时时间，超过value指定的时间，或者自身出现异常触发降级
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "3000")
    })
    public String paymentInfo_Timeout(Long id) {
        //int age = 10 / 0;
        Integer timeNumber = 2;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("线程池：%s paymentInfo_Timeout，id：%d 耗时：%d", Thread.currentThread().getName(), id,  3);
    }

    public String paymentInfo_TimeoutHandler(Long id){
        return String.format("线程池：%s  系统繁忙，请稍后再试，id：%d", Thread.currentThread().getName(), id);
    }

    //服务熔断
    //@desc 一定时间范围内（这里为10秒） 一定次数的请求下（这里是10次）失败率达到多少（这里是60%）就熔断服务，拒绝访问 在一定时间过后（这里是5秒）尝试半开放（允许请求访问）如果可以承受就恢复调用，否则继续熔断
    @Override
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED, value = "true"), //是否开启熔断机制
            @HystrixProperty(name = HystrixPropertiesManager.METRICS_ROLLING_STATS_TIME_IN_MILLISECONDS, value = "10000"), //请求时间范围
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"), //请求次数
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5000"), //断路器进入半熔断状态的时间
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "60") //失败率达到多少后熔断
    }, fallbackMethod = "paymentCircuitBreaker_fallback")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return String.format("%s 调用成功，流水号：%s", Thread.currentThread().getName(), serialNumber);
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return String.format("id 不能负数，请稍后再试，o(╥﹏╥)o id：%d", id);
    }
}

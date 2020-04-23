package com.universe.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.universe.springcloud.feign.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.hystrix.HystrixProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/29
 * @Time: 11:18 下午
 * @Version: spring-cloud-universe 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") //全局服务降级配置，如果@HystrixCommand中指定了fallbackMethod则使用自身的，如果没有则使用defaultFallback
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id){
        return orderHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "1500")
    },fallbackMethod = "paymentTimeoutFallbackMethod")*/
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Long id){
        return orderHystrixService.paymentInfo_Timeout(id);
    }

    public String paymentTimeoutFallbackMethod(@PathVariable("id") Long id){
        return "支付系统繁忙请10秒钟后重试";
    }

    public String payment_Global_FallbackMethod(){
        return "全局服务降级方法，支付系统繁忙请10秒钟后重试";
    }
}

package com.universe.springcloud.controller;

import com.universe.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/29
 * @Time: 9:40 下午
 * @Version: spring-cloud-universe 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentServiceImpl;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id) {
        String result = paymentServiceImpl.paymentInfo_OK(id);
        log.info("result：{}", result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Long id) {
        String result = paymentServiceImpl.paymentInfo_Timeout(id);
        log.info("result：{}", result);
        return result;
    }

    // 服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentServiceImpl.paymentCircuitBreaker(id);
        log.info("result: {}", result);
        return result;
    }
}

package com.universe.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/22
 * @Time: 11:35 上午
 * @Version: spring-cloud-universe 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return String.format("springcloud with consul：%s %s", serverPort, UUID.randomUUID().toString());
    }
}

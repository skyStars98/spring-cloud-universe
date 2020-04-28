package com.universe.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: daiguoqing
 * @Date: 2020/4/28
 * @Time: 9:35 下午
 * @Version: spring-cloud-universe 1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Long id){
        return String.format("nacos registry，serverPort：%s id %d", serverPort, id);
    }
}

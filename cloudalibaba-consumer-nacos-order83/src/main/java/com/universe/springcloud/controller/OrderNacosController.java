package com.universe.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: daiguoqing
 * @Date: 2020/4/28
 * @Time: 10:25 下午
 * @Version: spring-cloud-universe 1.0
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    private static final String SERVER_URL = "http://nacos-payment-provider";

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(SERVER_URL + "/payment/nacos/" + id, String.class);
    }
}

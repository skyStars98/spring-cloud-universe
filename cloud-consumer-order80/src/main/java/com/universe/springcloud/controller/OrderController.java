package com.universe.springcloud.controller;

import com.universe.springcloud.entity.Payment;
import com.universe.springcloud.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/15
 * @Time: 11:50 下午
 * @Version: spring-cloud-universe 1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://localhost:8001";

    @GetMapping("/consumer/payment/get/{id}")
    public ResponseResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ResponseResult.class);
    }
}

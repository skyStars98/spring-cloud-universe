package com.universe.springcloud.controller;

import com.universe.springcloud.entity.Payment;
import com.universe.springcloud.response.ResponseResult;
import com.universe.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/27
 * @Time: 11:20 下午
 * @Version: spring-cloud-universe 1.0
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public ResponseResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
}

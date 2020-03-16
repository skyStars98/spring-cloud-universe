package com.universe.springcloud.controller;

import com.universe.springcloud.entity.Payment;
import com.universe.springcloud.response.ResponseResult;
import com.universe.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/15
 * @Time: 11:15 下午
 * @Version: spring-cloud-universe 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentServiceImpl;

    @PostMapping("/payment/create")
    public ResponseResult<Integer> save(Payment payment){
        Integer result = paymentServiceImpl.save(payment);
        log.info("插入结果：{}", result);
        return ResponseResult.success(result);
    }

    @GetMapping("/payment/get/{id}")
    public ResponseResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentServiceImpl.getPaymentById(id);
        log.info("查询结果：{}", payment);
        return ResponseResult.success(payment);
    }
}

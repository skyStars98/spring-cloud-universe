package com.universe.springcloud.service;

import com.universe.springcloud.entity.Payment;
import com.universe.springcloud.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/27
 * @Time: 11:03 下午
 * @Version: spring-cloud-universe 1.0
 */
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    ResponseResult<Payment> getPaymentById(@PathVariable("id") Long id);
}

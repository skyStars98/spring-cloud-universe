package com.universe.springcloud.service;

import com.universe.springcloud.entity.Payment;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/15
 * @Time: 11:11 下午
 * @Version: spring-cloud-universe 1.0
 */
public interface PaymentService {

    Integer save(Payment payment);

    Payment getPaymentById(Long id);

}

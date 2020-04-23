package com.universe.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/29
 * @Time: 9:24 下午
 * @Version: spring-cloud-universe 1.0
 */
public interface PaymentService {

    String paymentInfo_OK(Long id);

    String paymentInfo_Timeout(Long id);

    String paymentCircuitBreaker(Integer id);
}

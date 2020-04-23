package com.universe.springcloud.feign;

import com.universe.springcloud.fallback.OrderFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/29
 * @Time: 11:14 下午
 * @Version: spring-cloud-universe 1.0
 */
@FeignClient(value = "cloud-provider-hystrix-payment", fallback = OrderFallbackService.class)
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Long id);
}

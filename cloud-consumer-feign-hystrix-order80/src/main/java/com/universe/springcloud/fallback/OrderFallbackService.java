package com.universe.springcloud.fallback;

import com.universe.springcloud.feign.OrderHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author: daiguoqing
 * @Date: 2020/4/1
 * @Time: 10:07 下午
 * @Version: spring-cloud-universe 1.0
 */
@Component
public class OrderFallbackService implements OrderHystrixService {

    @Override
    public String paymentInfo_OK(Long id) {
        return "OrderFallbackService fall back -paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Long id) {
        return "OrderFallbackService fall back -paymentInfo_Timeout";
    }
}

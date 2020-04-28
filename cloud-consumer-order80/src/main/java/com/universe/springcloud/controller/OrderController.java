package com.universe.springcloud.controller;

import com.universe.springcloud.entity.Payment;
import com.universe.springcloud.lb.Loadbalancer;
import com.universe.springcloud.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private Loadbalancer loadbalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @GetMapping("/consumer/payment/get/{id}")
    public ResponseResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ResponseResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public ResponseResult<Payment> getPayment(@PathVariable("id") Long id){
        ResponseEntity<ResponseResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, ResponseResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return ResponseResult.fail();
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        if(CollectionUtils.isEmpty(instances)){
            return null;
        }
        ServiceInstance serviceInstance = loadbalancer.instances(instances);
        log.info("调用地址：{}", serviceInstance.getUri() + "/payment/lb");
        return restTemplate.getForObject(serviceInstance.getUri() + "/payment/lb", String.class);
    }

    //zipkin + sleuth
    @GetMapping("/consumer/payment/zipkin")
    @SuppressWarnings("SpellCheckingInspection")
    public String paymentzipkin(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
        return result;
    }
}

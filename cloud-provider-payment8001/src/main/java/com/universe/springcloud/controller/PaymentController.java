package com.universe.springcloud.controller;

import com.universe.springcloud.entity.Payment;
import com.universe.springcloud.response.ResponseResult;
import com.universe.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient; //对于注册进eureka中的服务，可以通过服务发现获取他们的信息

    @PostMapping("/payment/create")
    public ResponseResult<Integer> save(Payment payment){
        Integer result = paymentServiceImpl.save(payment);
        log.info("插入结果：{}", result);
        return ResponseResult.success(result);
    }

    @GetMapping("/payment/get/{id}")
    public ResponseResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentServiceImpl.getPaymentById(id);
        log.info("端口号为：{}, 查询结果：{}", serverPort, payment);
        return ResponseResult.success("查询成功，端口号：" + serverPort, payment);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获取eureka所有注册好的微服务名称
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("Microservice-Name：{}", service);
        }
        //根据微服务名称获取某个微服务下所有实例的信息（集群）
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("服务id：{}, 服务ip：{}, 服务端口：{}, 服务访问地址：{}",
                    instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi i'am paymentzipkin server fall back, welcome to universe";
    }
}

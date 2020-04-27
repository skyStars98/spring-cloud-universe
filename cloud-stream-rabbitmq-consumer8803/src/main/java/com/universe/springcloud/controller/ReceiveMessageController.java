package com.universe.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


/**
 * @Author: daiguoqing
 * @Date: 2020/4/27
 * @Time: 9:07 下午
 * @Version: spring-cloud-universe 1.0
 */
@Component
@EnableBinding(Sink.class) //用于指定一个或多个定义了@Input和@Output注解的接口，以此实现对消息通道(Channel)的绑定。Sink.class：输入绑定  Source.class：输出绑定
@Slf4j
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    //@StreamListener能将被修饰的方法注册为消息中间件上数据流的监听器，属性值对应了监听的通道名。
    // @StreamListener内置了一系列消息转换功能,将消息转换成具体对象
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者1号------>收到的消息：{} 端口号：{}", message.getPayload(), serverPort);
    }
}

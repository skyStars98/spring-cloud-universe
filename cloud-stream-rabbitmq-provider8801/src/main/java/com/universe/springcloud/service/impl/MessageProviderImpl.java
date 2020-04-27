package com.universe.springcloud.service.impl;

import com.universe.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author: daiguoqing
 * @Date: 2020/4/27
 * @Time: 11:29
 * @Version: spring-cloud-universe 1.0
 */
@EnableBinding(Source.class) //用于指定一个或多个定义了@Input和@Output注解的接口，以此实现对消息通道(Channel)的绑定。Sink.class：输入绑定  Source.class：输出绑定
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; //消息发送通道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info(serial);
        return null;
    }

}

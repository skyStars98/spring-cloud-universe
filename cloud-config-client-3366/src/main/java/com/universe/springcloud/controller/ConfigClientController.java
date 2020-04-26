package com.universe.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: daiguoqing
 * @Date: 2020/4/26
 * @Time: 9:39 下午
 * @Version: spring-cloud-universe 1.0
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return String.format("serverPort：%s configInfo：%s", serverPort, configInfo);
    }
}

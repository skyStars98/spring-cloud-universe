package com.universe.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: daiguoqing
 * @Date: 2020/4/25
 * @Time: 11:08 下午
 * @Version: spring-cloud-universe 1.0
 */
@RestController
@RefreshScope //手动刷新配置 还需要发一个post请求
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}

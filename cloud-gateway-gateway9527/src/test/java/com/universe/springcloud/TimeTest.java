package com.universe.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

/**
 * @Author: daiguoqing
 * @Date: 2020/4/13
 * @Time: 9:22 下午
 * @Version: spring-cloud-universe 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeTest {

    @Test
    public void test(){
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
    }
}

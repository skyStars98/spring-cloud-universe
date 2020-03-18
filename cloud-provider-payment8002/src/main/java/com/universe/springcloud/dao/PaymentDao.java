package com.universe.springcloud.dao;

import com.universe.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/15
 * @Time: 10:47 下午
 * @Version: spring-cloud-universe 1.0
 */
@Mapper
public interface PaymentDao {

    Integer save(Payment payment);

    Payment getPaymentById(Long id);


}

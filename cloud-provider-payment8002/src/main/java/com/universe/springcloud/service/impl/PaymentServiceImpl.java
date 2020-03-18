package com.universe.springcloud.service.impl;

import com.universe.springcloud.dao.PaymentDao;
import com.universe.springcloud.entity.Payment;
import com.universe.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: daiguoqing
 * @Date: 2020/3/15
 * @Time: 11:12 下午
 * @Version: spring-cloud-universe 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Integer save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

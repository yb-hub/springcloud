package com.yb.demo.dao;

import com.yb.demo.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int insertPayment(@Param("payment") Payment payment);
    Payment queryPaymentById(Long id);
}


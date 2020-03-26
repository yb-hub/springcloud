package com.yb.demo.dao;

import com.yb.demo.entity.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * @author yb
 * @description
 * @data 2020/3/25
 */
@Mapper
public interface PaymentDao {
    int insertPayment(@Param("payment") Payment payment);
    Payment queryPaymentById(Long id);
}

package com.yb.demo.service;

import com.yb.demo.entity.Payment;

public interface PaymentService {
    int insertPayment(Payment payment);
    Payment queryPaymentById(Long id);
}

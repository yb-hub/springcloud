package com.yb.demo.service;

import com.yb.demo.common.CommonResult;
import com.yb.demo.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.TimeUnit;

/**
 * @author yb
 * @description
 * @data 2020/4/1
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-SERVICE")
public interface PaymentService {
    @PostMapping("/payment/insert")
    CommonResult insertPayment(@RequestBody Payment payment);
    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}

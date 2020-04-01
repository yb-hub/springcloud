package com.yb.demo.service;

import com.yb.demo.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yb
 * @description
 * @data 2020/4/1
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX8003")
public interface PaymentService {
    @GetMapping("/payment/hystrix/success/{id}")
    CommonResult paymentSuccess(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/fail/{id}")
    CommonResult paymentFail(@PathVariable("id") Integer id);
}

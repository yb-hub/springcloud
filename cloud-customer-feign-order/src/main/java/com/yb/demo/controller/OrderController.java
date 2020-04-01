package com.yb.demo.controller;

import com.yb.demo.common.CommonResult;
import com.yb.demo.entity.Payment;
import com.yb.demo.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private PaymentService paymentService;
    @GetMapping("/customer/payment/insert")
    public CommonResult insertPayment(@RequestBody Payment payment){
        paymentService.insertPayment(payment);
        return new CommonResult(200,"8001:success");
    }

    @GetMapping("/customer/payment/timeout")
    public CommonResult paymentTimeout(){
        return new CommonResult(200,paymentService.paymentFeignTimeout());
    }
}

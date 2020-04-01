package com.yb.demo.controller;

import com.yb.demo.common.CommonResult;
import com.yb.demo.entity.Payment;
import com.yb.demo.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author yb
 * @description
 * @data 2020/3/25
 */
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/insert")
    public CommonResult insertPayment(@RequestBody Payment payment){
        //paymentService.insertPayment(payment);
        return new CommonResult(200,"8001:success");
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "8001:FeignTimeout";
    }
}

package com.yb.demo.controller;

import com.yb.demo.common.CommonResult;
import com.yb.demo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yb
 * @description
 * @data 2020/3/30
 */
@RestController
@Slf4j
public class PaymentController {
    @PostMapping("/payment/insert")
    public CommonResult insertPayment(){
        //paymentService.insertPayment(payment);
        log.debug("payment_consul");
        return new CommonResult(200,"success");
    }
}

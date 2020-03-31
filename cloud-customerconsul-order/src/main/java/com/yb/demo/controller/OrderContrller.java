package com.yb.demo.controller;

import com.yb.demo.common.CommonResult;
import com.yb.demo.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yb
 * @description
 * @data 2020/3/26
 */
@RestController
public class OrderContrller {

    @Autowired
    private RestTemplate restTemplate;

    //public static  final  String PAYMENT_URL = "http://localhost:8001/payment/insert";
    public static final String PAYMENT_URL = "http://paymentconsul8003"+"/payment/insert";
    @GetMapping("/customer/payment/insert")
    public CommonResult insert(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL,payment,CommonResult.class);
    }
//    @GetMapping("/health")
//    public String healhTest(){
//        return "success";
//    }
}

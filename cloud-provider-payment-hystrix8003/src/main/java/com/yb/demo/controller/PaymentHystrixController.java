package com.yb.demo.controller;

import com.yb.demo.common.CommonResult;
import com.yb.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yb
 * @description
 * @data 2020/4/1
 */
@RestController
@Slf4j
public class PaymentHystrixController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;
    @GetMapping("/payment/hystrix/success/{id}")
    public CommonResult paymentSuccess(@PathVariable("id") Integer id){
        log.info(serverPort+":"+"success"+id);
        paymentService.success(id);
        return new CommonResult(200,serverPort+":"+"success"+id);
    }

    @GetMapping("/payment/hystrix/fail/{id}")
    public CommonResult paymentFail(@PathVariable("id") Integer id){
        log.info(serverPort+":"+"fail"+id);
        String result = paymentService.fail(id);
        return new CommonResult(200,serverPort+":"+result);
    }
}

package com.yb.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yb.demo.common.CommonResult;
import com.yb.demo.service.PaymentGlobalService;
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
    private PaymentGlobalService paymentGlobalService;
    @GetMapping("/payment/hystrix/success/{id}")
    public CommonResult paymentSuccess(@PathVariable("id") Integer id){
        log.info(serverPort+":"+"success"+id);
        paymentGlobalService.success(id);
        return new CommonResult(200,serverPort+":"+"success"+id);
    }

    @GetMapping("/payment/hystrix/fail/{id}")
    public CommonResult paymentFail(@PathVariable("id") Integer id){
        log.info(serverPort+":"+"fail"+id);
        String result = paymentGlobalService.fail(id);
        return new CommonResult(200,"fail:"+serverPort+":"+result);
    }

    @GetMapping("/payment/hystrix/fail2/{id}")
    public CommonResult paymentFail2(@PathVariable("id") Integer id){
        log.info(serverPort+":"+"fail2"+id);
        String result = paymentGlobalService.fail2(id);
        return new CommonResult(200,"fail2:"+serverPort+":"+result);
    }
}

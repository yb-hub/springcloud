package com.yb.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yb.demo.common.CommonResult;
import com.yb.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
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
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/customer/hystrix/success/{id}")
    public CommonResult customerSuccess(@PathVariable("id") Integer id){
        paymentService.paymentSuccess(id);
        log.debug("customer:success"+id);
        return new CommonResult(200,"customer:success"+id);
    }

    @GetMapping("/customer/hystrix/fail/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public CommonResult customerFail(@PathVariable("id") Integer id){
        CommonResult commonResult = paymentService.paymentFail(id);
        log.info("customer:fail"+id);
        return commonResult;
    }

    @GetMapping("/customer/hystrix/fail2/{id}")
    public CommonResult customerFail2(@PathVariable("id") Integer id){
        CommonResult commonResult = paymentService.paymentFail2(id);
        log.info("customer:fail2"+id);
        return commonResult;
    }
    public CommonResult customerFailFallback(@PathVariable("id") Integer id){
        return new CommonResult(200,"/(ㄒoㄒ)/~~"+"customer:fail"+id);
    }
}

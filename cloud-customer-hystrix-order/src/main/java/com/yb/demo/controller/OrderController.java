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
    @HystrixCommand(fallbackMethod = "customerFailFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public CommonResult customerFail(@PathVariable("id") Integer id){
        paymentService.paymentFail(id);
        log.debug("customer:fail"+id);
        return new CommonResult(200,"customer:fail"+id);
    }
    public CommonResult customerFailFallback(@PathVariable("id") Integer id){
        return new CommonResult(200,"/(ㄒoㄒ)/~~"+"customer:fail"+id);
    }
}

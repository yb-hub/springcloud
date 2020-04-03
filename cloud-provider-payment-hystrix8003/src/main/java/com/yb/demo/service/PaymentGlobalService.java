package com.yb.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import sun.awt.SunHints;

import java.util.concurrent.TimeUnit;

/**
 * @author yb
 * @description
 * @data 2020/4/2
 */
@Service
//@DefaultProperties(defaultFallback = "defaultFallback")
public class PaymentGlobalService {
    public String success(Integer id) {
        return "success:"+id;
    }

    //@HystrixCommand(fallbackMethod = "defaultFallback")
    public String fail(Integer id) {
        //int i =10/0;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "paymentGlobalService:"+id;
    }
    //@HystrixCommand(fallbackMethod = "defaultFallback")
    public String fail2(Integer id){
        int i = 10/0;
        return "paymentGlobalService:"+id;
    }
    public String defaultFallback(Integer id){
        return "/(ㄒoㄒ)/~~"+"defaultFallback:"+id;
    }
}

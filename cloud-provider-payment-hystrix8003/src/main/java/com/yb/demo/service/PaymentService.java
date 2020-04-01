package com.yb.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yb
 * @description
 * @data 2020/4/1
 */
@Service
public class PaymentService {
    public String success(Integer id) {
        return "success:"+id;
    }

    @HystrixCommand(fallbackMethod = "failFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String fail(Integer id) {
        //int i =10/0;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "fail:"+id;
    }
    public String failFallback(Integer id){
        return "/(ㄒoㄒ)/~~"+"failFallback:"+id;
    }
}

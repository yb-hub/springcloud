package com.yb.demo;

import com.yb.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yb
 * @description
 * @data 2020/4/1
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClient(name="CLOUD-PROVIDER-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}

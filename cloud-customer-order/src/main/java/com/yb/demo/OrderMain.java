package com.yb.demo;

import com.yb.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author yb
 * @description
 * @data 2020/3/26
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="CLOUD-PROVIDER-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class);
    }
}

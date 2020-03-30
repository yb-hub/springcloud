package com.yb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author yb
 * @description
 * @data 2020/3/30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8003.class,args);
    }
}

package com.yb.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yb
 * @description 测试控制器
 * @data 2020/4/2
 */
@RestController
public class TestController {
    @GetMapping("/payment/insert")
    public String test(){
        return "test1";
    }
    @GetMapping("/test")
    public String test2(){
        return "test2";
    }

    @GetMapping("/myzuul/test")
    public String test3(){
        return "test3";
    }
}

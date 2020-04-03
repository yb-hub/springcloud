package com.yb.demo.service;

import com.yb.demo.common.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author yb
 * @description
 * @data 2020/4/2
 */

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult paymentSuccess(Integer id) {
        return new CommonResult(200,"paymentFallbackService:success");
    }

    @Override
    public CommonResult paymentFail(Integer id) {
        return new CommonResult(200,"paymentFallbackService:fail");
    }

    @Override
    public CommonResult paymentFail2(Integer id) {
        return new CommonResult(200,"paymentFallbackService:fail2");
    }
}

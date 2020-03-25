package com.yb.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yb
 * @description 统一返回类
 * @data 2020/3/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;
    public CommonResult(int code,String message){
        this.code = code;
        this.message = message;
    }
}

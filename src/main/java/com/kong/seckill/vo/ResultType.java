package com.kong.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * @author shijiu
 * 枚举
 */
@Getter
@AllArgsConstructor
@ToString
public enum ResultType {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务端异常"),
    BIND_ERROR(504,"参数校验异常");
    private final Integer code;
    private final String message;

}

package com.kong.seckill.exception;

import com.kong.seckill.vo.Result;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/**
 * @author shijiu
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result ExceptionHandler(GlobalException e){
        if(e instanceof GlobalException){
            GlobalException exception = (GlobalException) e;
            return Result.fail(exception);
        }
        return Result.fail("服务器异常");
    }

}

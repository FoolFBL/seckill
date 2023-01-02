package com.kong.seckill.vo;

import javafx.beans.binding.ObjectExpression;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shijiu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code;
    private String message;
    private Object obj;

    public static Result success(String msg){
        return new Result(200,msg,null);
    }
    public static Result success(String msg,Object obj){
        return new Result(200,msg,obj);
    }
    public static Result success(){
        return new Result(ResultType.SUCCESS.getCode(),ResultType.SUCCESS.getMessage(),null);
    }
    public static Result success(Object obj){
        return new Result(ResultType.SUCCESS.getCode(),ResultType.SUCCESS.getMessage(),obj);
    }
    public static Result fail(){
        return new Result(ResultType.ERROR.getCode(),ResultType.ERROR.getMessage(),null);
    }
    public static Result fail(Object obj){
        return new Result(ResultType.ERROR.getCode(),ResultType.ERROR.getMessage(),obj);
    }
    public static Result fail(String msg){
        return new Result(404,msg,null);
    }


}

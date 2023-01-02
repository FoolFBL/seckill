package com.kong.seckill.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shijiu
 * 他想写个类验证手机号 利用lamda表达式
 */
/**
 * @author 47roro
 * @create 2022/4/3
 * @description: 手机号码校验
 */
public class ValidatorUtill {
    private static final Pattern mobile_pattern = Pattern.compile("[1]([3-9])[0-9]{9}$");

    public static boolean isMobile(String mobile){
        if(!StringUtils.hasLength(mobile)){
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(mobile);
        return matcher.matches();
    }
}

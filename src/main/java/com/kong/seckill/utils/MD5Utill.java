package com.kong.seckill.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.DispatcherServlet;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author shijiu
 */
public class MD5Utill {

    public static String md5(String src){
        return DigestUtils.md5DigestAsHex(src.getBytes(StandardCharsets.UTF_8));
    }

    public static final String salt = "1a2b3c4d";
    //第一层加密 是在前端加密数据
    public static String inputPassToFromPass(String inputPass){
        String str = salt.charAt(2)+inputPass+salt.charAt(3);
        return md5(str);
    }

    //生成随机字符串
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    //第二次加密 服务端第一次加密
    public static String formPassToDBPass(String formPass,String salt){
        String str = salt.charAt(0)+salt.charAt(2)+formPass;
        return md5(str);
    }

    //第二次加密 服务端第二次加密 把salty存入数据库中
    public static String inputPassToDBPass(String inputPass,String salt){
        String formPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(formPass, salt);
//        String salty = UUID.randomUUID().toString().replaceAll("-","").substring(0,5);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println("前端加密后的密码"+inputPassToFromPass("123456"));
        System.out.println("后端加密后的密码"+formPassToDBPass(inputPassToFromPass("123456"),salt));
        System.out.println("存入数据库的密码"+inputPassToDBPass("123456",salt));
    }

}

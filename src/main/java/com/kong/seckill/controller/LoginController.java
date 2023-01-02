package com.kong.seckill.controller;

import com.kong.seckill.service.UserService;
import com.kong.seckill.vo.LoginVo;
import com.kong.seckill.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shijiu
 */
@Controller
@CrossOrigin
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/doLogin")
    @ResponseBody
    public Result doLogin( LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        log.info("{}",loginVo);
        return userService.doLogin(loginVo,request,response);
    }

}

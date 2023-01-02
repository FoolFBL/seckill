package com.kong.seckill.controller;


import com.alibaba.fastjson.JSON;
import com.kong.seckill.mapper.UserMapper;
import com.kong.seckill.pojo.User;
import com.kong.seckill.utils.MD5Utill;
import com.kong.seckill.utils.UserUtil;
import com.kong.seckill.vo.LoginVo;
import com.kong.seckill.vo.Result;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kong
 * @since 2022-12-19
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/info")
    //查看个人信息
    @ResponseBody
    public Result info(User user){
        return Result.success(user);
    }


}


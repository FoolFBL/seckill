package com.kong.seckill.service;

import com.kong.seckill.exception.GlobalException;
import com.kong.seckill.mapper.UserMapper;
import com.kong.seckill.pojo.User;
import com.kong.seckill.utils.CookieUtils;
import com.kong.seckill.utils.MD5Utill;
import com.kong.seckill.utils.UUIDUtil;
import com.kong.seckill.vo.LoginVo;
import com.kong.seckill.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shijiu
 */
@Service
public class UserService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserMapper userMapper;
    public Result doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        String mobilePhone = loginVo.getMobilePhone();
        String formPassword = loginVo.getPassword();
        //参数校验
        if(StringUtils.isEmpty(mobilePhone)||StringUtils.isEmpty(formPassword)){
            return Result.fail("登录失败 账号或密码为空");
        }
        //前端收到的数据
        //从数据库中根据手机号取出密码
        User user = userMapper.selectUserById(loginVo.getMobilePhone());
        //用MD5工具类加密前端传入的密码 与数据库中密码做比较
        System.out.println("数据库中密码"+user.getPassword());
        String password = MD5Utill.formPassToDBPass(loginVo.getPassword(), user.getSalt());
        System.out.println("前端二次加密后的密码"+password);
        if(!password.equals(user.getPassword())){
            return Result.fail("验证密码失败");
        }

        boolean[] booleans = new boolean[1];

        //生成cookie
        String ticket = UUIDUtil.uuid();
//        request.getSession().setAttribute(ticket,user);
        redisTemplate.opsForValue().set("user:"+ticket,user);
        System.out.println(redisTemplate.opsForValue().get("user:"+ticket));
        CookieUtils.setCookie(request,response,"userTicket",ticket);
        return Result.success("登录成功！",ticket);
    }

    //根据cookie获取用户
    public User getUserByCookie(String ticket){
        if(StringUtils.isEmpty(ticket)){
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + ticket);
        return user;
    }
}

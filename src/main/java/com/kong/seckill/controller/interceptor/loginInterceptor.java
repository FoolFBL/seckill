package com.kong.seckill.controller.interceptor;

import com.kong.seckill.pojo.User;
import com.kong.seckill.utils.CookieUtils;
import com.kong.seckill.utils.HostHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shijiu
 * 拦截器 访问controller之前 拦截 验证是否登录
 */
@Component
public class loginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private HostHolder hostHolder;
    //访问controller之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userTicket = CookieUtils.getCookieValue(request, "userTicket");
        if(StringUtils.isEmpty(userTicket)){
            response.sendRedirect("/login/toLogin");
            return false;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        hostHolder.setUsers(user);
        if(user==null){
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();
    }
}


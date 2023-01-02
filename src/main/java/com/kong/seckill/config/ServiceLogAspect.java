package com.kong.seckill.config;

import com.kong.seckill.pojo.User;
import com.kong.seckill.utils.HostHolder;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class ServiceLogAspect {

    @Autowired
    private HostHolder hostHolder;
    private static final Logger logger =  LoggerFactory.getLogger(ServiceLogAspect.class);
    @Pointcut("execution(* com.kong.seckill.controller.*.*(..))")
    public void pointcut(){
    }
    @SneakyThrows
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) throws IOException {
        //用户某某某 在 什么时间 访问了什么功能
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String ip = request.getRemoteHost();
        User user = hostHolder.getUser();
        String username = user.getNickname();
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String target = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        String log = String.format("用户[%s],ip地址为[%s],在[%s],访问了[%s]接口.", username, ip, now, target);
        logger.info(log);
        String path = "E:\\log\\data.txt";
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path,true)));
        out.write(log+"\r\n");
        out.close();
    }
}
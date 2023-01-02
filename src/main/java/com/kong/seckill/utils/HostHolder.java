package com.kong.seckill.utils;

import com.kong.seckill.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author shijiu
 * 持有用户的信息 用来代替session对象
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();
    public void setUsers(User user)
    {
        users.set(user);
    }
    public User getUser(){
        return users.get();
    }
    public void clear(){
        users.remove();
    }
}
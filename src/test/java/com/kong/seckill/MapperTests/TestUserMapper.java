package com.kong.seckill.MapperTests;
import com.alibaba.fastjson.JSON;
import com.kong.seckill.mapper.UserMapper;
import com.kong.seckill.pojo.User;
import com.kong.seckill.utils.MD5Utill;
import com.kong.seckill.utils.UserUtil;
import com.kong.seckill.vo.LoginVo;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
/**
 * @author shijiu
 */
@SpringBootTest
public class TestUserMapper {
    @Autowired
    private UserMapper userMapper;

//    @Test
//    public void testselectUserById() {
////        User user = userMapper.selectAll();
////        System.out.println(user);
////        User user = userMapper.selectUserById("15771964258");
////        System.out.println(user);
////        List<User> user = UserUtil.createUser(1);
//        for (int i = 0; i < user.size(); i++) {
//            userMapper.insertUser(user.get(i));
//            // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
//            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//            // 创建Post请求
//            HttpPost httpPost = new HttpPost("http://localhost:8080/login/doLogin");
//
//            LoginVo loginVo = new LoginVo();
//            Long id = user.get(i).getId();
//            String mobliephone = String.valueOf(id);
//            loginVo.setMobilePhone(mobliephone);
//            loginVo.setPassword(MD5Utill.inputPassToDBPass("123456",user.get(i).getSalt()));
//            // 我这里利用阿里的fastjson，将Object转换为json字符串;
//            // (需要导入com.alibaba.fastjson.JSON包)
//            String jsonString = JSON.toJSONString(loginVo);
//
//            StringEntity entity = new StringEntity(jsonString, "UTF-8");
//
//            // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
//            httpPost.setEntity(entity);
//
//            httpPost.setHeader("Content-Type", "application/json;charset=utf8");
//
//            // 响应模型
//            CloseableHttpResponse response = null;
//            try {
//                // 由客户端执行(发送)Post请求
//                response = httpClient.execute(httpPost);
//                // 从响应模型中获取响应实体
//                HttpEntity responseEntity = response.getEntity();
//
//                System.out.println("响应状态为:" + response.getStatusLine());
//                Header[] allHeaders = response.getAllHeaders();
//                for (Header allHeader : allHeaders) {
//                    System.out.println("header:"+allHeader);
//                }
//                Header[] headers = response.getHeaders("Set-Cookie");
//                for (Header header : headers) {
//                    System.out.println("cookie"+header);
//                }
//            } catch (ClientProtocolException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    // 释放资源
//                    if (httpClient != null) {
//                        httpClient.close();
//                    }
//                    if (response != null) {
//                        response.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
////        userMapper.insertUser(user);
//    }

}

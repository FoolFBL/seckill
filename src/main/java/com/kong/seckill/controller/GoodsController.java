package com.kong.seckill.controller;

import com.kong.seckill.pojo.User;
import com.kong.seckill.service.GoodsService;
import com.kong.seckill.service.UserService;
import com.kong.seckill.utils.HostHolder;
import com.kong.seckill.vo.GoodsVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shijiu
 */
@CrossOrigin
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    //页面缓存
    @RequestMapping(value = "/toList" ,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String toList(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String goodsListHtml = (String) valueOperations.get("goodsList");
        if(!StringUtils.isEmpty(goodsListHtml)){
            return goodsListHtml;
        }
        User user = hostHolder.getUser();
        System.out.println("user-----"+user);
        if(user==null){
            return "login";
        }
        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        //如果为空 手动渲染 存入Redis中
        WebContext webContext = new WebContext(request,response,request.getServletContext(),request.getLocale(),model.asMap());
        goodsListHtml=thymeleafViewResolver.getTemplateEngine().process("goodsList",webContext);
        if(!StringUtils.isEmpty(goodsListHtml)){
            System.out.println(goodsListHtml);
            valueOperations.set("goodsList",goodsListHtml,60, TimeUnit.SECONDS);
        }
        //        return "ok";
//       return "goodsList";
        return goodsListHtml;
    }

    //商品详情页
    @RequestMapping(value = "/toDetail/{goodsId}",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String toDetail(Model model,@PathVariable int goodsId,@CookieValue("userTicket")String ticket,HttpServletRequest request, HttpServletResponse response){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String html  = (String) valueOperations.get("goodsDetail:" + goodsId);
        if(!StringUtils.isEmpty(html)){
           return html;
        }
        model.addAttribute("user",userService.getUserByCookie(ticket));
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startTime = goods.getStartTime();
        Date endTime = goods.getEndTime();
        Date date = new Date();
        //秒杀状态
        int secKillStatus = 0;
        //秒杀倒计时
        int remainSeconds = 0;
        //秒杀还未开始
        if(date.before(startTime)){
            remainSeconds = (int) ((startTime.getTime()-date.getTime())/1000);
        }else if(date.after(endTime)){
            secKillStatus = 2;
            remainSeconds = -1;
        }else{
            secKillStatus=1;
        }
        model.addAttribute("remainSeconds",remainSeconds);
        model.addAttribute("secKillStatus",secKillStatus);
        model.addAttribute("goods",goods);
        WebContext webContext = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        html = thymeleafViewResolver.getTemplateEngine().process("goodsDetail", webContext);
        if(!StringUtils.isEmpty(html)){
            valueOperations.set("goodsDetail:"+goodsId,html,60,TimeUnit.SECONDS);

        }
        return html;
    }



}

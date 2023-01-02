package com.kong.seckill.controller;

import com.kong.seckill.pojo.Order;
import com.kong.seckill.pojo.SeckillOrder;
import com.kong.seckill.pojo.User;
import com.kong.seckill.service.GoodsService;
import com.kong.seckill.service.OrderService;
import com.kong.seckill.service.SeckillGoodsService;
import com.kong.seckill.service.SeckillOrderService;
import com.kong.seckill.utils.HostHolder;
import com.kong.seckill.vo.GoodsVo;
import com.kong.seckill.vo.Result;
import com.kong.seckill.vo.SeckillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shijiu
 */
@Controller
@RequestMapping("/secKill")
public class SecKillController {
    @Autowired
    private HostHolder hostHolder;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SeckillOrderService seckillOrderService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private SeckillGoodsService seckillGoodsService;

    @RequestMapping("/doSecKill")
    public String doSeckill(Model model, int goodsId){
        User user = hostHolder.getUser();
        model.addAttribute("user",user);
        //秒杀库存表里查啊 为什么要分成两张表 什么时候分库分表呢
        //1.秒杀库存表中根据商品编号查询商品 判断商品库存是否充足
        SeckillGoodsVo good = seckillGoodsService.findGoodsVoByGoodsId(goodsId);
        if(good.getStockCount()<1){
            model.addAttribute("errmsg", Result.fail("商品已经售完 请您下次再来"));
            return "secKillFail";
        }
        //2.秒杀订单表中根据用户id查询订单 判断该用户是否已经秒杀过该物品
        //判断订单 一个人只能抢一件相同物品
        try{
            SeckillOrder judgeOrder = seckillOrderService.findOrderByUserId(user.getId(), good.getId());
            if(judgeOrder!=null){
                model.addAttribute("errmsg",Result.fail("您已经秒杀成功 每人只能秒杀一件"));
                return "secKillFail";
            }
        }catch (Exception e){

        }
        //3.需要在秒杀订单表和订单表中插入数据 并且应该在商品表和秒杀商品表中更新库
        //应该启动事务管理
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        Order order = orderService.save(goods);
        model.addAttribute("goods",goods);
        model.addAttribute("order",order);
        return "orderDetail";
    }

}

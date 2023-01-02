package com.kong.seckill.service;


import com.kong.seckill.mapper.OrderMapper;
import com.kong.seckill.mapper.SeckillOrderMapper;
import com.kong.seckill.pojo.Order;
import com.kong.seckill.pojo.SeckillOrder;
import com.kong.seckill.pojo.User;
import com.kong.seckill.utils.HostHolder;
import com.kong.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kong
 * @since 2022-12-22
 */
@Service
public class OrderService  {

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private HostHolder hostHolder;
    @Autowired
    private SeckillGoodsService seckillGoodsService;

    public Order save(GoodsVo goods){
        //3.需要在秒杀订单表和订单表中插入数据
        User user = hostHolder.getUser();
        //插入order表中
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setOrderChannel(1);
        order.setDeliveryAddrId(123L);
        order.setGoodsCount(1);
        order.setGoodsName(goods.getGoodsName());
        order.setGoodsId(goods.getId());
        order.setGoodsPrice(goods.getGoodsPrice());
        order.setStatus(1);
        order.setPayDate(new Date());
        order.setUserId(user.getId());
        orderMapper.insertOrder(order);
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setGoodsId(goods.getId());
        seckillOrder.setUserId(user.getId());
        seckillOrderMapper.insSeckillOrder(seckillOrder);
        // 并且应该在商品表和秒杀商品表中更新库
        seckillGoodsService.decrementGoods(goods.getId());
        goodsService.decrementGoods(goods.getId());
        return order;
    }


}

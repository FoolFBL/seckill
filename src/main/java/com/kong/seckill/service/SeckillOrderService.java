package com.kong.seckill.service;


import com.kong.seckill.mapper.SeckillOrderMapper;
import com.kong.seckill.pojo.SeckillOrder;
import com.kong.seckill.pojo.User;
import com.kong.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kong
 * @since 2022-12-22
 */
@Service
public class SeckillOrderService  {
    @Autowired
    private SeckillOrderMapper orderMapper;

    public SeckillOrder findOrderByUserId(Long userId,int goodId){
        return orderMapper.selectOrderByUserId(userId,goodId);
    }

    public void save(GoodsVo goods){
        SeckillOrder seckillOrder = new SeckillOrder();

    }
}

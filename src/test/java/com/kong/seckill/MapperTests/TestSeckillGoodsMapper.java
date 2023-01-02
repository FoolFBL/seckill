package com.kong.seckill.MapperTests;

import com.kong.seckill.mapper.SeckillGoodsMapper;
import com.kong.seckill.pojo.SeckillOrder;
import com.kong.seckill.service.SeckillOrderService;
import com.kong.seckill.vo.GoodsVo;
import com.kong.seckill.vo.SeckillGoodsVo;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shijiu
 */
@SpringBootTest
public class TestSeckillGoodsMapper {
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Autowired
    private SeckillOrderService seckillOrderService;
    @Test
    public void test(){
        SeckillGoodsVo goodsVo = seckillGoodsMapper.selectGoodsByUserId(1);
        System.out.println(goodsVo);
        SeckillOrder orderByUserId = seckillOrderService.findOrderByUserId(15771964258L,1);
        System.out.println(orderByUserId);
    }


}

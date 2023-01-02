package com.kong.seckill.service;


import com.kong.seckill.mapper.SeckillGoodsMapper;
import com.kong.seckill.mapper.SeckillOrderMapper;
import com.kong.seckill.pojo.SeckillGoods;
import com.kong.seckill.vo.GoodsVo;
import com.kong.seckill.vo.SeckillGoodsVo;
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
public class SeckillGoodsService   {
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;
    public SeckillGoodsVo findGoodsVoByGoodsId(long goodsId){
        return seckillGoodsMapper.selectGoodsByUserId(goodsId);
    }
    public void decrementGoods(long goodsId){
        seckillGoodsMapper.decreGoods(goodsId);
    }



}

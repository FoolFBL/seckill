package com.kong.seckill.service;

import com.kong.seckill.mapper.GoodsMapper;
import com.kong.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kong
 * @since 2022-12-22
 */
@Service
public class GoodsService  {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<GoodsVo> findGoodsVo(){

        return goodsMapper.selectGoodsVo();
    }

    public GoodsVo findGoodsVoByGoodsId(int goodsId){
        return goodsMapper.selectGoodsVoById(goodsId);
    }

    public void decrementGoods(Long goodsId){
        goodsMapper.decrementGoods(goodsId);
    }

}

package com.kong.seckill.mapper;


import com.kong.seckill.pojo.SeckillGoods;
import com.kong.seckill.vo.GoodsVo;
import com.kong.seckill.vo.SeckillGoodsVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kong
 * @since 2022-12-22
 */
@Mapper
public interface SeckillGoodsMapper  {
    SeckillGoodsVo selectGoodsByUserId(long goodsId);
    void decreGoods(long goodsId);
}

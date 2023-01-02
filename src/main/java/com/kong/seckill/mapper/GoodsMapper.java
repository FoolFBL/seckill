package com.kong.seckill.mapper;

import com.kong.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kong
 * @since 2022-12-22
 */
@Mapper
public interface GoodsMapper  {
    List<GoodsVo> selectGoodsVo();
    GoodsVo selectGoodsVoById(int goodsId);
    int decrementGoods(Long goodsId);
}

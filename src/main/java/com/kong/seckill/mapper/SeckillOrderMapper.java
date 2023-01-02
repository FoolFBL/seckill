package com.kong.seckill.mapper;

import com.kong.seckill.pojo.SeckillOrder;
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
public interface SeckillOrderMapper {
    SeckillOrder selectOrderByUserId(Long userId,int goodId);
    void insSeckillOrder(SeckillOrder order);

}

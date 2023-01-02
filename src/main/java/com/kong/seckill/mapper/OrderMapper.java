package com.kong.seckill.mapper;

import com.kong.seckill.pojo.Order;
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
public interface OrderMapper  {
    SeckillOrder selectOrderByUserId(Long id);
    void insertOrder(Order order);
}

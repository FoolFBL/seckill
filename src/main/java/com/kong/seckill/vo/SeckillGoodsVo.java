package com.kong.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shijiu
 * 展示层 秒杀库存表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeckillGoodsVo {
    private int stockCount;
    private int goodsId;
    private Date endDate;
    private Date startDate;
    private int id;
    private Double seckillPrice;
}

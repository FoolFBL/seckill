package com.kong.seckill.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author kong
 * @since 2022-12-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class SeckillGoods implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private Long goodsId;

    private BigDecimal seckillPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;


}

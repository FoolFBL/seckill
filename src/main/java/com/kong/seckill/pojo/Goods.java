package com.kong.seckill.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

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

public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品库存 -1表示没有限制
     */
    private Integer goodsStock;

    /**
     * 商品id

     */

    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品标题

     */
    private String goodsTitle;

    /**
     * 商品图片
     */
    private String goodsImg;

    /**
     * 商品图片
     */
    private String goodsDetail;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;


}

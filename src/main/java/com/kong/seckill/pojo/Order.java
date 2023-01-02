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

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private Long userId;

    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品单价
     */
    private BigDecimal goodsPrice;

    /**
     * 收货地址id
     */
    private Long deliveryAddrId;

    /**
     * 1pc 2android 3ios
     */
    private Integer orderChannel;

    /**
     * 订单状态 0 未支付 1 已支付 2 已发货 3未发货 4.已退款 5 已完成
     */
    private Integer status;

    /**
     * 订单创建时间
     */

    private Date createTime;

    /**
     * 订单支付时间
     */
    private Date payDate;

    /**
     * 冗余过来的商品名称
     */
    private String goodsName;


}

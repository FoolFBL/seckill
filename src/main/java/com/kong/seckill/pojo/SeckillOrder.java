package com.kong.seckill.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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

public class SeckillOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Long orderId;

    private Long goodsId;


}

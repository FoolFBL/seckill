package com.kong.seckill.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author shijiu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo {


//    private final static String DATE_FORMAT = "yyyy-MM-dd";
//
//    private final static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
//
//    private final static String TIME_ZONE = "GMT+8";

    private Long id;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private String goodsDetail;
    private BigDecimal goodsPrice;
    private Integer goodsStock;

    private BigDecimal seckillPrice;
    private Integer stockCount;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}


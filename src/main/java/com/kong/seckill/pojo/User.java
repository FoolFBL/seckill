package com.kong.seckill.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author kong
 * @since 2022-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id 手机号码
     */

    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 盐值
     */
    private String salt;

    /**
     * MD5双重加密
     */
    private String password;

    /**
     * 头像
     */
    private String head;

    /**
     * 注册时间
     */
    private Date registerDate;

    /**
     * 最后一次登录时间
     */
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;


}

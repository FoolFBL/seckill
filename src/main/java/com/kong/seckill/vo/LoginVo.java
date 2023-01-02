package com.kong.seckill.vo;

import com.kong.seckill.annoation.isMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author shijiu
 */
@Data
public class LoginVo {
    @NotNull
    @isMobile
    private String mobilePhone;
    @NotNull
    @Length(min = 32)
    private String password;
}

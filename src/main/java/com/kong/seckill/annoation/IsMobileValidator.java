package com.kong.seckill.annoation;

import com.kong.seckill.utils.ValidatorUtill;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shijiu
 */
public class IsMobileValidator implements ConstraintValidator<isMobile,String> {
    //默认非必填
    private boolean required = false;
    //初始化 获取是否必填
    @Override
    public void initialize(isMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return ValidatorUtill.isMobile(value);
        }else{
            if(StringUtils.isEmpty(value)){
                return true;
            }
            else{
                return ValidatorUtill.isMobile(value);
            }
        }
    }
}

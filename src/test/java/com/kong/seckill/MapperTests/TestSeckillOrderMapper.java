package com.kong.seckill.MapperTests;

import com.kong.seckill.mapper.SeckillOrderMapper;
import com.kong.seckill.pojo.SeckillOrder;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

/**
 * @author shijiu
 */
@SpringBootTest
public class TestSeckillOrderMapper {
    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Test
    public void testSelectOrderByUserId(){
        SeckillOrder seckillOrder = seckillOrderMapper.selectOrderByUserId(1L,1);
        System.out.println(seckillOrder);
    }

}

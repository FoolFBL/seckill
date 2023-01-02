package com.kong.seckill.MapperTests;

import com.kong.seckill.mapper.OrderMapper;
import com.kong.seckill.pojo.Order;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shijiu
 */
@SpringBootTest
public class TestOrderMapper {
    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void testIns(){
        Order order = new Order();
        order.setUserId(1L);
        order.setStatus(1);
        orderMapper.insertOrder(order);
    }

}

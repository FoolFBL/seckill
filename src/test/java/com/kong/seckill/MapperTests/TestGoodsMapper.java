package com.kong.seckill.MapperTests;

import com.kong.seckill.mapper.GoodsMapper;
import com.kong.seckill.vo.GoodsVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author shijiu
 */
@SpringBootTest
public class TestGoodsMapper {

    @Autowired
    private GoodsMapper goodsMapper;
    @Test
    public void testSelectGoodsVo(){
//
//        List<GoodsVo> goodsVos = goodsMapper.selectGoodsVo();
//        for (GoodsVo goodsVo : goodsVos) {
//            System.out.println(goodsVo);
//        }
//
//        GoodsVo goodsVo = goodsMapper.selectGoodsVoById(1);
//        System.out.println(goodsVo);
        String s = "2551";
        String substring = s.substring(0, 2)+s.substring(2);
        System.out.println(substring);


    }
}

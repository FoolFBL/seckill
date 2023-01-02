package com.kong.seckill.mapper;

import com.kong.seckill.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kong
 * @since 2022-12-19
 */
@Mapper
public interface UserMapper {
    User selectUserById(String id);

    User selectAll();

    int insertUser(User user);
}

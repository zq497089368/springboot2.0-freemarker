package com.zq.mapper;

import com.zq.entity.UserPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where id = #{id}")
    UserPO findById(Long id);

    @Insert("insert into user(name, age) values(#{name}, #{age})")
    void save(UserPO userPO);
}

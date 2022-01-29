package com.bf.studysb.Repository;

import com.bf.studysb.Entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name} limit 1")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, EMAIL) VALUES(#{name}, #{email})")
    int insert(@Param("name") String name,@Param("email") String email);
}

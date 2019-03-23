package com.bailuning.operation.mapper;

import com.bailuning.operation.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    UserEntity selectById(@Param("id")Integer id);

    int delete(@Param("id")Integer id);

    int insert(UserEntity record);


    int update(UserEntity record);
}
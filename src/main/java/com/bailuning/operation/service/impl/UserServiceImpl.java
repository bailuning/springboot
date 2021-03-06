package com.bailuning.operation.service.impl;

import com.bailuning.operation.mapper.UserMapper;
import com.bailuning.operation.entity.UserEntity;
import com.bailuning.operation.service.IUserService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserEntity getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void add(UserEntity userEntity) {
        try {
            userMapper.insert(userEntity);
        }catch (DuplicateKeyException de){
            Throwable throwable = de.getCause();
            String error = throwable.toString();
            System.out.println(throwable.getMessage());
            System.out.println(de.getCause());
        }catch (Exception e){

        }finally {

        }

    }
}

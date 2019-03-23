package com.bailuning.operation.service;

import com.bailuning.operation.entity.UserEntity;

public interface IUserService {

   UserEntity getUserById(Integer id);

    void add(UserEntity userEntity);
}

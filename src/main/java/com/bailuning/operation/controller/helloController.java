package com.bailuning.operation.controller;

import com.bailuning.operation.code.common.CommonResponse;
import com.bailuning.operation.code.exception.CommonErrorEnum;
import com.bailuning.operation.code.exception.CommonException;
import com.bailuning.operation.code.exception.ExceptionsHandler;
import com.bailuning.operation.common.exception.UserExceptionEnum;
import com.bailuning.operation.entity.UserEntity;
import com.bailuning.operation.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    private Logger logger = LoggerFactory.getLogger(helloController.class);
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello word!";
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public CommonResponse get(@RequestParam(name = "id")Integer id){

        UserEntity userEntity = userServiceImpl.getUserById(id);
        try {
            if(userEntity ==null){
                CommonResponse.getFailResponse(userEntity);
//                throw new CommonException(CommonErrorEnum.UN_VALIDATION_ERROR.setErrorMsg("用户数据为空"));
            }
//            UserEntity user = null;
//            user.setId(1);
        }catch (Exception e){
            e.printStackTrace();
            logger.info(UserExceptionEnum.USER_EXCEPTION.errorMsg(),e);
//            return CommonResponse.getFailResponse(userEntity);
            throw new CommonException(UserExceptionEnum.USER_EXCEPTION.setErrorMsg("用户不存在哦"),e);
        }

        return CommonResponse.getSuccessResponse(userEntity);
    }
}

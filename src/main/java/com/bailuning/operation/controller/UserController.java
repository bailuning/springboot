package com.bailuning.operation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bailuning.operation.code.common.CommonResponse;
import com.bailuning.operation.code.common.IPUtils;
import com.bailuning.operation.code.config.MyHttpSessionListener;
import com.bailuning.operation.code.exception.CommonErrorEnum;
import com.bailuning.operation.code.exception.CommonException;
import com.bailuning.operation.code.exception.UserExceptionEnum;
import com.bailuning.operation.entity.UserEntity;
import com.bailuning.operation.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    private Logger logger = LoggerFactory.getLogger(helloController.class);
    @Autowired
    private UserServiceImpl userServiceImpl;


    @RequestMapping(value = "/address")
    public String hello(HttpServletRequest request){
        IPUtils.getIpAddr( request);
        System.out.println(IPUtils.getIpAddr( request));
        return IPUtils.getIpAddr( request);
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public CommonResponse get(@RequestParam(name = "id")Integer id){

        UserEntity userEntity = userServiceImpl.getUserById(id);
        try {
            if(userEntity ==null){
//                CommonResponse.getFailResponse(userEntity);
                throw new CommonException(CommonErrorEnum.UN_VALIDATION_ERROR.setErrorMsg("用户数据为空"));
            }
//            UserEntity user = null;
//            user.setId(1);
        }catch (Exception e){
            logger.info(UserExceptionEnum.USER_EXCEPTION.errorMsg(),e);
//            return CommonResponse.getFailResponse(userEntity);
            throw new CommonException(UserExceptionEnum.USER_EXCEPTION.setErrorMsg("用户不存在哦"),e);
        }

        return CommonResponse.getSuccessResponse(userEntity);
    }
    @RequestMapping(value = "/add")
    @ResponseBody
    public CommonResponse add(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("小白");
        userEntity.setSex("1");
        userServiceImpl.add(userEntity);
        return CommonResponse.getSuccessResponse(userEntity);
    }

}
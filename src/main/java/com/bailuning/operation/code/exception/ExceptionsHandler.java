package com.bailuning.operation.code.exception;

import com.bailuning.operation.code.common.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(Exception ex) {
        Map<String ,Object> responseData = new HashMap<>();
        if(ex instanceof CommonException){
        CommonException commonException = (CommonException) ex;
        responseData.put("errorCode",commonException.errorCode());
        responseData.put("errorMsg",commonException.errorMsg());
    }else {
        responseData.put("errorCode", CommonErrorEnum.UN_VALIDATION_ERROR.errorCode());
        responseData.put("errorMsg", CommonErrorEnum.UN_VALIDATION_ERROR.errorMsg());

    }
        return CommonResponse.getResponse(responseData,"FAIL");
    }

}

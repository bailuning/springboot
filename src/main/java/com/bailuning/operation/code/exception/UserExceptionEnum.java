package com.bailuning.operation.code.exception;

import com.bailuning.operation.code.exception.ICommonError;

public enum UserExceptionEnum implements ICommonError {
    USER_EXCEPTION("USER_ERROR","用户错误");
    /**
     * 异常编码
     */
    private String errorCode;
    /**
     * 异常消息
     */
    private String errorMsg;

    UserExceptionEnum(String errorCode, String errorMsg){
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
    }

    @Override
    public String errorCode() {
        return this.errorCode;
    }

    @Override
    public String errorMsg() {
        return this.errorMsg;
    }

    @Override
    public ICommonError setErrorMsg(String errorMsg) {
        this.errorMsg=errorMsg;
        return this;
    }

}

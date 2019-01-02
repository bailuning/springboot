package com.bailuning.operation.code.exception;

public enum CommonErrorEnum implements ICommonError {

    PARAMETER_VALIDATION_ERROR("10000","参数不合法"),
    UN_VALIDATION_ERROR("10001","未知错误"),
    WAY_VALIDATION_ERROR("10002","网络异常");
    /**
     * 异常编码
     */
    private String errorCode;
    /**
     * 异常消息
     */
    private String errorMsg;


    CommonErrorEnum(String errorCode, String errorMsg){
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

package com.bailuning.operation.code.exception;

public enum LinkExceptionEnum implements ICommonError {
    LONG_LINK_EXCEPTION("LINK_ERROR1","长连接地址不能为空"),
    HTTP_LINK_EXCEPTION("LINK_ERROR2","链接地址必须以http或https开头");
    /**
     * 异常编码
     */
    private String errorCode;
    /**
     * 异常消息
     */
    private String errorMsg;

    LinkExceptionEnum(String errorCode, String errorMsg){
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

package com.bailuning.operation.code.exception;

import java.io.Serializable;

/**
 * 包装器 自定义通用异常基类
 */
public class CommonException extends RuntimeException implements ICommonError, Serializable {

    private static final long serialVersionUID = 1821614620227463134L;

    private ICommonError ICommonError;

    private Exception innerException;
    /**
     * 此方法，直接用于接收 CommonErrorEnum枚举类的参数用于构造公共异常
     * @param iCommonError
     */
    public CommonException(ICommonError iCommonError){
        super();
        this.ICommonError = iCommonError;

    }

    /**
     * 接受Exception的方法自定义构造公共异常
     *  @param iCommonError
     *  @param e
     * @return
     */
    public CommonException(ICommonError iCommonError, Exception e){
        super();
        this.ICommonError = iCommonError;
        this.setException(e);

    }

    @Override
    public String errorCode() {
        return this.ICommonError.errorCode();
    }

    @Override
    public String errorMsg() {
        return this.ICommonError.errorMsg();
    }

    @Override
    public ICommonError setErrorMsg(String errorMsg) {
        return ICommonError.setErrorMsg(errorMsg);
    }

    public Exception getInnerException() {
        return innerException;
    }

    public void setException(Exception innerException) {
        this.innerException =innerException;
    }
}

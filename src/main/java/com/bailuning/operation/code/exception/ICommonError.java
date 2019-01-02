package com.bailuning.operation.code.exception;

public interface ICommonError {

    String errorCode();
    String errorMsg();
    ICommonError setErrorMsg(String errorMsg);
}

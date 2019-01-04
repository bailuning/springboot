package com.bailuning.operation.code.common;

public class CommonResponse {
    /**
     * status success 或 fail
     */
    private String status;
    private Object data;
    public static CommonResponse getSuccessResponse(Object result){
       return getResponse(result,"SUCCESS");
    }
    public static CommonResponse getFailResponse(Object result){
        return getResponse(result,"FAIL");
    }
    public static CommonResponse getResponse(Object result, String status){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatus(status);
        commonResponse.setData(result);
       return commonResponse;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

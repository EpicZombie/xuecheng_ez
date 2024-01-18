package com.xuecheng.base.exception;

import java.io.Serializable;

public class RestErrorResponse implements Serializable {

    Boolean status;//成功or是失败
    private String errMessage;

    public RestErrorResponse(String errMessage){
        this.errMessage= errMessage;
    }

    public RestErrorResponse(Boolean status, String errMessage) {
        this.status = status;
        this.errMessage = errMessage;
    }

    public RestErrorResponse(Boolean status) {
        this.status = status;
        this.errMessage = "";
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

}

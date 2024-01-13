package com.xuecheng.base.exception;

public class XueChengEzException  extends RuntimeException{
    private String errMessage;

    public XueChengEzException(String errMessage) {
        this.errMessage = errMessage;
    }

    public XueChengEzException(String message, String errMessage) {
        super(message);
        this.errMessage = errMessage;
    }

    public static void cast(String message){
        throw new XueChengEzException(message);
    }
    public static void cast(CommonError error){
        throw new XueChengEzException(error.getErrMessage());
    }
}

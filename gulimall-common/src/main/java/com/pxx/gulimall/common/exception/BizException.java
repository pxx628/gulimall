package com.pxx.gulimall.common.exception;

public enum BizException {
    UNKNOWN_EXCEPTION(10000,"系统未知异常"),
    VALID_EXCEPTION(10001,"系统格式校验异常");

    private int code;
    private String msg;
    BizException(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}

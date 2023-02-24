package com.hjw.utils;


public enum ReturnEnum {

    //成功
    SUCCESS(200,"success"),
    //警告
    LOGIN_STATUS_WARN(201,"当前用户已登录"),

    //系统错误
    UNKNOW(500,"未知错误，请联系系统负责人"),
    PATH_ERROR(404,"路径不存在，请检查路径"),

    //
    LOGIN_ERR(10000,"用户名或密码错误"),
    CHECKCODE_ERR(10001,"验证码有误"),
    CREATE_CHECKCODE_ERR(10002,"验证码生成失败"),
    DB_ERR(10003,"数据库错误，请联系系统负责人"),




    ;

    private int code;
    private String message;

    ReturnEnum(int code, String message) {
        this.code = code;
        this.message =message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.jyyx.example.springbootdemo.domain;

public enum  ExceptionMsg
{
    SUCCESS("000000"," 操作成功"),
    FAILED("999999","操作失败"),
    NOEMPLOYEE("999998","无此员工"),
    ALREADYBIND("999997","此账号已绑定");

    ExceptionMsg(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg ;

    public String getCode(){return code;}
    public String getMsg(){return msg;}
}

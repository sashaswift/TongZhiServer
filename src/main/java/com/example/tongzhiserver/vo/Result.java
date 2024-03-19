package com.example.tongzhiserver.vo;

public class Result <T>{
    public int code;
    public String msg;
    public T data;

    private Result(String msg,int code,T data){
        this.msg=msg;
        this.code=code;
        this.data=data;
    }

    public static <T> Result success(){
        Result r=new Result("suc",0,null);
        return r;
    }

    public static <T> Result success(T data){
        Result r=new Result("suc",0,data);
        return  r;
    }
}

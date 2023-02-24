package com.hjw.utils;

import java.util.HashMap;
import java.util.Map;

public class Result extends HashMap<String,Object> {

    public Result(){
        put("code",ReturnEnum.SUCCESS.getCode());
        put("message",ReturnEnum.SUCCESS.getMessage());
    }

    public static Result ok(){
        return new Result();
    }


    public static Result error(ReturnEnum err){
        Result result = new Result();
        result.put("code",err.getCode());
        result.put("message",err.getMessage());
        return result;
    }

    public static Result warn(ReturnEnum err) {
        Result result = new Result();
        result.put("code",err.getCode());
        result.put("message",err.getMessage());
        return result;
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

package com.skse.utils;

import com.google.gson.Gson;

/**
 * @Author jiangyao
 * @Date 2020/6/20 11:34
 **/
public class GsonUtil<T> {

    private static Gson gson = new Gson();

    public static String jsonToString(Object o){
        return gson.toJson(o);
    }

    public static <T> T stringToJson(String str, Class<T> t){
        return gson.fromJson(str, t);

    }
}

package com.csl.codedemos.gson;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * author: laichangsen | create time: 2017/6/19
 */

public class GsonConvert {

    public static GsonConvert newInstance() {
        return new GsonConvert();
    }

    private GsonConvert() {}

    public <T> T fromJson(String json, Type type) {
        return new Gson().fromJson(json, type);
    }

}

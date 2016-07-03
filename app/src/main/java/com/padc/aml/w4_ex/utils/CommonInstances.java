package com.padc.aml.w4_ex.utils;

import com.google.gson.Gson;

/**
 * Created by user on 7/2/2016.
 */
public class CommonInstances {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}

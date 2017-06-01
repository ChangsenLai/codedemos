package com.csl.codedemos.util;

import android.util.Log;

import com.csl.codedemos.BuildConfig;

/**
 * Created by ChangsenLai on 2016/6/14.
 * log util class
 */
public class LogUtil {

    private static String tag = "senutil";

    private LogUtil() {}

    public static void init(String tagName) {
        tag = tagName;
    }

    public static void i(String content) {
        if (isDebug())
        Log.i(tag, content);
    }

    public static void w(String content) {
        if (isDebug())
            Log.w(tag, content);
    }

    public static void e(String content) {
        if (isDebug())
            Log.e(tag, content);
    }

    private static boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}

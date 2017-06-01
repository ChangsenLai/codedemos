package com.csl.codedemos.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by ChangsenLai-WZ on 2017/3/17.
 * a memory util class
 */

public class MemoryUtil {

    private MemoryUtil () {}

    public static void logMemoryInfo(Activity aty) {
        ActivityManager activityManager = (ActivityManager) aty.getSystemService(Context.ACTIVITY_SERVICE);
        int memClass = activityManager.getMemoryClass(); // m unit
        int largeMemoryClass = activityManager.getLargeMemoryClass(); // m unit
        float totalMemory = Runtime.getRuntime().totalMemory() * 1.0f / (1024 * 1024);
        float freeMemory = Runtime.getRuntime().freeMemory() * 1.0f / (1024 * 1024);
        float maxMemory = Runtime.getRuntime().maxMemory() * 1.0f / (1024 * 1024);

        LogUtil.i("device memClass:" + memClass + "m");
        LogUtil.i("device largeMemoryClass:" + largeMemoryClass + "m");
        LogUtil.i("app totalMemory:" + totalMemory + "m");
        LogUtil.i("app freeMemory:" + freeMemory + "m");
        LogUtil.i("app maxMemory:" + maxMemory + "m");
    }

    /**
     * @return app max memory of unit m
     */
    public static float appMaxMemory(Activity aty) {
        return Runtime.getRuntime().maxMemory() * 1.0f / (1024 * 1024);
    }

    /**
     * @return app free memory of unit m
     */
    public static float appfreeMemory(Activity aty) {
        return Runtime.getRuntime().maxMemory() * 1.0f / (1024 * 1024);
    }

    /**
     * @return app total memory of unit m
     */
    public static float appTotalMemory(Activity aty) {
        return Runtime.getRuntime().maxMemory() * 1.0f / (1024 * 1024);
    }














}

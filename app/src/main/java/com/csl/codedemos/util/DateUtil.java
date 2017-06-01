package com.csl.codedemos.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * date util
 */
public class DateUtil {

    private DateUtil() {}

    /**
     * 将1-7转换为中文
     * 注意：系统的以周日为每周的第一天
     */
    public static String getChineseWeekDay(int day) {
        if (day < 1 || day > 7) {
            return "";
        }
        String chineseDay = "";
        switch (day) {
            case 2:
                chineseDay = "一";
                break;
            case 3:
                chineseDay = "二";
                break;
            case 4:
                chineseDay = "三";
                break;
            case 5:
                chineseDay = "四";
                break;
            case 6:
                chineseDay = "五";
                break;
            case 7:
                chineseDay = "六";
                break;
            case 1:
                chineseDay = "日";
                break;
        }
        return chineseDay;
    }

    /**
     * 解析 yyyy-MM-dd HH:mm:ss
     */
    public static long parserDateyyyyMMddHHmmss(String time) {
        Date date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        try {
            date = format.parse(time);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 获得 yyyy-MM-dd 格式的date
     */
    public static String getDateyyyyMMdd(long time) {
        String result;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        result = format.format(time);
        return result;
    }

    /**
     * 获得 yyyy-MM-dd 格式的date
     */
    public static String getDateHHmmdd(long time) {
        String result;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        result = format.format(time);
        return result;
    }

    /**
     * 获得 yyyy年MM月dd日 格式的date
     */
    public static String getDateyyyyMMddHHmmss(long time) {
        String result;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        result = format.format(time);
        return result;
    }

    /**
     * 获得 yyyy年MM月dd日 格式的date
     */
    public static String getDateyyyyMMddZH(long time) {
        String result;
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
        result = format.format(time);
        return result;
    }

    /**
     * 获得 yyyy-MM-dd 格式的date
     */
    public static String getDatehhmm(long time) {
        String result;
        SimpleDateFormat format = new SimpleDateFormat("hh:mm", Locale.getDefault());
        result = format.format(time);
        return result;
    }

    /**
     * 格式化时间，今天就显示为几点几分，非今天显示具体日期+周
     */
    public static String getFilterTime(String time) {
        long timeValue;
        try {
            String displayTime;
            timeValue = Long.parseLong(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timeValue);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int weekOfDay = calendar.get(Calendar.DAY_OF_WEEK);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            Calendar nowCalendar = Calendar.getInstance();
            nowCalendar.setTimeInMillis(System.currentTimeMillis());
            int nowYear = nowCalendar.get(Calendar.YEAR);
            int nowMonth = nowCalendar.get(Calendar.MONTH) + 1;
            int nowDay = nowCalendar.get(Calendar.DAY_OF_MONTH);

            if (year == nowYear && month == nowMonth && day == nowDay) {
                displayTime = hour + ":" + minute;
            } else {
                displayTime = month + "月" + day + "日 " + "周" + getChineseWeekDay(weekOfDay);
            }
            return displayTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 格式化时间，今天就显示为几点几分，非今天显示具体日期+周
     */
    public static String getFilterTimeUS(long timeValue) {
        String displayTime;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeValue);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int weekOfDay = calendar.get(Calendar.DAY_OF_WEEK);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTimeInMillis(System.currentTimeMillis());
        int nowYear = nowCalendar.get(Calendar.YEAR);
        int nowMonth = nowCalendar.get(Calendar.MONTH) + 1;
        int nowDay = nowCalendar.get(Calendar.DAY_OF_MONTH);

        if (year == nowYear && month == nowMonth && day == nowDay) {
            displayTime = hour + ":" + minute;
        } else {
            displayTime = month + "-" + day + " " + "周" + getChineseWeekDay(weekOfDay);
        }
        return displayTime;
    }

    /**
     * 格式化时间，今天就显示为几点几分，非今天显示具体日期
     *
     * @param time "yyyy-MM-dd HH:mm:ss
     */
    public static String getFilterTimeNoWeek(String time) {
        return getFilterTimeNoWeek(DateUtil.parserDateyyyyMMddHHmmss(time));
    }

    /**
     * 格式化时间，今天就显示为几点几分，非今天显示具体日期
     */
    public static String getFilterTimeNoWeek(long time) {
        String displayTime;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTimeInMillis(System.currentTimeMillis());
        int nowYear = nowCalendar.get(Calendar.YEAR);
        int nowMonth = nowCalendar.get(Calendar.MONTH) + 1;
        int nowDay = nowCalendar.get(Calendar.DAY_OF_MONTH);

        if (year == nowYear && month == nowMonth && day == nowDay) {
            displayTime = hour + ":" + minute;
        } else {
            displayTime = getDateyyyyMMdd(time);
        }
        return displayTime;
    }

    /**
     * 获取今日日期
     */
    public static String getDateToday() {
        Calendar calendar = Calendar.getInstance();
        String y = calendar.get(Calendar.YEAR) + "";
        String m = (calendar.get(Calendar.MONTH) + 1) + "";
        String d = calendar.get(Calendar.DAY_OF_MONTH) + "";
        return y + "-" + m + "-" + d;
    }

    /**
     * 获取今日日期 如：9.26
     */
    public static String getDateTodayMD() {
        Calendar calendar = Calendar.getInstance();
        String m = (calendar.get(Calendar.MONTH) + 1) + "";
        String d = calendar.get(Calendar.DAY_OF_MONTH) + "";
        return m + "." + d;
    }

    /**
     * 获取今日日期
     */
    public static String dayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        return "星期" + getChineseWeekDay(calendar.get(Calendar.DAY_OF_WEEK));
    }

}

package com.core.lion.util;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utility {

    private static int debugCurrentTimeStamp = 0;

    public static int getCurrentTimeStamp() {
        if (debugCurrentTimeStamp == 0) {
            return (int) (System.currentTimeMillis() / 1000);
        } else {
            return debugCurrentTimeStamp;
        }
    }

    public static String fmtYmdHms(int timestamp) {
        long ts = ((long) timestamp) * 1000;
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sf.format(ts);
    }

    public static String getForMartTime() {
        return forMartTime(String.valueOf(System.currentTimeMillis()), "yyyy-MM-dd");
    }

    public static String forMartTime(String timePoint) {
        return forMartTime(timePoint, "yyyy-MM-dd HH:mm:ss S");
    }

    public static String forMartTime(String timePoint, String pattern) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(Long.parseLong(timePoint));
    }

    public static String forMartTime(Long timePoint, String pattern) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        String a = sf.format(Long.parseLong(String.valueOf(timePoint)));
        return sf.format(Long.parseLong(String.valueOf(timePoint)));
    }

    public static int getTimeStampByDay(int day) {
        return getDayStartTime(getCurrentTimeStamp() - day * 86400);
    }

    public static int getDayStartTime(int timePoint) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        long theTime = ((long) timePoint) * 1000;
        calendar.setTimeInMillis(theTime);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        calendar.clear();
        calendar.set(year, month, day, 0, 0, 0);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String generateGlobalOrder() {
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return (1 + String.format("%015d", hashCodeV));
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((!Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return (!isBlank(str));
    }

    public static String encodeUtf8(String url) {
        try {
            return URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        return url;
    }

    public static String getMd5(String key) {
        if (Utility.isBlank(key)) {
            return key;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(key.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(md5.digest());
        } catch (Exception e) {
        }
        return key;
    }

    public static String getCashKey(String key) {
        return "core:cash:" + key;
    }

    public static String getLockerKey(String key) {
        return "core:locker:" + key;
    }
}

package com.upuphone.ar.translation.utils;

import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordSearchViewAdapter;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.phone.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static long a(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
            if (parse == null) {
                return d();
            }
            Calendar instance = Calendar.getInstance(Locale.getDefault());
            instance.setTime(parse);
            instance.set(11, 23);
            instance.set(12, 59);
            instance.set(13, 59);
            instance.set(14, 999);
            return instance.getTimeInMillis();
        } catch (ParseException unused) {
            return d();
        }
    }

    public static long b(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
            return parse != null ? parse.getTime() : e();
        } catch (ParseException unused) {
            return e();
        }
    }

    public static String c(long j, int i) {
        String str;
        switch (i) {
            case 0:
                str = "yyyy/MM/dd HH:mm";
                break;
            case 1:
                str = "MM/dd HH:mm";
                break;
            case 2:
                str = "mm:ss";
                break;
            case 3:
                str = FastRecordSearchViewAdapter.TIME_FORMAT;
                break;
            case 4:
                str = "yyyy/MM/dd";
                break;
            case 5:
                str = "MM/dd";
                break;
            case 6:
                str = "HH:mm";
                break;
            case 7:
                str = "yyyy-MM-dd";
                break;
            case 8:
                str = "yyyy-MM-dd HH:mm:ss:SSS";
                break;
            default:
                str = "yyyy-MM-dd HH:mm:ss";
                break;
        }
        return DateTimeFormatter.ofPattern(str, Locale.US).withZone(ZoneId.systemDefault()).format(Instant.ofEpochMilli(j));
    }

    public static long d() {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        return instance.getTimeInMillis();
    }

    public static long e() {
        return System.currentTimeMillis();
    }

    public static long f(int i) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(e());
        int i2 = instance.get(11) + i;
        if (i2 >= 24) {
            instance.add(5, i2 / 24);
            instance.set(11, i2 % 24);
        } else {
            instance.set(11, i2);
        }
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        return instance.getTimeInMillis();
    }

    public static boolean g(long j) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i2 = instance.get(6);
        Calendar instance2 = Calendar.getInstance(Locale.getDefault());
        instance2.setTimeInMillis(System.currentTimeMillis());
        instance2.add(6, -2);
        return i == instance2.get(1) && i2 == instance2.get(6);
    }

    public static boolean h(String str) {
        long b = b(str);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(b);
        return instance.get(11) == 0 && instance.get(12) == 0 && instance.get(13) == 0;
    }

    public static boolean i(long j) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i2 = instance.get(6);
        Calendar instance2 = Calendar.getInstance(Locale.getDefault());
        instance2.setTimeInMillis(System.currentTimeMillis());
        return i == instance2.get(1) && i2 == instance2.get(6);
    }

    public static boolean j(long j) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i2 = instance.get(6);
        Calendar instance2 = Calendar.getInstance(Locale.getDefault());
        instance2.setTimeInMillis(System.currentTimeMillis());
        instance2.add(6, -1);
        return i == instance2.get(1) && i2 == instance2.get(6);
    }

    public static String k(long j) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        Calendar instance2 = Calendar.getInstance(Locale.getDefault());
        instance2.setTimeInMillis(System.currentTimeMillis());
        return i != instance2.get(1) ? c(j, 4) : i(j) ? c(j, 6) : j(j) ? TranslatorConstants.getContext().getString(R.string.tl_yesterday) : g(j) ? TranslatorConstants.getContext().getString(R.string.tl_before_yesterday) : c(j, 5);
    }
}

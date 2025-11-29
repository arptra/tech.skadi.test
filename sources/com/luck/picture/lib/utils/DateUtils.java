package com.luck.picture.lib.utils;

import android.content.Context;
import com.luck.picture.lib.R;
import com.meizu.common.util.LunarCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f9471a = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static int a(long j) {
        try {
            return (int) Math.abs(d() - j);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String b(long j) {
        String str = j < 0 ? LunarCalendar.DATE_SEPARATOR : "";
        long abs = Math.abs(j) / 1000;
        long j2 = abs % 60;
        long j3 = (abs / 60) % 60;
        long j4 = abs / 3600;
        return j4 > 0 ? String.format(Locale.getDefault(), "%s%d:%02d:%02d", new Object[]{str, Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)}) : String.format(Locale.getDefault(), "%s%02d:%02d", new Object[]{str, Long.valueOf(j3), Long.valueOf(j2)});
    }

    public static String c(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        return str + f9471a.format(Long.valueOf(currentTimeMillis));
    }

    public static long d() {
        String g = ValueOf.g(Long.valueOf(System.currentTimeMillis()));
        if (g.length() > 10) {
            g = g.substring(0, 10);
        }
        return ValueOf.e(g);
    }

    public static String e(Context context, long j) {
        if (String.valueOf(j).length() <= 10) {
            j *= 1000;
        }
        return h(j) ? context.getString(R.string.ps_current_week) : g(j) ? context.getString(R.string.ps_current_month) : b.format(Long.valueOf(j));
    }

    public static String f(long j) {
        if (String.valueOf(j).length() <= 10) {
            j *= 1000;
        }
        return c.format(Long.valueOf(j));
    }

    public static boolean g(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = b;
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date()));
    }

    public static boolean h(long j) {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(3);
        instance.setTime(new Date(j));
        return instance.get(3) == i;
    }

    public static long i(long j) {
        return (j / 1000) * 1000;
    }
}

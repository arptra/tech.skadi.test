package com.meizu.net.pedometerprovider.util;

import com.meizu.common.util.LunarCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateUtil {
    private static final long ONE_DAY = 86400000;

    public static long convertHour(int i) {
        String str;
        String str2;
        String str3;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        instance.set(11, i);
        StringBuilder sb = new StringBuilder();
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        int i4 = instance.get(11);
        if (i2 < 10) {
            str = String.valueOf("0" + i2);
        } else {
            str = String.valueOf(i2);
        }
        if (i3 < 10) {
            str2 = String.valueOf("0" + i3);
        } else {
            str2 = String.valueOf(i3);
        }
        if (i4 < 10) {
            str3 = String.valueOf("0" + i4);
        } else {
            str3 = String.valueOf(i4);
        }
        sb.append(instance.get(1));
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return Long.valueOf(sb.toString() + "00").longValue();
    }

    public static long convetTime(long j, boolean z) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        int i4 = instance.get(11);
        if (z) {
            return Long.valueOf(i + getStringInt(i2) + getStringInt(i3)).longValue();
        }
        return Long.valueOf(i + getStringInt(i2) + getStringInt(i3) + getStringInt(i4) + "00").longValue();
    }

    public static int div(long j, int i) {
        return Integer.valueOf(String.valueOf(j / ((long) i))).intValue();
    }

    public static long getCurrentHourBegine() {
        String str;
        String str2;
        String str3;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        int i = instance.get(2);
        int i2 = instance.get(5);
        int i3 = instance.get(11);
        if (i < 10) {
            str = String.valueOf("0" + i);
        } else {
            str = String.valueOf(i);
        }
        if (i2 < 10) {
            str2 = String.valueOf("0" + i2);
        } else {
            str2 = String.valueOf(i2);
        }
        if (i3 < 10) {
            str3 = String.valueOf("0" + i3);
        } else {
            str3 = String.valueOf(i3);
        }
        sb.append(instance.get(1));
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return Long.valueOf(sb.toString() + "00").longValue();
    }

    public static Date getDateBeforeToday(int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        instance.add(5, 0 - i);
        return instance.getTime();
    }

    public static String getDay(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date).split(LunarCalendar.DATE_SEPARATOR)[2].split(" ")[0];
    }

    public static long getDayBeforBegin(int i) {
        String str;
        String str2;
        String str3;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.setTimeInMillis(instance.getTimeInMillis() - (((long) i) * 86400000));
        StringBuilder sb = new StringBuilder();
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        int i4 = instance.get(11);
        if (i2 < 10) {
            str = String.valueOf("0" + i2);
        } else {
            str = String.valueOf(i2);
        }
        if (i3 < 10) {
            str2 = String.valueOf("0" + i3);
        } else {
            str2 = String.valueOf(i3);
        }
        if (i4 < 10) {
            str3 = String.valueOf("0" + i4);
        } else {
            str3 = String.valueOf(i4);
        }
        sb.append(instance.get(1));
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return Long.valueOf(sb.toString() + "00").longValue();
    }

    public static long getDayBeforEnd(int i) {
        return getDayBeforBegin(i) + 2300;
    }

    public static int getDayCountOfMonth(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, 1);
        return instance.getActualMaximum(5);
    }

    public static int getDaysByYearMonth(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, 1);
        instance.roll(5, -1);
        return instance.get(5);
    }

    public static int getInWeekIndex(long j) {
        int intValue = Integer.valueOf(String.valueOf(j).substring(0, 4)).intValue();
        int intValue2 = Integer.valueOf(String.valueOf(j).substring(4, 6)).intValue();
        int intValue3 = Integer.valueOf(String.valueOf(j).substring(6, 8)).intValue();
        Calendar instance = Calendar.getInstance();
        instance.set(1, intValue);
        instance.set(2, intValue2);
        instance.set(5, intValue3);
        return instance.get(7);
    }

    public static String getMonth(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date).split(LunarCalendar.DATE_SEPARATOR)[1];
    }

    private static String getStringInt(int i) {
        if (i >= 10) {
            return String.valueOf(i);
        }
        return "0" + i;
    }

    public static long getTimeInMillis(long j) {
        int intValue = Integer.valueOf(String.valueOf(j).substring(0, 4)).intValue();
        int intValue2 = Integer.valueOf(String.valueOf(j).substring(4, 6)).intValue();
        int intValue3 = Integer.valueOf(String.valueOf(j).substring(6, 8)).intValue();
        Calendar instance = Calendar.getInstance();
        instance.set(1, intValue);
        instance.set(2, intValue2);
        instance.set(5, intValue3);
        instance.set(11, 0);
        return instance.getTimeInMillis();
    }

    public static long getTodayBegin() {
        return convertHour(0);
    }

    public static long getCurrentHourBegine(long j) {
        String str;
        String str2;
        String str3;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        StringBuilder sb = new StringBuilder();
        int i = instance.get(2);
        int i2 = instance.get(5);
        int i3 = instance.get(11);
        if (i < 10) {
            str = String.valueOf("0" + i);
        } else {
            str = String.valueOf(i);
        }
        if (i2 < 10) {
            str2 = String.valueOf("0" + i2);
        } else {
            str2 = String.valueOf(i2);
        }
        if (i3 < 10) {
            str3 = String.valueOf("0" + i3);
        } else {
            str3 = String.valueOf(i3);
        }
        sb.append(instance.get(1));
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return Long.valueOf(sb.toString() + "00").longValue();
    }
}

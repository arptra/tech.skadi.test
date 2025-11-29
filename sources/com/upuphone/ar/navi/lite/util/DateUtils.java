package com.upuphone.ar.navi.lite.util;

import android.os.SystemClock;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordSearchViewAdapter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {
    public static String a() {
        return DateFormat.getTimeInstance().format(Long.valueOf(SystemClock.currentThreadTimeMillis()));
    }

    public static boolean b(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FastRecordSearchViewAdapter.TIME_FORMAT);
            return c(simpleDateFormat.parse(simpleDateFormat.format(new Date())), simpleDateFormat.parse(str), simpleDateFormat.parse(str2));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(Date date, Date date2, Date date3) {
        if (date.getTime() == date2.getTime() || date.getTime() == date3.getTime()) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        Calendar instance3 = Calendar.getInstance();
        instance3.setTime(date3);
        return instance.after(instance2) && instance.before(instance3);
    }
}

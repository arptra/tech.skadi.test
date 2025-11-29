package com.upuphone.ar.transcribe.utils;

import android.content.Context;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordSearchViewAdapter;
import com.upuphone.ar.transcribe.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static long a(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
            if (parse == null) {
                return e();
            }
            Calendar instance = Calendar.getInstance(Locale.getDefault());
            instance.setTime(parse);
            instance.set(11, 23);
            instance.set(12, 59);
            instance.set(13, 59);
            instance.set(14, 999);
            return instance.getTimeInMillis();
        } catch (ParseException unused) {
            return e();
        }
    }

    public static long b(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
            return parse != null ? parse.getTime() : f();
        } catch (ParseException unused) {
            return f();
        }
    }

    public static String c(long j) {
        String str;
        String str2;
        if (j == 0) {
            return "00:00";
        }
        long j2 = j / 3600000;
        long j3 = j % 3600000;
        long j4 = j3 / 60000;
        long j5 = (j3 % 60000) / 1000;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        String str3 = "00";
        if (i == 0) {
            str = str3;
        } else if (j2 < 10) {
            str = "0" + j2;
        } else {
            str = String.valueOf(j2);
        }
        if (j4 == 0) {
            str2 = str3;
        } else if (j4 < 10) {
            str2 = "0" + j4;
        } else {
            str2 = String.valueOf(j4);
        }
        if (j5 != 0) {
            if (j5 < 10) {
                str3 = "0" + j5;
            } else {
                str3 = String.valueOf(j5);
            }
        }
        if (i == 0) {
            return str2 + AccountConstantKt.CODE_SEPARTOR + str3;
        }
        return str + AccountConstantKt.CODE_SEPARTOR + str2 + AccountConstantKt.CODE_SEPARTOR + str3;
    }

    public static String d(long j, int i) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        date.setTime(j);
        switch (i) {
            case 0:
                simpleDateFormat.applyPattern("yyyy/MM/dd HH:mm");
                break;
            case 1:
                simpleDateFormat.applyPattern("MM/dd HH:mm");
                break;
            case 2:
                simpleDateFormat.applyPattern("mm:ss");
                break;
            case 3:
                simpleDateFormat.applyPattern(FastRecordSearchViewAdapter.TIME_FORMAT);
                break;
            case 4:
                simpleDateFormat.applyPattern("yyyy/MM/dd");
                break;
            case 5:
                simpleDateFormat.applyPattern("MM/dd");
                break;
            case 6:
                simpleDateFormat.applyPattern("HH:mm");
                break;
            case 7:
                simpleDateFormat.applyPattern("yyyy-MM-dd");
                break;
            case 8:
                simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss:SSS");
                break;
            default:
                simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
                break;
        }
        return simpleDateFormat.format(date);
    }

    public static long e() {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        return instance.getTimeInMillis();
    }

    public static long f() {
        return System.currentTimeMillis();
    }

    public static long g(int i) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(f());
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

    public static boolean h(long j) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i2 = instance.get(6);
        Calendar instance2 = Calendar.getInstance(Locale.getDefault());
        instance2.setTimeInMillis(System.currentTimeMillis());
        instance2.add(6, -2);
        return i == instance2.get(1) && i2 == instance2.get(6);
    }

    public static boolean i(String str) {
        long b = b(str);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(b);
        return instance.get(11) == 0 && instance.get(12) == 0 && instance.get(13) == 0;
    }

    public static boolean j(long j) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i2 = instance.get(6);
        Calendar instance2 = Calendar.getInstance(Locale.getDefault());
        instance2.setTimeInMillis(System.currentTimeMillis());
        return i == instance2.get(1) && i2 == instance2.get(6);
    }

    public static boolean k(long j) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i2 = instance.get(6);
        Calendar instance2 = Calendar.getInstance(Locale.getDefault());
        instance2.setTimeInMillis(System.currentTimeMillis());
        instance2.add(6, -1);
        return i == instance2.get(1) && i2 == instance2.get(6);
    }

    public static String l(Context context, long j) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        Calendar instance2 = Calendar.getInstance(Locale.getDefault());
        instance2.setTimeInMillis(System.currentTimeMillis());
        return i != instance2.get(1) ? d(j, 4) : j(j) ? d(j, 6) : k(j) ? context.getString(R.string.trsb_yesterday) : h(j) ? context.getString(R.string.trsb_before_yesterday) : d(j, 5);
    }
}

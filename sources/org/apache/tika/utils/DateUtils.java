package org.apache.tika.utils;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    public static final TimeZone b = TimeZone.getTimeZone("UTC");
    public static final TimeZone c = TimeZone.getTimeZone("GMT-12:00");

    /* renamed from: a  reason: collision with root package name */
    public final List f3338a = e();

    public static DateFormat a(String str, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, new DateFormatSymbols(Locale.US));
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        return simpleDateFormat;
    }

    public static String b(Calendar calendar) {
        return String.format(Locale.ROOT, "%04d-%02d-%02dT%02d:%02d:%02dZ", new Object[]{Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13))});
    }

    public static String c(Calendar calendar) {
        calendar.setTimeZone(b);
        return b(calendar);
    }

    public static String d(Date date) {
        Calendar instance = Calendar.getInstance(b, Locale.US);
        instance.setTime(date);
        return b(instance);
    }

    public final List e() {
        ArrayList arrayList = new ArrayList();
        TimeZone timeZone = b;
        arrayList.add(a("yyyy-MM-dd'T'HH:mm:ss'Z'", timeZone));
        arrayList.add(a("yyyy-MM-dd'T'HH:mm:ssZ", (TimeZone) null));
        arrayList.add(a("yyyy-MM-dd'T'HH:mm:ss", (TimeZone) null));
        arrayList.add(a("yyyy-MM-dd' 'HH:mm:ss'Z'", timeZone));
        arrayList.add(a("yyyy-MM-dd' 'HH:mm:ssZ", (TimeZone) null));
        arrayList.add(a("yyyy-MM-dd' 'HH:mm:ss", (TimeZone) null));
        TimeZone timeZone2 = c;
        arrayList.add(a("yyyy-MM-dd", timeZone2));
        arrayList.add(a("yyyy:MM:dd", timeZone2));
        return arrayList;
    }

    public Date f(String str) {
        int length = str.length();
        int i = length - 3;
        if (str.charAt(i) == ':') {
            int i2 = length - 6;
            if (str.charAt(i2) == '+' || str.charAt(i2) == '-') {
                str = str.substring(0, i) + str.substring(length - 2);
            }
        }
        for (DateFormat parse : this.f3338a) {
            try {
                return parse.parse(str);
            } catch (ParseException unused) {
            }
        }
        return null;
    }
}

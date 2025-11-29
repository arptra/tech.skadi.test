package com.upuphone.star.core.log.file.naming;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFileNameGenerator implements FileNameGenerator {

    /* renamed from: a  reason: collision with root package name */
    public ThreadLocal f6456a = new ThreadLocal<SimpleDateFormat>() {
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        }
    };

    public boolean a() {
        return true;
    }

    public String b(int i, long j) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) this.f6456a.get();
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date(j));
    }
}

package com.upuphone.xr.sapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/utils/DateUtil;", "", "<init>", "()V", "", "dateStr", "format", "Ljava/util/Date;", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Date;", "a", "()Ljava/lang/String;", "date", "b", "(Ljava/util/Date;)Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DateUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final DateUtil f7876a = new DateUtil();

    public final String a() {
        return b(new Date());
    }

    public final String b(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final Date c(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "dateStr");
        Intrinsics.checkNotNullParameter(str2, "format");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        Date date = new Date();
        try {
            Date parse = simpleDateFormat.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            return parse;
        } catch (Exception e) {
            e.printStackTrace();
            return date;
        }
    }
}

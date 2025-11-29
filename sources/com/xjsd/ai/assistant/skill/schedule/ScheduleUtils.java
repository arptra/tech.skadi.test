package com.xjsd.ai.assistant.skill.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/xjsd/ai/assistant/skill/schedule/ScheduleUtils;", "", "<init>", "()V", "", "formatDate", "", "d", "(Ljava/lang/String;)J", "Ljava/util/Date;", "c", "(Ljava/lang/String;)Ljava/util/Date;", "timestamp", "e", "(J)Ljava/lang/String;", "time", "b", "a", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final ScheduleUtils f8700a = new ScheduleUtils();

    public final String a(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String b(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final Date c(String str) {
        Intrinsics.checkNotNullParameter(str, "formatDate");
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        return parse;
    }

    public final long d(String str) {
        Intrinsics.checkNotNullParameter(str, "formatDate");
        return c(str).getTime();
    }

    public final String e(long j) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}

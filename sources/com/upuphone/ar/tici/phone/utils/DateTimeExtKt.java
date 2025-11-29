package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import com.upuphone.ar.tici.R;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "Ljava/time/LocalDateTime;", "c", "(J)Ljava/time/LocalDateTime;", "Ljava/time/LocalDate;", "b", "(J)Ljava/time/LocalDate;", "Landroid/content/Context;", "context", "today", "recentWeek", "recentMonth", "", "a", "(JLandroid/content/Context;Ljava/time/LocalDate;Ljava/time/LocalDate;Ljava/time/LocalDate;)Ljava/lang/String;", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class DateTimeExtKt {
    public static final String a(long j, Context context, LocalDate localDate, LocalDate localDate2, LocalDate localDate3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(localDate, "today");
        Intrinsics.checkNotNullParameter(localDate2, "recentWeek");
        Intrinsics.checkNotNullParameter(localDate3, "recentMonth");
        LocalDate b = b(j);
        if (b.isEqual(localDate) || b.isAfter(localDate)) {
            String string = context.getString(R.string.tici_date_today);
            Intrinsics.checkNotNull(string);
            return string;
        } else if (b.isAfter(localDate2)) {
            String string2 = context.getString(R.string.tici_date_recent_week);
            Intrinsics.checkNotNull(string2);
            return string2;
        } else if (b.isAfter(localDate3)) {
            String string3 = context.getString(R.string.tici_date_recent_month);
            Intrinsics.checkNotNull(string3);
            return string3;
        } else {
            String string4 = context.getString(R.string.tici_date_one_month_ago);
            Intrinsics.checkNotNull(string4);
            return string4;
        }
    }

    public static final LocalDate b(long j) {
        LocalDate localDate = c(j).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        return localDate;
    }

    public static final LocalDateTime c(long j) {
        LocalDateTime ofInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(j), ZoneId.systemDefault());
        Intrinsics.checkNotNullExpressionValue(ofInstant, "ofInstant(...)");
        return ofInstant;
    }
}

package com.upuphone.ar.fastrecord.phone.schedule;

import android.content.Context;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.core.content.ContextCompat;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u0016\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0013H\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u000e\u0010\u0012\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/schedule/ScheduleUtils;", "", "()V", "CALENDAR_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getCALENDAR_URI", "()Landroid/net/Uri;", "EVENT_URI", "getEVENT_URI", "ONE_HOURS", "", "REMINDERS_MINUTES", "", "getREMINDERS_MINUTES", "()I", "REMINDER_URI", "getREMINDER_URI", "TAG", "", "adjustDate", "dateStr", "adjustDateAddOneHour", "dateToTimestamp", "formatStr", "hasCalendarPermission", "", "context", "Landroid/content/Context;", "timestampToDate", "timestamp", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScheduleUtils {
    private static final Uri CALENDAR_URI = CalendarContract.Calendars.CONTENT_URI;
    private static final Uri EVENT_URI = CalendarContract.Events.CONTENT_URI;
    @NotNull
    public static final ScheduleUtils INSTANCE = new ScheduleUtils();
    private static final long ONE_HOURS = 3600000;
    private static final int REMINDERS_MINUTES = 5;
    private static final Uri REMINDER_URI = CalendarContract.Reminders.CONTENT_URI;
    @NotNull
    private static final String TAG = "ScheduleUtils";

    private ScheduleUtils() {
    }

    private final String timestampToDate(long j, String str) {
        try {
            String format = new SimpleDateFormat(str).format(new Date(j));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.logE("timestampToDate error = " + message, TAG);
            return "";
        }
    }

    @NotNull
    public final String adjustDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "dateStr");
        String timestampToDate = timestampToDate(dateToTimestamp(str, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd");
        return timestampToDate + " 23:59:59";
    }

    @NotNull
    public final String adjustDateAddOneHour(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "dateStr");
        String timestampToDate = timestampToDate(dateToTimestamp(str, "yyyy-MM-dd HH:mm:ss") + 3600000, "yyyy-MM-dd HH:mm:ss");
        LogExt.logE("adjustDateAddOneHour millisStr = " + timestampToDate, TAG);
        return timestampToDate;
    }

    public final long dateToTimestamp(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "dateStr");
        Intrinsics.checkNotNullParameter(str2, "formatStr");
        try {
            Date parse = new SimpleDateFormat(str2).parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            return parse.getTime();
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.logE("dateToTimestamp error = " + message, TAG);
            return 0;
        }
    }

    public final Uri getCALENDAR_URI() {
        return CALENDAR_URI;
    }

    public final Uri getEVENT_URI() {
        return EVENT_URI;
    }

    public final int getREMINDERS_MINUTES() {
        return REMINDERS_MINUTES;
    }

    public final Uri getREMINDER_URI() {
        return REMINDER_URI;
    }

    public final boolean hasCalendarPermission(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.checkSelfPermission(context, "android.permission.READ_CALENDAR") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.WRITE_CALENDAR") == 0;
    }
}

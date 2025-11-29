package com.upuphone.ar.fastrecord.phone.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0006H\u0007J\u0016\u0010 \u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006J\u0016\u0010\"\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006J\u0010\u0010#\u001a\u00020\u00042\b\b\u0001\u0010$\u001a\u00020\u0011J\u0010\u0010%\u001a\u00020&2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006J\u0010\u0010'\u001a\u00020&2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordDateUtil;", "", "()V", "DAY", "", "FORMAT_HH_MM", "", "FORMAT_NO_TIME", "FORMAT_WITH_TIME", "TAG", "convertTimeToZero", "dateStr", "currentDateToYearMonthDay", "dateRoll", "Ljava/util/Date;", "date", "type", "", "num", "dateStr2TimeStamp", "dateStrToEndOfDayTimestamp", "dateStrToTimestamp", "dateToYearMonthDay", "formatRecordDate", "timestamp", "getDateToString", "milSecond", "pattern", "getEndOfDayTimestamp", "getRecordDayDetail", "time", "day", "getStringToDate", "format", "getStringToTimestamp", "hourlyTime", "hourLater", "isAfterCur", "", "isStartOfDay", "timeStamp2Date", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordDateUtil {
    private static final long DAY = 86400000;
    @NotNull
    private static final String FORMAT_HH_MM = "HH:mm";
    @NotNull
    private static final String FORMAT_NO_TIME = "yyyy-MM-dd";
    @NotNull
    private static final String FORMAT_WITH_TIME = "yyyy-MM-dd HH:mm:ss";
    @NotNull
    public static final RecordDateUtil INSTANCE = new RecordDateUtil();
    @NotNull
    private static final String TAG = "RecordDateUtil";

    private RecordDateUtil() {
    }

    private final long getEndOfDayTimestamp() {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        return instance.getTimeInMillis();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String convertTimeToZero(@org.jetbrains.annotations.NotNull java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r2 = "dateStr"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0024 }
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0024 }
            java.lang.String r0 = "yyyy-MM-dd"
            r2.<init>(r0)     // Catch:{ all -> 0x0024 }
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss"
            r0.<init>(r1)     // Catch:{ all -> 0x0024 }
            java.util.Date r2 = r2.parse(r3)     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = r0.format(r2)     // Catch:{ all -> 0x0024 }
            java.lang.Object r2 = kotlin.Result.m20constructorimpl(r2)     // Catch:{ all -> 0x0024 }
            goto L_0x002f
        L_0x0024:
            r2 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            java.lang.Object r2 = kotlin.Result.m20constructorimpl(r2)
        L_0x002f:
            boolean r0 = kotlin.Result.m26isFailureimpl(r2)
            if (r0 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r3 = r2
        L_0x0037:
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil.convertTimeToZero(java.lang.String):java.lang.String");
    }

    @NotNull
    public final String currentDateToYearMonthDay() {
        return dateToYearMonthDay(new Date());
    }

    @NotNull
    public final Date dateRoll(@NotNull Date date, int i, int i2) {
        Intrinsics.checkNotNullParameter(date, "date");
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(i, i2);
        Date time = instance.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        return time;
    }

    public final long dateStr2TimeStamp(@NotNull String str) {
        Long l;
        Intrinsics.checkNotNullParameter(str, "dateStr");
        try {
            Result.Companion companion = Result.Companion;
            l = Result.m20constructorimpl(Long.valueOf(new SimpleDateFormat(FORMAT_WITH_TIME).parse(str).getTime()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            l = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m26isFailureimpl(l)) {
            l = 0L;
        }
        return ((Number) l).longValue();
    }

    public final long dateStrToEndOfDayTimestamp(@Nullable String str) {
        try {
            Date parse = new SimpleDateFormat(FORMAT_WITH_TIME, Locale.getDefault()).parse(str);
            if (parse == null) {
                return getEndOfDayTimestamp();
            }
            Calendar instance = Calendar.getInstance(Locale.getDefault());
            instance.setTime(parse);
            instance.set(11, 23);
            instance.set(12, 59);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis();
        } catch (ParseException unused) {
            return getEndOfDayTimestamp();
        }
    }

    public final long dateStrToTimestamp(@Nullable String str) {
        try {
            LogExt.logE("dateStrToTimestamp dateStr = " + str, TAG);
            Date parse = new SimpleDateFormat(FORMAT_WITH_TIME, Locale.getDefault()).parse(str);
            return parse != null ? parse.getTime() : System.currentTimeMillis();
        } catch (ParseException e) {
            String message = e.getMessage();
            LogExt.logE("dateStrToTimestamp error = " + message, TAG);
            return System.currentTimeMillis();
        }
    }

    @NotNull
    public final String dateToYearMonthDay(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String format = new SimpleDateFormat(FORMAT_NO_TIME, Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @NotNull
    public final String formatRecordDate(long j) {
        String str;
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_NO_TIME, Locale.getDefault());
        String format = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS", Locale.getDefault()).format(Long.valueOf(j));
        LogExt.logE("dateFormat2 = " + format, TAG);
        boolean z = true;
        if (instance2.get(1) != instance.get(1)) {
            z = false;
        }
        if (z) {
            simpleDateFormat.applyPattern("MM/dd");
            String format2 = simpleDateFormat.format(instance2.getTime());
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            str = getRecordDayDetail(j, format2);
        } else {
            simpleDateFormat.applyPattern("yyyy/MM/dd");
            str = simpleDateFormat.format(instance2.getTime());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        }
        LogExt.logE("formatRecordDate = " + str, TAG);
        return str;
    }

    @NotNull
    @SuppressLint({"SimpleDateFormat"})
    public final String getDateToString(long j, @Nullable String str) {
        long time = new Date(j).getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String format = simpleDateFormat.format(Long.valueOf(time));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @NotNull
    @SuppressLint({"SimpleDateFormat"})
    public final String getRecordDayDetail(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "day");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_NO_TIME);
        Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis())));
        Long l = null;
        Long valueOf = parse != null ? Long.valueOf(parse.getTime()) : null;
        Date parse2 = simpleDateFormat.parse(simpleDateFormat.format(new Date(j)));
        if (parse2 != null) {
            l = Long.valueOf(parse2.getTime());
        }
        if (!(valueOf == null || l == null)) {
            long longValue = valueOf.longValue() - l.longValue();
            if (longValue == 0) {
                str = new SimpleDateFormat(FORMAT_HH_MM, Locale.getDefault()).format(Long.valueOf(new Date(j).getTime()));
            } else if (longValue == 86400000) {
                str = FastRecordManager.Companion.getInstance().appContext().getString(R.string.fast_record_yestday);
            } else if (longValue == 172800000) {
                str = FastRecordManager.Companion.getInstance().appContext().getString(R.string.fast_record_lastday);
            }
            Intrinsics.checkNotNull(str);
        }
        return str;
    }

    @NotNull
    public final Date getStringToDate(@NotNull String str, @NotNull String str2) {
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

    public final long getStringToTimestamp(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "dateStr");
        Intrinsics.checkNotNullParameter(str2, "format");
        return getStringToDate(str, str2).getTime();
    }

    public final long hourlyTime(@IntRange int i) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTimeInMillis(System.currentTimeMillis());
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

    public final boolean isAfterCur(@Nullable String str) {
        Boolean bool;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_WITH_TIME);
        Date date = new Date();
        try {
            Result.Companion companion = Result.Companion;
            bool = Result.m20constructorimpl(Boolean.valueOf(simpleDateFormat.parse(str).after(date)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            bool = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.m26isFailureimpl(bool)) {
            bool = bool2;
        }
        return ((Boolean) bool).booleanValue();
    }

    public final boolean isStartOfDay(@Nullable String str) {
        long dateStrToTimestamp = dateStrToTimestamp(str);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(dateStrToTimestamp);
        return instance.get(11) == 0 && instance.get(12) == 0 && instance.get(13) == 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String timeStamp2Date(long r3) {
        /*
            r2 = this;
            r0 = 0
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            java.lang.String r0 = ""
            if (r2 > 0) goto L_0x0009
            return r0
        L_0x0009:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0021 }
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0021 }
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss"
            r2.<init>(r1)     // Catch:{ all -> 0x0021 }
            java.util.Date r1 = new java.util.Date     // Catch:{ all -> 0x0021 }
            r1.<init>(r3)     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = r2.format(r1)     // Catch:{ all -> 0x0021 }
            java.lang.Object r2 = kotlin.Result.m20constructorimpl(r2)     // Catch:{ all -> 0x0021 }
            goto L_0x002c
        L_0x0021:
            r2 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            java.lang.Object r2 = kotlin.Result.m20constructorimpl(r2)
        L_0x002c:
            boolean r3 = kotlin.Result.m26isFailureimpl(r2)
            if (r3 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r0 = r2
        L_0x0034:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil.timeStamp2Date(long):java.lang.String");
    }
}

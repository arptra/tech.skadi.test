package com.upuphone.ar.fastrecord.phone.ext;

import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.star.core.log.ULog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a \u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a\u0014\u0010\n\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a \u0010\n\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a \u0010\u000b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a&\u0010\f\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a \u0010\u000f\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a \u0010\u0010\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"logCountMap", "", "", "", "clearLogCountMap", "", "logD", "tag", "tr", "", "logE", "logI", "logReachCount", "key", "count", "logV", "logW", "ar-fastrecord_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "LogExt")
public final class LogExt {
    @NotNull
    private static final Map<String, Integer> logCountMap = new LinkedHashMap();

    public static final void clearLogCountMap() {
        logCountMap.clear();
    }

    public static final void logD(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(RecordConstants.TAG_PREFIX + str2, str);
    }

    public static /* synthetic */ void logD$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logD(str, str2, th);
    }

    public static final void logE(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c(RecordConstants.TAG_PREFIX + str2, str);
    }

    public static /* synthetic */ void logE$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logE(str, str2, th);
    }

    public static final void logI(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g(RecordConstants.TAG_PREFIX + str2, str);
    }

    public static /* synthetic */ void logI$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logI(str, str2, th);
    }

    public static final void logReachCount(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Intrinsics.checkNotNullParameter(str3, IntentKey.ACTIVITY.ACTION_KEY);
        Map<String, Integer> map = logCountMap;
        if (map.containsKey(str3)) {
            Integer num = map.get(str3);
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue() + 1;
            map.put(str3, Integer.valueOf(intValue));
            if (intValue == i) {
                map.put(str3, 0);
            }
        } else {
            map.put(str3, 0);
        }
        Integer num2 = map.get(str3);
        if (num2 != null && num2.intValue() == 0) {
            logI(str, str2);
        }
    }

    public static /* synthetic */ void logReachCount$default(String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 100;
        }
        logReachCount(str, str2, str3, i);
    }

    public static final void logV(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.l(RecordConstants.TAG_PREFIX + str2, str);
    }

    public static /* synthetic */ void logV$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logV(str, str2, th);
    }

    public static final void logW(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o(RecordConstants.TAG_PREFIX + str2, str);
    }

    public static /* synthetic */ void logW$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logW(str, str2, th);
    }

    public static final void logD(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.b(RecordConstants.TAG_PREFIX + str2, str, th);
    }

    public static final void logE(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.d(RecordConstants.TAG_PREFIX + str2, str, th);
    }

    public static final void logI(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.h(RecordConstants.TAG_PREFIX + str2, str, th);
    }

    public static final void logV(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.m(RecordConstants.TAG_PREFIX + str2, str, th);
    }

    public static final void logW(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.p(RecordConstants.TAG_PREFIX + str2, str, th);
    }
}

package com.xjsd.xr.sapp.asr.utils;

import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.star.core.log.ULog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a \u0010\t\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0000\u001a\u0014\u0010\f\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a&\u0010\r\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"PREFIX_TAG", "", "mLogCountMap", "", "", "clearLogCountMap", "", "logD", "tag", "logE", "t", "", "logI", "logReachCount", "key", "count", "asr_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UlogExtKt {
    @NotNull
    private static final String PREFIX_TAG = "XrAsr-";
    @NotNull
    private static final Map<String, Integer> mLogCountMap = new LinkedHashMap();

    public static final void clearLogCountMap() {
        mLogCountMap.clear();
    }

    public static final void logD(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(PREFIX_TAG + str2, str);
    }

    public static final void logE(@NotNull String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.d(PREFIX_TAG + str2, str, th);
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
        delegate.g(PREFIX_TAG + str2, str);
    }

    public static final void logReachCount(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Intrinsics.checkNotNullParameter(str3, IntentKey.ACTIVITY.ACTION_KEY);
        Map<String, Integer> map = mLogCountMap;
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
}

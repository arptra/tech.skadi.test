package com.upuphone.ar.transcribe.ext;

import com.upuphone.ar.transcribe.eventtrack.EventTrackingHelper;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.star.core.log.ULog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u0019\u0010\u0011\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0004\" \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013\" \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013¨\u0006\u0017"}, d2 = {"", "tag", "", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "f", "(Ljava/lang/String;)V", "key", "", "count", "", "showTime", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "a", "()V", "g", "e", "", "Ljava/util/Map;", "logCountMap", "", "logTimeMap", "ar-transcribe_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLogExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogExt.kt\ncom/upuphone/ar/transcribe/ext/LogExt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,469:1\n151#2,6:470\n151#2,6:476\n*S KotlinDebug\n*F\n+ 1 LogExt.kt\ncom/upuphone/ar/transcribe/ext/LogExt\n*L\n207#1:470,6\n215#1:476,6\n*E\n"})
@JvmName(name = "LogExt")
public final class LogExt {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f6066a = new LinkedHashMap();
    public static final Map b = new LinkedHashMap();

    public static final void a() {
        f6066a.clear();
        b.clear();
    }

    public static final void b(String str, String str2, String str3, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Intrinsics.checkNotNullParameter(str3, IntentKey.ACTIVITY.ACTION_KEY);
        Map map = f6066a;
        if (map.containsKey(str3)) {
            Object obj = map.get(str3);
            Intrinsics.checkNotNull(obj);
            int intValue = ((Number) obj).intValue() + 1;
            map.put(str3, Integer.valueOf(intValue));
            if (intValue == i) {
                map.put(str3, 0);
            }
        } else {
            map.put(str3, 0);
        }
        Integer num = (Integer) map.get(str3);
        if (num != null && num.intValue() == 0) {
            g(str, str2);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                Map map2 = b;
                Long l = (Long) map2.get(str3);
                long longValue = currentTimeMillis - (l != null ? l.longValue() : currentTimeMillis);
                map2.put(str3, Long.valueOf(currentTimeMillis));
                if (longValue > 1300) {
                    e("audioInterval delay: " + longValue, str2);
                    EventTrackingHelper.f6058a.b(longValue, currentTimeMillis);
                } else if (1 <= longValue && longValue < 1100) {
                    e("audioInterval compress: " + longValue, str2);
                    EventTrackingHelper.f6058a.b(longValue, currentTimeMillis);
                }
            }
        }
    }

    public static /* synthetic */ void c(String str, String str2, String str3, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 100;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        b(str, str2, str3, i, z);
    }

    public static final void d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("TrcB-" + str2, str);
    }

    public static final void e(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("TrcB-" + str2, str);
    }

    public static final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULog.f6446a.f(str);
    }

    public static final void g(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("TrcB-" + str2, str);
    }
}

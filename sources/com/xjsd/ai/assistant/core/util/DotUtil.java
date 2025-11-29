package com.xjsd.ai.assistant.core.util;

import com.honey.account.constant.AccountConstantKt;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.track.TrackAbility;
import com.xjsd.ai.assistant.log.ILog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJC\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042*\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\n0\t\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010JK\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042*\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\n0\t\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/xjsd/ai/assistant/core/util/DotUtil;", "", "<init>", "()V", "", "event", "", "e", "(Ljava/lang/String;)V", "", "Lkotlin/Pair;", "trackData", "d", "(Ljava/lang/String;[Lkotlin/Pair;)V", "logPrefix", "b", "(Ljava/lang/String;Ljava/lang/String;)V", "a", "(Ljava/lang/String;Ljava/lang/String;[Lkotlin/Pair;)V", "", "c", "()Z", "", "", "Ljava/util/Map;", "timestampMap", "Lcom/xjsd/ai/assistant/core/api/track/TrackAbility;", "Lcom/xjsd/ai/assistant/core/api/track/TrackAbility;", "trackAbility", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public final class DotUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final DotUtil f8460a = new DotUtil();
    public static final Map b = new LinkedHashMap();
    public static TrackAbility c;

    public static final void a(String str, String str2, Pair... pairArr) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(str2, "logPrefix");
        Intrinsics.checkNotNullParameter(pairArr, "trackData");
        Long l = (Long) b.get(str);
        String str3 = str2 + "->" + (System.currentTimeMillis() - (l != null ? l.longValue() : 0)) + "ms";
        ILog.j("DotUtil", str3);
        if (f8460a.c()) {
            HashMap hashMap = new HashMap();
            hashMap.put("costTime", str3);
            for (Pair pair : pairArr) {
                hashMap.put(pair.getFirst(), pair.getSecond());
            }
            TrackAbility trackAbility = c;
            if (trackAbility != null) {
                trackAbility.track("cost_" + str, hashMap);
            }
        }
    }

    public static final void b(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(str2, "logPrefix");
        Long l = (Long) b.get(str);
        long longValue = l != null ? l.longValue() : 0;
        ILog.j("DotUtil", str2 + "->" + (System.currentTimeMillis() - longValue) + "ms");
    }

    public static final void d(String str, Pair... pairArr) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(pairArr, "trackData");
        long currentTimeMillis = System.currentTimeMillis();
        b.put(str, Long.valueOf(currentTimeMillis));
        ILog.j("DotUtil", "event_" + str + AccountConstantKt.CODE_SEPARTOR + currentTimeMillis);
        if (f8460a.c()) {
            HashMap hashMap = new HashMap();
            hashMap.put("eventTime", Long.valueOf(currentTimeMillis));
            for (Pair pair : pairArr) {
                hashMap.put(pair.getFirst(), pair.getSecond());
            }
            TrackAbility trackAbility = c;
            if (trackAbility != null) {
                trackAbility.track(str, hashMap);
            }
        }
    }

    public static final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "event");
        long currentTimeMillis = System.currentTimeMillis();
        b.put(str, Long.valueOf(currentTimeMillis));
        ILog.j("DotUtil", "event_" + str + AccountConstantKt.CODE_SEPARTOR + currentTimeMillis);
    }

    public final boolean c() {
        if (c != null) {
            return true;
        }
        TrackAbility trackAbility = (TrackAbility) AbilityManager.b.b(TrackAbility.class);
        if (trackAbility != null && trackAbility.isProxyInstance()) {
            return false;
        }
        c = trackAbility;
        return true;
    }
}

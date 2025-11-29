package com.upuphone.ai.ttsengine.base.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001b\u0010\u000f\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u0006\u0010\fR\u001b\u0010\u0011\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u001b\u0010\u0013\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/utils/SystemUtils;", "", "<init>", "()V", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "b", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "", "c", "Lkotlin/Lazy;", "()Z", "isMIUI", "d", "isHUAWEI", "e", "isMeizu", "f", "isVIVO", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SystemUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final SystemUtils f5531a = new SystemUtils();
    public static final AILOG b = AILOG.a("SystemUtils");
    public static final Lazy c = LazyKt.lazy(SystemUtils$isMIUI$2.INSTANCE);
    public static final Lazy d = LazyKt.lazy(SystemUtils$isHUAWEI$2.INSTANCE);
    public static final Lazy e = LazyKt.lazy(SystemUtils$isMeizu$2.INSTANCE);
    public static final Lazy f = LazyKt.lazy(SystemUtils$isVIVO$2.INSTANCE);

    public final boolean b() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) e.getValue()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f.getValue()).booleanValue();
    }
}

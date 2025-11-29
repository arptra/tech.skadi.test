package com.xjsd.ai.assistant.phone.helper;

import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/VersionUtil;", "", "<init>", "()V", "", "targetVersion", "", "b", "(Ljava/lang/String;)Z", "c", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "AIR_ACCESSIBILITY_TARGET_VERSION", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VersionUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final VersionUtil f8566a = new VersionUtil();
    public static final String b = GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.6.3.20240424_Air_FR"));

    public final String a() {
        return b;
    }

    public final boolean b(String str) {
        Intrinsics.checkNotNullParameter(str, "targetVersion");
        IGlassInfo a2 = SdkContext.f6675a.e().a();
        if (a2 == null) {
            return false;
        }
        if (GlassInfoExtKt.f(a2)) {
            if (GlassInfoExtKt.j(GlassInfoExtKt.c(GlassInfoExtKt.d(a2.getRomVersion())), str) < 0) {
                return false;
            }
        } else if (!GlassInfoExtKt.h(a2) && !GlassInfoExtKt.i(a2)) {
            return false;
        }
        return true;
    }

    public final boolean c(String str) {
        Intrinsics.checkNotNullParameter(str, "targetVersion");
        IGlassInfo a2 = SdkContext.f6675a.e().a();
        if (a2 == null || !DeviceUtils.d()) {
            return false;
        }
        String romVersion = a2.getRomVersion();
        ILog.a("VersionUtil", "isAirRomVersionAbove: 眼镜版本->" + romVersion);
        return GlassInfoExtKt.j(GlassInfoExtKt.c(GlassInfoExtKt.d(a2.getRomVersion())), str) >= 0;
    }
}

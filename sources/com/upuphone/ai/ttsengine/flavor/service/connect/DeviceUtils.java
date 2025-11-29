package com.upuphone.ai.ttsengine.flavor.service.connect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ai/ttsengine/flavor/service/connect/DeviceUtils;", "", "<init>", "()V", "", "id", "", "b", "(Ljava/lang/String;)V", "Ljava/lang/String;", "sModelId", "", "a", "()Z", "isStar", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DeviceUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final DeviceUtils f5567a = new DeviceUtils();
    public static volatile String b = "";

    public final boolean a() {
        return Intrinsics.areEqual((Object) "1002", (Object) b);
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        b = str;
    }
}

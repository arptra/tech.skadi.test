package com.upuphone.xr.sapp.monitor.schedule.config;

import com.upuphone.xr.sapp.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/config/ScheduleConfig;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/monitor/schedule/config/LarkType;", "a", "()Lcom/upuphone/xr/sapp/monitor/schedule/config/LarkType;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final ScheduleConfig f7785a = new ScheduleConfig();

    public final LarkType a() {
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        return bool.booleanValue() ? LarkType.XR_FS_THRID : LarkType.XR_FS_FLYME;
    }
}

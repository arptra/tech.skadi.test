package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.xr.sapp.entity.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\t\u0018\u00010\u0001¢\u0006\u0002\b\u00022\u000b\u0010\u0003\u001a\u00070\u0004¢\u0006\u0002\b\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassesDeviceInfoModel$version$1 extends Lambda implements Function1<DeviceInfo, String> {
    public static final VuGlassesDeviceInfoModel$version$1 INSTANCE = new VuGlassesDeviceInfoModel$version$1();

    public VuGlassesDeviceInfoModel$version$1() {
        super(1);
    }

    @Nullable
    public final String invoke(@NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "it");
        return deviceInfo.getRomVersion();
    }
}

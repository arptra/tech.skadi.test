package com.upuphone.xr.interconnect.inner;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.ResourceOperator;
import com.upuphone.xr.interconnect.resource.ResourceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u000eJ*\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J \u0010\u0014\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/interconnect/inner/InnerResourceOperator;", "Lcom/upuphone/xr/interconnect/api/ResourceOperator;", "()V", "manager", "Lcom/upuphone/xr/interconnect/resource/ResourceManager;", "kotlin.jvm.PlatformType", "getManager", "()Lcom/upuphone/xr/interconnect/resource/ResourceManager;", "getAvailability", "", "deviceId", "", "type", "identifier", "(Ljava/lang/String;BLjava/lang/String;)Ljava/lang/Byte;", "open", "", "targetDeviceId", "registerOpener", "taskExecutorName", "setAvailability", "available", "", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InnerResourceOperator implements ResourceOperator {
    private final ResourceManager getManager() {
        return InterconnectManager.getInstance().getResourceManager();
    }

    @NotNull
    public Byte getAvailability(@Nullable String str, byte b, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "identifier");
        return Byte.valueOf(getManager().getAvailability(str, b, str2));
    }

    public void open(@Nullable String str, @NotNull String str2, byte b, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str3, "identifier");
        getManager().openResource(str, str2, b, str3);
    }

    public void registerOpener(byte b, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "taskExecutorName");
        getManager().registerOpener(b, str);
    }

    public void setAvailability(byte b, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        getManager().setAvailability(b, str, z);
    }
}

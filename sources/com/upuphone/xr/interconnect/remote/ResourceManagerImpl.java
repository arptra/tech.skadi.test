package com.upuphone.xr.interconnect.remote;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IResourceManager;
import com.upuphone.xr.interconnect.resource.ResourceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/interconnect/remote/ResourceManagerImpl;", "Lcom/upuphone/xr/interconnect/common/IResourceManager$Stub;", "()V", "manager", "Lcom/upuphone/xr/interconnect/resource/ResourceManager;", "getManager", "()Lcom/upuphone/xr/interconnect/resource/ResourceManager;", "getAvailability", "", "deviceId", "", "type", "identifier", "open", "", "targetDeviceId", "registerOpener", "taskExecutorName", "setAvailability", "available", "", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ResourceManagerImpl extends IResourceManager.Stub {
    private final ResourceManager getManager() {
        ResourceManager resourceManager = InterconnectManager.getInstance().getResourceManager();
        Intrinsics.checkNotNullExpressionValue(resourceManager, "getResourceManager(...)");
        return resourceManager;
    }

    public byte getAvailability(@NotNull String str, byte b, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "identifier");
        return getManager().getAvailability(str, b, str2);
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

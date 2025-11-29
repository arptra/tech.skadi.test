package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/DeviceCompatInfo;", "", "appChannel", "", "appVersion", "appRegion", "deviceVersionList", "", "Lcom/upuphone/xr/sapp/entity/DeviceCompatConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAppChannel", "()Ljava/lang/String;", "getAppRegion", "getAppVersion", "getDeviceVersionList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class DeviceCompatInfo {
    @NotNull
    private final String appChannel;
    @NotNull
    private final String appRegion;
    @NotNull
    private final String appVersion;
    @Nullable
    private final List<DeviceCompatConfig> deviceVersionList;

    public DeviceCompatInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<DeviceCompatConfig> list) {
        Intrinsics.checkNotNullParameter(str, "appChannel");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(str3, "appRegion");
        this.appChannel = str;
        this.appVersion = str2;
        this.appRegion = str3;
        this.deviceVersionList = list;
    }

    public static /* synthetic */ DeviceCompatInfo copy$default(DeviceCompatInfo deviceCompatInfo, String str, String str2, String str3, List<DeviceCompatConfig> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceCompatInfo.appChannel;
        }
        if ((i & 2) != 0) {
            str2 = deviceCompatInfo.appVersion;
        }
        if ((i & 4) != 0) {
            str3 = deviceCompatInfo.appRegion;
        }
        if ((i & 8) != 0) {
            list = deviceCompatInfo.deviceVersionList;
        }
        return deviceCompatInfo.copy(str, str2, str3, list);
    }

    @NotNull
    public final String component1() {
        return this.appChannel;
    }

    @NotNull
    public final String component2() {
        return this.appVersion;
    }

    @NotNull
    public final String component3() {
        return this.appRegion;
    }

    @Nullable
    public final List<DeviceCompatConfig> component4() {
        return this.deviceVersionList;
    }

    @NotNull
    public final DeviceCompatInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<DeviceCompatConfig> list) {
        Intrinsics.checkNotNullParameter(str, "appChannel");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(str3, "appRegion");
        return new DeviceCompatInfo(str, str2, str3, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceCompatInfo)) {
            return false;
        }
        DeviceCompatInfo deviceCompatInfo = (DeviceCompatInfo) obj;
        return Intrinsics.areEqual((Object) this.appChannel, (Object) deviceCompatInfo.appChannel) && Intrinsics.areEqual((Object) this.appVersion, (Object) deviceCompatInfo.appVersion) && Intrinsics.areEqual((Object) this.appRegion, (Object) deviceCompatInfo.appRegion) && Intrinsics.areEqual((Object) this.deviceVersionList, (Object) deviceCompatInfo.deviceVersionList);
    }

    @NotNull
    public final String getAppChannel() {
        return this.appChannel;
    }

    @NotNull
    public final String getAppRegion() {
        return this.appRegion;
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    public final List<DeviceCompatConfig> getDeviceVersionList() {
        return this.deviceVersionList;
    }

    public int hashCode() {
        int hashCode = ((((this.appChannel.hashCode() * 31) + this.appVersion.hashCode()) * 31) + this.appRegion.hashCode()) * 31;
        List<DeviceCompatConfig> list = this.deviceVersionList;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.appChannel;
        String str2 = this.appVersion;
        String str3 = this.appRegion;
        List<DeviceCompatConfig> list = this.deviceVersionList;
        return "DeviceCompatInfo(appChannel=" + str + ", appVersion=" + str2 + ", appRegion=" + str3 + ", deviceVersionList=" + list + ")";
    }
}

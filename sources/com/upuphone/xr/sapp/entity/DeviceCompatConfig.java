package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JT\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/entity/DeviceCompatConfig;", "", "deviceType", "", "minDeviceVersion", "maxDeviceVersion", "deviceRegion", "upgradeModalStatus", "", "popLimit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDeviceRegion", "()Ljava/lang/String;", "getDeviceType", "getMaxDeviceVersion", "getMinDeviceVersion", "getPopLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUpgradeModalStatus", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/upuphone/xr/sapp/entity/DeviceCompatConfig;", "equals", "", "other", "hashCode", "toString", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class DeviceCompatConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int UPGRADE_STATUS_FORCE = 1;
    public static final int UPGRADE_STATUS_NOTICE = 2;
    @NotNull
    private final String deviceRegion;
    @Nullable
    private final String deviceType;
    @Nullable
    private final String maxDeviceVersion;
    @Nullable
    private final String minDeviceVersion;
    @Nullable
    private final Integer popLimit;
    @Nullable
    private final Integer upgradeModalStatus;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/entity/DeviceCompatConfig$Companion;", "", "()V", "UPGRADE_STATUS_FORCE", "", "UPGRADE_STATUS_NOTICE", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DeviceCompatConfig(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str4, "deviceRegion");
        this.deviceType = str;
        this.minDeviceVersion = str2;
        this.maxDeviceVersion = str3;
        this.deviceRegion = str4;
        this.upgradeModalStatus = num;
        this.popLimit = num2;
    }

    public static /* synthetic */ DeviceCompatConfig copy$default(DeviceCompatConfig deviceCompatConfig, String str, String str2, String str3, String str4, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceCompatConfig.deviceType;
        }
        if ((i & 2) != 0) {
            str2 = deviceCompatConfig.minDeviceVersion;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = deviceCompatConfig.maxDeviceVersion;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = deviceCompatConfig.deviceRegion;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            num = deviceCompatConfig.upgradeModalStatus;
        }
        Integer num3 = num;
        if ((i & 32) != 0) {
            num2 = deviceCompatConfig.popLimit;
        }
        return deviceCompatConfig.copy(str, str5, str6, str7, num3, num2);
    }

    @Nullable
    public final String component1() {
        return this.deviceType;
    }

    @Nullable
    public final String component2() {
        return this.minDeviceVersion;
    }

    @Nullable
    public final String component3() {
        return this.maxDeviceVersion;
    }

    @NotNull
    public final String component4() {
        return this.deviceRegion;
    }

    @Nullable
    public final Integer component5() {
        return this.upgradeModalStatus;
    }

    @Nullable
    public final Integer component6() {
        return this.popLimit;
    }

    @NotNull
    public final DeviceCompatConfig copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str4, "deviceRegion");
        return new DeviceCompatConfig(str, str2, str3, str4, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceCompatConfig)) {
            return false;
        }
        DeviceCompatConfig deviceCompatConfig = (DeviceCompatConfig) obj;
        return Intrinsics.areEqual((Object) this.deviceType, (Object) deviceCompatConfig.deviceType) && Intrinsics.areEqual((Object) this.minDeviceVersion, (Object) deviceCompatConfig.minDeviceVersion) && Intrinsics.areEqual((Object) this.maxDeviceVersion, (Object) deviceCompatConfig.maxDeviceVersion) && Intrinsics.areEqual((Object) this.deviceRegion, (Object) deviceCompatConfig.deviceRegion) && Intrinsics.areEqual((Object) this.upgradeModalStatus, (Object) deviceCompatConfig.upgradeModalStatus) && Intrinsics.areEqual((Object) this.popLimit, (Object) deviceCompatConfig.popLimit);
    }

    @NotNull
    public final String getDeviceRegion() {
        return this.deviceRegion;
    }

    @Nullable
    public final String getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    public final String getMaxDeviceVersion() {
        return this.maxDeviceVersion;
    }

    @Nullable
    public final String getMinDeviceVersion() {
        return this.minDeviceVersion;
    }

    @Nullable
    public final Integer getPopLimit() {
        return this.popLimit;
    }

    @Nullable
    public final Integer getUpgradeModalStatus() {
        return this.upgradeModalStatus;
    }

    public int hashCode() {
        String str = this.deviceType;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.minDeviceVersion;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.maxDeviceVersion;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.deviceRegion.hashCode()) * 31;
        Integer num = this.upgradeModalStatus;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.popLimit;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        String str = this.deviceType;
        String str2 = this.minDeviceVersion;
        String str3 = this.maxDeviceVersion;
        String str4 = this.deviceRegion;
        Integer num = this.upgradeModalStatus;
        Integer num2 = this.popLimit;
        return "DeviceCompatConfig(deviceType=" + str + ", minDeviceVersion=" + str2 + ", maxDeviceVersion=" + str3 + ", deviceRegion=" + str4 + ", upgradeModalStatus=" + num + ", popLimit=" + num2 + ")";
    }
}

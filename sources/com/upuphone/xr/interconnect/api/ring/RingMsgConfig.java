package com.upuphone.xr.interconnect.api.ring;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/interconnect/api/ring/RingMsgConfig;", "", "serviceData", "", "characteristic", "version", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCharacteristic", "()Ljava/lang/String;", "getServiceData", "getVersion", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RingMsgConfig {
    @NotNull
    private final String characteristic;
    @NotNull
    private final String serviceData;
    private final int version;

    public RingMsgConfig(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "serviceData");
        Intrinsics.checkNotNullParameter(str2, "characteristic");
        this.serviceData = str;
        this.characteristic = str2;
        this.version = i;
    }

    public static /* synthetic */ RingMsgConfig copy$default(RingMsgConfig ringMsgConfig, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = ringMsgConfig.serviceData;
        }
        if ((i2 & 2) != 0) {
            str2 = ringMsgConfig.characteristic;
        }
        if ((i2 & 4) != 0) {
            i = ringMsgConfig.version;
        }
        return ringMsgConfig.copy(str, str2, i);
    }

    @NotNull
    public final String component1() {
        return this.serviceData;
    }

    @NotNull
    public final String component2() {
        return this.characteristic;
    }

    public final int component3() {
        return this.version;
    }

    @NotNull
    public final RingMsgConfig copy(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "serviceData");
        Intrinsics.checkNotNullParameter(str2, "characteristic");
        return new RingMsgConfig(str, str2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RingMsgConfig)) {
            return false;
        }
        RingMsgConfig ringMsgConfig = (RingMsgConfig) obj;
        return Intrinsics.areEqual((Object) this.serviceData, (Object) ringMsgConfig.serviceData) && Intrinsics.areEqual((Object) this.characteristic, (Object) ringMsgConfig.characteristic) && this.version == ringMsgConfig.version;
    }

    @NotNull
    public final String getCharacteristic() {
        return this.characteristic;
    }

    @NotNull
    public final String getServiceData() {
        return this.serviceData;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((this.serviceData.hashCode() * 31) + this.characteristic.hashCode()) * 31) + Integer.hashCode(this.version);
    }

    @NotNull
    public String toString() {
        String str = this.serviceData;
        String str2 = this.characteristic;
        int i = this.version;
        return "RingMsgConfig(serviceData=" + str + ", characteristic=" + str2 + ", version=" + i + ")";
    }
}

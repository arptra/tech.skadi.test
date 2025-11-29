package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/PeerInfo;", "", "deviceId", "", "version", "", "(Ljava/lang/String;I)V", "getDeviceId", "()Ljava/lang/String;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PeerInfo {
    @NotNull
    private final String deviceId;
    private final int version;

    public PeerInfo(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        this.deviceId = str;
        this.version = i;
    }

    public static /* synthetic */ PeerInfo copy$default(PeerInfo peerInfo, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = peerInfo.deviceId;
        }
        if ((i2 & 2) != 0) {
            i = peerInfo.version;
        }
        return peerInfo.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.deviceId;
    }

    public final int component2() {
        return this.version;
    }

    @NotNull
    public final PeerInfo copy(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        return new PeerInfo(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PeerInfo)) {
            return false;
        }
        PeerInfo peerInfo = (PeerInfo) obj;
        return Intrinsics.areEqual((Object) this.deviceId, (Object) peerInfo.deviceId) && this.version == peerInfo.version;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + Integer.hashCode(this.version);
    }

    @NotNull
    public String toString() {
        String str = this.deviceId;
        int i = this.version;
        return "PeerInfo(deviceId=" + str + ", version=" + i + ")";
    }
}

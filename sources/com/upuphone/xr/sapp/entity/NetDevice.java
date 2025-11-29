package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003JI\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/upuphone/xr/sapp/entity/NetDevice;", "", "mIdentifier", "", "mDeviceName", "state", "Lcom/upuphone/xr/sapp/entity/ConnectState;", "fromModifyGlassName", "", "validTime", "", "modelID", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/ConnectState;ZJLjava/lang/String;)V", "getFromModifyGlassName", "()Z", "setFromModifyGlassName", "(Z)V", "getMDeviceName", "()Ljava/lang/String;", "getMIdentifier", "getModelID", "setModelID", "(Ljava/lang/String;)V", "getState", "()Lcom/upuphone/xr/sapp/entity/ConnectState;", "setState", "(Lcom/upuphone/xr/sapp/entity/ConnectState;)V", "getValidTime", "()J", "setValidTime", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class NetDevice {
    private boolean fromModifyGlassName;
    @Nullable
    private final String mDeviceName;
    @Nullable
    private final String mIdentifier;
    @NotNull
    private String modelID;
    @NotNull
    private ConnectState state;
    private long validTime;

    public NetDevice(@Nullable String str, @Nullable String str2, @NotNull ConnectState connectState, boolean z, long j, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(connectState, "state");
        Intrinsics.checkNotNullParameter(str3, "modelID");
        this.mIdentifier = str;
        this.mDeviceName = str2;
        this.state = connectState;
        this.fromModifyGlassName = z;
        this.validTime = j;
        this.modelID = str3;
    }

    public static /* synthetic */ NetDevice copy$default(NetDevice netDevice, String str, String str2, ConnectState connectState, boolean z, long j, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = netDevice.mIdentifier;
        }
        if ((i & 2) != 0) {
            str2 = netDevice.mDeviceName;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            connectState = netDevice.state;
        }
        ConnectState connectState2 = connectState;
        if ((i & 8) != 0) {
            z = netDevice.fromModifyGlassName;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            j = netDevice.validTime;
        }
        long j2 = j;
        if ((i & 32) != 0) {
            str3 = netDevice.modelID;
        }
        return netDevice.copy(str, str4, connectState2, z2, j2, str3);
    }

    @Nullable
    public final String component1() {
        return this.mIdentifier;
    }

    @Nullable
    public final String component2() {
        return this.mDeviceName;
    }

    @NotNull
    public final ConnectState component3() {
        return this.state;
    }

    public final boolean component4() {
        return this.fromModifyGlassName;
    }

    public final long component5() {
        return this.validTime;
    }

    @NotNull
    public final String component6() {
        return this.modelID;
    }

    @NotNull
    public final NetDevice copy(@Nullable String str, @Nullable String str2, @NotNull ConnectState connectState, boolean z, long j, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(connectState, "state");
        Intrinsics.checkNotNullParameter(str3, "modelID");
        return new NetDevice(str, str2, connectState, z, j, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetDevice)) {
            return false;
        }
        NetDevice netDevice = (NetDevice) obj;
        return Intrinsics.areEqual((Object) this.mIdentifier, (Object) netDevice.mIdentifier) && Intrinsics.areEqual((Object) this.mDeviceName, (Object) netDevice.mDeviceName) && this.state == netDevice.state && this.fromModifyGlassName == netDevice.fromModifyGlassName && this.validTime == netDevice.validTime && Intrinsics.areEqual((Object) this.modelID, (Object) netDevice.modelID);
    }

    public final boolean getFromModifyGlassName() {
        return this.fromModifyGlassName;
    }

    @Nullable
    public final String getMDeviceName() {
        return this.mDeviceName;
    }

    @Nullable
    public final String getMIdentifier() {
        return this.mIdentifier;
    }

    @NotNull
    public final String getModelID() {
        return this.modelID;
    }

    @NotNull
    public final ConnectState getState() {
        return this.state;
    }

    public final long getValidTime() {
        return this.validTime;
    }

    public int hashCode() {
        String str = this.mIdentifier;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.mDeviceName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((((hashCode + i) * 31) + this.state.hashCode()) * 31) + Boolean.hashCode(this.fromModifyGlassName)) * 31) + Long.hashCode(this.validTime)) * 31) + this.modelID.hashCode();
    }

    public final void setFromModifyGlassName(boolean z) {
        this.fromModifyGlassName = z;
    }

    public final void setModelID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelID = str;
    }

    public final void setState(@NotNull ConnectState connectState) {
        Intrinsics.checkNotNullParameter(connectState, "<set-?>");
        this.state = connectState;
    }

    public final void setValidTime(long j) {
        this.validTime = j;
    }

    @NotNull
    public String toString() {
        String str = this.mIdentifier;
        String str2 = this.mDeviceName;
        ConnectState connectState = this.state;
        boolean z = this.fromModifyGlassName;
        long j = this.validTime;
        String str3 = this.modelID;
        return "NetDevice(mIdentifier=" + str + ", mDeviceName=" + str2 + ", state=" + connectState + ", fromModifyGlassName=" + z + ", validTime=" + j + ", modelID=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetDevice(String str, String str2, ConnectState connectState, boolean z, long j, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? ConnectState.UNCONNECTED : connectState, (i & 8) != 0 ? false : z, (i & 16) != 0 ? 0 : j, (i & 32) != 0 ? "" : str3);
    }
}

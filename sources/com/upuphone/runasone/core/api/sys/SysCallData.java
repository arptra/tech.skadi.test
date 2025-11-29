package com.upuphone.runasone.core.api.sys;

import androidx.annotation.Keep;
import com.upuphone.runasone.device.StarryDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003JH\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/upuphone/runasone/core/api/sys/SysCallData;", "", "action", "", "callState", "phoneNum", "", "phoneBookState", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/upuphone/runasone/device/StarryDevice;)V", "getAction", "()I", "setAction", "(I)V", "getCallState", "()Ljava/lang/Integer;", "setCallState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDevice", "()Lcom/upuphone/runasone/device/StarryDevice;", "setDevice", "(Lcom/upuphone/runasone/device/StarryDevice;)V", "getPhoneBookState", "setPhoneBookState", "getPhoneNum", "()Ljava/lang/String;", "setPhoneNum", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/upuphone/runasone/device/StarryDevice;)Lcom/upuphone/runasone/core/api/sys/SysCallData;", "equals", "", "other", "hashCode", "toString", "core-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Keep
public final class SysCallData {
    private int action;
    @Nullable
    private Integer callState;
    @Nullable
    private StarryDevice device;
    @Nullable
    private Integer phoneBookState;
    @Nullable
    private String phoneNum;

    public SysCallData(int i, @Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable StarryDevice starryDevice) {
        this.action = i;
        this.callState = num;
        this.phoneNum = str;
        this.phoneBookState = num2;
        this.device = starryDevice;
    }

    public static /* synthetic */ SysCallData copy$default(SysCallData sysCallData, int i, Integer num, String str, Integer num2, StarryDevice starryDevice, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sysCallData.action;
        }
        if ((i2 & 2) != 0) {
            num = sysCallData.callState;
        }
        Integer num3 = num;
        if ((i2 & 4) != 0) {
            str = sysCallData.phoneNum;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            num2 = sysCallData.phoneBookState;
        }
        Integer num4 = num2;
        if ((i2 & 16) != 0) {
            starryDevice = sysCallData.device;
        }
        return sysCallData.copy(i, num3, str2, num4, starryDevice);
    }

    public final int component1() {
        return this.action;
    }

    @Nullable
    public final Integer component2() {
        return this.callState;
    }

    @Nullable
    public final String component3() {
        return this.phoneNum;
    }

    @Nullable
    public final Integer component4() {
        return this.phoneBookState;
    }

    @Nullable
    public final StarryDevice component5() {
        return this.device;
    }

    @NotNull
    public final SysCallData copy(int i, @Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable StarryDevice starryDevice) {
        return new SysCallData(i, num, str, num2, starryDevice);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SysCallData)) {
            return false;
        }
        SysCallData sysCallData = (SysCallData) obj;
        return this.action == sysCallData.action && Intrinsics.areEqual((Object) this.callState, (Object) sysCallData.callState) && Intrinsics.areEqual((Object) this.phoneNum, (Object) sysCallData.phoneNum) && Intrinsics.areEqual((Object) this.phoneBookState, (Object) sysCallData.phoneBookState) && Intrinsics.areEqual((Object) this.device, (Object) sysCallData.device);
    }

    public final int getAction() {
        return this.action;
    }

    @Nullable
    public final Integer getCallState() {
        return this.callState;
    }

    @Nullable
    public final StarryDevice getDevice() {
        return this.device;
    }

    @Nullable
    public final Integer getPhoneBookState() {
        return this.phoneBookState;
    }

    @Nullable
    public final String getPhoneNum() {
        return this.phoneNum;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.action) * 31;
        Integer num = this.callState;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.phoneNum;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.phoneBookState;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        StarryDevice starryDevice = this.device;
        if (starryDevice != null) {
            i = starryDevice.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setAction(int i) {
        this.action = i;
    }

    public final void setCallState(@Nullable Integer num) {
        this.callState = num;
    }

    public final void setDevice(@Nullable StarryDevice starryDevice) {
        this.device = starryDevice;
    }

    public final void setPhoneBookState(@Nullable Integer num) {
        this.phoneBookState = num;
    }

    public final void setPhoneNum(@Nullable String str) {
        this.phoneNum = str;
    }

    @NotNull
    public String toString() {
        return "SysCallData(action=" + this.action + ", callState=" + this.callState + ", phoneNum=" + this.phoneNum + ", phoneBookState=" + this.phoneBookState + ", device=" + this.device + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SysCallData(int i, Integer num, String str, Integer num2, StarryDevice starryDevice, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : starryDevice);
    }
}

package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J[\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u00065"}, d2 = {"Lcom/upuphone/xr/sapp/entity/DeviceState;", "", "state", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "errorCode", "time", "", "beaconId", "fromModifyGlassName", "", "validTime", "windowType", "(ILcom/upuphone/xr/interconnect/entity/StarryNetDevice;IJIZJI)V", "getBeaconId", "()I", "setBeaconId", "(I)V", "getDevice", "()Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "setDevice", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)V", "getErrorCode", "setErrorCode", "getFromModifyGlassName", "()Z", "setFromModifyGlassName", "(Z)V", "getState", "setState", "getTime", "()J", "setTime", "(J)V", "getValidTime", "setValidTime", "getWindowType", "setWindowType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class DeviceState {
    private int beaconId;
    @Nullable
    private StarryNetDevice device;
    private int errorCode;
    private boolean fromModifyGlassName;
    private int state;
    private long time;
    private long validTime;
    private int windowType;

    public DeviceState(int i, @Nullable StarryNetDevice starryNetDevice, int i2, long j, int i3, boolean z, long j2, int i4) {
        this.state = i;
        this.device = starryNetDevice;
        this.errorCode = i2;
        this.time = j;
        this.beaconId = i3;
        this.fromModifyGlassName = z;
        this.validTime = j2;
        this.windowType = i4;
    }

    public static /* synthetic */ DeviceState copy$default(DeviceState deviceState, int i, StarryNetDevice starryNetDevice, int i2, long j, int i3, boolean z, long j2, int i4, int i5, Object obj) {
        DeviceState deviceState2 = deviceState;
        int i6 = i5;
        return deviceState.copy((i6 & 1) != 0 ? deviceState2.state : i, (i6 & 2) != 0 ? deviceState2.device : starryNetDevice, (i6 & 4) != 0 ? deviceState2.errorCode : i2, (i6 & 8) != 0 ? deviceState2.time : j, (i6 & 16) != 0 ? deviceState2.beaconId : i3, (i6 & 32) != 0 ? deviceState2.fromModifyGlassName : z, (i6 & 64) != 0 ? deviceState2.validTime : j2, (i6 & 128) != 0 ? deviceState2.windowType : i4);
    }

    public final int component1() {
        return this.state;
    }

    @Nullable
    public final StarryNetDevice component2() {
        return this.device;
    }

    public final int component3() {
        return this.errorCode;
    }

    public final long component4() {
        return this.time;
    }

    public final int component5() {
        return this.beaconId;
    }

    public final boolean component6() {
        return this.fromModifyGlassName;
    }

    public final long component7() {
        return this.validTime;
    }

    public final int component8() {
        return this.windowType;
    }

    @NotNull
    public final DeviceState copy(int i, @Nullable StarryNetDevice starryNetDevice, int i2, long j, int i3, boolean z, long j2, int i4) {
        return new DeviceState(i, starryNetDevice, i2, j, i3, z, j2, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceState)) {
            return false;
        }
        DeviceState deviceState = (DeviceState) obj;
        return this.state == deviceState.state && Intrinsics.areEqual((Object) this.device, (Object) deviceState.device) && this.errorCode == deviceState.errorCode && this.time == deviceState.time && this.beaconId == deviceState.beaconId && this.fromModifyGlassName == deviceState.fromModifyGlassName && this.validTime == deviceState.validTime && this.windowType == deviceState.windowType;
    }

    public final int getBeaconId() {
        return this.beaconId;
    }

    @Nullable
    public final StarryNetDevice getDevice() {
        return this.device;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final boolean getFromModifyGlassName() {
        return this.fromModifyGlassName;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTime() {
        return this.time;
    }

    public final long getValidTime() {
        return this.validTime;
    }

    public final int getWindowType() {
        return this.windowType;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.state) * 31;
        StarryNetDevice starryNetDevice = this.device;
        return ((((((((((((hashCode + (starryNetDevice == null ? 0 : starryNetDevice.hashCode())) * 31) + Integer.hashCode(this.errorCode)) * 31) + Long.hashCode(this.time)) * 31) + Integer.hashCode(this.beaconId)) * 31) + Boolean.hashCode(this.fromModifyGlassName)) * 31) + Long.hashCode(this.validTime)) * 31) + Integer.hashCode(this.windowType);
    }

    public final void setBeaconId(int i) {
        this.beaconId = i;
    }

    public final void setDevice(@Nullable StarryNetDevice starryNetDevice) {
        this.device = starryNetDevice;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final void setFromModifyGlassName(boolean z) {
        this.fromModifyGlassName = z;
    }

    public final void setState(int i) {
        this.state = i;
    }

    public final void setTime(long j) {
        this.time = j;
    }

    public final void setValidTime(long j) {
        this.validTime = j;
    }

    public final void setWindowType(int i) {
        this.windowType = i;
    }

    @NotNull
    public String toString() {
        int i = this.state;
        StarryNetDevice starryNetDevice = this.device;
        int i2 = this.errorCode;
        long j = this.time;
        int i3 = this.beaconId;
        boolean z = this.fromModifyGlassName;
        long j2 = this.validTime;
        int i4 = this.windowType;
        return "DeviceState(state=" + i + ", device=" + starryNetDevice + ", errorCode=" + i2 + ", time=" + j + ", beaconId=" + i3 + ", fromModifyGlassName=" + z + ", validTime=" + j2 + ", windowType=" + i4 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceState(int r16, com.upuphone.xr.interconnect.entity.StarryNetDevice r17, int r18, long r19, int r21, boolean r22, long r23, int r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r15 = this;
            r0 = r26
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r8 = r2
            goto L_0x000c
        L_0x000a:
            r8 = r19
        L_0x000c:
            r1 = r0 & 16
            r4 = 0
            if (r1 == 0) goto L_0x0013
            r10 = r4
            goto L_0x0015
        L_0x0013:
            r10 = r21
        L_0x0015:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001b
            r11 = r4
            goto L_0x001d
        L_0x001b:
            r11 = r22
        L_0x001d:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0023
            r12 = r2
            goto L_0x0025
        L_0x0023:
            r12 = r23
        L_0x0025:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002c
            r0 = -1
            r14 = r0
            goto L_0x002e
        L_0x002c:
            r14 = r25
        L_0x002e:
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r4.<init>(r5, r6, r7, r8, r10, r11, r12, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.entity.DeviceState.<init>(int, com.upuphone.xr.interconnect.entity.StarryNetDevice, int, long, int, boolean, long, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/entity/BatteryInfo;", "Landroid/os/Parcelable;", "batteryCapacity", "", "charging", "", "(IZ)V", "getBatteryCapacity", "()I", "setBatteryCapacity", "(I)V", "getCharging", "()Z", "component1", "component2", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class BatteryInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<BatteryInfo> CREATOR = new Creator();
    private int batteryCapacity;
    private final boolean charging;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BatteryInfo> {
        @NotNull
        public final BatteryInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BatteryInfo(parcel.readInt(), parcel.readInt() != 0);
        }

        @NotNull
        public final BatteryInfo[] newArray(int i) {
            return new BatteryInfo[i];
        }
    }

    public BatteryInfo(int i, boolean z) {
        this.batteryCapacity = i;
        this.charging = z;
    }

    public static /* synthetic */ BatteryInfo copy$default(BatteryInfo batteryInfo, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = batteryInfo.batteryCapacity;
        }
        if ((i2 & 2) != 0) {
            z = batteryInfo.charging;
        }
        return batteryInfo.copy(i, z);
    }

    public final int component1() {
        return this.batteryCapacity;
    }

    public final boolean component2() {
        return this.charging;
    }

    @NotNull
    public final BatteryInfo copy(int i, boolean z) {
        return new BatteryInfo(i, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BatteryInfo)) {
            return false;
        }
        BatteryInfo batteryInfo = (BatteryInfo) obj;
        return this.batteryCapacity == batteryInfo.batteryCapacity && this.charging == batteryInfo.charging;
    }

    public final int getBatteryCapacity() {
        return this.batteryCapacity;
    }

    public final boolean getCharging() {
        return this.charging;
    }

    public int hashCode() {
        return (Integer.hashCode(this.batteryCapacity) * 31) + Boolean.hashCode(this.charging);
    }

    public final void setBatteryCapacity(int i) {
        this.batteryCapacity = i;
    }

    @NotNull
    public String toString() {
        int i = this.batteryCapacity;
        boolean z = this.charging;
        return "BatteryInfo(batteryCapacity=" + i + ", charging=" + z + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.batteryCapacity);
        parcel.writeInt(this.charging ? 1 : 0);
    }
}

package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassBatteryInfo;", "Landroid/os/Parcelable;", "battery", "", "isCharging", "", "(IZ)V", "getBattery", "()I", "()Z", "component1", "component2", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class GlassBatteryInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<GlassBatteryInfo> CREATOR = new Creator();
    private final int battery;
    private final boolean isCharging;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GlassBatteryInfo> {
        @NotNull
        public final GlassBatteryInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GlassBatteryInfo(parcel.readInt(), parcel.readInt() != 0);
        }

        @NotNull
        public final GlassBatteryInfo[] newArray(int i) {
            return new GlassBatteryInfo[i];
        }
    }

    public GlassBatteryInfo(int i, boolean z) {
        this.battery = i;
        this.isCharging = z;
    }

    public static /* synthetic */ GlassBatteryInfo copy$default(GlassBatteryInfo glassBatteryInfo, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = glassBatteryInfo.battery;
        }
        if ((i2 & 2) != 0) {
            z = glassBatteryInfo.isCharging;
        }
        return glassBatteryInfo.copy(i, z);
    }

    public final int component1() {
        return this.battery;
    }

    public final boolean component2() {
        return this.isCharging;
    }

    @NotNull
    public final GlassBatteryInfo copy(int i, boolean z) {
        return new GlassBatteryInfo(i, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassBatteryInfo)) {
            return false;
        }
        GlassBatteryInfo glassBatteryInfo = (GlassBatteryInfo) obj;
        return this.battery == glassBatteryInfo.battery && this.isCharging == glassBatteryInfo.isCharging;
    }

    public final int getBattery() {
        return this.battery;
    }

    public int hashCode() {
        return (Integer.hashCode(this.battery) * 31) + Boolean.hashCode(this.isCharging);
    }

    public final boolean isCharging() {
        return this.isCharging;
    }

    @NotNull
    public String toString() {
        int i = this.battery;
        boolean z = this.isCharging;
        return "GlassBatteryInfo(battery=" + i + ", isCharging=" + z + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.battery);
        parcel.writeInt(this.isCharging ? 1 : 0);
    }
}

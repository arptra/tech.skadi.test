package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lcom/upuphone/xr/sapp/entity/UnicronBatteryInfo;", "Landroid/os/Parcelable;", "capacity", "", "isConnect", "", "devName", "", "bound", "bluetooth", "mouseState", "(IZLjava/lang/String;ZLjava/lang/String;Z)V", "getBluetooth", "()Ljava/lang/String;", "getBound", "()Z", "getCapacity", "()I", "getDevName", "setDevName", "(Ljava/lang/String;)V", "getMouseState", "setMouseState", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class UnicronBatteryInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<UnicronBatteryInfo> CREATOR = new Creator();
    @NotNull
    private final String bluetooth;
    private final boolean bound;
    private final int capacity;
    @NotNull
    private String devName;
    private final boolean isConnect;
    private boolean mouseState;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UnicronBatteryInfo> {
        @NotNull
        public final UnicronBatteryInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UnicronBatteryInfo(parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0);
        }

        @NotNull
        public final UnicronBatteryInfo[] newArray(int i) {
            return new UnicronBatteryInfo[i];
        }
    }

    public UnicronBatteryInfo() {
        this(0, false, (String) null, false, (String) null, false, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UnicronBatteryInfo copy$default(UnicronBatteryInfo unicronBatteryInfo, int i, boolean z, String str, boolean z2, String str2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = unicronBatteryInfo.capacity;
        }
        if ((i2 & 2) != 0) {
            z = unicronBatteryInfo.isConnect;
        }
        boolean z4 = z;
        if ((i2 & 4) != 0) {
            str = unicronBatteryInfo.devName;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            z2 = unicronBatteryInfo.bound;
        }
        boolean z5 = z2;
        if ((i2 & 16) != 0) {
            str2 = unicronBatteryInfo.bluetooth;
        }
        String str4 = str2;
        if ((i2 & 32) != 0) {
            z3 = unicronBatteryInfo.mouseState;
        }
        return unicronBatteryInfo.copy(i, z4, str3, z5, str4, z3);
    }

    public final int component1() {
        return this.capacity;
    }

    public final boolean component2() {
        return this.isConnect;
    }

    @NotNull
    public final String component3() {
        return this.devName;
    }

    public final boolean component4() {
        return this.bound;
    }

    @NotNull
    public final String component5() {
        return this.bluetooth;
    }

    public final boolean component6() {
        return this.mouseState;
    }

    @NotNull
    public final UnicronBatteryInfo copy(int i, boolean z, @NotNull String str, boolean z2, @NotNull String str2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "devName");
        Intrinsics.checkNotNullParameter(str2, "bluetooth");
        return new UnicronBatteryInfo(i, z, str, z2, str2, z3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnicronBatteryInfo)) {
            return false;
        }
        UnicronBatteryInfo unicronBatteryInfo = (UnicronBatteryInfo) obj;
        return this.capacity == unicronBatteryInfo.capacity && this.isConnect == unicronBatteryInfo.isConnect && Intrinsics.areEqual((Object) this.devName, (Object) unicronBatteryInfo.devName) && this.bound == unicronBatteryInfo.bound && Intrinsics.areEqual((Object) this.bluetooth, (Object) unicronBatteryInfo.bluetooth) && this.mouseState == unicronBatteryInfo.mouseState;
    }

    @NotNull
    public final String getBluetooth() {
        return this.bluetooth;
    }

    public final boolean getBound() {
        return this.bound;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @NotNull
    public final String getDevName() {
        return this.devName;
    }

    public final boolean getMouseState() {
        return this.mouseState;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.capacity) * 31) + Boolean.hashCode(this.isConnect)) * 31) + this.devName.hashCode()) * 31) + Boolean.hashCode(this.bound)) * 31) + this.bluetooth.hashCode()) * 31) + Boolean.hashCode(this.mouseState);
    }

    public final boolean isConnect() {
        return this.isConnect;
    }

    public final void setDevName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.devName = str;
    }

    public final void setMouseState(boolean z) {
        this.mouseState = z;
    }

    @NotNull
    public String toString() {
        int i = this.capacity;
        boolean z = this.isConnect;
        String str = this.devName;
        boolean z2 = this.bound;
        String str2 = this.bluetooth;
        boolean z3 = this.mouseState;
        return "UnicronBatteryInfo(capacity=" + i + ", isConnect=" + z + ", devName=" + str + ", bound=" + z2 + ", bluetooth=" + str2 + ", mouseState=" + z3 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.capacity);
        parcel.writeInt(this.isConnect ? 1 : 0);
        parcel.writeString(this.devName);
        parcel.writeInt(this.bound ? 1 : 0);
        parcel.writeString(this.bluetooth);
        parcel.writeInt(this.mouseState ? 1 : 0);
    }

    public UnicronBatteryInfo(int i, boolean z, @NotNull String str, boolean z2, @NotNull String str2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "devName");
        Intrinsics.checkNotNullParameter(str2, "bluetooth");
        this.capacity = i;
        this.isConnect = z;
        this.devName = str;
        this.bound = z2;
        this.bluetooth = str2;
        this.mouseState = z3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnicronBatteryInfo(int i, boolean z, String str, boolean z2, String str2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? false : z3);
    }
}

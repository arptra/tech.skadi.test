package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.upuphone.runasone.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "Landroid/os/Parcelable;", "deviceId", "", "model", "version", "battery", "", "sn", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBattery", "()I", "getDeviceId", "()Ljava/lang/String;", "getModel", "getSn", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class UnicronInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<UnicronInfo> CREATOR = new Creator();
    private final int battery;
    @NotNull
    private final String deviceId;
    @NotNull
    private final String model;
    @Nullable
    private final String sn;
    @NotNull
    private final String version;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UnicronInfo> {
        @NotNull
        public final UnicronInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UnicronInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @NotNull
        public final UnicronInfo[] newArray(int i) {
            return new UnicronInfo[i];
        }
    }

    public UnicronInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "model");
        Intrinsics.checkNotNullParameter(str3, "version");
        this.deviceId = str;
        this.model = str2;
        this.version = str3;
        this.battery = i;
        this.sn = str4;
    }

    public static /* synthetic */ UnicronInfo copy$default(UnicronInfo unicronInfo, String str, String str2, String str3, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = unicronInfo.deviceId;
        }
        if ((i2 & 2) != 0) {
            str2 = unicronInfo.model;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = unicronInfo.version;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            i = unicronInfo.battery;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str4 = unicronInfo.sn;
        }
        return unicronInfo.copy(str, str5, str6, i3, str4);
    }

    @NotNull
    public final String component1() {
        return this.deviceId;
    }

    @NotNull
    public final String component2() {
        return this.model;
    }

    @NotNull
    public final String component3() {
        return this.version;
    }

    public final int component4() {
        return this.battery;
    }

    @Nullable
    public final String component5() {
        return this.sn;
    }

    @NotNull
    public final UnicronInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "model");
        Intrinsics.checkNotNullParameter(str3, "version");
        return new UnicronInfo(str, str2, str3, i, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnicronInfo)) {
            return false;
        }
        UnicronInfo unicronInfo = (UnicronInfo) obj;
        return Intrinsics.areEqual((Object) this.deviceId, (Object) unicronInfo.deviceId) && Intrinsics.areEqual((Object) this.model, (Object) unicronInfo.model) && Intrinsics.areEqual((Object) this.version, (Object) unicronInfo.version) && this.battery == unicronInfo.battery && Intrinsics.areEqual((Object) this.sn, (Object) unicronInfo.sn);
    }

    public final int getBattery() {
        return this.battery;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @Nullable
    public final String getSn() {
        return this.sn;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = ((((((this.deviceId.hashCode() * 31) + this.model.hashCode()) * 31) + this.version.hashCode()) * 31) + Integer.hashCode(this.battery)) * 31;
        String str = this.sn;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.deviceId;
        String str2 = this.model;
        String str3 = this.version;
        int i = this.battery;
        String str4 = this.sn;
        return "UnicronInfo(deviceId=" + str + ", model=" + str2 + ", version=" + str3 + ", battery=" + i + ", sn=" + str4 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.deviceId);
        parcel.writeString(this.model);
        parcel.writeString(this.version);
        parcel.writeInt(this.battery);
        parcel.writeString(this.sn);
    }
}

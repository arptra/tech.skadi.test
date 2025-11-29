package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassWifiValidInfo;", "Landroid/os/Parcelable;", "networkValid", "", "ssid", "", "(ZLjava/lang/String;)V", "getNetworkValid", "()Z", "setNetworkValid", "(Z)V", "getSsid", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class GlassWifiValidInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<GlassWifiValidInfo> CREATOR = new Creator();
    private boolean networkValid;
    @NotNull
    private final String ssid;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GlassWifiValidInfo> {
        @NotNull
        public final GlassWifiValidInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GlassWifiValidInfo(parcel.readInt() != 0, parcel.readString());
        }

        @NotNull
        public final GlassWifiValidInfo[] newArray(int i) {
            return new GlassWifiValidInfo[i];
        }
    }

    public GlassWifiValidInfo(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        this.networkValid = z;
        this.ssid = str;
    }

    public static /* synthetic */ GlassWifiValidInfo copy$default(GlassWifiValidInfo glassWifiValidInfo, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = glassWifiValidInfo.networkValid;
        }
        if ((i & 2) != 0) {
            str = glassWifiValidInfo.ssid;
        }
        return glassWifiValidInfo.copy(z, str);
    }

    public final boolean component1() {
        return this.networkValid;
    }

    @NotNull
    public final String component2() {
        return this.ssid;
    }

    @NotNull
    public final GlassWifiValidInfo copy(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        return new GlassWifiValidInfo(z, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassWifiValidInfo)) {
            return false;
        }
        GlassWifiValidInfo glassWifiValidInfo = (GlassWifiValidInfo) obj;
        return this.networkValid == glassWifiValidInfo.networkValid && Intrinsics.areEqual((Object) this.ssid, (Object) glassWifiValidInfo.ssid);
    }

    public final boolean getNetworkValid() {
        return this.networkValid;
    }

    @NotNull
    public final String getSsid() {
        return this.ssid;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.networkValid) * 31) + this.ssid.hashCode();
    }

    public final void setNetworkValid(boolean z) {
        this.networkValid = z;
    }

    @NotNull
    public String toString() {
        boolean z = this.networkValid;
        String str = this.ssid;
        return "GlassWifiValidInfo(networkValid=" + z + ", ssid='" + str + "')";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.networkValid ? 1 : 0);
        parcel.writeString(this.ssid);
    }
}

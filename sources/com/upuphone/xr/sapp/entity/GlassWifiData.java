package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassWifiData;", "", "wifiState", "", "ssid", "", "bssid", "(ZLjava/lang/String;Ljava/lang/String;)V", "getBssid", "()Ljava/lang/String;", "setBssid", "(Ljava/lang/String;)V", "getSsid", "setSsid", "getWifiState", "()Z", "setWifiState", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassWifiData {
    @SerializedName("bssid")
    @NotNull
    private String bssid;
    @SerializedName("ssid")
    @NotNull
    private String ssid;
    @SerializedName("is_wifi_enable")
    private boolean wifiState;

    public GlassWifiData(boolean z, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        Intrinsics.checkNotNullParameter(str2, "bssid");
        this.wifiState = z;
        this.ssid = str;
        this.bssid = str2;
    }

    public static /* synthetic */ GlassWifiData copy$default(GlassWifiData glassWifiData, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = glassWifiData.wifiState;
        }
        if ((i & 2) != 0) {
            str = glassWifiData.ssid;
        }
        if ((i & 4) != 0) {
            str2 = glassWifiData.bssid;
        }
        return glassWifiData.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.wifiState;
    }

    @NotNull
    public final String component2() {
        return this.ssid;
    }

    @NotNull
    public final String component3() {
        return this.bssid;
    }

    @NotNull
    public final GlassWifiData copy(boolean z, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        Intrinsics.checkNotNullParameter(str2, "bssid");
        return new GlassWifiData(z, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassWifiData)) {
            return false;
        }
        GlassWifiData glassWifiData = (GlassWifiData) obj;
        return this.wifiState == glassWifiData.wifiState && Intrinsics.areEqual((Object) this.ssid, (Object) glassWifiData.ssid) && Intrinsics.areEqual((Object) this.bssid, (Object) glassWifiData.bssid);
    }

    @NotNull
    public final String getBssid() {
        return this.bssid;
    }

    @NotNull
    public final String getSsid() {
        return this.ssid;
    }

    public final boolean getWifiState() {
        return this.wifiState;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.wifiState) * 31) + this.ssid.hashCode()) * 31) + this.bssid.hashCode();
    }

    public final void setBssid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bssid = str;
    }

    public final void setSsid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ssid = str;
    }

    public final void setWifiState(boolean z) {
        this.wifiState = z;
    }

    @NotNull
    public String toString() {
        boolean z = this.wifiState;
        String str = this.ssid;
        String str2 = this.bssid;
        return "GlassWifiData(wifiState=" + z + ", ssid=" + str + ", bssid=" + str2 + ")";
    }
}

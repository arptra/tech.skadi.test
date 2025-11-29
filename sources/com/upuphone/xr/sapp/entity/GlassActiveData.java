package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003JY\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010¨\u0006/"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassActiveData;", "", "duration", "", "ip", "", "model", "other", "romVersion", "romVersionOld", "sn", "timestamp", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getDuration", "()J", "setDuration", "(J)V", "getIp", "()Ljava/lang/String;", "setIp", "(Ljava/lang/String;)V", "getModel", "setModel", "getOther", "setOther", "getRomVersion", "setRomVersion", "getRomVersionOld", "setRomVersionOld", "getSn", "setSn", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassActiveData {
    @SerializedName("duration")
    private long duration;
    @SerializedName("ip")
    @NotNull
    private String ip;
    @SerializedName("model")
    @NotNull
    private String model;
    @SerializedName("other")
    @NotNull
    private String other;
    @SerializedName("rom_version")
    @NotNull
    private String romVersion;
    @SerializedName("romversion")
    @NotNull
    private String romVersionOld;
    @SerializedName("sn")
    @NotNull
    private String sn;
    @SerializedName("timestamp")
    private long timestamp;

    public GlassActiveData(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j2) {
        Intrinsics.checkNotNullParameter(str, "ip");
        Intrinsics.checkNotNullParameter(str2, "model");
        Intrinsics.checkNotNullParameter(str3, "other");
        Intrinsics.checkNotNullParameter(str4, "romVersion");
        Intrinsics.checkNotNullParameter(str5, "romVersionOld");
        Intrinsics.checkNotNullParameter(str6, PayloadConstant.PARAMS_KEY_STR_SN);
        this.duration = j;
        this.ip = str;
        this.model = str2;
        this.other = str3;
        this.romVersion = str4;
        this.romVersionOld = str5;
        this.sn = str6;
        this.timestamp = j2;
    }

    public static /* synthetic */ GlassActiveData copy$default(GlassActiveData glassActiveData, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, int i, Object obj) {
        GlassActiveData glassActiveData2 = glassActiveData;
        int i2 = i;
        return glassActiveData.copy((i2 & 1) != 0 ? glassActiveData2.duration : j, (i2 & 2) != 0 ? glassActiveData2.ip : str, (i2 & 4) != 0 ? glassActiveData2.model : str2, (i2 & 8) != 0 ? glassActiveData2.other : str3, (i2 & 16) != 0 ? glassActiveData2.romVersion : str4, (i2 & 32) != 0 ? glassActiveData2.romVersionOld : str5, (i2 & 64) != 0 ? glassActiveData2.sn : str6, (i2 & 128) != 0 ? glassActiveData2.timestamp : j2);
    }

    public final long component1() {
        return this.duration;
    }

    @NotNull
    public final String component2() {
        return this.ip;
    }

    @NotNull
    public final String component3() {
        return this.model;
    }

    @NotNull
    public final String component4() {
        return this.other;
    }

    @NotNull
    public final String component5() {
        return this.romVersion;
    }

    @NotNull
    public final String component6() {
        return this.romVersionOld;
    }

    @NotNull
    public final String component7() {
        return this.sn;
    }

    public final long component8() {
        return this.timestamp;
    }

    @NotNull
    public final GlassActiveData copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j2) {
        Intrinsics.checkNotNullParameter(str, "ip");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "model");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "other");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "romVersion");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "romVersionOld");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, PayloadConstant.PARAMS_KEY_STR_SN);
        return new GlassActiveData(j, str, str7, str8, str9, str10, str11, j2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassActiveData)) {
            return false;
        }
        GlassActiveData glassActiveData = (GlassActiveData) obj;
        return this.duration == glassActiveData.duration && Intrinsics.areEqual((Object) this.ip, (Object) glassActiveData.ip) && Intrinsics.areEqual((Object) this.model, (Object) glassActiveData.model) && Intrinsics.areEqual((Object) this.other, (Object) glassActiveData.other) && Intrinsics.areEqual((Object) this.romVersion, (Object) glassActiveData.romVersion) && Intrinsics.areEqual((Object) this.romVersionOld, (Object) glassActiveData.romVersionOld) && Intrinsics.areEqual((Object) this.sn, (Object) glassActiveData.sn) && this.timestamp == glassActiveData.timestamp;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getIp() {
        return this.ip;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final String getOther() {
        return this.other;
    }

    @NotNull
    public final String getRomVersion() {
        return this.romVersion;
    }

    @NotNull
    public final String getRomVersionOld() {
        return this.romVersionOld;
    }

    @NotNull
    public final String getSn() {
        return this.sn;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.duration) * 31) + this.ip.hashCode()) * 31) + this.model.hashCode()) * 31) + this.other.hashCode()) * 31) + this.romVersion.hashCode()) * 31) + this.romVersionOld.hashCode()) * 31) + this.sn.hashCode()) * 31) + Long.hashCode(this.timestamp);
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final void setIp(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ip = str;
    }

    public final void setModel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.model = str;
    }

    public final void setOther(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.other = str;
    }

    public final void setRomVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.romVersion = str;
    }

    public final void setRomVersionOld(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.romVersionOld = str;
    }

    public final void setSn(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sn = str;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    @NotNull
    public String toString() {
        long j = this.duration;
        String str = this.ip;
        String str2 = this.model;
        String str3 = this.other;
        String str4 = this.romVersion;
        String str5 = this.romVersionOld;
        String str6 = this.sn;
        long j2 = this.timestamp;
        return "GlassActiveData(duration=" + j + ", ip=" + str + ", model=" + str2 + ", other=" + str3 + ", romVersion=" + str4 + ", romVersionOld=" + str5 + ", sn=" + str6 + ", timestamp=" + j2 + ")";
    }
}

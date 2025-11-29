package com.upuphone.star.fota.phone;

import androidx.annotation.Keep;
import com.upuphone.runasone.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\b\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0010HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0010HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015¨\u00069"}, d2 = {"Lcom/upuphone/star/fota/phone/GlassUpdateResultParam;", "", "deviceType", "", "deviceModel", "deviceId", "tid", "originVersion", "version", "otaStartTime", "", "otaEndTime", "otaFailDetail", "phoneModel", "phoneBrand", "status", "", "deviceIdEncrypted", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceIdEncrypted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDeviceModel", "getDeviceType", "getOriginVersion", "getOtaEndTime", "()J", "getOtaFailDetail", "getOtaStartTime", "getPhoneBrand", "getPhoneModel", "getStatus", "()I", "getTid", "getVersion", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;)Lcom/upuphone/star/fota/phone/GlassUpdateResultParam;", "equals", "other", "hashCode", "toString", "ar-fota-lib_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassUpdateResultParam {
    @NotNull
    private final String deviceId;
    @Nullable
    private final Boolean deviceIdEncrypted;
    @NotNull
    private final String deviceModel;
    @NotNull
    private final String deviceType;
    @NotNull
    private final String originVersion;
    private final long otaEndTime;
    @NotNull
    private final String otaFailDetail;
    private final long otaStartTime;
    @NotNull
    private final String phoneBrand;
    @NotNull
    private final String phoneModel;
    private final int status;
    @NotNull
    private final String tid;
    @NotNull
    private final String version;

    public GlassUpdateResultParam(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j, long j2, @NotNull String str7, @NotNull String str8, @NotNull String str9, int i, @Nullable Boolean bool) {
        String str10 = str5;
        String str11 = str6;
        String str12 = str7;
        String str13 = str8;
        String str14 = str9;
        Intrinsics.checkNotNullParameter(str, "deviceType");
        Intrinsics.checkNotNullParameter(str2, "deviceModel");
        Intrinsics.checkNotNullParameter(str3, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str4, "tid");
        Intrinsics.checkNotNullParameter(str10, "originVersion");
        Intrinsics.checkNotNullParameter(str11, "version");
        Intrinsics.checkNotNullParameter(str12, "otaFailDetail");
        Intrinsics.checkNotNullParameter(str13, "phoneModel");
        Intrinsics.checkNotNullParameter(str14, "phoneBrand");
        this.deviceType = str;
        this.deviceModel = str2;
        this.deviceId = str3;
        this.tid = str4;
        this.originVersion = str10;
        this.version = str11;
        this.otaStartTime = j;
        this.otaEndTime = j2;
        this.otaFailDetail = str12;
        this.phoneModel = str13;
        this.phoneBrand = str14;
        this.status = i;
        this.deviceIdEncrypted = bool;
    }

    public static /* synthetic */ GlassUpdateResultParam copy$default(GlassUpdateResultParam glassUpdateResultParam, String str, String str2, String str3, String str4, String str5, String str6, long j, long j2, String str7, String str8, String str9, int i, Boolean bool, int i2, Object obj) {
        GlassUpdateResultParam glassUpdateResultParam2 = glassUpdateResultParam;
        int i3 = i2;
        return glassUpdateResultParam.copy((i3 & 1) != 0 ? glassUpdateResultParam2.deviceType : str, (i3 & 2) != 0 ? glassUpdateResultParam2.deviceModel : str2, (i3 & 4) != 0 ? glassUpdateResultParam2.deviceId : str3, (i3 & 8) != 0 ? glassUpdateResultParam2.tid : str4, (i3 & 16) != 0 ? glassUpdateResultParam2.originVersion : str5, (i3 & 32) != 0 ? glassUpdateResultParam2.version : str6, (i3 & 64) != 0 ? glassUpdateResultParam2.otaStartTime : j, (i3 & 128) != 0 ? glassUpdateResultParam2.otaEndTime : j2, (i3 & 256) != 0 ? glassUpdateResultParam2.otaFailDetail : str7, (i3 & 512) != 0 ? glassUpdateResultParam2.phoneModel : str8, (i3 & 1024) != 0 ? glassUpdateResultParam2.phoneBrand : str9, (i3 & 2048) != 0 ? glassUpdateResultParam2.status : i, (i3 & 4096) != 0 ? glassUpdateResultParam2.deviceIdEncrypted : bool);
    }

    @NotNull
    public final String component1() {
        return this.deviceType;
    }

    @NotNull
    public final String component10() {
        return this.phoneModel;
    }

    @NotNull
    public final String component11() {
        return this.phoneBrand;
    }

    public final int component12() {
        return this.status;
    }

    @Nullable
    public final Boolean component13() {
        return this.deviceIdEncrypted;
    }

    @NotNull
    public final String component2() {
        return this.deviceModel;
    }

    @NotNull
    public final String component3() {
        return this.deviceId;
    }

    @NotNull
    public final String component4() {
        return this.tid;
    }

    @NotNull
    public final String component5() {
        return this.originVersion;
    }

    @NotNull
    public final String component6() {
        return this.version;
    }

    public final long component7() {
        return this.otaStartTime;
    }

    public final long component8() {
        return this.otaEndTime;
    }

    @NotNull
    public final String component9() {
        return this.otaFailDetail;
    }

    @NotNull
    public final GlassUpdateResultParam copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j, long j2, @NotNull String str7, @NotNull String str8, @NotNull String str9, int i, @Nullable Boolean bool) {
        String str10 = str;
        Intrinsics.checkNotNullParameter(str10, "deviceType");
        String str11 = str2;
        Intrinsics.checkNotNullParameter(str11, "deviceModel");
        String str12 = str3;
        Intrinsics.checkNotNullParameter(str12, Constants.DEVICE_ID);
        String str13 = str4;
        Intrinsics.checkNotNullParameter(str13, "tid");
        String str14 = str5;
        Intrinsics.checkNotNullParameter(str14, "originVersion");
        String str15 = str6;
        Intrinsics.checkNotNullParameter(str15, "version");
        String str16 = str7;
        Intrinsics.checkNotNullParameter(str16, "otaFailDetail");
        String str17 = str8;
        Intrinsics.checkNotNullParameter(str17, "phoneModel");
        String str18 = str9;
        Intrinsics.checkNotNullParameter(str18, "phoneBrand");
        return new GlassUpdateResultParam(str10, str11, str12, str13, str14, str15, j, j2, str16, str17, str18, i, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassUpdateResultParam)) {
            return false;
        }
        GlassUpdateResultParam glassUpdateResultParam = (GlassUpdateResultParam) obj;
        return Intrinsics.areEqual((Object) this.deviceType, (Object) glassUpdateResultParam.deviceType) && Intrinsics.areEqual((Object) this.deviceModel, (Object) glassUpdateResultParam.deviceModel) && Intrinsics.areEqual((Object) this.deviceId, (Object) glassUpdateResultParam.deviceId) && Intrinsics.areEqual((Object) this.tid, (Object) glassUpdateResultParam.tid) && Intrinsics.areEqual((Object) this.originVersion, (Object) glassUpdateResultParam.originVersion) && Intrinsics.areEqual((Object) this.version, (Object) glassUpdateResultParam.version) && this.otaStartTime == glassUpdateResultParam.otaStartTime && this.otaEndTime == glassUpdateResultParam.otaEndTime && Intrinsics.areEqual((Object) this.otaFailDetail, (Object) glassUpdateResultParam.otaFailDetail) && Intrinsics.areEqual((Object) this.phoneModel, (Object) glassUpdateResultParam.phoneModel) && Intrinsics.areEqual((Object) this.phoneBrand, (Object) glassUpdateResultParam.phoneBrand) && this.status == glassUpdateResultParam.status && Intrinsics.areEqual((Object) this.deviceIdEncrypted, (Object) glassUpdateResultParam.deviceIdEncrypted);
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    public final Boolean getDeviceIdEncrypted() {
        return this.deviceIdEncrypted;
    }

    @NotNull
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    @NotNull
    public final String getOriginVersion() {
        return this.originVersion;
    }

    public final long getOtaEndTime() {
        return this.otaEndTime;
    }

    @NotNull
    public final String getOtaFailDetail() {
        return this.otaFailDetail;
    }

    public final long getOtaStartTime() {
        return this.otaStartTime;
    }

    @NotNull
    public final String getPhoneBrand() {
        return this.phoneBrand;
    }

    @NotNull
    public final String getPhoneModel() {
        return this.phoneModel;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getTid() {
        return this.tid;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((this.deviceType.hashCode() * 31) + this.deviceModel.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.tid.hashCode()) * 31) + this.originVersion.hashCode()) * 31) + this.version.hashCode()) * 31) + Long.hashCode(this.otaStartTime)) * 31) + Long.hashCode(this.otaEndTime)) * 31) + this.otaFailDetail.hashCode()) * 31) + this.phoneModel.hashCode()) * 31) + this.phoneBrand.hashCode()) * 31) + Integer.hashCode(this.status)) * 31;
        Boolean bool = this.deviceIdEncrypted;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.deviceType;
        String str2 = this.deviceModel;
        String str3 = this.deviceId;
        String str4 = this.tid;
        String str5 = this.originVersion;
        String str6 = this.version;
        long j = this.otaStartTime;
        long j2 = this.otaEndTime;
        String str7 = this.otaFailDetail;
        String str8 = this.phoneModel;
        String str9 = this.phoneBrand;
        int i = this.status;
        Boolean bool = this.deviceIdEncrypted;
        return "GlassUpdateResultParam(deviceType=" + str + ", deviceModel=" + str2 + ", deviceId=" + str3 + ", tid=" + str4 + ", originVersion=" + str5 + ", version=" + str6 + ", otaStartTime=" + j + ", otaEndTime=" + j2 + ", otaFailDetail=" + str7 + ", phoneModel=" + str8 + ", phoneBrand=" + str9 + ", status=" + i + ", deviceIdEncrypted=" + bool + ")";
    }
}

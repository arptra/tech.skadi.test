package com.upuphone.star.fota.phone;

import androidx.annotation.Keep;
import com.upuphone.runasone.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0010HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00101\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00066"}, d2 = {"Lcom/upuphone/star/fota/phone/CheckGlassUpdateParamV2;", "", "deviceType", "", "deviceId", "version", "deviceModel", "buildType", "versionType", "timestamp", "", "lang", "appVersion", "depDeviceType", "depDeviceVersion", "deviceIdEncrypted", "", "os", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAppVersion", "()Ljava/lang/String;", "getBuildType", "getDepDeviceType", "getDepDeviceVersion", "getDeviceId", "getDeviceIdEncrypted", "()Z", "getDeviceModel", "getDeviceType", "getLang", "getOs", "getTimestamp", "()J", "getVersion", "getVersionType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "ar-fota-lib_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class CheckGlassUpdateParamV2 {
    @NotNull
    private final String appVersion;
    @NotNull
    private final String buildType;
    @Nullable
    private final String depDeviceType;
    @Nullable
    private final String depDeviceVersion;
    @NotNull
    private final String deviceId;
    private final boolean deviceIdEncrypted;
    @NotNull
    private final String deviceModel;
    @NotNull
    private final String deviceType;
    @Nullable
    private final String lang;
    @NotNull
    private final String os;
    private final long timestamp;
    @NotNull
    private final String version;
    @NotNull
    private final String versionType;

    public CheckGlassUpdateParamV2(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j, @Nullable String str7, @NotNull String str8, @Nullable String str9, @Nullable String str10, boolean z, @NotNull String str11) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        Intrinsics.checkNotNullParameter(str2, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str3, "version");
        Intrinsics.checkNotNullParameter(str4, "deviceModel");
        Intrinsics.checkNotNullParameter(str5, "buildType");
        Intrinsics.checkNotNullParameter(str6, "versionType");
        Intrinsics.checkNotNullParameter(str8, "appVersion");
        Intrinsics.checkNotNullParameter(str11, "os");
        this.deviceType = str;
        this.deviceId = str2;
        this.version = str3;
        this.deviceModel = str4;
        this.buildType = str5;
        this.versionType = str6;
        this.timestamp = j;
        this.lang = str7;
        this.appVersion = str8;
        this.depDeviceType = str9;
        this.depDeviceVersion = str10;
        this.deviceIdEncrypted = z;
        this.os = str11;
    }

    public static /* synthetic */ CheckGlassUpdateParamV2 copy$default(CheckGlassUpdateParamV2 checkGlassUpdateParamV2, String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, String str8, String str9, String str10, boolean z, String str11, int i, Object obj) {
        CheckGlassUpdateParamV2 checkGlassUpdateParamV22 = checkGlassUpdateParamV2;
        int i2 = i;
        return checkGlassUpdateParamV2.copy((i2 & 1) != 0 ? checkGlassUpdateParamV22.deviceType : str, (i2 & 2) != 0 ? checkGlassUpdateParamV22.deviceId : str2, (i2 & 4) != 0 ? checkGlassUpdateParamV22.version : str3, (i2 & 8) != 0 ? checkGlassUpdateParamV22.deviceModel : str4, (i2 & 16) != 0 ? checkGlassUpdateParamV22.buildType : str5, (i2 & 32) != 0 ? checkGlassUpdateParamV22.versionType : str6, (i2 & 64) != 0 ? checkGlassUpdateParamV22.timestamp : j, (i2 & 128) != 0 ? checkGlassUpdateParamV22.lang : str7, (i2 & 256) != 0 ? checkGlassUpdateParamV22.appVersion : str8, (i2 & 512) != 0 ? checkGlassUpdateParamV22.depDeviceType : str9, (i2 & 1024) != 0 ? checkGlassUpdateParamV22.depDeviceVersion : str10, (i2 & 2048) != 0 ? checkGlassUpdateParamV22.deviceIdEncrypted : z, (i2 & 4096) != 0 ? checkGlassUpdateParamV22.os : str11);
    }

    @NotNull
    public final String component1() {
        return this.deviceType;
    }

    @Nullable
    public final String component10() {
        return this.depDeviceType;
    }

    @Nullable
    public final String component11() {
        return this.depDeviceVersion;
    }

    public final boolean component12() {
        return this.deviceIdEncrypted;
    }

    @NotNull
    public final String component13() {
        return this.os;
    }

    @NotNull
    public final String component2() {
        return this.deviceId;
    }

    @NotNull
    public final String component3() {
        return this.version;
    }

    @NotNull
    public final String component4() {
        return this.deviceModel;
    }

    @NotNull
    public final String component5() {
        return this.buildType;
    }

    @NotNull
    public final String component6() {
        return this.versionType;
    }

    public final long component7() {
        return this.timestamp;
    }

    @Nullable
    public final String component8() {
        return this.lang;
    }

    @NotNull
    public final String component9() {
        return this.appVersion;
    }

    @NotNull
    public final CheckGlassUpdateParamV2 copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j, @Nullable String str7, @NotNull String str8, @Nullable String str9, @Nullable String str10, boolean z, @NotNull String str11) {
        String str12 = str;
        Intrinsics.checkNotNullParameter(str12, "deviceType");
        String str13 = str2;
        Intrinsics.checkNotNullParameter(str13, Constants.DEVICE_ID);
        String str14 = str3;
        Intrinsics.checkNotNullParameter(str14, "version");
        String str15 = str4;
        Intrinsics.checkNotNullParameter(str15, "deviceModel");
        String str16 = str5;
        Intrinsics.checkNotNullParameter(str16, "buildType");
        String str17 = str6;
        Intrinsics.checkNotNullParameter(str17, "versionType");
        String str18 = str8;
        Intrinsics.checkNotNullParameter(str18, "appVersion");
        String str19 = str11;
        Intrinsics.checkNotNullParameter(str19, "os");
        return new CheckGlassUpdateParamV2(str12, str13, str14, str15, str16, str17, j, str7, str18, str9, str10, z, str19);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckGlassUpdateParamV2)) {
            return false;
        }
        CheckGlassUpdateParamV2 checkGlassUpdateParamV2 = (CheckGlassUpdateParamV2) obj;
        return Intrinsics.areEqual((Object) this.deviceType, (Object) checkGlassUpdateParamV2.deviceType) && Intrinsics.areEqual((Object) this.deviceId, (Object) checkGlassUpdateParamV2.deviceId) && Intrinsics.areEqual((Object) this.version, (Object) checkGlassUpdateParamV2.version) && Intrinsics.areEqual((Object) this.deviceModel, (Object) checkGlassUpdateParamV2.deviceModel) && Intrinsics.areEqual((Object) this.buildType, (Object) checkGlassUpdateParamV2.buildType) && Intrinsics.areEqual((Object) this.versionType, (Object) checkGlassUpdateParamV2.versionType) && this.timestamp == checkGlassUpdateParamV2.timestamp && Intrinsics.areEqual((Object) this.lang, (Object) checkGlassUpdateParamV2.lang) && Intrinsics.areEqual((Object) this.appVersion, (Object) checkGlassUpdateParamV2.appVersion) && Intrinsics.areEqual((Object) this.depDeviceType, (Object) checkGlassUpdateParamV2.depDeviceType) && Intrinsics.areEqual((Object) this.depDeviceVersion, (Object) checkGlassUpdateParamV2.depDeviceVersion) && this.deviceIdEncrypted == checkGlassUpdateParamV2.deviceIdEncrypted && Intrinsics.areEqual((Object) this.os, (Object) checkGlassUpdateParamV2.os);
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final String getBuildType() {
        return this.buildType;
    }

    @Nullable
    public final String getDepDeviceType() {
        return this.depDeviceType;
    }

    @Nullable
    public final String getDepDeviceVersion() {
        return this.depDeviceVersion;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final boolean getDeviceIdEncrypted() {
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

    @Nullable
    public final String getLang() {
        return this.lang;
    }

    @NotNull
    public final String getOs() {
        return this.os;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final String getVersionType() {
        return this.versionType;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.deviceType.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.version.hashCode()) * 31) + this.deviceModel.hashCode()) * 31) + this.buildType.hashCode()) * 31) + this.versionType.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31;
        String str = this.lang;
        int i = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.appVersion.hashCode()) * 31;
        String str2 = this.depDeviceType;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.depDeviceVersion;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((hashCode3 + i) * 31) + Boolean.hashCode(this.deviceIdEncrypted)) * 31) + this.os.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.deviceType;
        String str2 = this.deviceId;
        String str3 = this.version;
        String str4 = this.deviceModel;
        String str5 = this.buildType;
        String str6 = this.versionType;
        long j = this.timestamp;
        String str7 = this.lang;
        String str8 = this.appVersion;
        String str9 = this.depDeviceType;
        String str10 = this.depDeviceVersion;
        boolean z = this.deviceIdEncrypted;
        String str11 = this.os;
        return "CheckGlassUpdateParamV2(deviceType=" + str + ", deviceId=" + str2 + ", version=" + str3 + ", deviceModel=" + str4 + ", buildType=" + str5 + ", versionType=" + str6 + ", timestamp=" + j + ", lang=" + str7 + ", appVersion=" + str8 + ", depDeviceType=" + str9 + ", depDeviceVersion=" + str10 + ", deviceIdEncrypted=" + z + ", os=" + str11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckGlassUpdateParamV2(String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, String str8, String str9, String str10, boolean z, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, j, str7, str8, str9, str10, z, (i & 4096) != 0 ? "Android" : str11);
    }
}

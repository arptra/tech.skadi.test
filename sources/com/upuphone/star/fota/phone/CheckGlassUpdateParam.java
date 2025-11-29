package com.upuphone.star.fota.phone;

import androidx.annotation.Keep;
import com.upuphone.runasone.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003Je\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006*"}, d2 = {"Lcom/upuphone/star/fota/phone/CheckGlassUpdateParam;", "", "deviceType", "", "deviceId", "version", "deviceModel", "buildType", "versionType", "timestamp", "", "lang", "deviceIdEncrypted", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)V", "getBuildType", "()Ljava/lang/String;", "getDeviceId", "getDeviceIdEncrypted", "()Z", "getDeviceModel", "getDeviceType", "getLang", "getTimestamp", "()J", "getVersion", "getVersionType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "ar-fota-lib_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class CheckGlassUpdateParam {
    @NotNull
    private final String buildType;
    @NotNull
    private final String deviceId;
    private final boolean deviceIdEncrypted;
    @NotNull
    private final String deviceModel;
    @NotNull
    private final String deviceType;
    @Nullable
    private final String lang;
    private final long timestamp;
    @NotNull
    private final String version;
    @NotNull
    private final String versionType;

    public CheckGlassUpdateParam(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j, @Nullable String str7, boolean z) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        Intrinsics.checkNotNullParameter(str2, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str3, "version");
        Intrinsics.checkNotNullParameter(str4, "deviceModel");
        Intrinsics.checkNotNullParameter(str5, "buildType");
        Intrinsics.checkNotNullParameter(str6, "versionType");
        this.deviceType = str;
        this.deviceId = str2;
        this.version = str3;
        this.deviceModel = str4;
        this.buildType = str5;
        this.versionType = str6;
        this.timestamp = j;
        this.lang = str7;
        this.deviceIdEncrypted = z;
    }

    public static /* synthetic */ CheckGlassUpdateParam copy$default(CheckGlassUpdateParam checkGlassUpdateParam, String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, boolean z, int i, Object obj) {
        CheckGlassUpdateParam checkGlassUpdateParam2 = checkGlassUpdateParam;
        int i2 = i;
        return checkGlassUpdateParam.copy((i2 & 1) != 0 ? checkGlassUpdateParam2.deviceType : str, (i2 & 2) != 0 ? checkGlassUpdateParam2.deviceId : str2, (i2 & 4) != 0 ? checkGlassUpdateParam2.version : str3, (i2 & 8) != 0 ? checkGlassUpdateParam2.deviceModel : str4, (i2 & 16) != 0 ? checkGlassUpdateParam2.buildType : str5, (i2 & 32) != 0 ? checkGlassUpdateParam2.versionType : str6, (i2 & 64) != 0 ? checkGlassUpdateParam2.timestamp : j, (i2 & 128) != 0 ? checkGlassUpdateParam2.lang : str7, (i2 & 256) != 0 ? checkGlassUpdateParam2.deviceIdEncrypted : z);
    }

    @NotNull
    public final String component1() {
        return this.deviceType;
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

    public final boolean component9() {
        return this.deviceIdEncrypted;
    }

    @NotNull
    public final CheckGlassUpdateParam copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, long j, @Nullable String str7, boolean z) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        Intrinsics.checkNotNullParameter(str2, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str3, "version");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "deviceModel");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "buildType");
        String str10 = str6;
        Intrinsics.checkNotNullParameter(str10, "versionType");
        return new CheckGlassUpdateParam(str, str2, str3, str8, str9, str10, j, str7, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckGlassUpdateParam)) {
            return false;
        }
        CheckGlassUpdateParam checkGlassUpdateParam = (CheckGlassUpdateParam) obj;
        return Intrinsics.areEqual((Object) this.deviceType, (Object) checkGlassUpdateParam.deviceType) && Intrinsics.areEqual((Object) this.deviceId, (Object) checkGlassUpdateParam.deviceId) && Intrinsics.areEqual((Object) this.version, (Object) checkGlassUpdateParam.version) && Intrinsics.areEqual((Object) this.deviceModel, (Object) checkGlassUpdateParam.deviceModel) && Intrinsics.areEqual((Object) this.buildType, (Object) checkGlassUpdateParam.buildType) && Intrinsics.areEqual((Object) this.versionType, (Object) checkGlassUpdateParam.versionType) && this.timestamp == checkGlassUpdateParam.timestamp && Intrinsics.areEqual((Object) this.lang, (Object) checkGlassUpdateParam.lang) && this.deviceIdEncrypted == checkGlassUpdateParam.deviceIdEncrypted;
    }

    @NotNull
    public final String getBuildType() {
        return this.buildType;
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
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.deviceIdEncrypted);
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
        boolean z = this.deviceIdEncrypted;
        return "CheckGlassUpdateParam(deviceType=" + str + ", deviceId=" + str2 + ", version=" + str3 + ", deviceModel=" + str4 + ", buildType=" + str5 + ", versionType=" + str6 + ", timestamp=" + j + ", lang=" + str7 + ", deviceIdEncrypted=" + z + ")";
    }
}

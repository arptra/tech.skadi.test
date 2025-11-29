package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J_\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AirGlassInfo;", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "serial", "", "model", "romVersion", "battery", "", "isCharging", "", "subModel", "displayName", "buildType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBattery", "()I", "getBuildType", "()Ljava/lang/String;", "getDisplayName", "()Z", "getModel", "getRomVersion", "getSerial", "getSubModel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AirGlassInfo extends BasicGlassInfo {
    private final int battery;
    @Nullable
    private final String buildType;
    @Nullable
    private final String displayName;
    private final boolean isCharging;
    @NotNull
    private final String model;
    @NotNull
    private final String romVersion;
    @NotNull
    private final String serial;
    @Nullable
    private final String subModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, boolean z, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "serial");
        Intrinsics.checkNotNullParameter(str2, "model");
        Intrinsics.checkNotNullParameter(str3, "romVersion");
        this.serial = str;
        this.model = str2;
        this.romVersion = str3;
        this.battery = i;
        this.isCharging = z;
        this.subModel = str4;
        this.displayName = str5;
        this.buildType = str6;
    }

    public static /* synthetic */ AirGlassInfo copy$default(AirGlassInfo airGlassInfo, String str, String str2, String str3, int i, boolean z, String str4, String str5, String str6, int i2, Object obj) {
        AirGlassInfo airGlassInfo2 = airGlassInfo;
        int i3 = i2;
        return airGlassInfo.copy((i3 & 1) != 0 ? airGlassInfo2.serial : str, (i3 & 2) != 0 ? airGlassInfo2.model : str2, (i3 & 4) != 0 ? airGlassInfo2.romVersion : str3, (i3 & 8) != 0 ? airGlassInfo2.battery : i, (i3 & 16) != 0 ? airGlassInfo2.isCharging : z, (i3 & 32) != 0 ? airGlassInfo2.subModel : str4, (i3 & 64) != 0 ? airGlassInfo2.displayName : str5, (i3 & 128) != 0 ? airGlassInfo2.buildType : str6);
    }

    @NotNull
    public final String component1() {
        return this.serial;
    }

    @NotNull
    public final String component2() {
        return this.model;
    }

    @NotNull
    public final String component3() {
        return this.romVersion;
    }

    public final int component4() {
        return this.battery;
    }

    public final boolean component5() {
        return this.isCharging;
    }

    @Nullable
    public final String component6() {
        return this.subModel;
    }

    @Nullable
    public final String component7() {
        return this.displayName;
    }

    @Nullable
    public final String component8() {
        return this.buildType;
    }

    @NotNull
    public final AirGlassInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, boolean z, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(str, "serial");
        Intrinsics.checkNotNullParameter(str2, "model");
        Intrinsics.checkNotNullParameter(str3, "romVersion");
        return new AirGlassInfo(str, str2, str3, i, z, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirGlassInfo)) {
            return false;
        }
        AirGlassInfo airGlassInfo = (AirGlassInfo) obj;
        return Intrinsics.areEqual((Object) this.serial, (Object) airGlassInfo.serial) && Intrinsics.areEqual((Object) this.model, (Object) airGlassInfo.model) && Intrinsics.areEqual((Object) this.romVersion, (Object) airGlassInfo.romVersion) && this.battery == airGlassInfo.battery && this.isCharging == airGlassInfo.isCharging && Intrinsics.areEqual((Object) this.subModel, (Object) airGlassInfo.subModel) && Intrinsics.areEqual((Object) this.displayName, (Object) airGlassInfo.displayName) && Intrinsics.areEqual((Object) this.buildType, (Object) airGlassInfo.buildType);
    }

    public int getBattery() {
        return this.battery;
    }

    @Nullable
    public String getBuildType() {
        return this.buildType;
    }

    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    @NotNull
    public String getModel() {
        return this.model;
    }

    @NotNull
    public String getRomVersion() {
        return this.romVersion;
    }

    @NotNull
    public String getSerial() {
        return this.serial;
    }

    @Nullable
    public String getSubModel() {
        return this.subModel;
    }

    public int hashCode() {
        int hashCode = ((((((((this.serial.hashCode() * 31) + this.model.hashCode()) * 31) + this.romVersion.hashCode()) * 31) + Integer.hashCode(this.battery)) * 31) + Boolean.hashCode(this.isCharging)) * 31;
        String str = this.subModel;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.displayName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.buildType;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public boolean isCharging() {
        return this.isCharging;
    }

    @NotNull
    public String toString() {
        String str = this.serial;
        String str2 = this.model;
        String str3 = this.romVersion;
        int i = this.battery;
        boolean z = this.isCharging;
        String str4 = this.subModel;
        String str5 = this.displayName;
        String str6 = this.buildType;
        return "AirGlassInfo(serial=" + str + ", model=" + str2 + ", romVersion=" + str3 + ", battery=" + i + ", isCharging=" + z + ", subModel=" + str4 + ", displayName=" + str5 + ", buildType=" + str6 + ")";
    }
}

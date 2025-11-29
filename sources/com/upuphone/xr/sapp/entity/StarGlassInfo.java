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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u000fHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u000fHÆ\u0003J}\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001J\u0013\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\bHÖ\u0001J\t\u00102\u001a\u00020\u0004HÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\bHÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0016\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017¨\u00068"}, d2 = {"Lcom/upuphone/xr/sapp/entity/StarGlassInfo;", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "Landroid/os/Parcelable;", "serial", "", "model", "romVersion", "battery", "", "androidVersion", "isCharging", "", "subModel", "displayName", "storageTotalBytes", "", "storageAvailableBytes", "buildType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V", "getAndroidVersion", "()I", "getBattery", "getBuildType", "()Ljava/lang/String;", "getDisplayName", "()Z", "getModel", "getRomVersion", "getSerial", "getStorageAvailableBytes", "()J", "getStorageTotalBytes", "getSubModel", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class StarGlassInfo extends BasicGlassInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<StarGlassInfo> CREATOR = new Creator();
    private final int androidVersion;
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
    private final long storageAvailableBytes;
    private final long storageTotalBytes;
    @Nullable
    private final String subModel;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<StarGlassInfo> {
        @NotNull
        public final StarGlassInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StarGlassInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString());
        }

        @NotNull
        public final StarGlassInfo[] newArray(int i) {
            return new StarGlassInfo[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarGlassInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2, boolean z, @Nullable String str4, @Nullable String str5, long j, long j2, @Nullable String str6) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "serial");
        Intrinsics.checkNotNullParameter(str2, "model");
        Intrinsics.checkNotNullParameter(str3, "romVersion");
        this.serial = str;
        this.model = str2;
        this.romVersion = str3;
        this.battery = i;
        this.androidVersion = i2;
        this.isCharging = z;
        this.subModel = str4;
        this.displayName = str5;
        this.storageTotalBytes = j;
        this.storageAvailableBytes = j2;
        this.buildType = str6;
    }

    public static /* synthetic */ StarGlassInfo copy$default(StarGlassInfo starGlassInfo, String str, String str2, String str3, int i, int i2, boolean z, String str4, String str5, long j, long j2, String str6, int i3, Object obj) {
        StarGlassInfo starGlassInfo2 = starGlassInfo;
        int i4 = i3;
        return starGlassInfo.copy((i4 & 1) != 0 ? starGlassInfo2.serial : str, (i4 & 2) != 0 ? starGlassInfo2.model : str2, (i4 & 4) != 0 ? starGlassInfo2.romVersion : str3, (i4 & 8) != 0 ? starGlassInfo2.battery : i, (i4 & 16) != 0 ? starGlassInfo2.androidVersion : i2, (i4 & 32) != 0 ? starGlassInfo2.isCharging : z, (i4 & 64) != 0 ? starGlassInfo2.subModel : str4, (i4 & 128) != 0 ? starGlassInfo2.displayName : str5, (i4 & 256) != 0 ? starGlassInfo2.storageTotalBytes : j, (i4 & 512) != 0 ? starGlassInfo2.storageAvailableBytes : j2, (i4 & 1024) != 0 ? starGlassInfo2.buildType : str6);
    }

    @NotNull
    public final String component1() {
        return this.serial;
    }

    public final long component10() {
        return this.storageAvailableBytes;
    }

    @Nullable
    public final String component11() {
        return this.buildType;
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

    public final int component5() {
        return this.androidVersion;
    }

    public final boolean component6() {
        return this.isCharging;
    }

    @Nullable
    public final String component7() {
        return this.subModel;
    }

    @Nullable
    public final String component8() {
        return this.displayName;
    }

    public final long component9() {
        return this.storageTotalBytes;
    }

    @NotNull
    public final StarGlassInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2, boolean z, @Nullable String str4, @Nullable String str5, long j, long j2, @Nullable String str6) {
        String str7 = str;
        Intrinsics.checkNotNullParameter(str7, "serial");
        String str8 = str2;
        Intrinsics.checkNotNullParameter(str8, "model");
        String str9 = str3;
        Intrinsics.checkNotNullParameter(str9, "romVersion");
        return new StarGlassInfo(str7, str8, str9, i, i2, z, str4, str5, j, j2, str6);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StarGlassInfo)) {
            return false;
        }
        StarGlassInfo starGlassInfo = (StarGlassInfo) obj;
        return Intrinsics.areEqual((Object) this.serial, (Object) starGlassInfo.serial) && Intrinsics.areEqual((Object) this.model, (Object) starGlassInfo.model) && Intrinsics.areEqual((Object) this.romVersion, (Object) starGlassInfo.romVersion) && this.battery == starGlassInfo.battery && this.androidVersion == starGlassInfo.androidVersion && this.isCharging == starGlassInfo.isCharging && Intrinsics.areEqual((Object) this.subModel, (Object) starGlassInfo.subModel) && Intrinsics.areEqual((Object) this.displayName, (Object) starGlassInfo.displayName) && this.storageTotalBytes == starGlassInfo.storageTotalBytes && this.storageAvailableBytes == starGlassInfo.storageAvailableBytes && Intrinsics.areEqual((Object) this.buildType, (Object) starGlassInfo.buildType);
    }

    public final int getAndroidVersion() {
        return this.androidVersion;
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

    public final long getStorageAvailableBytes() {
        return this.storageAvailableBytes;
    }

    public final long getStorageTotalBytes() {
        return this.storageTotalBytes;
    }

    @Nullable
    public String getSubModel() {
        return this.subModel;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.serial.hashCode() * 31) + this.model.hashCode()) * 31) + this.romVersion.hashCode()) * 31) + Integer.hashCode(this.battery)) * 31) + Integer.hashCode(this.androidVersion)) * 31) + Boolean.hashCode(this.isCharging)) * 31;
        String str = this.subModel;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.displayName;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Long.hashCode(this.storageTotalBytes)) * 31) + Long.hashCode(this.storageAvailableBytes)) * 31;
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
        int i2 = this.androidVersion;
        boolean z = this.isCharging;
        String str4 = this.subModel;
        String str5 = this.displayName;
        long j = this.storageTotalBytes;
        long j2 = this.storageAvailableBytes;
        String str6 = this.buildType;
        return "StarGlassInfo(serial=" + str + ", model=" + str2 + ", romVersion=" + str3 + ", battery=" + i + ", androidVersion=" + i2 + ", isCharging=" + z + ", subModel=" + str4 + ", displayName=" + str5 + ", storageTotalBytes=" + j + ", storageAvailableBytes=" + j2 + ", buildType=" + str6 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.serial);
        parcel.writeString(this.model);
        parcel.writeString(this.romVersion);
        parcel.writeInt(this.battery);
        parcel.writeInt(this.androidVersion);
        parcel.writeInt(this.isCharging ? 1 : 0);
        parcel.writeString(this.subModel);
        parcel.writeString(this.displayName);
        parcel.writeLong(this.storageTotalBytes);
        parcel.writeLong(this.storageAvailableBytes);
        parcel.writeString(this.buildType);
    }
}

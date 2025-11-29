package com.upuphone.star.fota.phone;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\u0005HÖ\u0001J\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0005HÖ\u0001J\t\u00105\u001a\u00020\u0007HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u0006;"}, d2 = {"Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "Landroid/os/Parcelable;", "existsUpdate", "", "updateType", "", "videoPath", "", "fileSize", "", "packLink", "packLink2", "digest", "latestVersion", "releaseNote", "releaseDate", "versionFullName", "(ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDigest", "()Ljava/lang/String;", "getExistsUpdate", "()Z", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLatestVersion", "getPackLink", "getPackLink2", "getReleaseDate", "getReleaseNote", "getUpdateType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVersionFullName", "getVideoPath", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ar-fota-lib_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Parcelize
@Keep
public final class GlassUpdateInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<GlassUpdateInfo> CREATOR = new Creator();
    @Nullable
    private final String digest;
    private final boolean existsUpdate;
    @Nullable
    private final Long fileSize;
    @Nullable
    private final String latestVersion;
    @Nullable
    private final String packLink;
    @Nullable
    private final String packLink2;
    @Nullable
    private final String releaseDate;
    @Nullable
    private final String releaseNote;
    @Nullable
    private final Integer updateType;
    @Nullable
    private final String versionFullName;
    @Nullable
    private final String videoPath;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GlassUpdateInfo> {
        /* renamed from: a */
        public final GlassUpdateInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GlassUpdateInfo(parcel.readInt() != 0, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final GlassUpdateInfo[] newArray(int i) {
            return new GlassUpdateInfo[i];
        }
    }

    public GlassUpdateInfo(boolean z, @Nullable Integer num, @Nullable String str, @Nullable Long l, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        this.existsUpdate = z;
        this.updateType = num;
        this.videoPath = str;
        this.fileSize = l;
        this.packLink = str2;
        this.packLink2 = str3;
        this.digest = str4;
        this.latestVersion = str5;
        this.releaseNote = str6;
        this.releaseDate = str7;
        this.versionFullName = str8;
    }

    public static /* synthetic */ GlassUpdateInfo copy$default(GlassUpdateInfo glassUpdateInfo, boolean z, Integer num, String str, Long l, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        GlassUpdateInfo glassUpdateInfo2 = glassUpdateInfo;
        int i2 = i;
        return glassUpdateInfo.copy((i2 & 1) != 0 ? glassUpdateInfo2.existsUpdate : z, (i2 & 2) != 0 ? glassUpdateInfo2.updateType : num, (i2 & 4) != 0 ? glassUpdateInfo2.videoPath : str, (i2 & 8) != 0 ? glassUpdateInfo2.fileSize : l, (i2 & 16) != 0 ? glassUpdateInfo2.packLink : str2, (i2 & 32) != 0 ? glassUpdateInfo2.packLink2 : str3, (i2 & 64) != 0 ? glassUpdateInfo2.digest : str4, (i2 & 128) != 0 ? glassUpdateInfo2.latestVersion : str5, (i2 & 256) != 0 ? glassUpdateInfo2.releaseNote : str6, (i2 & 512) != 0 ? glassUpdateInfo2.releaseDate : str7, (i2 & 1024) != 0 ? glassUpdateInfo2.versionFullName : str8);
    }

    public final boolean component1() {
        return this.existsUpdate;
    }

    @Nullable
    public final String component10() {
        return this.releaseDate;
    }

    @Nullable
    public final String component11() {
        return this.versionFullName;
    }

    @Nullable
    public final Integer component2() {
        return this.updateType;
    }

    @Nullable
    public final String component3() {
        return this.videoPath;
    }

    @Nullable
    public final Long component4() {
        return this.fileSize;
    }

    @Nullable
    public final String component5() {
        return this.packLink;
    }

    @Nullable
    public final String component6() {
        return this.packLink2;
    }

    @Nullable
    public final String component7() {
        return this.digest;
    }

    @Nullable
    public final String component8() {
        return this.latestVersion;
    }

    @Nullable
    public final String component9() {
        return this.releaseNote;
    }

    @NotNull
    public final GlassUpdateInfo copy(boolean z, @Nullable Integer num, @Nullable String str, @Nullable Long l, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        return new GlassUpdateInfo(z, num, str, l, str2, str3, str4, str5, str6, str7, str8);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassUpdateInfo)) {
            return false;
        }
        GlassUpdateInfo glassUpdateInfo = (GlassUpdateInfo) obj;
        return this.existsUpdate == glassUpdateInfo.existsUpdate && Intrinsics.areEqual((Object) this.updateType, (Object) glassUpdateInfo.updateType) && Intrinsics.areEqual((Object) this.videoPath, (Object) glassUpdateInfo.videoPath) && Intrinsics.areEqual((Object) this.fileSize, (Object) glassUpdateInfo.fileSize) && Intrinsics.areEqual((Object) this.packLink, (Object) glassUpdateInfo.packLink) && Intrinsics.areEqual((Object) this.packLink2, (Object) glassUpdateInfo.packLink2) && Intrinsics.areEqual((Object) this.digest, (Object) glassUpdateInfo.digest) && Intrinsics.areEqual((Object) this.latestVersion, (Object) glassUpdateInfo.latestVersion) && Intrinsics.areEqual((Object) this.releaseNote, (Object) glassUpdateInfo.releaseNote) && Intrinsics.areEqual((Object) this.releaseDate, (Object) glassUpdateInfo.releaseDate) && Intrinsics.areEqual((Object) this.versionFullName, (Object) glassUpdateInfo.versionFullName);
    }

    @Nullable
    public final String getDigest() {
        return this.digest;
    }

    public final boolean getExistsUpdate() {
        return this.existsUpdate;
    }

    @Nullable
    public final Long getFileSize() {
        return this.fileSize;
    }

    @Nullable
    public final String getLatestVersion() {
        return this.latestVersion;
    }

    @Nullable
    public final String getPackLink() {
        return this.packLink;
    }

    @Nullable
    public final String getPackLink2() {
        return this.packLink2;
    }

    @Nullable
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    public final String getReleaseNote() {
        return this.releaseNote;
    }

    @Nullable
    public final Integer getUpdateType() {
        return this.updateType;
    }

    @Nullable
    public final String getVersionFullName() {
        return this.versionFullName;
    }

    @Nullable
    public final String getVideoPath() {
        return this.videoPath;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.existsUpdate) * 31;
        Integer num = this.updateType;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.videoPath;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.fileSize;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.packLink;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.packLink2;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.digest;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.latestVersion;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.releaseNote;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.releaseDate;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.versionFullName;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode10 + i;
    }

    @NotNull
    public String toString() {
        boolean z = this.existsUpdate;
        Integer num = this.updateType;
        String str = this.videoPath;
        Long l = this.fileSize;
        String str2 = this.packLink;
        String str3 = this.packLink2;
        String str4 = this.digest;
        String str5 = this.latestVersion;
        String str6 = this.releaseNote;
        String str7 = this.releaseDate;
        String str8 = this.versionFullName;
        return "GlassUpdateInfo(existsUpdate=" + z + ", updateType=" + num + ", videoPath=" + str + ", fileSize=" + l + ", packLink=" + str2 + ", packLink2=" + str3 + ", digest=" + str4 + ", latestVersion=" + str5 + ", releaseNote=" + str6 + ", releaseDate=" + str7 + ", versionFullName=" + str8 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.existsUpdate ? 1 : 0);
        Integer num = this.updateType;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.videoPath);
        Long l = this.fileSize;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.packLink);
        parcel.writeString(this.packLink2);
        parcel.writeString(this.digest);
        parcel.writeString(this.latestVersion);
        parcel.writeString(this.releaseNote);
        parcel.writeString(this.releaseDate);
        parcel.writeString(this.versionFullName);
    }
}

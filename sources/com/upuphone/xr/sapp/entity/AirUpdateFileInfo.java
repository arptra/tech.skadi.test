package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AirUpdateFileInfo;", "", "fileName", "", "fileSize", "", "md5", "filePath", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getFilePath", "getFileSize", "()J", "getMd5", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AirUpdateFileInfo {
    @NotNull
    private final String fileName;
    @NotNull
    private final String filePath;
    private final long fileSize;
    @Nullable
    private final String md5;

    public AirUpdateFileInfo(@NotNull String str, long j, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str3, "filePath");
        this.fileName = str;
        this.fileSize = j;
        this.md5 = str2;
        this.filePath = str3;
    }

    public static /* synthetic */ AirUpdateFileInfo copy$default(AirUpdateFileInfo airUpdateFileInfo, String str, long j, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = airUpdateFileInfo.fileName;
        }
        if ((i & 2) != 0) {
            j = airUpdateFileInfo.fileSize;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = airUpdateFileInfo.md5;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = airUpdateFileInfo.filePath;
        }
        return airUpdateFileInfo.copy(str, j2, str4, str3);
    }

    @NotNull
    public final String component1() {
        return this.fileName;
    }

    public final long component2() {
        return this.fileSize;
    }

    @Nullable
    public final String component3() {
        return this.md5;
    }

    @NotNull
    public final String component4() {
        return this.filePath;
    }

    @NotNull
    public final AirUpdateFileInfo copy(@NotNull String str, long j, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str3, "filePath");
        return new AirUpdateFileInfo(str, j, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirUpdateFileInfo)) {
            return false;
        }
        AirUpdateFileInfo airUpdateFileInfo = (AirUpdateFileInfo) obj;
        return Intrinsics.areEqual((Object) this.fileName, (Object) airUpdateFileInfo.fileName) && this.fileSize == airUpdateFileInfo.fileSize && Intrinsics.areEqual((Object) this.md5, (Object) airUpdateFileInfo.md5) && Intrinsics.areEqual((Object) this.filePath, (Object) airUpdateFileInfo.filePath);
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    @Nullable
    public final String getMd5() {
        return this.md5;
    }

    public int hashCode() {
        int hashCode = ((this.fileName.hashCode() * 31) + Long.hashCode(this.fileSize)) * 31;
        String str = this.md5;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.filePath.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.fileName;
        long j = this.fileSize;
        String str2 = this.md5;
        String str3 = this.filePath;
        return "AirUpdateFileInfo(fileName=" + str + ", fileSize=" + j + ", md5=" + str2 + ", filePath=" + str3 + ")";
    }
}

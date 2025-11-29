package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AirSilentSendFileRequest;", "", "fileName", "", "md5", "fileOffset", "", "fileLength", "(Ljava/lang/String;Ljava/lang/String;II)V", "getFileLength", "()I", "getFileName", "()Ljava/lang/String;", "getFileOffset", "getMd5", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AirSilentSendFileRequest {
    private final int fileLength;
    @NotNull
    private final String fileName;
    private final int fileOffset;
    @NotNull
    private final String md5;

    public AirSilentSendFileRequest(@NotNull String str, @NotNull String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "md5");
        this.fileName = str;
        this.md5 = str2;
        this.fileOffset = i;
        this.fileLength = i2;
    }

    public static /* synthetic */ AirSilentSendFileRequest copy$default(AirSilentSendFileRequest airSilentSendFileRequest, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = airSilentSendFileRequest.fileName;
        }
        if ((i3 & 2) != 0) {
            str2 = airSilentSendFileRequest.md5;
        }
        if ((i3 & 4) != 0) {
            i = airSilentSendFileRequest.fileOffset;
        }
        if ((i3 & 8) != 0) {
            i2 = airSilentSendFileRequest.fileLength;
        }
        return airSilentSendFileRequest.copy(str, str2, i, i2);
    }

    @NotNull
    public final String component1() {
        return this.fileName;
    }

    @NotNull
    public final String component2() {
        return this.md5;
    }

    public final int component3() {
        return this.fileOffset;
    }

    public final int component4() {
        return this.fileLength;
    }

    @NotNull
    public final AirSilentSendFileRequest copy(@NotNull String str, @NotNull String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "md5");
        return new AirSilentSendFileRequest(str, str2, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirSilentSendFileRequest)) {
            return false;
        }
        AirSilentSendFileRequest airSilentSendFileRequest = (AirSilentSendFileRequest) obj;
        return Intrinsics.areEqual((Object) this.fileName, (Object) airSilentSendFileRequest.fileName) && Intrinsics.areEqual((Object) this.md5, (Object) airSilentSendFileRequest.md5) && this.fileOffset == airSilentSendFileRequest.fileOffset && this.fileLength == airSilentSendFileRequest.fileLength;
    }

    public final int getFileLength() {
        return this.fileLength;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    public final int getFileOffset() {
        return this.fileOffset;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }

    public int hashCode() {
        return (((((this.fileName.hashCode() * 31) + this.md5.hashCode()) * 31) + Integer.hashCode(this.fileOffset)) * 31) + Integer.hashCode(this.fileLength);
    }

    @NotNull
    public String toString() {
        String str = this.fileName;
        String str2 = this.md5;
        int i = this.fileOffset;
        int i2 = this.fileLength;
        return "AirSilentSendFileRequest(fileName=" + str + ", md5=" + str2 + ", fileOffset=" + i + ", fileLength=" + i2 + ")";
    }
}

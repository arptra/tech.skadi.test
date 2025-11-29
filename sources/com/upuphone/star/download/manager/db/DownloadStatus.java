package com.upuphone.star.download.manager.db;

import androidx.annotation.Keep;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/upuphone/star/download/manager/db/DownloadStatus;", "", "url", "", "filePath", "fileSize", "", "progress", "", "(Ljava/lang/String;Ljava/lang/String;JF)V", "getFilePath", "()Ljava/lang/String;", "getFileSize", "()J", "getProgress", "()F", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class DownloadStatus {
    @NotNull
    private final String filePath;
    private final long fileSize;
    private final float progress;
    @NotNull
    private final String url;

    public DownloadStatus(@NotNull String str, @NotNull String str2, long j, float f) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "filePath");
        this.url = str;
        this.filePath = str2;
        this.fileSize = j;
        this.progress = f;
    }

    public static /* synthetic */ DownloadStatus copy$default(DownloadStatus downloadStatus, String str, String str2, long j, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = downloadStatus.url;
        }
        if ((i & 2) != 0) {
            str2 = downloadStatus.filePath;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            j = downloadStatus.fileSize;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            f = downloadStatus.progress;
        }
        return downloadStatus.copy(str, str3, j2, f);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final String component2() {
        return this.filePath;
    }

    public final long component3() {
        return this.fileSize;
    }

    public final float component4() {
        return this.progress;
    }

    @NotNull
    public final DownloadStatus copy(@NotNull String str, @NotNull String str2, long j, float f) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "filePath");
        return new DownloadStatus(str, str2, j, f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadStatus)) {
            return false;
        }
        DownloadStatus downloadStatus = (DownloadStatus) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) downloadStatus.url) && Intrinsics.areEqual((Object) this.filePath, (Object) downloadStatus.filePath) && this.fileSize == downloadStatus.fileSize && Float.compare(this.progress, downloadStatus.progress) == 0;
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final float getProgress() {
        return this.progress;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.filePath.hashCode()) * 31) + Long.hashCode(this.fileSize)) * 31) + Float.hashCode(this.progress);
    }

    @NotNull
    public String toString() {
        String str = this.url;
        String str2 = this.filePath;
        long j = this.fileSize;
        float f = this.progress;
        return "DownloadStatus(url=" + str + ", filePath=" + str2 + ", fileSize=" + j + ", progress=" + f + ")";
    }
}

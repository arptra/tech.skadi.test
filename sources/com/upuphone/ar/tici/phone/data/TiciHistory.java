package com.upuphone.ar.tici.phone.data;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003JL\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\n\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "", "id", "", "fileName", "", "lastModified", "fileType", "", "fileSize", "totalTextLength", "(JLjava/lang/String;JLjava/lang/Integer;JI)V", "getFileName", "()Ljava/lang/String;", "getFileSize", "()J", "getFileType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getLastModified", "getTotalTextLength", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(JLjava/lang/String;JLjava/lang/Integer;JI)Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "equals", "", "other", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class TiciHistory {
    @ColumnInfo
    @NotNull
    private final String fileName;
    @ColumnInfo
    private final long fileSize;
    @ColumnInfo
    @Nullable
    private final Integer fileType;
    @ColumnInfo
    private final long id;
    @ColumnInfo
    private final long lastModified;
    @ColumnInfo
    private final int totalTextLength;

    public TiciHistory(long j, @NotNull String str, long j2, @Nullable Integer num, long j3, int i) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        this.id = j;
        this.fileName = str;
        this.lastModified = j2;
        this.fileType = num;
        this.fileSize = j3;
        this.totalTextLength = i;
    }

    public static /* synthetic */ TiciHistory copy$default(TiciHistory ticiHistory, long j, String str, long j2, Integer num, long j3, int i, int i2, Object obj) {
        TiciHistory ticiHistory2 = ticiHistory;
        return ticiHistory.copy((i2 & 1) != 0 ? ticiHistory2.id : j, (i2 & 2) != 0 ? ticiHistory2.fileName : str, (i2 & 4) != 0 ? ticiHistory2.lastModified : j2, (i2 & 8) != 0 ? ticiHistory2.fileType : num, (i2 & 16) != 0 ? ticiHistory2.fileSize : j3, (i2 & 32) != 0 ? ticiHistory2.totalTextLength : i);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.fileName;
    }

    public final long component3() {
        return this.lastModified;
    }

    @Nullable
    public final Integer component4() {
        return this.fileType;
    }

    public final long component5() {
        return this.fileSize;
    }

    public final int component6() {
        return this.totalTextLength;
    }

    @NotNull
    public final TiciHistory copy(long j, @NotNull String str, long j2, @Nullable Integer num, long j3, int i) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        return new TiciHistory(j, str, j2, num, j3, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TiciHistory)) {
            return false;
        }
        TiciHistory ticiHistory = (TiciHistory) obj;
        return this.id == ticiHistory.id && Intrinsics.areEqual((Object) this.fileName, (Object) ticiHistory.fileName) && this.lastModified == ticiHistory.lastModified && Intrinsics.areEqual((Object) this.fileType, (Object) ticiHistory.fileType) && this.fileSize == ticiHistory.fileSize && this.totalTextLength == ticiHistory.totalTextLength;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    @Nullable
    public final Integer getFileType() {
        return this.fileType;
    }

    public final long getId() {
        return this.id;
    }

    public final long getLastModified() {
        return this.lastModified;
    }

    public final int getTotalTextLength() {
        return this.totalTextLength;
    }

    public int hashCode() {
        int hashCode = ((((Long.hashCode(this.id) * 31) + this.fileName.hashCode()) * 31) + Long.hashCode(this.lastModified)) * 31;
        Integer num = this.fileType;
        return ((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Long.hashCode(this.fileSize)) * 31) + Integer.hashCode(this.totalTextLength);
    }

    @NotNull
    public String toString() {
        long j = this.id;
        String str = this.fileName;
        long j2 = this.lastModified;
        Integer num = this.fileType;
        long j3 = this.fileSize;
        int i = this.totalTextLength;
        return "TiciHistory(id=" + j + ", fileName=" + str + ", lastModified=" + j2 + ", fileType=" + num + ", fileSize=" + j3 + ", totalTextLength=" + i + ")";
    }
}

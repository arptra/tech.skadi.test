package com.upuphone.ar.tici.phone.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/DefaultTiciContent;", "", "fileName", "", "content", "fileType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getFileName", "getFileType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class DefaultTiciContent {
    @NotNull
    private final String content;
    @NotNull
    private final String fileName;
    private final int fileType;

    public DefaultTiciContent(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "content");
        this.fileName = str;
        this.content = str2;
        this.fileType = i;
    }

    public static /* synthetic */ DefaultTiciContent copy$default(DefaultTiciContent defaultTiciContent, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = defaultTiciContent.fileName;
        }
        if ((i2 & 2) != 0) {
            str2 = defaultTiciContent.content;
        }
        if ((i2 & 4) != 0) {
            i = defaultTiciContent.fileType;
        }
        return defaultTiciContent.copy(str, str2, i);
    }

    @NotNull
    public final String component1() {
        return this.fileName;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    public final int component3() {
        return this.fileType;
    }

    @NotNull
    public final DefaultTiciContent copy(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "content");
        return new DefaultTiciContent(str, str2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultTiciContent)) {
            return false;
        }
        DefaultTiciContent defaultTiciContent = (DefaultTiciContent) obj;
        return Intrinsics.areEqual((Object) this.fileName, (Object) defaultTiciContent.fileName) && Intrinsics.areEqual((Object) this.content, (Object) defaultTiciContent.content) && this.fileType == defaultTiciContent.fileType;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    public final int getFileType() {
        return this.fileType;
    }

    public int hashCode() {
        return (((this.fileName.hashCode() * 31) + this.content.hashCode()) * 31) + Integer.hashCode(this.fileType);
    }

    @NotNull
    public String toString() {
        String str = this.fileName;
        String str2 = this.content;
        int i = this.fileType;
        return "DefaultTiciContent(fileName=" + str + ", content=" + str2 + ", fileType=" + i + ")";
    }
}

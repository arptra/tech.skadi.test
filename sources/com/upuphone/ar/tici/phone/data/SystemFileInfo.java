package com.upuphone.ar.tici.phone.data;

import androidx.annotation.Keep;
import com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "", "name", "", "path", "size", "", "updateTime", "highlight", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "(Ljava/lang/String;Ljava/lang/String;JJLcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;)V", "getHighlight", "()Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "getName", "()Ljava/lang/String;", "getPath", "getSize", "()J", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class SystemFileInfo {
    @Nullable
    private final ParagraphItem highlight;
    @NotNull
    private final String name;
    @NotNull
    private final String path;
    private final long size;
    private final long updateTime;

    public SystemFileInfo(@NotNull String str, @NotNull String str2, long j, long j2, @Nullable ParagraphItem paragraphItem) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "path");
        this.name = str;
        this.path = str2;
        this.size = j;
        this.updateTime = j2;
        this.highlight = paragraphItem;
    }

    public static /* synthetic */ SystemFileInfo copy$default(SystemFileInfo systemFileInfo, String str, String str2, long j, long j2, ParagraphItem paragraphItem, int i, Object obj) {
        if ((i & 1) != 0) {
            str = systemFileInfo.name;
        }
        if ((i & 2) != 0) {
            str2 = systemFileInfo.path;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            j = systemFileInfo.size;
        }
        long j3 = j;
        if ((i & 8) != 0) {
            j2 = systemFileInfo.updateTime;
        }
        long j4 = j2;
        if ((i & 16) != 0) {
            paragraphItem = systemFileInfo.highlight;
        }
        return systemFileInfo.copy(str, str3, j3, j4, paragraphItem);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.path;
    }

    public final long component3() {
        return this.size;
    }

    public final long component4() {
        return this.updateTime;
    }

    @Nullable
    public final ParagraphItem component5() {
        return this.highlight;
    }

    @NotNull
    public final SystemFileInfo copy(@NotNull String str, @NotNull String str2, long j, long j2, @Nullable ParagraphItem paragraphItem) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "path");
        return new SystemFileInfo(str, str2, j, j2, paragraphItem);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemFileInfo)) {
            return false;
        }
        SystemFileInfo systemFileInfo = (SystemFileInfo) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) systemFileInfo.name) && Intrinsics.areEqual((Object) this.path, (Object) systemFileInfo.path) && this.size == systemFileInfo.size && this.updateTime == systemFileInfo.updateTime && Intrinsics.areEqual((Object) this.highlight, (Object) systemFileInfo.highlight);
    }

    @Nullable
    public final ParagraphItem getHighlight() {
        return this.highlight;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        int hashCode = ((((((this.name.hashCode() * 31) + this.path.hashCode()) * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.updateTime)) * 31;
        ParagraphItem paragraphItem = this.highlight;
        return hashCode + (paragraphItem == null ? 0 : paragraphItem.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.name;
        String str2 = this.path;
        long j = this.size;
        long j2 = this.updateTime;
        ParagraphItem paragraphItem = this.highlight;
        return "SystemFileInfo(name=" + str + ", path=" + str2 + ", size=" + j + ", updateTime=" + j2 + ", highlight=" + paragraphItem + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SystemFileInfo(String str, String str2, long j, long j2, ParagraphItem paragraphItem, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, j2, (i & 16) != 0 ? null : paragraphItem);
    }
}

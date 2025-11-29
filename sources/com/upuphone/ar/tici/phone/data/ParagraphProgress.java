package com.upuphone.ar.tici.phone.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/ParagraphProgress;", "", "pageInfo", "Lcom/upuphone/ar/tici/phone/data/PageInfo;", "progress", "", "(Lcom/upuphone/ar/tici/phone/data/PageInfo;I)V", "getPageInfo", "()Lcom/upuphone/ar/tici/phone/data/PageInfo;", "getProgress", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ParagraphProgress {
    @NotNull
    private final PageInfo pageInfo;
    private final int progress;

    public ParagraphProgress(@NotNull PageInfo pageInfo2, int i) {
        Intrinsics.checkNotNullParameter(pageInfo2, "pageInfo");
        this.pageInfo = pageInfo2;
        this.progress = i;
    }

    public static /* synthetic */ ParagraphProgress copy$default(ParagraphProgress paragraphProgress, PageInfo pageInfo2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            pageInfo2 = paragraphProgress.pageInfo;
        }
        if ((i2 & 2) != 0) {
            i = paragraphProgress.progress;
        }
        return paragraphProgress.copy(pageInfo2, i);
    }

    @NotNull
    public final PageInfo component1() {
        return this.pageInfo;
    }

    public final int component2() {
        return this.progress;
    }

    @NotNull
    public final ParagraphProgress copy(@NotNull PageInfo pageInfo2, int i) {
        Intrinsics.checkNotNullParameter(pageInfo2, "pageInfo");
        return new ParagraphProgress(pageInfo2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphProgress)) {
            return false;
        }
        ParagraphProgress paragraphProgress = (ParagraphProgress) obj;
        return Intrinsics.areEqual((Object) this.pageInfo, (Object) paragraphProgress.pageInfo) && this.progress == paragraphProgress.progress;
    }

    @NotNull
    public final PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final int getProgress() {
        return this.progress;
    }

    public int hashCode() {
        return (this.pageInfo.hashCode() * 31) + Integer.hashCode(this.progress);
    }

    @NotNull
    public String toString() {
        PageInfo pageInfo2 = this.pageInfo;
        int i = this.progress;
        return "ParagraphProgress(pageInfo=" + pageInfo2 + ", progress=" + i + ")";
    }
}

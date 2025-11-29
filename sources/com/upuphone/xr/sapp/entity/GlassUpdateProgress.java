package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateProgress;", "", "progress", "", "(I)V", "getProgress", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassUpdateProgress {
    private final int progress;

    public GlassUpdateProgress(int i) {
        this.progress = i;
    }

    public static /* synthetic */ GlassUpdateProgress copy$default(GlassUpdateProgress glassUpdateProgress, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = glassUpdateProgress.progress;
        }
        return glassUpdateProgress.copy(i);
    }

    public final int component1() {
        return this.progress;
    }

    @NotNull
    public final GlassUpdateProgress copy(int i) {
        return new GlassUpdateProgress(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GlassUpdateProgress) && this.progress == ((GlassUpdateProgress) obj).progress;
    }

    public final int getProgress() {
        return this.progress;
    }

    public int hashCode() {
        return Integer.hashCode(this.progress);
    }

    @NotNull
    public String toString() {
        int i = this.progress;
        return "GlassUpdateProgress(progress=" + i + ")";
    }
}

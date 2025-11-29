package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateDownloadProgress;", "", "digest", "", "filePath", "percent", "", "(Ljava/lang/String;Ljava/lang/String;F)V", "getDigest", "()Ljava/lang/String;", "getFilePath", "getPercent", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassUpdateDownloadProgress {
    @Nullable
    private final String digest;
    @Nullable
    private final String filePath;
    private final float percent;

    public GlassUpdateDownloadProgress(@Nullable String str, @Nullable String str2, float f) {
        this.digest = str;
        this.filePath = str2;
        this.percent = f;
    }

    public static /* synthetic */ GlassUpdateDownloadProgress copy$default(GlassUpdateDownloadProgress glassUpdateDownloadProgress, String str, String str2, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            str = glassUpdateDownloadProgress.digest;
        }
        if ((i & 2) != 0) {
            str2 = glassUpdateDownloadProgress.filePath;
        }
        if ((i & 4) != 0) {
            f = glassUpdateDownloadProgress.percent;
        }
        return glassUpdateDownloadProgress.copy(str, str2, f);
    }

    @Nullable
    public final String component1() {
        return this.digest;
    }

    @Nullable
    public final String component2() {
        return this.filePath;
    }

    public final float component3() {
        return this.percent;
    }

    @NotNull
    public final GlassUpdateDownloadProgress copy(@Nullable String str, @Nullable String str2, float f) {
        return new GlassUpdateDownloadProgress(str, str2, f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassUpdateDownloadProgress)) {
            return false;
        }
        GlassUpdateDownloadProgress glassUpdateDownloadProgress = (GlassUpdateDownloadProgress) obj;
        return Intrinsics.areEqual((Object) this.digest, (Object) glassUpdateDownloadProgress.digest) && Intrinsics.areEqual((Object) this.filePath, (Object) glassUpdateDownloadProgress.filePath) && Float.compare(this.percent, glassUpdateDownloadProgress.percent) == 0;
    }

    @Nullable
    public final String getDigest() {
        return this.digest;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    public final float getPercent() {
        return this.percent;
    }

    public int hashCode() {
        String str = this.digest;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.filePath;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + Float.hashCode(this.percent);
    }

    @NotNull
    public String toString() {
        String str = this.digest;
        String str2 = this.filePath;
        float f = this.percent;
        return "GlassUpdateDownloadProgress(digest=" + str + ", filePath=" + str2 + ", percent=" + f + ")";
    }
}

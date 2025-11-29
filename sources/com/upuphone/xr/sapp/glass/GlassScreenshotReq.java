package com.upuphone.xr.sapp.glass;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassScreenshotReq;", "", "filePath", "", "useEncoding", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getFilePath", "()Ljava/lang/String;", "getUseEncoding", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/upuphone/xr/sapp/glass/GlassScreenshotReq;", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassScreenshotReq {
    @Nullable
    private final String filePath;
    @Nullable
    private final Boolean useEncoding;

    public GlassScreenshotReq(@Nullable String str, @Nullable Boolean bool) {
        this.filePath = str;
        this.useEncoding = bool;
    }

    public static /* synthetic */ GlassScreenshotReq copy$default(GlassScreenshotReq glassScreenshotReq, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = glassScreenshotReq.filePath;
        }
        if ((i & 2) != 0) {
            bool = glassScreenshotReq.useEncoding;
        }
        return glassScreenshotReq.copy(str, bool);
    }

    @Nullable
    public final String component1() {
        return this.filePath;
    }

    @Nullable
    public final Boolean component2() {
        return this.useEncoding;
    }

    @NotNull
    public final GlassScreenshotReq copy(@Nullable String str, @Nullable Boolean bool) {
        return new GlassScreenshotReq(str, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassScreenshotReq)) {
            return false;
        }
        GlassScreenshotReq glassScreenshotReq = (GlassScreenshotReq) obj;
        return Intrinsics.areEqual((Object) this.filePath, (Object) glassScreenshotReq.filePath) && Intrinsics.areEqual((Object) this.useEncoding, (Object) glassScreenshotReq.useEncoding);
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    public final Boolean getUseEncoding() {
        return this.useEncoding;
    }

    public int hashCode() {
        String str = this.filePath;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.useEncoding;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        String str = this.filePath;
        Boolean bool = this.useEncoding;
        return "GlassScreenshotReq(filePath=" + str + ", useEncoding=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlassScreenshotReq(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Boolean.TRUE : bool);
    }
}

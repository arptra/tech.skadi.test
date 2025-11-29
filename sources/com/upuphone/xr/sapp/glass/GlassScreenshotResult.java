package com.upuphone.xr.sapp.glass;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassScreenshotResult;", "", "taskId", "", "errorCode", "", "useEncoding", "", "(Ljava/lang/String;ILjava/lang/Boolean;)V", "getErrorCode", "()I", "getTaskId", "()Ljava/lang/String;", "getUseEncoding", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ILjava/lang/Boolean;)Lcom/upuphone/xr/sapp/glass/GlassScreenshotResult;", "equals", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassScreenshotResult {
    private final int errorCode;
    @NotNull
    private final String taskId;
    @Nullable
    private final Boolean useEncoding;

    public GlassScreenshotResult(@NotNull String str, int i, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "taskId");
        this.taskId = str;
        this.errorCode = i;
        this.useEncoding = bool;
    }

    public static /* synthetic */ GlassScreenshotResult copy$default(GlassScreenshotResult glassScreenshotResult, String str, int i, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = glassScreenshotResult.taskId;
        }
        if ((i2 & 2) != 0) {
            i = glassScreenshotResult.errorCode;
        }
        if ((i2 & 4) != 0) {
            bool = glassScreenshotResult.useEncoding;
        }
        return glassScreenshotResult.copy(str, i, bool);
    }

    @NotNull
    public final String component1() {
        return this.taskId;
    }

    public final int component2() {
        return this.errorCode;
    }

    @Nullable
    public final Boolean component3() {
        return this.useEncoding;
    }

    @NotNull
    public final GlassScreenshotResult copy(@NotNull String str, int i, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "taskId");
        return new GlassScreenshotResult(str, i, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassScreenshotResult)) {
            return false;
        }
        GlassScreenshotResult glassScreenshotResult = (GlassScreenshotResult) obj;
        return Intrinsics.areEqual((Object) this.taskId, (Object) glassScreenshotResult.taskId) && this.errorCode == glassScreenshotResult.errorCode && Intrinsics.areEqual((Object) this.useEncoding, (Object) glassScreenshotResult.useEncoding);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getTaskId() {
        return this.taskId;
    }

    @Nullable
    public final Boolean getUseEncoding() {
        return this.useEncoding;
    }

    public int hashCode() {
        int hashCode = ((this.taskId.hashCode() * 31) + Integer.hashCode(this.errorCode)) * 31;
        Boolean bool = this.useEncoding;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.taskId;
        int i = this.errorCode;
        Boolean bool = this.useEncoding;
        return "GlassScreenshotResult(taskId=" + str + ", errorCode=" + i + ", useEncoding=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlassScreenshotResult(String str, int i, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? null : bool);
    }
}

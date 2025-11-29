package com.upuphone.xr.sapp.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassScreenShotResult;", "", "taskId", "", "errorCode", "", "(Ljava/lang/String;I)V", "getErrorCode", "()I", "getTaskId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassScreenShotResult {
    private final int errorCode;
    @Nullable
    private final String taskId;

    public GlassScreenShotResult(@Nullable String str, int i) {
        this.taskId = str;
        this.errorCode = i;
    }

    public static /* synthetic */ GlassScreenShotResult copy$default(GlassScreenShotResult glassScreenShotResult, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = glassScreenShotResult.taskId;
        }
        if ((i2 & 2) != 0) {
            i = glassScreenShotResult.errorCode;
        }
        return glassScreenShotResult.copy(str, i);
    }

    @Nullable
    public final String component1() {
        return this.taskId;
    }

    public final int component2() {
        return this.errorCode;
    }

    @NotNull
    public final GlassScreenShotResult copy(@Nullable String str, int i) {
        return new GlassScreenShotResult(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassScreenShotResult)) {
            return false;
        }
        GlassScreenShotResult glassScreenShotResult = (GlassScreenShotResult) obj;
        return Intrinsics.areEqual((Object) this.taskId, (Object) glassScreenShotResult.taskId) && this.errorCode == glassScreenShotResult.errorCode;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        String str = this.taskId;
        return ((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.errorCode);
    }

    @NotNull
    public String toString() {
        String str = this.taskId;
        int i = this.errorCode;
        return "GlassScreenShotResult(taskId=" + str + ", errorCode=" + i + ")";
    }
}

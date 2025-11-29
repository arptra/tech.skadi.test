package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassLogTaskInfo;", "", "taskId", "", "errorCode", "", "(Ljava/lang/String;I)V", "getErrorCode", "()I", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassLogTaskInfo {
    private final int errorCode;
    @NotNull
    private String taskId;

    public GlassLogTaskInfo(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "taskId");
        this.taskId = str;
        this.errorCode = i;
    }

    public static /* synthetic */ GlassLogTaskInfo copy$default(GlassLogTaskInfo glassLogTaskInfo, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = glassLogTaskInfo.taskId;
        }
        if ((i2 & 2) != 0) {
            i = glassLogTaskInfo.errorCode;
        }
        return glassLogTaskInfo.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.taskId;
    }

    public final int component2() {
        return this.errorCode;
    }

    @NotNull
    public final GlassLogTaskInfo copy(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "taskId");
        return new GlassLogTaskInfo(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassLogTaskInfo)) {
            return false;
        }
        GlassLogTaskInfo glassLogTaskInfo = (GlassLogTaskInfo) obj;
        return Intrinsics.areEqual((Object) this.taskId, (Object) glassLogTaskInfo.taskId) && this.errorCode == glassLogTaskInfo.errorCode;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        return (this.taskId.hashCode() * 31) + Integer.hashCode(this.errorCode);
    }

    public final void setTaskId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taskId = str;
    }

    @NotNull
    public String toString() {
        String str = this.taskId;
        int i = this.errorCode;
        return "GlassLogTaskInfo(taskId=" + str + ", errorCode=" + i + ")";
    }
}

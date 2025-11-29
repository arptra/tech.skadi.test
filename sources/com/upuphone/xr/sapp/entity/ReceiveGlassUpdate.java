package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ReceiveGlassUpdate;", "", "version", "", "digest", "taskId", "delayFailTime", "", "fileSize", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;)V", "getDelayFailTime", "()J", "getDigest", "()Ljava/lang/String;", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTaskId", "getVersion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ReceiveGlassUpdate {
    private final long delayFailTime;
    @NotNull
    private final String digest;
    @Nullable
    private final Long fileSize;
    @NotNull
    private final String taskId;
    @NotNull
    private final String version;

    public ReceiveGlassUpdate(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(str2, "digest");
        Intrinsics.checkNotNullParameter(str3, "taskId");
        this.version = str;
        this.digest = str2;
        this.taskId = str3;
        this.delayFailTime = j;
        this.fileSize = l;
    }

    public final long getDelayFailTime() {
        return this.delayFailTime;
    }

    @NotNull
    public final String getDigest() {
        return this.digest;
    }

    @Nullable
    public final Long getFileSize() {
        return this.fileSize;
    }

    @NotNull
    public final String getTaskId() {
        return this.taskId;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }
}

package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ReceiveUnicronUpdateFileCmd;", "", "version", "", "digest", "taskId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDigest", "()Ljava/lang/String;", "getTaskId", "getVersion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ReceiveUnicronUpdateFileCmd {
    @NotNull
    private final String digest;
    @NotNull
    private final String taskId;
    @NotNull
    private final String version;

    public ReceiveUnicronUpdateFileCmd(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(str2, "digest");
        Intrinsics.checkNotNullParameter(str3, "taskId");
        this.version = str;
        this.digest = str2;
        this.taskId = str3;
    }

    @NotNull
    public final String getDigest() {
        return this.digest;
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

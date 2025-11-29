package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/entity/CheckGlassUpdateFileCmd;", "", "version", "", "digest", "(Ljava/lang/String;Ljava/lang/String;)V", "getDigest", "()Ljava/lang/String;", "getVersion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class CheckGlassUpdateFileCmd {
    @NotNull
    private final String digest;
    @NotNull
    private final String version;

    public CheckGlassUpdateFileCmd(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(str2, "digest");
        this.version = str;
        this.digest = str2;
    }

    @NotNull
    public final String getDigest() {
        return this.digest;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }
}

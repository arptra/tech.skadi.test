package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/UnicronUpdateInfo;", "", "version", "", "digest", "releaseNote", "existsUpdate", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDigest", "()Ljava/lang/String;", "getExistsUpdate", "()Z", "getReleaseNote", "getVersion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class UnicronUpdateInfo {
    @Nullable
    private final String digest;
    private final boolean existsUpdate;
    @Nullable
    private final String releaseNote;
    @Nullable
    private final String version;

    public UnicronUpdateInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z) {
        this.version = str;
        this.digest = str2;
        this.releaseNote = str3;
        this.existsUpdate = z;
    }

    @Nullable
    public final String getDigest() {
        return this.digest;
    }

    public final boolean getExistsUpdate() {
        return this.existsUpdate;
    }

    @Nullable
    public final String getReleaseNote() {
        return this.releaseNote;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }
}

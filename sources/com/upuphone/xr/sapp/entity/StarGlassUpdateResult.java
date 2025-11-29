package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/StarGlassUpdateResult;", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "code", "", "msg", "", "uid", "version", "digest", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDigest", "()Ljava/lang/String;", "getUid", "getVersion", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class StarGlassUpdateResult extends BasicGlassResponse {
    @Nullable
    private final String digest;
    @Nullable
    private final String uid;
    @Nullable
    private final String version;

    public StarGlassUpdateResult(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        super(i, str);
        this.uid = str2;
        this.version = str3;
        this.digest = str4;
    }

    @Nullable
    public final String getDigest() {
        return this.digest;
    }

    @Nullable
    public final String getUid() {
        return this.uid;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public String toString() {
        int code = getCode();
        String msg = getMsg();
        String str = this.uid;
        String str2 = this.version;
        String str3 = this.digest;
        return "StarGlassUpdateResult(code=" + code + ", msg=" + msg + ", uid=" + str + ", version=" + str2 + ", digest=" + str3 + ")";
    }
}

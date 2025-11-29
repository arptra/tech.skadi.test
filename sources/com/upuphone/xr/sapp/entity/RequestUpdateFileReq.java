package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/entity/RequestUpdateFileReq;", "", "digest", "", "version", "(Ljava/lang/String;Ljava/lang/String;)V", "getDigest", "()Ljava/lang/String;", "getVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class RequestUpdateFileReq {
    @Nullable
    private final String digest;
    @Nullable
    private final String version;

    public RequestUpdateFileReq(@Nullable String str, @Nullable String str2) {
        this.digest = str;
        this.version = str2;
    }

    public static /* synthetic */ RequestUpdateFileReq copy$default(RequestUpdateFileReq requestUpdateFileReq, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestUpdateFileReq.digest;
        }
        if ((i & 2) != 0) {
            str2 = requestUpdateFileReq.version;
        }
        return requestUpdateFileReq.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.digest;
    }

    @Nullable
    public final String component2() {
        return this.version;
    }

    @NotNull
    public final RequestUpdateFileReq copy(@Nullable String str, @Nullable String str2) {
        return new RequestUpdateFileReq(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestUpdateFileReq)) {
            return false;
        }
        RequestUpdateFileReq requestUpdateFileReq = (RequestUpdateFileReq) obj;
        return Intrinsics.areEqual((Object) this.digest, (Object) requestUpdateFileReq.digest) && Intrinsics.areEqual((Object) this.version, (Object) requestUpdateFileReq.version);
    }

    @Nullable
    public final String getDigest() {
        return this.digest;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.digest;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.version;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        String str = this.digest;
        String str2 = this.version;
        return "RequestUpdateFileReq(digest=" + str + ", version=" + str2 + ")";
    }
}

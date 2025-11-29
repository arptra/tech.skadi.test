package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/RequestSendAirUpdateFile;", "", "fileName", "", "(Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class RequestSendAirUpdateFile {
    @Nullable
    private final String fileName;

    public RequestSendAirUpdateFile(@Nullable String str) {
        this.fileName = str;
    }

    public static /* synthetic */ RequestSendAirUpdateFile copy$default(RequestSendAirUpdateFile requestSendAirUpdateFile, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestSendAirUpdateFile.fileName;
        }
        return requestSendAirUpdateFile.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.fileName;
    }

    @NotNull
    public final RequestSendAirUpdateFile copy(@Nullable String str) {
        return new RequestSendAirUpdateFile(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RequestSendAirUpdateFile) && Intrinsics.areEqual((Object) this.fileName, (Object) ((RequestSendAirUpdateFile) obj).fileName);
    }

    @Nullable
    public final String getFileName() {
        return this.fileName;
    }

    public int hashCode() {
        String str = this.fileName;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.fileName;
        return "RequestSendAirUpdateFile(fileName=" + str + ")";
    }
}

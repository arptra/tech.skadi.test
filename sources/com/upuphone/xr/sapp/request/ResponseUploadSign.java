package com.upuphone.xr.sapp.request;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/request/ResponseUploadSign;", "", "mime", "", "name", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMime", "()Ljava/lang/String;", "getName", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ResponseUploadSign {
    @NotNull
    private final String mime;
    @NotNull
    private final String name;
    @NotNull
    private final String url;

    public ResponseUploadSign(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "mime");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "url");
        this.mime = str;
        this.name = str2;
        this.url = str3;
    }

    public static /* synthetic */ ResponseUploadSign copy$default(ResponseUploadSign responseUploadSign, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = responseUploadSign.mime;
        }
        if ((i & 2) != 0) {
            str2 = responseUploadSign.name;
        }
        if ((i & 4) != 0) {
            str3 = responseUploadSign.url;
        }
        return responseUploadSign.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.mime;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final ResponseUploadSign copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "mime");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "url");
        return new ResponseUploadSign(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseUploadSign)) {
            return false;
        }
        ResponseUploadSign responseUploadSign = (ResponseUploadSign) obj;
        return Intrinsics.areEqual((Object) this.mime, (Object) responseUploadSign.mime) && Intrinsics.areEqual((Object) this.name, (Object) responseUploadSign.name) && Intrinsics.areEqual((Object) this.url, (Object) responseUploadSign.url);
    }

    @NotNull
    public final String getMime() {
        return this.mime;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((this.mime.hashCode() * 31) + this.name.hashCode()) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.mime;
        String str2 = this.name;
        String str3 = this.url;
        return "ResponseUploadSign(mime=" + str + ", name=" + str2 + ", url=" + str3 + ")";
    }
}

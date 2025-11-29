package io.ktor.client.plugins;

import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/plugins/HttpRequestTimeoutException;", "Ljava/io/IOException;", "Lio/ktor/utils/io/errors/IOException;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "Lio/ktor/client/request/HttpRequestData;", "(Lio/ktor/client/request/HttpRequestData;)V", "url", "", "timeoutMillis", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HttpRequestTimeoutException extends IOException {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequestTimeoutException(@org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.Nullable java.lang.Long r4) {
        /*
            r2 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Request timeout has expired [url="
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = ", request_timeout="
            r0.append(r3)
            if (r4 != 0) goto L_0x001d
            java.lang.String r4 = "unknown"
        L_0x001d:
            r0.append(r4)
            java.lang.String r3 = " ms]"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestTimeoutException.<init>(java.lang.String, java.lang.Long):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequestTimeoutException(@org.jetbrains.annotations.NotNull io.ktor.client.request.HttpRequestBuilder r3) {
        /*
            r2 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            io.ktor.http.URLBuilder r0 = r3.i()
            java.lang.String r0 = r0.c()
            io.ktor.client.plugins.HttpTimeout$Plugin r1 = io.ktor.client.plugins.HttpTimeout.d
            java.lang.Object r3 = r3.f(r1)
            io.ktor.client.plugins.HttpTimeout$HttpTimeoutCapabilityConfiguration r3 = (io.ktor.client.plugins.HttpTimeout.HttpTimeoutCapabilityConfiguration) r3
            if (r3 == 0) goto L_0x001c
            java.lang.Long r3 = r3.d()
            goto L_0x001d
        L_0x001c:
            r3 = 0
        L_0x001d:
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestTimeoutException.<init>(io.ktor.client.request.HttpRequestBuilder):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpRequestTimeoutException(@org.jetbrains.annotations.NotNull io.ktor.client.request.HttpRequestData r3) {
        /*
            r2 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            io.ktor.http.Url r0 = r3.h()
            java.lang.String r0 = r0.toString()
            io.ktor.client.plugins.HttpTimeout$Plugin r1 = io.ktor.client.plugins.HttpTimeout.d
            java.lang.Object r3 = r3.c(r1)
            io.ktor.client.plugins.HttpTimeout$HttpTimeoutCapabilityConfiguration r3 = (io.ktor.client.plugins.HttpTimeout.HttpTimeoutCapabilityConfiguration) r3
            if (r3 == 0) goto L_0x001c
            java.lang.Long r3 = r3.d()
            goto L_0x001d
        L_0x001c:
            r3 = 0
        L_0x001d:
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestTimeoutException.<init>(io.ktor.client.request.HttpRequestData):void");
    }
}

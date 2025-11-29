package okhttp3.internal.http;

import kotlin.Metadata;
import okhttp3.Interceptor;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", "code", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int i) {
        if (i == 100) {
            return true;
        }
        return 102 <= i && i < 200;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
        if (r3.isDuplex() == false) goto L_0x0099;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00aa A[SYNTHETIC, Splitter:B:41:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e5 A[Catch:{ IOException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0120 A[Catch:{ IOException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012f A[Catch:{ IOException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0169 A[Catch:{ IOException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x016e A[Catch:{ IOException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0176 A[Catch:{ IOException -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01ac  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r14) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "Connection"
            java.lang.String r1 = "close"
            java.lang.String r2 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
            okhttp3.internal.http.RealInterceptorChain r14 = (okhttp3.internal.http.RealInterceptorChain) r14
            okhttp3.internal.connection.Exchange r2 = r14.getExchange$okhttp()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            okhttp3.Request r14 = r14.getRequest$okhttp()
            okhttp3.RequestBody r3 = r14.body()
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 0
            r7 = 1
            r8 = 0
            r2.writeRequestHeaders(r14)     // Catch:{ IOException -> 0x004d }
            java.lang.String r9 = r14.method()     // Catch:{ IOException -> 0x004d }
            boolean r9 = okhttp3.internal.http.HttpMethod.permitsRequestBody(r9)     // Catch:{ IOException -> 0x004d }
            if (r9 == 0) goto L_0x008c
            if (r3 == 0) goto L_0x008c
            java.lang.String r9 = "100-continue"
            java.lang.String r10 = "Expect"
            java.lang.String r10 = r14.header(r10)     // Catch:{ IOException -> 0x004d }
            boolean r9 = kotlin.text.StringsKt.equals(r9, r10, r7)     // Catch:{ IOException -> 0x004d }
            if (r9 == 0) goto L_0x0051
            r2.flushRequest()     // Catch:{ IOException -> 0x004d }
            okhttp3.Response$Builder r9 = r2.readResponseHeaders(r7)     // Catch:{ IOException -> 0x004d }
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x004a }
            r10 = r6
            goto L_0x0053
        L_0x004a:
            r3 = move-exception
            r10 = r7
            goto L_0x009e
        L_0x004d:
            r3 = move-exception
            r10 = r7
            r9 = r8
            goto L_0x009e
        L_0x0051:
            r10 = r7
            r9 = r8
        L_0x0053:
            if (r9 != 0) goto L_0x007b
            boolean r11 = r3.isDuplex()     // Catch:{ IOException -> 0x006a }
            if (r11 == 0) goto L_0x006c
            r2.flushRequest()     // Catch:{ IOException -> 0x006a }
            okio.Sink r11 = r2.createRequestBody(r14, r7)     // Catch:{ IOException -> 0x006a }
            okio.BufferedSink r11 = okio.Okio.buffer((okio.Sink) r11)     // Catch:{ IOException -> 0x006a }
            r3.writeTo(r11)     // Catch:{ IOException -> 0x006a }
            goto L_0x0091
        L_0x006a:
            r3 = move-exception
            goto L_0x009e
        L_0x006c:
            okio.Sink r11 = r2.createRequestBody(r14, r6)     // Catch:{ IOException -> 0x006a }
            okio.BufferedSink r11 = okio.Okio.buffer((okio.Sink) r11)     // Catch:{ IOException -> 0x006a }
            r3.writeTo(r11)     // Catch:{ IOException -> 0x006a }
            r11.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x0091
        L_0x007b:
            r2.noRequestBody()     // Catch:{ IOException -> 0x006a }
            okhttp3.internal.connection.RealConnection r11 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x006a }
            boolean r11 = r11.isMultiplexed$okhttp()     // Catch:{ IOException -> 0x006a }
            if (r11 != 0) goto L_0x0091
            r2.noNewExchangesOnConnection()     // Catch:{ IOException -> 0x006a }
            goto L_0x0091
        L_0x008c:
            r2.noRequestBody()     // Catch:{ IOException -> 0x004d }
            r10 = r7
            r9 = r8
        L_0x0091:
            if (r3 == 0) goto L_0x0099
            boolean r3 = r3.isDuplex()     // Catch:{ IOException -> 0x006a }
            if (r3 != 0) goto L_0x009c
        L_0x0099:
            r2.finishRequest()     // Catch:{ IOException -> 0x006a }
        L_0x009c:
            r3 = r8
            goto L_0x00a8
        L_0x009e:
            boolean r11 = r3 instanceof okhttp3.internal.http2.ConnectionShutdownException
            if (r11 != 0) goto L_0x01ac
            boolean r11 = r2.getHasFailure$okhttp()
            if (r11 == 0) goto L_0x01ab
        L_0x00a8:
            if (r9 != 0) goto L_0x00bb
            okhttp3.Response$Builder r9 = r2.readResponseHeaders(r6)     // Catch:{ IOException -> 0x00b8 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch:{ IOException -> 0x00b8 }
            if (r10 == 0) goto L_0x00bb
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x00b8 }
            r10 = r6
            goto L_0x00bb
        L_0x00b8:
            r13 = move-exception
            goto L_0x01a4
        L_0x00bb:
            okhttp3.Response$Builder r9 = r9.request(r14)     // Catch:{ IOException -> 0x00b8 }
            okhttp3.internal.connection.RealConnection r11 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Handshake r11 = r11.handshake()     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response$Builder r9 = r9.handshake(r11)     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response$Builder r9 = r9.sentRequestAtMillis(r4)     // Catch:{ IOException -> 0x00b8 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response$Builder r9 = r9.receivedResponseAtMillis(r11)     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response r9 = r9.build()     // Catch:{ IOException -> 0x00b8 }
            int r11 = r9.code()     // Catch:{ IOException -> 0x00b8 }
            boolean r12 = r13.shouldIgnoreAndWaitForRealResponse(r11)     // Catch:{ IOException -> 0x00b8 }
            if (r12 == 0) goto L_0x0115
            okhttp3.Response$Builder r6 = r2.readResponseHeaders(r6)     // Catch:{ IOException -> 0x00b8 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ IOException -> 0x00b8 }
            if (r10 == 0) goto L_0x00f1
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x00b8 }
        L_0x00f1:
            okhttp3.Response$Builder r14 = r6.request(r14)     // Catch:{ IOException -> 0x00b8 }
            okhttp3.internal.connection.RealConnection r6 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Handshake r6 = r6.handshake()     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response$Builder r14 = r14.handshake(r6)     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response$Builder r14 = r14.sentRequestAtMillis(r4)     // Catch:{ IOException -> 0x00b8 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response$Builder r14 = r14.receivedResponseAtMillis(r4)     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response r9 = r14.build()     // Catch:{ IOException -> 0x00b8 }
            int r11 = r9.code()     // Catch:{ IOException -> 0x00b8 }
        L_0x0115:
            r2.responseHeadersEnd(r9)     // Catch:{ IOException -> 0x00b8 }
            boolean r13 = r13.forWebSocket     // Catch:{ IOException -> 0x00b8 }
            if (r13 == 0) goto L_0x012f
            r13 = 101(0x65, float:1.42E-43)
            if (r11 != r13) goto L_0x012f
            okhttp3.Response$Builder r13 = r9.newBuilder()     // Catch:{ IOException -> 0x00b8 }
            okhttp3.ResponseBody r14 = okhttp3.internal.Util.EMPTY_RESPONSE     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response$Builder r13 = r13.body(r14)     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response r13 = r13.build()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x013f
        L_0x012f:
            okhttp3.Response$Builder r13 = r9.newBuilder()     // Catch:{ IOException -> 0x00b8 }
            okhttp3.ResponseBody r14 = r2.openResponseBody(r9)     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response$Builder r13 = r13.body(r14)     // Catch:{ IOException -> 0x00b8 }
            okhttp3.Response r13 = r13.build()     // Catch:{ IOException -> 0x00b8 }
        L_0x013f:
            okhttp3.Request r14 = r13.request()     // Catch:{ IOException -> 0x00b8 }
            java.lang.String r14 = r14.header(r0)     // Catch:{ IOException -> 0x00b8 }
            boolean r14 = kotlin.text.StringsKt.equals(r1, r14, r7)     // Catch:{ IOException -> 0x00b8 }
            if (r14 != 0) goto L_0x0158
            r14 = 2
            java.lang.String r14 = okhttp3.Response.header$default(r13, r0, r8, r14, r8)     // Catch:{ IOException -> 0x00b8 }
            boolean r14 = kotlin.text.StringsKt.equals(r1, r14, r7)     // Catch:{ IOException -> 0x00b8 }
            if (r14 == 0) goto L_0x015b
        L_0x0158:
            r2.noNewExchangesOnConnection()     // Catch:{ IOException -> 0x00b8 }
        L_0x015b:
            r14 = 204(0xcc, float:2.86E-43)
            if (r11 == r14) goto L_0x0163
            r14 = 205(0xcd, float:2.87E-43)
            if (r11 != r14) goto L_0x01a3
        L_0x0163:
            okhttp3.ResponseBody r14 = r13.body()     // Catch:{ IOException -> 0x00b8 }
            if (r14 == 0) goto L_0x016e
            long r0 = r14.contentLength()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x0170
        L_0x016e:
            r0 = -1
        L_0x0170:
            r4 = 0
            int r14 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x01a3
            java.net.ProtocolException r14 = new java.net.ProtocolException     // Catch:{ IOException -> 0x00b8 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b8 }
            r0.<init>()     // Catch:{ IOException -> 0x00b8 }
            java.lang.String r1 = "HTTP "
            r0.append(r1)     // Catch:{ IOException -> 0x00b8 }
            r0.append(r11)     // Catch:{ IOException -> 0x00b8 }
            java.lang.String r1 = " had non-zero Content-Length: "
            r0.append(r1)     // Catch:{ IOException -> 0x00b8 }
            okhttp3.ResponseBody r13 = r13.body()     // Catch:{ IOException -> 0x00b8 }
            if (r13 == 0) goto L_0x0198
            long r1 = r13.contentLength()     // Catch:{ IOException -> 0x00b8 }
            java.lang.Long r8 = java.lang.Long.valueOf(r1)     // Catch:{ IOException -> 0x00b8 }
        L_0x0198:
            r0.append(r8)     // Catch:{ IOException -> 0x00b8 }
            java.lang.String r13 = r0.toString()     // Catch:{ IOException -> 0x00b8 }
            r14.<init>(r13)     // Catch:{ IOException -> 0x00b8 }
            throw r14     // Catch:{ IOException -> 0x00b8 }
        L_0x01a3:
            return r13
        L_0x01a4:
            if (r3 == 0) goto L_0x01aa
            kotlin.ExceptionsKt.addSuppressed(r3, r13)
            throw r3
        L_0x01aa:
            throw r13
        L_0x01ab:
            throw r3
        L_0x01ac:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}

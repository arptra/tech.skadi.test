package io.ktor.client.call;

import com.google.common.net.HttpHeaders;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00178\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\u00020\u001d8\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0018\u0010 R\u001a\u0010\"\u001a\u00020\u001d8\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u001a\u0010&\u001a\u00020#8\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010$\u001a\u0004\b\t\u0010%R\u001a\u0010+\u001a\u00020'8\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*R \u00102\u001a\u00020,8\u0016X\u0004¢\u0006\u0012\n\u0004\b-\u0010.\u0012\u0004\b0\u00101\u001a\u0004\b\u0012\u0010/¨\u00063"}, d2 = {"Lio/ktor/client/call/SavedHttpResponse;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/call/SavedHttpCall;", "call", "", "body", "origin", "<init>", "(Lio/ktor/client/call/SavedHttpCall;[BLio/ktor/client/statement/HttpResponse;)V", "a", "Lio/ktor/client/call/SavedHttpCall;", "h", "()Lio/ktor/client/call/SavedHttpCall;", "Lkotlinx/coroutines/CompletableJob;", "b", "Lkotlinx/coroutines/CompletableJob;", "context", "Lio/ktor/http/HttpStatusCode;", "c", "Lio/ktor/http/HttpStatusCode;", "f", "()Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/HttpProtocolVersion;", "d", "Lio/ktor/http/HttpProtocolVersion;", "g", "()Lio/ktor/http/HttpProtocolVersion;", "version", "Lio/ktor/util/date/GMTDate;", "e", "Lio/ktor/util/date/GMTDate;", "()Lio/ktor/util/date/GMTDate;", "requestTime", "responseTime", "Lio/ktor/http/Headers;", "Lio/ktor/http/Headers;", "()Lio/ktor/http/Headers;", "headers", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ByteReadChannel;", "i", "Lio/ktor/utils/io/ByteReadChannel;", "()Lio/ktor/utils/io/ByteReadChannel;", "getContent$annotations", "()V", "content", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class SavedHttpResponse extends HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    public final SavedHttpCall f8820a;
    public final CompletableJob b;
    public final HttpStatusCode c;
    public final HttpProtocolVersion d;
    public final GMTDate e;
    public final GMTDate f;
    public final Headers g;
    public final CoroutineContext h;
    public final ByteReadChannel i;

    public SavedHttpResponse(SavedHttpCall savedHttpCall, byte[] bArr, HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(savedHttpCall, "call");
        Intrinsics.checkNotNullParameter(bArr, "body");
        Intrinsics.checkNotNullParameter(httpResponse, HttpHeaders.ReferrerPolicyValues.ORIGIN);
        this.f8820a = savedHttpCall;
        CompletableJob b2 = JobKt__JobKt.b((Job) null, 1, (Object) null);
        this.b = b2;
        this.c = httpResponse.f();
        this.d = httpResponse.g();
        this.e = httpResponse.d();
        this.f = httpResponse.e();
        this.g = httpResponse.a();
        this.h = httpResponse.getCoroutineContext().plus(b2);
        this.i = ByteChannelCtorKt.a(bArr);
    }

    public Headers a() {
        return this.g;
    }

    public ByteReadChannel c() {
        return this.i;
    }

    public GMTDate d() {
        return this.e;
    }

    public GMTDate e() {
        return this.f;
    }

    public HttpStatusCode f() {
        return this.c;
    }

    public HttpProtocolVersion g() {
        return this.d;
    }

    public CoroutineContext getCoroutineContext() {
        return this.h;
    }

    /* renamed from: h */
    public SavedHttpCall p0() {
        return this.f8820a;
    }
}

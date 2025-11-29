package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteChannelCtorKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00108\u0014XD¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lio/ktor/client/call/SavedHttpCall;", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/HttpClient;", "client", "Lio/ktor/client/request/HttpRequest;", "request", "Lio/ktor/client/statement/HttpResponse;", "response", "", "responseBody", "<init>", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;[B)V", "Lio/ktor/utils/io/ByteReadChannel;", "h", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[B", "", "i", "Z", "d", "()Z", "allowDoubleReceive", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class SavedHttpCall extends HttpClientCall {
    public final byte[] h;
    public final boolean i = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavedHttpCall(HttpClient httpClient, HttpRequest httpRequest, HttpResponse httpResponse, byte[] bArr) {
        super(httpClient);
        Intrinsics.checkNotNullParameter(httpClient, "client");
        Intrinsics.checkNotNullParameter(httpRequest, "request");
        Intrinsics.checkNotNullParameter(httpResponse, "response");
        Intrinsics.checkNotNullParameter(bArr, "responseBody");
        this.h = bArr;
        k(new SavedHttpRequest(this, httpRequest));
        l(new SavedHttpResponse(this, bArr, httpResponse));
    }

    public boolean d() {
        return this.i;
    }

    public Object h(Continuation continuation) {
        return ByteChannelCtorKt.a(this.h);
    }
}

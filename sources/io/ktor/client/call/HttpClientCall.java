package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.client.request.DefaultHttpRequest;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.DefaultHttpResponse;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.utils.io.ByteReadChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ\u0013\u0010\f\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR*\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8\u0006@DX.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00178\u0006@DX.¢\u0006\u0012\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\u001bR\u001a\u00100\u001a\u00020,8\u0014XD¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/R\u0014\u00104\u001a\u0002018VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00108\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b6\u00107\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/client/HttpClient;", "client", "<init>", "(Lio/ktor/client/HttpClient;)V", "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lio/ktor/client/request/HttpResponseData;", "responseData", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequestData;Lio/ktor/client/request/HttpResponseData;)V", "Lio/ktor/utils/io/ByteReadChannel;", "h", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "info", "", "c", "(Lio/ktor/util/reflect/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/statement/HttpResponse;", "response", "", "m", "(Lio/ktor/client/statement/HttpResponse;)V", "Lio/ktor/client/HttpClient;", "e", "()Lio/ktor/client/HttpClient;", "Lio/ktor/client/request/HttpRequest;", "<set-?>", "b", "Lio/ktor/client/request/HttpRequest;", "f", "()Lio/ktor/client/request/HttpRequest;", "k", "(Lio/ktor/client/request/HttpRequest;)V", "request", "Lio/ktor/client/statement/HttpResponse;", "g", "()Lio/ktor/client/statement/HttpResponse;", "l", "", "d", "Z", "()Z", "allowDoubleReceive", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/util/Attributes;", "J", "()Lio/ktor/util/Attributes;", "attributes", "Companion", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpClientCall.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpClientCall.kt\nio/ktor/client/call/HttpClientCall\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n1#2:209\n*E\n"})
public class HttpClientCall implements CoroutineScope {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(HttpClientCall.class, "received");
    public static final AttributeKey g = new AttributeKey("CustomResponse");

    /* renamed from: a  reason: collision with root package name */
    public final HttpClient f8818a;
    public HttpRequest b;
    public HttpResponse c;
    public final boolean d;
    @NotNull
    private volatile /* synthetic */ int received;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/client/call/HttpClientCall$Companion;", "", "<init>", "()V", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public HttpClientCall(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "client");
        this.f8818a = httpClient;
        this.received = 0;
    }

    public final Attributes J() {
        return f().J();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(io.ktor.util.reflect.TypeInfo r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.call.HttpClientCall$body$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.client.call.HttpClientCall$body$1 r0 = (io.ktor.client.call.HttpClientCall$body$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.call.HttpClientCall$body$1 r0 = new io.ktor.client.call.HttpClientCall$body$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.Object r6 = r4.c(r5, r0)
            if (r6 != r1) goto L_0x003d
            return r1
        L_0x003d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.call.HttpClientCall.a(io.ktor.util.reflect.TypeInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: io.ktor.util.reflect.TypeInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c9 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ca A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cd A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(io.ktor.util.reflect.TypeInfo r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.client.call.HttpClientCall$bodyNullable$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.ktor.client.call.HttpClientCall$bodyNullable$1 r0 = (io.ktor.client.call.HttpClientCall$bodyNullable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.call.HttpClientCall$bodyNullable$1 r0 = new io.ktor.client.call.HttpClientCall$bodyNullable$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r6 = r0.L$1
            io.ktor.util.reflect.TypeInfo r6 = (io.ktor.util.reflect.TypeInfo) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.client.call.HttpClientCall r7 = (io.ktor.client.call.HttpClientCall) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0035 }
            goto L_0x00ba
        L_0x0035:
            r6 = move-exception
            goto L_0x00f6
        L_0x0038:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0040:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            io.ktor.util.reflect.TypeInfo r7 = (io.ktor.util.reflect.TypeInfo) r7
            java.lang.Object r6 = r0.L$0
            io.ktor.client.call.HttpClientCall r6 = (io.ktor.client.call.HttpClientCall) r6
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x004d }
            goto L_0x009f
        L_0x004d:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x00f6
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.client.statement.HttpResponse r8 = r6.g()     // Catch:{ all -> 0x004d }
            kotlin.reflect.KClass r2 = r7.b()     // Catch:{ all -> 0x004d }
            boolean r8 = io.ktor.util.reflect.TypeInfoJvmKt.a(r8, r2)     // Catch:{ all -> 0x004d }
            if (r8 == 0) goto L_0x0070
            io.ktor.client.statement.HttpResponse r7 = r6.g()     // Catch:{ all -> 0x004d }
            io.ktor.client.statement.HttpResponse r6 = r6.g()
            io.ktor.client.statement.HttpResponseKt.d(r6)
            return r7
        L_0x0070:
            boolean r8 = r6.d()     // Catch:{ all -> 0x004d }
            if (r8 != 0) goto L_0x0086
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r8 = f     // Catch:{ all -> 0x004d }
            r2 = 0
            boolean r8 = r8.compareAndSet(r6, r2, r4)     // Catch:{ all -> 0x004d }
            if (r8 == 0) goto L_0x0080
            goto L_0x0086
        L_0x0080:
            io.ktor.client.call.DoubleReceiveException r7 = new io.ktor.client.call.DoubleReceiveException     // Catch:{ all -> 0x004d }
            r7.<init>(r6)     // Catch:{ all -> 0x004d }
            throw r7     // Catch:{ all -> 0x004d }
        L_0x0086:
            io.ktor.util.Attributes r8 = r6.J()     // Catch:{ all -> 0x004d }
            io.ktor.util.AttributeKey r2 = g     // Catch:{ all -> 0x004d }
            java.lang.Object r8 = r8.e(r2)     // Catch:{ all -> 0x004d }
            if (r8 != 0) goto L_0x009f
            r0.L$0 = r6     // Catch:{ all -> 0x004d }
            r0.L$1 = r7     // Catch:{ all -> 0x004d }
            r0.label = r4     // Catch:{ all -> 0x004d }
            java.lang.Object r8 = r6.h(r0)     // Catch:{ all -> 0x004d }
            if (r8 != r1) goto L_0x009f
            return r1
        L_0x009f:
            io.ktor.client.statement.HttpResponseContainer r2 = new io.ktor.client.statement.HttpResponseContainer     // Catch:{ all -> 0x004d }
            r2.<init>(r7, r8)     // Catch:{ all -> 0x004d }
            io.ktor.client.HttpClient r8 = r6.f8818a     // Catch:{ all -> 0x004d }
            io.ktor.client.statement.HttpResponsePipeline r8 = r8.r()     // Catch:{ all -> 0x004d }
            r0.L$0 = r6     // Catch:{ all -> 0x004d }
            r0.L$1 = r7     // Catch:{ all -> 0x004d }
            r0.label = r3     // Catch:{ all -> 0x004d }
            java.lang.Object r8 = r8.d(r6, r2, r0)     // Catch:{ all -> 0x004d }
            if (r8 != r1) goto L_0x00b7
            return r1
        L_0x00b7:
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x00ba:
            io.ktor.client.statement.HttpResponseContainer r8 = (io.ktor.client.statement.HttpResponseContainer) r8     // Catch:{ all -> 0x0035 }
            java.lang.Object r8 = r8.c()     // Catch:{ all -> 0x0035 }
            io.ktor.http.content.NullBody r0 = io.ktor.http.content.NullBody.f8994a     // Catch:{ all -> 0x0035 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)     // Catch:{ all -> 0x0035 }
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x00ca
            goto L_0x00cb
        L_0x00ca:
            r8 = 0
        L_0x00cb:
            if (r8 == 0) goto L_0x00ee
            kotlin.reflect.KClass r0 = r6.b()     // Catch:{ all -> 0x0035 }
            boolean r0 = io.ktor.util.reflect.TypeInfoJvmKt.a(r8, r0)     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x00d8
            goto L_0x00ee
        L_0x00d8:
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x0035 }
            kotlin.reflect.KClass r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)     // Catch:{ all -> 0x0035 }
            kotlin.reflect.KClass r6 = r6.b()     // Catch:{ all -> 0x0035 }
            io.ktor.client.call.NoTransformationFoundException r0 = new io.ktor.client.call.NoTransformationFoundException     // Catch:{ all -> 0x0035 }
            io.ktor.client.statement.HttpResponse r1 = r7.g()     // Catch:{ all -> 0x0035 }
            r0.<init>(r1, r8, r6)     // Catch:{ all -> 0x0035 }
            throw r0     // Catch:{ all -> 0x0035 }
        L_0x00ee:
            io.ktor.client.statement.HttpResponse r6 = r7.g()
            io.ktor.client.statement.HttpResponseKt.d(r6)
            return r8
        L_0x00f6:
            io.ktor.client.statement.HttpResponse r8 = r7.g()     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = "Receive failed"
            kotlinx.coroutines.CoroutineScopeKt.c(r8, r0, r6)     // Catch:{ all -> 0x0100 }
            throw r6     // Catch:{ all -> 0x0100 }
        L_0x0100:
            r6 = move-exception
            io.ktor.client.statement.HttpResponse r7 = r7.g()
            io.ktor.client.statement.HttpResponseKt.d(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.call.HttpClientCall.c(io.ktor.util.reflect.TypeInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean d() {
        return this.d;
    }

    public final HttpClient e() {
        return this.f8818a;
    }

    public final HttpRequest f() {
        HttpRequest httpRequest = this.b;
        if (httpRequest != null) {
            return httpRequest;
        }
        Intrinsics.throwUninitializedPropertyAccessException("request");
        return null;
    }

    public final HttpResponse g() {
        HttpResponse httpResponse = this.c;
        if (httpResponse != null) {
            return httpResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    public CoroutineContext getCoroutineContext() {
        return g().getCoroutineContext();
    }

    public Object h(Continuation continuation) {
        return g().c();
    }

    public final void k(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<set-?>");
        this.b = httpRequest;
    }

    public final void l(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<set-?>");
        this.c = httpResponse;
    }

    public final void m(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "response");
        l(httpResponse);
    }

    public String toString() {
        return "HttpClientCall[" + f().T() + ", " + g().f() + ']';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpClientCall(HttpClient httpClient, HttpRequestData httpRequestData, HttpResponseData httpResponseData) {
        this(httpClient);
        Intrinsics.checkNotNullParameter(httpClient, "client");
        Intrinsics.checkNotNullParameter(httpRequestData, "requestData");
        Intrinsics.checkNotNullParameter(httpResponseData, "responseData");
        k(new DefaultHttpRequest(this, httpRequestData));
        l(new DefaultHttpResponse(this, httpResponseData));
        if (!(httpResponseData.a() instanceof ByteReadChannel)) {
            J().a(g, httpResponseData.a());
        }
    }
}

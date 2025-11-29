package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \n2\u00020\u0001:\u0002\u000b\fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\r"}, d2 = {"Lio/ktor/client/plugins/HttpRedirect;", "", "", "checkHttpMethod", "allowHttpsDowngrade", "<init>", "(ZZ)V", "a", "Z", "b", "c", "Config", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpRedirect {
    public static final Plugin c = new Plugin((DefaultConstructorMarker) null);
    public static final AttributeKey d = new AttributeKey("HttpRedirect");
    public static final EventDefinition e = new EventDefinition();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8851a;
    public final boolean b;

    @KtorDsl
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/HttpRedirect$Config;", "", "<init>", "()V", "", "a", "Z", "b", "()Z", "setCheckHttpMethod", "(Z)V", "checkHttpMethod", "setAllowHttpsDowngrade", "allowHttpsDowngrade", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        public boolean f8852a = true;
        public boolean b;

        public final boolean a() {
            return this.b;
        }

        public final boolean b() {
            return this.f8852a;
        }
    }

    @SourceDebugExtension({"SMAP\nHttpRedirect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRedirect.kt\nio/ktor/client/plugins/HttpRedirect$Plugin\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n1#2:129\n*E\n"})
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0019\u001a\u00020\u0014*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b8\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lio/ktor/client/plugins/HttpRedirect$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpRedirect$Config;", "Lio/ktor/client/plugins/HttpRedirect;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "g", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/HttpRedirect;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "f", "(Lio/ktor/client/plugins/HttpRedirect;Lio/ktor/client/HttpClient;)V", "Lio/ktor/client/plugins/Sender;", "Lio/ktor/client/request/HttpRequestBuilder;", "context", "Lio/ktor/client/call/HttpClientCall;", "origin", "", "allowHttpsDowngrade", "client", "e", "(Lio/ktor/client/plugins/Sender;Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/call/HttpClientCall;ZLio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "HttpResponseRedirect", "Lio/ktor/events/EventDefinition;", "d", "()Lio/ktor/events/EventDefinition;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Plugin implements HttpClientPlugin<Config, HttpRedirect> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventDefinition d() {
            return HttpRedirect.e;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0117  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0134  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0158  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0166  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x01ac A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x01ad  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x01cd  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object e(io.ktor.client.plugins.Sender r18, io.ktor.client.request.HttpRequestBuilder r19, io.ktor.client.call.HttpClientCall r20, boolean r21, io.ktor.client.HttpClient r22, kotlin.coroutines.Continuation r23) {
            /*
                r17 = this;
                r0 = r20
                r1 = r23
                boolean r2 = r1 instanceof io.ktor.client.plugins.HttpRedirect$Plugin$handleCall$1
                if (r2 == 0) goto L_0x0019
                r2 = r1
                io.ktor.client.plugins.HttpRedirect$Plugin$handleCall$1 r2 = (io.ktor.client.plugins.HttpRedirect$Plugin$handleCall$1) r2
                int r3 = r2.label
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                r5 = r3 & r4
                if (r5 == 0) goto L_0x0019
                int r3 = r3 - r4
                r2.label = r3
                r3 = r17
                goto L_0x0020
            L_0x0019:
                io.ktor.client.plugins.HttpRedirect$Plugin$handleCall$1 r2 = new io.ktor.client.plugins.HttpRedirect$Plugin$handleCall$1
                r3 = r17
                r2.<init>(r3, r1)
            L_0x0020:
                java.lang.Object r1 = r2.result
                java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r5 = r2.label
                r6 = 1
                if (r5 == 0) goto L_0x006c
                if (r5 != r6) goto L_0x0064
                boolean r0 = r2.Z$0
                java.lang.Object r3 = r2.L$8
                kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
                java.lang.Object r5 = r2.L$7
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r7 = r2.L$6
                io.ktor.http.URLProtocol r7 = (io.ktor.http.URLProtocol) r7
                java.lang.Object r8 = r2.L$5
                kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
                java.lang.Object r9 = r2.L$4
                kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
                java.lang.Object r10 = r2.L$3
                io.ktor.client.HttpClient r10 = (io.ktor.client.HttpClient) r10
                java.lang.Object r11 = r2.L$2
                io.ktor.client.request.HttpRequestBuilder r11 = (io.ktor.client.request.HttpRequestBuilder) r11
                java.lang.Object r12 = r2.L$1
                io.ktor.client.plugins.Sender r12 = (io.ktor.client.plugins.Sender) r12
                java.lang.Object r13 = r2.L$0
                io.ktor.client.plugins.HttpRedirect$Plugin r13 = (io.ktor.client.plugins.HttpRedirect.Plugin) r13
                kotlin.ResultKt.throwOnFailure(r1)
                r16 = r2
                r2 = r0
                r0 = r12
                r12 = r6
                r6 = r7
                r7 = r11
                r11 = r8
                r8 = r9
                r9 = r5
                r5 = r16
                goto L_0x01b6
            L_0x0064:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x006c:
                kotlin.ResultKt.throwOnFailure(r1)
                io.ktor.client.statement.HttpResponse r1 = r20.g()
                io.ktor.http.HttpStatusCode r1 = r1.f()
                boolean r1 = io.ktor.client.plugins.HttpRedirectKt.d(r1)
                if (r1 != 0) goto L_0x007e
                return r0
            L_0x007e:
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                r1.element = r0
                kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
                r5.<init>()
                r7 = r19
                r5.element = r7
                io.ktor.client.request.HttpRequest r8 = r20.f()
                io.ktor.http.Url r8 = r8.T()
                io.ktor.http.URLProtocol r8 = r8.k()
                io.ktor.client.request.HttpRequest r0 = r20.f()
                io.ktor.http.Url r0 = r0.T()
                java.lang.String r0 = io.ktor.http.UrlKt.a(r0)
                r9 = r0
                r11 = r5
                r10 = r8
                r0 = r18
                r8 = r1
                r5 = r2
                r1 = r21
                r2 = r22
            L_0x00b1:
                io.ktor.events.Events r12 = r2.g()
                io.ktor.events.EventDefinition r13 = r3.d()
                T r14 = r8.element
                io.ktor.client.call.HttpClientCall r14 = (io.ktor.client.call.HttpClientCall) r14
                io.ktor.client.statement.HttpResponse r14 = r14.g()
                r12.a(r13, r14)
                T r12 = r8.element
                io.ktor.client.call.HttpClientCall r12 = (io.ktor.client.call.HttpClientCall) r12
                io.ktor.client.statement.HttpResponse r12 = r12.g()
                io.ktor.http.Headers r12 = r12.a()
                io.ktor.http.HttpHeaders r13 = io.ktor.http.HttpHeaders.f8966a
                java.lang.String r14 = r13.t()
                java.lang.String r12 = r12.get(r14)
                org.slf4j.Logger r14 = io.ktor.client.plugins.HttpRedirectKt.b
                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                r15.<init>()
                java.lang.String r6 = "Received redirect response to "
                r15.append(r6)
                r15.append(r12)
                java.lang.String r6 = " for request "
                r15.append(r6)
                io.ktor.http.URLBuilder r6 = r7.i()
                r15.append(r6)
                java.lang.String r6 = r15.toString()
                r14.trace(r6)
                io.ktor.client.request.HttpRequestBuilder r6 = new io.ktor.client.request.HttpRequestBuilder
                r6.<init>()
                T r14 = r11.element
                io.ktor.client.request.HttpRequestBuilder r14 = (io.ktor.client.request.HttpRequestBuilder) r14
                r6.p(r14)
                io.ktor.http.URLBuilder r14 = r6.i()
                io.ktor.http.ParametersBuilder r14 = r14.k()
                r14.clear()
                if (r12 == 0) goto L_0x011e
                io.ktor.http.URLBuilder r14 = r6.i()
                io.ktor.http.URLParserKt.j(r14, r12)
            L_0x011e:
                if (r1 != 0) goto L_0x0158
                boolean r12 = io.ktor.http.URLProtocolKt.a(r10)
                if (r12 == 0) goto L_0x0158
                io.ktor.http.URLBuilder r12 = r6.i()
                io.ktor.http.URLProtocol r12 = r12.o()
                boolean r12 = io.ktor.http.URLProtocolKt.a(r12)
                if (r12 != 0) goto L_0x0158
                org.slf4j.Logger r0 = io.ktor.client.plugins.HttpRedirectKt.b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Can not redirect "
                r1.append(r2)
                io.ktor.http.URLBuilder r2 = r7.i()
                r1.append(r2)
                java.lang.String r2 = " because of security downgrade"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.trace(r1)
                T r0 = r8.element
                return r0
            L_0x0158:
                io.ktor.http.URLBuilder r12 = r6.i()
                java.lang.String r12 = io.ktor.http.URLBuilderKt.f(r12)
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r12)
                if (r12 != 0) goto L_0x018d
                io.ktor.http.HeadersBuilder r12 = r6.a()
                java.lang.String r13 = r13.e()
                r12.j(r13)
                org.slf4j.Logger r12 = io.ktor.client.plugins.HttpRedirectKt.b
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r14 = "Removing Authorization header from redirect for "
                r13.append(r14)
                io.ktor.http.URLBuilder r14 = r7.i()
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                r12.trace(r13)
            L_0x018d:
                r11.element = r6
                r5.L$0 = r3
                r5.L$1 = r0
                r5.L$2 = r7
                r5.L$3 = r2
                r5.L$4 = r8
                r5.L$5 = r11
                r5.L$6 = r10
                r5.L$7 = r9
                r5.L$8 = r8
                r5.Z$0 = r1
                r12 = 1
                r5.label = r12
                java.lang.Object r6 = r0.a(r6, r5)
                if (r6 != r4) goto L_0x01ad
                return r4
            L_0x01ad:
                r13 = r3
                r3 = r8
                r16 = r2
                r2 = r1
                r1 = r6
                r6 = r10
                r10 = r16
            L_0x01b6:
                r3.element = r1
                T r1 = r8.element
                io.ktor.client.call.HttpClientCall r1 = (io.ktor.client.call.HttpClientCall) r1
                io.ktor.client.statement.HttpResponse r1 = r1.g()
                io.ktor.http.HttpStatusCode r1 = r1.f()
                boolean r1 = io.ktor.client.plugins.HttpRedirectKt.d(r1)
                if (r1 != 0) goto L_0x01cd
                T r0 = r8.element
                return r0
            L_0x01cd:
                r1 = r2
                r2 = r10
                r3 = r13
                r10 = r6
                r6 = r12
                goto L_0x00b1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRedirect.Plugin.e(io.ktor.client.plugins.Sender, io.ktor.client.request.HttpRequestBuilder, io.ktor.client.call.HttpClientCall, boolean, io.ktor.client.HttpClient, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* renamed from: f */
        public void b(HttpRedirect httpRedirect, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpRedirect, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            ((HttpSend) HttpClientPluginKt.b(httpClient, HttpSend.c)).d(new HttpRedirect$Plugin$install$1(httpRedirect, httpClient, (Continuation<? super HttpRedirect$Plugin$install$1>) null));
        }

        /* renamed from: g */
        public HttpRedirect a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new HttpRedirect(config.b(), config.a(), (DefaultConstructorMarker) null);
        }

        public AttributeKey getKey() {
            return HttpRedirect.d;
        }

        public Plugin() {
        }
    }

    public /* synthetic */ HttpRedirect(boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2);
    }

    public HttpRedirect(boolean z, boolean z2) {
        this.f8851a = z;
        this.b = z2;
    }
}

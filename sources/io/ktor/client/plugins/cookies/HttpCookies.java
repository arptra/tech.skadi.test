package io.ktor.client.plugins.cookies;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00060\u0001j\u0002`\u0002:\u0002'(BC\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012-\u0010\u000b\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n0\u0005ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0016J\u001b\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR>\u0010\u000b\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n0\u00058\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010&\u001a\u00020\"8\u0002X\u0004¢\u0006\f\n\u0004\b#\u0010$\u0012\u0004\b%\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "storage", "", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "defaults", "<init>", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/util/List;)V", "Lio/ktor/http/Url;", "requestUrl", "Lio/ktor/http/Cookie;", "O", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "d", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "Lio/ktor/client/statement/HttpResponse;", "response", "g", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "()V", "a", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "b", "Ljava/util/List;", "Lkotlinx/coroutines/Job;", "c", "Lkotlinx/coroutines/Job;", "getInitializer$annotations", "initializer", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpCookies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpCookies.kt\nio/ktor/client/plugins/cookies/HttpCookies\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n125#2:149\n152#2,3:150\n1855#3,2:153\n1855#3,2:155\n1855#3,2:157\n*S KotlinDebug\n*F\n+ 1 HttpCookies.kt\nio/ktor/client/plugins/cookies/HttpCookies\n*L\n52#1:149\n52#1:150,3\n54#1:153,2\n74#1:155,2\n77#1:157,2\n*E\n"})
public final class HttpCookies implements Closeable {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static final AttributeKey e = new AttributeKey("HttpCookies");

    /* renamed from: a  reason: collision with root package name */
    public final CookiesStorage f8900a;
    public final List b;
    public final Job c = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.d(), (CoroutineStart) null, new HttpCookies$initializer$1(this, (Continuation<? super HttpCookies$initializer$1>) null), 2, (Object) null);

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "Lio/ktor/client/plugins/cookies/HttpCookies;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "d", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/cookies/HttpCookies;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "c", "(Lio/ktor/client/plugins/cookies/HttpCookies;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Companion implements HttpClientPlugin<Config, HttpCookies> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: c */
        public void b(HttpCookies httpCookies, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpCookies, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.n().l(HttpRequestPipeline.g.d(), new HttpCookies$Companion$install$1(httpCookies, (Continuation<? super HttpCookies$Companion$install$1>) null));
            httpClient.s().l(HttpSendPipeline.g.a(), new HttpCookies$Companion$install$2(httpCookies, (Continuation<? super HttpCookies$Companion$install$2>) null));
            httpClient.j().l(HttpReceivePipeline.g.b(), new HttpCookies$Companion$install$3(httpCookies, (Continuation<? super HttpCookies$Companion$install$3>) null));
        }

        /* renamed from: d */
        public HttpCookies a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return config.a();
        }

        public AttributeKey getKey() {
            return HttpCookies.e;
        }

        public Companion() {
        }
    }

    @KtorDsl
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R>\u0010\u000e\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\b\f0\u00078\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "", "<init>", "()V", "Lio/ktor/client/plugins/cookies/HttpCookies;", "a", "()Lio/ktor/client/plugins/cookies/HttpCookies;", "", "Lkotlin/Function2;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Ljava/util/List;", "defaults", "b", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "getStorage", "()Lio/ktor/client/plugins/cookies/CookiesStorage;", "setStorage", "(Lio/ktor/client/plugins/cookies/CookiesStorage;)V", "storage", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        public final List f8901a = new ArrayList();
        public CookiesStorage b = new AcceptAllCookiesStorage();

        public final HttpCookies a() {
            return new HttpCookies(this.b, this.f8901a);
        }
    }

    public HttpCookies(CookiesStorage cookiesStorage, List list) {
        Intrinsics.checkNotNullParameter(cookiesStorage, "storage");
        Intrinsics.checkNotNullParameter(list, "defaults");
        this.f8900a = cookiesStorage;
        this.b = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: io.ktor.http.Url} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v4 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0060, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object O(io.ktor.http.Url r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.cookies.HttpCookies$get$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.ktor.client.plugins.cookies.HttpCookies$get$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies$get$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cookies.HttpCookies$get$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$get$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0063
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            io.ktor.http.Url r6 = (io.ktor.http.Url) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.client.plugins.cookies.HttpCookies r5 = (io.ktor.client.plugins.cookies.HttpCookies) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0053
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.Job r7 = r5.c
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.i0(r0)
            if (r7 != r1) goto L_0x0053
            return r1
        L_0x0053:
            io.ktor.client.plugins.cookies.CookiesStorage r5 = r5.f8900a
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r5.O(r6, r0)
            if (r7 != r1) goto L_0x0063
            return r1
        L_0x0063:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.O(io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void close() {
        this.f8900a.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(io.ktor.client.request.HttpRequestBuilder r23, kotlin.coroutines.Continuation r24) {
        /*
            r22 = this;
            r0 = r24
            boolean r1 = r0 instanceof io.ktor.client.plugins.cookies.HttpCookies$captureHeaderCookies$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            io.ktor.client.plugins.cookies.HttpCookies$captureHeaderCookies$1 r1 = (io.ktor.client.plugins.cookies.HttpCookies$captureHeaderCookies$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r22
            goto L_0x001e
        L_0x0017:
            io.ktor.client.plugins.cookies.HttpCookies$captureHeaderCookies$1 r1 = new io.ktor.client.plugins.cookies.HttpCookies$captureHeaderCookies$1
            r2 = r22
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L_0x0047
            if (r4 != r5) goto L_0x003f
            java.lang.Object r2 = r1.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r1.L$1
            io.ktor.http.Url r4 = (io.ktor.http.Url) r4
            java.lang.Object r6 = r1.L$0
            io.ktor.client.plugins.cookies.HttpCookies r6 = (io.ktor.client.plugins.cookies.HttpCookies) r6
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r4
            r4 = r2
            r2 = r6
            goto L_0x00dc
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r0)
            io.ktor.http.URLBuilder r0 = r23.i()
            io.ktor.http.URLBuilder r0 = io.ktor.http.URLBuilderKt.e(r0)
            io.ktor.http.Url r0 = r0.b()
            io.ktor.http.HeadersBuilder r4 = r23.a()
            io.ktor.http.HttpHeaders r6 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r6 = r6.l()
            java.lang.String r4 = r4.h(r6)
            r6 = 0
            if (r4 == 0) goto L_0x00d6
            org.slf4j.Logger r7 = io.ktor.client.plugins.cookies.HttpCookiesKt.f8902a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Saving cookie "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r9 = " for "
            r8.append(r9)
            io.ktor.http.URLBuilder r9 = r23.i()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.trace(r8)
            r7 = 0
            r8 = 2
            java.util.Map r4 = io.ktor.http.CookieKt.d(r4, r7, r8, r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = r4.size()
            r6.<init>(r7)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x00a2:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x00d6
            java.lang.Object r7 = r4.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getKey()
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r7 = r7.getValue()
            r11 = r7
            java.lang.String r11 = (java.lang.String) r11
            io.ktor.http.Cookie r7 = new io.ktor.http.Cookie
            r20 = 1020(0x3fc, float:1.43E-42)
            r21 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r9 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r6.add(r7)
            goto L_0x00a2
        L_0x00d6:
            if (r6 == 0) goto L_0x00f9
            java.util.Iterator r4 = r6.iterator()
        L_0x00dc:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00f9
            java.lang.Object r6 = r4.next()
            io.ktor.http.Cookie r6 = (io.ktor.http.Cookie) r6
            io.ktor.client.plugins.cookies.CookiesStorage r7 = r2.f8900a
            r1.L$0 = r2
            r1.L$1 = r0
            r1.L$2 = r4
            r1.label = r5
            java.lang.Object r6 = r7.o0(r0, r6, r1)
            if (r6 != r3) goto L_0x00dc
            return r3
        L_0x00f9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.d(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(io.ktor.client.statement.HttpResponse r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r9 = r0.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.L$1
            io.ktor.http.Url r10 = (io.ktor.http.Url) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.client.plugins.cookies.HttpCookies r2 = (io.ktor.client.plugins.cookies.HttpCookies) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            r10 = r2
            goto L_0x00a2
        L_0x0037:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r11)
            io.ktor.client.request.HttpRequest r11 = io.ktor.client.statement.HttpResponseKt.e(r10)
            io.ktor.http.Url r11 = r11.T()
            io.ktor.http.Headers r2 = r10.a()
            io.ktor.http.HttpHeaders r4 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r4 = r4.y()
            java.util.List r2 = r2.a(r4)
            if (r2 == 0) goto L_0x0097
            java.util.Iterator r2 = r2.iterator()
        L_0x005e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0097
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            org.slf4j.Logger r5 = io.ktor.client.plugins.cookies.HttpCookiesKt.f8902a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Received cookie "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = " in response for "
            r6.append(r4)
            io.ktor.client.call.HttpClientCall r4 = r10.p0()
            io.ktor.client.request.HttpRequest r4 = r4.f()
            io.ktor.http.Url r4 = r4.T()
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.trace(r4)
            goto L_0x005e
        L_0x0097:
            java.util.List r10 = io.ktor.http.HttpMessagePropertiesKt.f(r10)
            java.util.Iterator r10 = r10.iterator()
            r8 = r10
            r10 = r9
            r9 = r8
        L_0x00a2:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x00bf
            java.lang.Object r2 = r9.next()
            io.ktor.http.Cookie r2 = (io.ktor.http.Cookie) r2
            io.ktor.client.plugins.cookies.CookiesStorage r4 = r10.f8900a
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r2 = r4.o0(r11, r2, r0)
            if (r2 != r1) goto L_0x00a2
            return r1
        L_0x00bf:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.g(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: io.ktor.client.request.HttpRequestBuilder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(io.ktor.client.request.HttpRequestBuilder r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.client.request.HttpRequestBuilder r5 = (io.ktor.client.request.HttpRequestBuilder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0050
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.http.URLBuilder r6 = r5.i()
            io.ktor.http.URLBuilder r6 = io.ktor.http.URLBuilderKt.e(r6)
            io.ktor.http.Url r6 = r6.b()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.O(r6, r0)
            if (r6 != r1) goto L_0x0050
            return r1
        L_0x0050:
            java.util.List r6 = (java.util.List) r6
            boolean r4 = r6.isEmpty()
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x008f
            java.lang.String r4 = io.ktor.client.plugins.cookies.HttpCookiesKt.e(r6)
            io.ktor.http.HeadersBuilder r6 = r5.a()
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r0 = r0.l()
            r6.k(r0, r4)
            org.slf4j.Logger r6 = io.ktor.client.plugins.cookies.HttpCookiesKt.f8902a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Sending cookie "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = " for "
            r0.append(r4)
            io.ktor.http.URLBuilder r4 = r5.i()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r6.trace(r4)
            goto L_0x009c
        L_0x008f:
            io.ktor.http.HeadersBuilder r4 = r5.a()
            io.ktor.http.HttpHeaders r5 = io.ktor.http.HttpHeaders.f8966a
            java.lang.String r5 = r5.l()
            r4.j(r5)
        L_0x009c:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.i(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

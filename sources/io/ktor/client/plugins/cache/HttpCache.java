package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.cache.storage.CacheStorage;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.pipeline.PipelinePhase;
import io.ktor.utils.io.ByteChannelCtorKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 52\u00020\u0001:\u000267B9\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015JA\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\"\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R \u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'R \u0010\u0004\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0012\n\u0004\b*\u0010%\u0012\u0004\b,\u0010)\u001a\u0004\b+\u0010'R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010.R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u0010\n\u001a\u00020\b8\u0000X\u0004¢\u0006\f\n\u0004\b2\u00101\u001a\u0004\b3\u00104\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache;", "", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "publicStorage", "privateStorage", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "publicStorageNew", "privateStorageNew", "", "useOldStorage", "isSharedClient", "<init>", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/plugins/cache/storage/CacheStorage;ZZ)V", "Lio/ktor/client/statement/HttpResponse;", "response", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "h", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequest;", "request", "i", "(Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "storage", "", "", "varyKeys", "Lio/ktor/http/Url;", "url", "j", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Ljava/util/Map;Lio/ktor/http/Url;Lio/ktor/client/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestBuilder;", "context", "Lio/ktor/http/content/OutgoingContent;", "content", "k", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "m", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPublicStorage$annotations", "()V", "b", "l", "getPrivateStorage$annotations", "c", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "d", "e", "Z", "f", "n", "()Z", "g", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpCache.kt\nio/ktor/client/plugins/cache/HttpCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,375:1\n1#2:376\n1054#3:377\n288#3:378\n289#3:382\n167#4,3:379\n167#4,3:383\n*S KotlinDebug\n*F\n+ 1 HttpCache.kt\nio/ktor/client/plugins/cache/HttpCache\n*L\n317#1:377\n318#1:378\n318#1:382\n319#1:379,3\n331#1:383,3\n*E\n"})
public final class HttpCache {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public static final AttributeKey h = new AttributeKey("HttpCache");
    public static final EventDefinition i = new EventDefinition();

    /* renamed from: a  reason: collision with root package name */
    public final HttpCacheStorage f8888a;
    public final HttpCacheStorage b;
    public final CacheStorage c;
    public final CacheStorage d;
    public final boolean e;
    public final boolean f;

    @SourceDebugExtension({"SMAP\nHttpCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpCache.kt\nio/ktor/client/plugins/cache/HttpCache$Companion\n+ 2 Headers.kt\nio/ktor/http/Headers$Companion\n*L\n1#1,375:1\n24#2:376\n*S KotlinDebug\n*F\n+ 1 HttpCache.kt\nio/ktor/client/plugins/cache/HttpCache$Companion\n*L\n234#1:376\n*E\n"})
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0016\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0018\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010\u001e\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cache/HttpCache$Config;", "Lio/ktor/client/plugins/cache/HttpCache;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "f", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/cache/HttpCache;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "e", "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/call/HttpClientCall;", "cachedCall", "g", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/HttpClient;Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "cachedResponse", "Lkotlin/coroutines/CoroutineContext;", "callContext", "i", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lio/ktor/client/HttpClient;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "HttpResponseFromCache", "Lio/ktor/events/EventDefinition;", "d", "()Lio/ktor/events/EventDefinition;", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Companion implements HttpClientPlugin<Config, HttpCache> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventDefinition d() {
            return HttpCache.i;
        }

        /* renamed from: e */
        public void b(HttpCache httpCache, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpCache, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            PipelinePhase pipelinePhase = new PipelinePhase("Cache");
            httpClient.s().j(HttpSendPipeline.g.a(), pipelinePhase);
            httpClient.s().l(pipelinePhase, new HttpCache$Companion$install$1(httpCache, httpClient, (Continuation<? super HttpCache$Companion$install$1>) null));
            httpClient.j().l(HttpReceivePipeline.g.b(), new HttpCache$Companion$install$2(httpCache, httpClient, (Continuation<? super HttpCache$Companion$install$2>) null));
        }

        /* renamed from: f */
        public HttpCache a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new HttpCache(config.c(), config.a(), config.d(), config.b(), config.e(), config.f(), (DefaultConstructorMarker) null);
        }

        public final Object g(PipelineContext pipelineContext, HttpClient httpClient, HttpClientCall httpClientCall, Continuation continuation) {
            pipelineContext.c();
            httpClient.g().a(d(), httpClientCall.g());
            Object g = pipelineContext.g(httpClientCall, continuation);
            return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
        }

        public AttributeKey getKey() {
            return HttpCache.h;
        }

        public final Object h(PipelineContext pipelineContext, HttpClient httpClient, Continuation continuation) {
            pipelineContext.c();
            HttpRequestData b = ((HttpRequestBuilder) pipelineContext.d()).b();
            Object g = pipelineContext.g(new HttpClientCall(httpClient, b, new HttpResponseData(HttpStatusCode.c.k(), DateJvmKt.c((Long) null, 1, (Object) null), Headers.f8962a.a(), HttpProtocolVersion.d.c(), ByteChannelCtorKt.a(new byte[0]), b.d())), continuation);
            return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
        }

        public final Object i(PipelineContext pipelineContext, CachedResponseData cachedResponseData, HttpClient httpClient, CoroutineContext coroutineContext, Continuation continuation) {
            HttpRequestData b = ((HttpRequestBuilder) pipelineContext.d()).b();
            HttpStatusCode g = cachedResponseData.g();
            GMTDate e = cachedResponseData.e();
            Headers.Companion companion = Headers.f8962a;
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
            headersBuilder.d(cachedResponseData.d());
            headersBuilder.e(HttpHeaders.f8966a.D(), "110");
            Unit unit = Unit.INSTANCE;
            HttpClientCall httpClientCall = new HttpClientCall(httpClient, b, new HttpResponseData(g, e, headersBuilder.n(), cachedResponseData.j(), ByteChannelCtorKt.a(cachedResponseData.b()), coroutineContext));
            pipelineContext.c();
            httpClient.g().a(d(), httpClientCall.g());
            Object g2 = pipelineContext.g(httpClientCall, continuation);
            return g2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g2 : Unit.INSTANCE;
        }

        public Companion() {
        }
    }

    @KtorDsl
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0016\u001a\u00020\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R0\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u000e¢\u0006\u0018\n\u0004\b\u0012\u0010\u001c\u0012\u0004\b \u0010\u0003\u001a\u0004\b\u0010\u0010\u001d\"\u0004\b\u001e\u0010\u001fR0\u0010$\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u000e¢\u0006\u0018\n\u0004\b\u0017\u0010\u001c\u0012\u0004\b#\u0010\u0003\u001a\u0004\b\u0005\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006%"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Config;", "", "<init>", "()V", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "a", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "d", "()Lio/ktor/client/plugins/cache/storage/CacheStorage;", "setPublicStorageNew$ktor_client_core", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", "publicStorageNew", "b", "setPrivateStorageNew$ktor_client_core", "privateStorageNew", "", "c", "Z", "e", "()Z", "setUseOldStorage$ktor_client_core", "(Z)V", "useOldStorage", "f", "setShared", "isShared", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "value", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "setPublicStorage", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;)V", "getPublicStorage$annotations", "publicStorage", "setPrivateStorage", "getPrivateStorage$annotations", "privateStorage", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        public CacheStorage f8889a;
        public CacheStorage b;
        public boolean c;
        public boolean d;
        public HttpCacheStorage e;
        public HttpCacheStorage f;

        public Config() {
            CacheStorage.Companion companion = CacheStorage.f8893a;
            this.f8889a = (CacheStorage) companion.a().invoke();
            this.b = (CacheStorage) companion.a().invoke();
            HttpCacheStorage.Companion companion2 = HttpCacheStorage.f8896a;
            this.e = (HttpCacheStorage) companion2.a().invoke();
            this.f = (HttpCacheStorage) companion2.a().invoke();
        }

        public final HttpCacheStorage a() {
            return this.f;
        }

        public final CacheStorage b() {
            return this.b;
        }

        public final HttpCacheStorage c() {
            return this.e;
        }

        public final CacheStorage d() {
            return this.f8889a;
        }

        public final boolean e() {
            return this.c;
        }

        public final boolean f() {
            return this.d;
        }
    }

    public /* synthetic */ HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, CacheStorage cacheStorage, CacheStorage cacheStorage2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpCacheStorage, httpCacheStorage2, cacheStorage, cacheStorage2, z, z2);
    }

    public final Object h(HttpResponse httpResponse, Continuation continuation) {
        HttpRequest f2 = httpResponse.p0().f();
        List a2 = HttpMessagePropertiesKt.a(httpResponse);
        List a3 = HttpMessagePropertiesKt.a(f2);
        CacheControl cacheControl = CacheControl.f8887a;
        boolean contains = a2.contains(cacheControl.e());
        if (contains && this.f) {
            return null;
        }
        CacheStorage cacheStorage = contains ? this.d : this.c;
        if (a2.contains(cacheControl.c()) || a3.contains(cacheControl.c())) {
            return null;
        }
        return HttpCacheStorageKt.b(cacheStorage, httpResponse, HttpCacheEntryKt.e(httpResponse), this.f, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(io.ktor.client.request.HttpRequest r13, io.ktor.client.statement.HttpResponse r14, kotlin.coroutines.Continuation r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof io.ktor.client.plugins.cache.HttpCache$findAndRefresh$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            io.ktor.client.plugins.cache.HttpCache$findAndRefresh$1 r0 = (io.ktor.client.plugins.cache.HttpCache$findAndRefresh$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cache.HttpCache$findAndRefresh$1 r0 = new io.ktor.client.plugins.cache.HttpCache$findAndRefresh$1
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            r8 = 2
            r9 = 0
            if (r1 == 0) goto L_0x005a
            if (r1 == r2) goto L_0x0042
            if (r1 != r8) goto L_0x003a
            java.lang.Object r12 = r0.L$2
            io.ktor.client.plugins.cache.storage.CachedResponseData r12 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r12
            java.lang.Object r13 = r0.L$1
            io.ktor.client.statement.HttpResponse r13 = (io.ktor.client.statement.HttpResponse) r13
            java.lang.Object r14 = r0.L$0
            io.ktor.client.request.HttpRequest r14 = (io.ktor.client.request.HttpRequest) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00da
        L_0x003a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0042:
            java.lang.Object r12 = r0.L$4
            java.util.Map r12 = (java.util.Map) r12
            java.lang.Object r13 = r0.L$3
            io.ktor.client.plugins.cache.storage.CacheStorage r13 = (io.ktor.client.plugins.cache.storage.CacheStorage) r13
            java.lang.Object r14 = r0.L$2
            io.ktor.client.statement.HttpResponse r14 = (io.ktor.client.statement.HttpResponse) r14
            java.lang.Object r1 = r0.L$1
            io.ktor.client.request.HttpRequest r1 = (io.ktor.client.request.HttpRequest) r1
            java.lang.Object r2 = r0.L$0
            io.ktor.client.plugins.cache.HttpCache r2 = (io.ktor.client.plugins.cache.HttpCache) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00a7
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r15)
            io.ktor.client.call.HttpClientCall r15 = r14.p0()
            io.ktor.client.request.HttpRequest r15 = r15.f()
            io.ktor.http.Url r4 = r15.T()
            java.util.List r15 = io.ktor.http.HttpMessagePropertiesKt.a(r14)
            io.ktor.client.plugins.cache.CacheControl r1 = io.ktor.client.plugins.cache.CacheControl.f8887a
            io.ktor.http.HeaderValue r1 = r1.e()
            boolean r15 = r15.contains(r1)
            if (r15 == 0) goto L_0x007e
            boolean r1 = r12.f
            if (r1 == 0) goto L_0x007e
            return r9
        L_0x007e:
            if (r15 == 0) goto L_0x0083
            io.ktor.client.plugins.cache.storage.CacheStorage r15 = r12.d
            goto L_0x0085
        L_0x0083:
            io.ktor.client.plugins.cache.storage.CacheStorage r15 = r12.c
        L_0x0085:
            java.util.Map r10 = io.ktor.client.plugins.cache.HttpCacheEntryKt.e(r14)
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.L$3 = r15
            r0.L$4 = r10
            r0.label = r2
            r1 = r12
            r2 = r15
            r3 = r10
            r5 = r13
            r6 = r0
            java.lang.Object r1 = r1.j(r2, r3, r4, r5, r6)
            if (r1 != r7) goto L_0x00a1
            return r7
        L_0x00a1:
            r2 = r12
            r12 = r10
            r11 = r1
            r1 = r13
            r13 = r15
            r15 = r11
        L_0x00a7:
            io.ktor.client.plugins.cache.storage.CachedResponseData r15 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r15
            if (r15 != 0) goto L_0x00ac
            return r9
        L_0x00ac:
            boolean r3 = r12.isEmpty()
            if (r3 == 0) goto L_0x00b6
            java.util.Map r12 = r15.i()
        L_0x00b6:
            io.ktor.http.Url r3 = r1.T()
            boolean r2 = r2.f
            io.ktor.util.date.GMTDate r2 = io.ktor.client.plugins.cache.HttpCacheEntryKt.c(r14, r2, r9, r8, r9)
            io.ktor.client.plugins.cache.storage.CachedResponseData r12 = r15.a(r12, r2)
            r0.L$0 = r1
            r0.L$1 = r14
            r0.L$2 = r15
            r0.L$3 = r9
            r0.L$4 = r9
            r0.label = r8
            java.lang.Object r12 = r13.a(r3, r12, r0)
            if (r12 != r7) goto L_0x00d7
            return r7
        L_0x00d7:
            r13 = r14
            r12 = r15
            r14 = r1
        L_0x00da:
            io.ktor.client.call.HttpClientCall r15 = r14.p0()
            io.ktor.client.HttpClient r15 = r15.e()
            kotlin.coroutines.CoroutineContext r13 = r13.getCoroutineContext()
            io.ktor.client.statement.HttpResponse r12 = io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.a(r12, r15, r14, r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.i(io.ktor.client.request.HttpRequest, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ca A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(io.ktor.client.plugins.cache.storage.CacheStorage r6, java.util.Map r7, io.ktor.http.Url r8, io.ktor.client.request.HttpRequest r9, kotlin.coroutines.Continuation r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.cache.HttpCache$findResponse$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.client.plugins.cache.HttpCache$findResponse$1 r0 = (io.ktor.client.plugins.cache.HttpCache$findResponse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cache.HttpCache$findResponse$1 r0 = new io.ktor.client.plugins.cache.HttpCache$findResponse$1
            r0.<init>(r5, r10)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003c
            if (r1 == r3) goto L_0x0038
            if (r1 != r2) goto L_0x0030
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0078
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004f
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r7.isEmpty()
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x0050
            r0.label = r3
            java.lang.Object r5 = r6.b(r8, r7, r0)
            if (r5 != r10) goto L_0x004f
            return r10
        L_0x004f:
            return r5
        L_0x0050:
            io.ktor.http.content.OutgoingContent r5 = r9.getContent()
            io.ktor.client.plugins.cache.HttpCache$findResponse$requestHeaders$1 r7 = new io.ktor.client.plugins.cache.HttpCache$findResponse$requestHeaders$1
            io.ktor.http.Headers r1 = r9.a()
            r7.<init>(r1)
            io.ktor.client.plugins.cache.HttpCache$findResponse$requestHeaders$2 r1 = new io.ktor.client.plugins.cache.HttpCache$findResponse$requestHeaders$2
            io.ktor.http.Headers r9 = r9.a()
            r1.<init>(r9)
            kotlin.jvm.functions.Function1 r5 = io.ktor.client.plugins.cache.HttpCacheKt.d(r5, r7, r1)
            r0.L$0 = r5
            r0.label = r2
            java.lang.Object r6 = r6.c(r8, r0)
            if (r6 != r10) goto L_0x0075
            return r10
        L_0x0075:
            r4 = r6
            r6 = r5
            r5 = r4
        L_0x0078:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            io.ktor.client.plugins.cache.HttpCache$findResponse$$inlined$sortedByDescending$1 r7 = new io.ktor.client.plugins.cache.HttpCache$findResponse$$inlined$sortedByDescending$1
            r7.<init>()
            java.util.List r5 = kotlin.collections.CollectionsKt.sortedWith(r5, r7)
            java.util.Iterator r5 = r5.iterator()
        L_0x0087:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00ca
            java.lang.Object r7 = r5.next()
            r8 = r7
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r8
            java.util.Map r8 = r8.i()
            boolean r9 = r8.isEmpty()
            if (r9 == 0) goto L_0x009f
            goto L_0x00cb
        L_0x009f:
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x00a7:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00cb
            java.lang.Object r9 = r8.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r6.invoke(r10)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r9)
            if (r9 != 0) goto L_0x00a7
            goto L_0x0087
        L_0x00ca:
            r7 = 0
        L_0x00cb:
            io.ktor.client.plugins.cache.storage.CachedResponseData r7 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.j(io.ktor.client.plugins.cache.storage.CacheStorage, java.util.Map, io.ktor.http.Url, io.ktor.client.request.HttpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0099 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(io.ktor.client.request.HttpRequestBuilder r9, io.ktor.http.content.OutgoingContent r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof io.ktor.client.plugins.cache.HttpCache$findResponse$4
            if (r0 == 0) goto L_0x0013
            r0 = r11
            io.ktor.client.plugins.cache.HttpCache$findResponse$4 r0 = (io.ktor.client.plugins.cache.HttpCache$findResponse$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.client.plugins.cache.HttpCache$findResponse$4 r0 = new io.ktor.client.plugins.cache.HttpCache$findResponse$4
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x003e
            if (r2 != r4) goto L_0x0036
            java.lang.Object r8 = r0.L$1
            java.util.Set r8 = (java.util.Set) r8
            java.lang.Object r9 = r0.L$0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x009e
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            java.lang.Object r8 = r0.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r0.L$1
            io.ktor.http.Url r9 = (io.ktor.http.Url) r9
            java.lang.Object r10 = r0.L$0
            io.ktor.client.plugins.cache.HttpCache r10 = (io.ktor.client.plugins.cache.HttpCache) r10
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r10
            r10 = r8
            r8 = r7
            goto L_0x0087
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r11)
            io.ktor.http.URLBuilder r11 = r9.i()
            io.ktor.http.Url r11 = io.ktor.http.URLUtilsKt.c(r11)
            io.ktor.client.plugins.cache.HttpCache$findResponse$lookup$1 r2 = new io.ktor.client.plugins.cache.HttpCache$findResponse$lookup$1
            io.ktor.http.HeadersBuilder r6 = r9.a()
            r2.<init>(r6)
            io.ktor.client.plugins.cache.HttpCache$findResponse$lookup$2 r6 = new io.ktor.client.plugins.cache.HttpCache$findResponse$lookup$2
            io.ktor.http.HeadersBuilder r9 = r9.a()
            r6.<init>(r9)
            kotlin.jvm.functions.Function1 r9 = io.ktor.client.plugins.cache.HttpCacheKt.d(r10, r2, r6)
            io.ktor.client.plugins.cache.storage.CacheStorage r10 = r8.d
            r0.L$0 = r8
            r0.L$1 = r11
            r0.L$2 = r9
            r0.label = r5
            java.lang.Object r10 = r10.c(r11, r0)
            if (r10 != r1) goto L_0x0083
            return r1
        L_0x0083:
            r7 = r10
            r10 = r9
            r9 = r11
            r11 = r7
        L_0x0087:
            java.util.Set r11 = (java.util.Set) r11
            io.ktor.client.plugins.cache.storage.CacheStorage r8 = r8.c
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r3
            r0.label = r4
            java.lang.Object r8 = r8.c(r9, r0)
            if (r8 != r1) goto L_0x009a
            return r1
        L_0x009a:
            r9 = r10
            r7 = r11
            r11 = r8
            r8 = r7
        L_0x009e:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Set r8 = kotlin.collections.SetsKt.plus(r8, r11)
            java.util.Iterator r8 = r8.iterator()
        L_0x00a8:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x00f1
            java.lang.Object r10 = r8.next()
            io.ktor.client.plugins.cache.storage.CachedResponseData r10 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r10
            java.util.Map r11 = r10.i()
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x00f0
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L_0x00c5
            goto L_0x00f0
        L_0x00c5:
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x00cd:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00f0
            java.lang.Object r0 = r11.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r9.invoke(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x00cd
            goto L_0x00a8
        L_0x00f0:
            return r10
        L_0x00f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.k(io.ktor.client.request.HttpRequestBuilder, io.ktor.http.content.OutgoingContent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final HttpCacheStorage l() {
        return this.b;
    }

    public final HttpCacheStorage m() {
        return this.f8888a;
    }

    public final boolean n() {
        return this.f;
    }

    public HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, CacheStorage cacheStorage, CacheStorage cacheStorage2, boolean z, boolean z2) {
        this.f8888a = httpCacheStorage;
        this.b = httpCacheStorage2;
        this.c = cacheStorage;
        this.d = cacheStorage2;
        this.e = z;
        this.f = z2;
    }
}

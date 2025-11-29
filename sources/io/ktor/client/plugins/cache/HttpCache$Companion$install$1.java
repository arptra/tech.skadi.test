package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.HttpCache;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$1", f = "HttpCache.kt", i = {1}, l = {145, 149, 155, 165, 170}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
public final class HttpCache$Companion$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$1(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    @Nullable
    public final Object invoke(@NotNull PipelineContext<Object, HttpRequestBuilder> pipelineContext, @NotNull Object obj, @Nullable Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$1 httpCache$Companion$install$1 = new HttpCache$Companion$install$1(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$1.L$0 = pipelineContext;
        httpCache$Companion$install$1.L$1 = obj;
        return httpCache$Companion$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PipelineContext pipelineContext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            pipelineContext = (PipelineContext) this.L$0;
            Object obj2 = this.L$1;
            if (!(obj2 instanceof OutgoingContent.NoContent)) {
                return Unit.INSTANCE;
            }
            if (!Intrinsics.areEqual((Object) ((HttpRequestBuilder) pipelineContext.d()).h(), (Object) HttpMethod.b.a()) || !HttpCacheKt.b(((HttpRequestBuilder) pipelineContext.d()).i().o())) {
                return Unit.INSTANCE;
            }
            if (this.$plugin.e) {
                HttpClient httpClient = this.$scope;
                this.L$0 = null;
                this.label = 1;
                if (HttpCacheLegacyKt.g(pipelineContext, this.$plugin, (OutgoingContent) obj2, httpClient, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            this.L$0 = pipelineContext;
            this.label = 2;
            obj = this.$plugin.k((HttpRequestBuilder) pipelineContext.d(), (OutgoingContent) obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else if (i == 2) {
            pipelineContext = (PipelineContext) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else if (i == 4) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else if (i == 5) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PipelineContext pipelineContext2 = pipelineContext;
        CachedResponseData cachedResponseData = (CachedResponseData) obj;
        if (cachedResponseData == null) {
            Logger c = HttpCacheKt.c();
            c.trace("No cached response for " + ((HttpRequestBuilder) pipelineContext2.d()).i() + " found");
            if (HttpHeaderValueParserKt.b(((HttpRequestBuilder) pipelineContext2.d()).a().h(HttpHeaders.f8966a.f())).contains(CacheControl.f8887a.d())) {
                Logger c2 = HttpCacheKt.c();
                c2.trace("No cache found and \"only-if-cached\" set for " + ((HttpRequestBuilder) pipelineContext2.d()).i());
                HttpCache.Companion companion = HttpCache.g;
                HttpClient httpClient2 = this.$scope;
                this.L$0 = null;
                this.label = 3;
                if (companion.h(pipelineContext2, httpClient2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        ValidateStatus d = HttpCacheEntryKt.d(cachedResponseData.c(), cachedResponseData.d(), (HttpRequestBuilder) pipelineContext2.d());
        if (d == ValidateStatus.ShouldNotValidate) {
            HttpClientCall p0 = HttpCacheStorageKt.a(cachedResponseData, this.$scope, new RequestForCache(((HttpRequestBuilder) pipelineContext2.d()).b()), ((HttpRequestBuilder) pipelineContext2.d()).g()).p0();
            HttpCache.Companion companion2 = HttpCache.g;
            HttpClient httpClient3 = this.$scope;
            this.L$0 = null;
            this.label = 4;
            if (companion2.g(pipelineContext2, httpClient3, p0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } else if (d == ValidateStatus.ShouldWarn) {
            HttpCache.Companion companion3 = HttpCache.g;
            HttpClient httpClient4 = this.$scope;
            Job g = ((HttpRequestBuilder) pipelineContext2.d()).g();
            this.L$0 = null;
            this.label = 5;
            if (companion3.i(pipelineContext2, cachedResponseData, httpClient4, g, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } else {
            Headers d2 = cachedResponseData.d();
            HttpHeaders httpHeaders = HttpHeaders.f8966a;
            String str = d2.get(httpHeaders.n());
            if (str != null) {
                Logger c3 = HttpCacheKt.c();
                c3.trace("Adding If-None-Match=" + str + " for " + ((HttpRequestBuilder) pipelineContext2.d()).i());
                UtilsKt.b((HttpMessageBuilder) pipelineContext2.d(), httpHeaders.q(), str);
            }
            String str2 = cachedResponseData.d().get(httpHeaders.s());
            if (str2 != null) {
                Logger c4 = HttpCacheKt.c();
                c4.trace("Adding If-Modified-Since=" + str2 + " for " + ((HttpRequestBuilder) pipelineContext2.d()).i());
                UtilsKt.b((HttpMessageBuilder) pipelineContext2.d(), httpHeaders.p(), str2);
            }
            return Unit.INSTANCE;
        }
    }
}

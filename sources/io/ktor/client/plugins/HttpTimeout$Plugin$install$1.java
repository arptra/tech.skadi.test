package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocolKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeout$Plugin$install$1", f = "HttpTimeout.kt", i = {}, l = {146, 174}, m = "invokeSuspend", n = {}, s = {})
public final class HttpTimeout$Plugin$install$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ HttpTimeout $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpTimeout$Plugin$install$1(HttpTimeout httpTimeout, HttpClient httpClient, Continuation<? super HttpTimeout$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpTimeout;
        this.$scope = httpClient;
    }

    @Nullable
    public final Object invoke(@NotNull Sender sender, @NotNull HttpRequestBuilder httpRequestBuilder, @Nullable Continuation<? super HttpClientCall> continuation) {
        HttpTimeout$Plugin$install$1 httpTimeout$Plugin$install$1 = new HttpTimeout$Plugin$install$1(this.$plugin, this.$scope, continuation);
        httpTimeout$Plugin$install$1.L$0 = sender;
        httpTimeout$Plugin$install$1.L$1 = httpRequestBuilder;
        return httpTimeout$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Sender sender = (Sender) this.L$0;
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$1;
            if (URLProtocolKt.b(httpRequestBuilder.i().o()) || (httpRequestBuilder.d() instanceof ClientUpgradeContent)) {
                this.L$0 = null;
                this.label = 1;
                obj = sender.a(httpRequestBuilder, this);
                return obj == coroutine_suspended ? coroutine_suspended : obj;
            }
            HttpTimeout.Plugin plugin = HttpTimeout.d;
            HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) httpRequestBuilder.f(plugin);
            if (httpTimeoutCapabilityConfiguration == null && this.$plugin.f()) {
                httpTimeoutCapabilityConfiguration = new HttpTimeout.HttpTimeoutCapabilityConfiguration((Long) null, (Long) null, (Long) null, 7, (DefaultConstructorMarker) null);
                httpRequestBuilder.l(plugin, httpTimeoutCapabilityConfiguration);
            }
            if (httpTimeoutCapabilityConfiguration != null) {
                HttpTimeout httpTimeout = this.$plugin;
                HttpClient httpClient = this.$scope;
                Long c = httpTimeoutCapabilityConfiguration.c();
                if (c == null) {
                    c = httpTimeout.b;
                }
                httpTimeoutCapabilityConfiguration.f(c);
                Long e = httpTimeoutCapabilityConfiguration.e();
                if (e == null) {
                    e = httpTimeout.c;
                }
                httpTimeoutCapabilityConfiguration.h(e);
                Long d = httpTimeoutCapabilityConfiguration.d();
                if (d == null) {
                    d = httpTimeout.f8867a;
                }
                httpTimeoutCapabilityConfiguration.g(d);
                Long d2 = httpTimeoutCapabilityConfiguration.d();
                if (d2 == null) {
                    d2 = httpTimeout.f8867a;
                }
                if (!(d2 == null || d2.longValue() == LongCompanionObject.MAX_VALUE)) {
                    httpRequestBuilder.g().r(new HttpTimeout$Plugin$install$1$1$1(BuildersKt__Builders_commonKt.d(httpClient, (CoroutineContext) null, (CoroutineStart) null, new HttpTimeout$Plugin$install$1$1$killer$1(d2, httpRequestBuilder, httpRequestBuilder.g(), (Continuation<? super HttpTimeout$Plugin$install$1$1$killer$1>) null), 3, (Object) null)));
                }
            }
            this.L$0 = null;
            this.label = 2;
            obj = sender.a(httpRequestBuilder, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}

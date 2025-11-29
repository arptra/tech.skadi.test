package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1", f = "ResponseObserver.kt", i = {0, 0, 0}, l = {68, 77}, m = "invokeSuspend", n = {"$this$intercept", "newResponse", "sideResponse"}, s = {"L$0", "L$1", "L$2"})
public final class ResponseObserver$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResponseObserver $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResponseObserver$Plugin$install$1(ResponseObserver responseObserver, HttpClient httpClient, Continuation<? super ResponseObserver$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = responseObserver;
        this.$scope = httpClient;
    }

    @Nullable
    public final Object invoke(@NotNull PipelineContext<HttpResponse, Unit> pipelineContext, @NotNull HttpResponse httpResponse, @Nullable Continuation<? super Unit> continuation) {
        ResponseObserver$Plugin$install$1 responseObserver$Plugin$install$1 = new ResponseObserver$Plugin$install$1(this.$plugin, this.$scope, continuation);
        responseObserver$Plugin$install$1.L$0 = pipelineContext;
        responseObserver$Plugin$install$1.L$1 = httpResponse;
        return responseObserver$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: io.ktor.util.pipeline.PipelineContext} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: io.ktor.client.HttpClient} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0034
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00c1
        L_0x0013:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x001b:
            java.lang.Object r1 = r13.L$3
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            java.lang.Object r3 = r13.L$2
            io.ktor.client.statement.HttpResponse r3 = (io.ktor.client.statement.HttpResponse) r3
            java.lang.Object r4 = r13.L$1
            io.ktor.client.statement.HttpResponse r4 = (io.ktor.client.statement.HttpResponse) r4
            java.lang.Object r5 = r13.L$0
            io.ktor.util.pipeline.PipelineContext r5 = (io.ktor.util.pipeline.PipelineContext) r5
            kotlin.ResultKt.throwOnFailure(r14)
            r9 = r4
            r10 = r5
            r12 = r3
            r3 = r1
            r1 = r12
            goto L_0x009f
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            r5 = r14
            io.ktor.util.pipeline.PipelineContext r5 = (io.ktor.util.pipeline.PipelineContext) r5
            java.lang.Object r14 = r13.L$1
            io.ktor.client.statement.HttpResponse r14 = (io.ktor.client.statement.HttpResponse) r14
            io.ktor.client.plugins.observer.ResponseObserver r1 = r13.$plugin
            kotlin.jvm.functions.Function1 r1 = r1.b
            if (r1 == 0) goto L_0x005b
            io.ktor.client.call.HttpClientCall r4 = r14.p0()
            java.lang.Object r1 = r1.invoke(r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x005b
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x005b:
            io.ktor.utils.io.ByteReadChannel r1 = r14.c()
            kotlin.Pair r1 = io.ktor.util.ByteChannelsKt.a(r1, r14)
            java.lang.Object r4 = r1.component1()
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            java.lang.Object r1 = r1.component2()
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            io.ktor.client.call.HttpClientCall r6 = r14.p0()
            io.ktor.client.call.HttpClientCall r1 = io.ktor.client.plugins.observer.DelegatedCallKt.a(r6, r1)
            io.ktor.client.statement.HttpResponse r1 = r1.g()
            io.ktor.client.call.HttpClientCall r14 = r14.p0()
            io.ktor.client.call.HttpClientCall r14 = io.ktor.client.plugins.observer.DelegatedCallKt.a(r14, r4)
            io.ktor.client.statement.HttpResponse r14 = r14.g()
            io.ktor.client.HttpClient r4 = r13.$scope
            r13.L$0 = r5
            r13.L$1 = r1
            r13.L$2 = r14
            r13.L$3 = r4
            r13.label = r3
            java.lang.Object r3 = io.ktor.client.plugins.observer.ResponseObserverContextJvmKt.a(r13)
            if (r3 != r0) goto L_0x009a
            return r0
        L_0x009a:
            r9 = r1
            r10 = r5
            r1 = r14
            r14 = r3
            r3 = r4
        L_0x009f:
            r4 = r14
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1 r6 = new io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1
            io.ktor.client.plugins.observer.ResponseObserver r14 = r13.$plugin
            r11 = 0
            r6.<init>(r1, r14, r11)
            r7 = 2
            r8 = 0
            r5 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.d(r3, r4, r5, r6, r7, r8)
            r13.L$0 = r11
            r13.L$1 = r11
            r13.L$2 = r11
            r13.L$3 = r11
            r13.label = r2
            java.lang.Object r13 = r10.g(r9, r13)
            if (r13 != r0) goto L_0x00c1
            return r0
        L_0x00c1:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

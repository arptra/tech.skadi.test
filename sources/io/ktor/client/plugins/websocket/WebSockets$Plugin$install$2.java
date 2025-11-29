package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<name for destructuring parameter 0>"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.WebSockets$Plugin$install$2", f = "WebSockets.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
public final class WebSockets$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $extensionsSupported;
    final /* synthetic */ WebSockets $plugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebSockets$Plugin$install$2(WebSockets webSockets, boolean z, Continuation<? super WebSockets$Plugin$install$2> continuation) {
        super(3, continuation);
        this.$plugin = webSockets;
        this.$extensionsSupported = z;
    }

    @Nullable
    public final Object invoke(@NotNull PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, @NotNull HttpResponseContainer httpResponseContainer, @Nullable Continuation<? super Unit> continuation) {
        WebSockets$Plugin$install$2 webSockets$Plugin$install$2 = new WebSockets$Plugin$install$2(this.$plugin, this.$extensionsSupported, continuation);
        webSockets$Plugin$install$2.L$0 = pipelineContext;
        webSockets$Plugin$install$2.L$1 = httpResponseContainer;
        return webSockets$Plugin$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: io.ktor.client.plugins.websocket.DelegatingClientWebSocketSession} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: io.ktor.client.plugins.websocket.DefaultClientWebSocketSession} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: io.ktor.client.plugins.websocket.DelegatingClientWebSocketSession} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: io.ktor.client.plugins.websocket.DelegatingClientWebSocketSession} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x0018
            if (r1 != r2) goto L_0x0010
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x010c
        L_0x0010:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            io.ktor.util.pipeline.PipelineContext r9 = (io.ktor.util.pipeline.PipelineContext) r9
            java.lang.Object r1 = r8.L$1
            io.ktor.client.statement.HttpResponseContainer r1 = (io.ktor.client.statement.HttpResponseContainer) r1
            io.ktor.util.reflect.TypeInfo r3 = r1.a()
            java.lang.Object r1 = r1.b()
            java.lang.Object r4 = r9.d()
            io.ktor.client.call.HttpClientCall r4 = (io.ktor.client.call.HttpClientCall) r4
            io.ktor.client.statement.HttpResponse r4 = r4.g()
            io.ktor.http.HttpStatusCode r5 = r4.f()
            io.ktor.client.request.HttpRequest r4 = io.ktor.client.statement.HttpResponseKt.e(r4)
            io.ktor.http.content.OutgoingContent r4 = r4.getContent()
            boolean r4 = r4 instanceof io.ktor.client.plugins.websocket.WebSocketContent
            java.lang.String r6 = ": "
            if (r4 != 0) goto L_0x0076
            org.slf4j.Logger r8 = io.ktor.client.plugins.websocket.WebSocketsKt.b()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Skipping non-websocket response from "
            r0.append(r2)
            java.lang.Object r9 = r9.d()
            io.ktor.client.call.HttpClientCall r9 = (io.ktor.client.call.HttpClientCall) r9
            io.ktor.client.request.HttpRequest r9 = r9.f()
            io.ktor.http.Url r9 = r9.T()
            r0.append(r9)
            r0.append(r6)
            r0.append(r1)
            java.lang.String r9 = r0.toString()
            r8.trace(r9)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0076:
            io.ktor.http.HttpStatusCode$Companion r4 = io.ktor.http.HttpStatusCode.c
            io.ktor.http.HttpStatusCode r7 = r4.Q()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0126
            boolean r4 = r1 instanceof io.ktor.websocket.WebSocketSession
            if (r4 == 0) goto L_0x010f
            org.slf4j.Logger r4 = io.ktor.client.plugins.websocket.WebSocketsKt.b()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Receive websocket session from "
            r5.append(r7)
            java.lang.Object r7 = r9.d()
            io.ktor.client.call.HttpClientCall r7 = (io.ktor.client.call.HttpClientCall) r7
            io.ktor.client.request.HttpRequest r7 = r7.f()
            io.ktor.http.Url r7 = r7.T()
            r5.append(r7)
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r4.trace(r5)
            kotlin.reflect.KClass r4 = r3.b()
            java.lang.Class<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r5 = io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x00ee
            io.ktor.client.plugins.websocket.WebSockets r4 = r8.$plugin
            io.ktor.websocket.WebSocketSession r1 = (io.ktor.websocket.WebSocketSession) r1
            io.ktor.websocket.DefaultWebSocketSession r1 = r4.f(r1)
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r4 = new io.ktor.client.plugins.websocket.DefaultClientWebSocketSession
            java.lang.Object r5 = r9.d()
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5
            r4.<init>(r5, r1)
            boolean r1 = r8.$extensionsSupported
            if (r1 == 0) goto L_0x00e6
            io.ktor.client.plugins.websocket.WebSockets r1 = r8.$plugin
            java.lang.Object r5 = r9.d()
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5
            java.util.List r1 = r1.e(r5)
            goto L_0x00ea
        L_0x00e6:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00ea:
            r4.r0(r1)
            goto L_0x00fb
        L_0x00ee:
            io.ktor.client.plugins.websocket.DelegatingClientWebSocketSession r4 = new io.ktor.client.plugins.websocket.DelegatingClientWebSocketSession
            java.lang.Object r5 = r9.d()
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5
            io.ktor.websocket.WebSocketSession r1 = (io.ktor.websocket.WebSocketSession) r1
            r4.<init>(r5, r1)
        L_0x00fb:
            io.ktor.client.statement.HttpResponseContainer r1 = new io.ktor.client.statement.HttpResponseContainer
            r1.<init>(r3, r4)
            r3 = 0
            r8.L$0 = r3
            r8.label = r2
            java.lang.Object r8 = r9.g(r1, r8)
            if (r8 != r0) goto L_0x010c
            return r0
        L_0x010c:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x010f:
            io.ktor.client.plugins.websocket.WebSocketException r8 = new io.ktor.client.plugins.websocket.WebSocketException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Handshake exception, expected `WebSocketSession` content but was "
            r9.append(r0)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0126:
            io.ktor.client.plugins.websocket.WebSocketException r8 = new io.ktor.client.plugins.websocket.WebSocketException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Handshake exception, expected status code "
            r9.append(r0)
            io.ktor.http.HttpStatusCode r0 = r4.Q()
            int r0 = r0.h0()
            r9.append(r0)
            java.lang.String r0 = " but was "
            r9.append(r0)
            int r0 = r5.h0()
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.WebSockets$Plugin$install$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bHAø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bHAø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0012\u001a\u00020\b2\u0012\b\u0002\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010%\u001a\u00020 8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0&8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "Lio/ktor/client/plugins/websocket/ClientWebSocketSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/client/call/HttpClientCall;", "call", "delegate", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/websocket/DefaultWebSocketSession;)V", "", "u", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/websocket/Frame;", "frame", "q0", "(Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "r0", "(Ljava/util/List;)V", "a", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlinx/coroutines/channels/ReceiveChannel;", "i", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "", "z", "()J", "d0", "(J)V", "maxFrameSize", "Lkotlinx/coroutines/channels/SendChannel;", "o", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class DefaultClientWebSocketSession implements ClientWebSocketSession, DefaultWebSocketSession {

    /* renamed from: a  reason: collision with root package name */
    public final HttpClientCall f8907a;
    public final /* synthetic */ DefaultWebSocketSession b;

    public DefaultClientWebSocketSession(HttpClientCall httpClientCall, DefaultWebSocketSession defaultWebSocketSession) {
        Intrinsics.checkNotNullParameter(httpClientCall, "call");
        Intrinsics.checkNotNullParameter(defaultWebSocketSession, "delegate");
        this.f8907a = httpClientCall;
        this.b = defaultWebSocketSession;
    }

    public void d0(long j) {
        this.b.d0(j);
    }

    public CoroutineContext getCoroutineContext() {
        return this.b.getCoroutineContext();
    }

    public ReceiveChannel i() {
        return this.b.i();
    }

    public SendChannel o() {
        return this.b.o();
    }

    public Object q0(Frame frame, Continuation continuation) {
        return this.b.q0(frame, continuation);
    }

    public void r0(List list) {
        Intrinsics.checkNotNullParameter(list, "negotiatedExtensions");
        this.b.r0(list);
    }

    public Object u(Continuation continuation) {
        return this.b.u(continuation);
    }

    public long z() {
        return this.b.z();
    }
}

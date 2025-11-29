package io.ktor.websocket;

import io.ktor.websocket.WebSocketSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR+\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108V@VX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00198\u0000X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u001a\u0010\"\u001a\u00020\u001e8\u0000X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0012\u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060#8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060'8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lio/ktor/websocket/RawWebSocketJvm;", "Lio/ktor/websocket/WebSocketSession;", "", "u", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "a", "Lkotlinx/coroutines/channels/Channel;", "filtered", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "", "<set-?>", "c", "Lkotlin/properties/ReadWriteProperty;", "z", "()J", "d0", "(J)V", "maxFrameSize", "Lio/ktor/websocket/WebSocketWriter;", "d", "Lio/ktor/websocket/WebSocketWriter;", "()Lio/ktor/websocket/WebSocketWriter;", "writer", "Lio/ktor/websocket/WebSocketReader;", "e", "Lio/ktor/websocket/WebSocketReader;", "()Lio/ktor/websocket/WebSocketReader;", "reader", "Lkotlinx/coroutines/channels/ReceiveChannel;", "i", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "Lkotlinx/coroutines/channels/SendChannel;", "o", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRawWebSocketJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RawWebSocketJvm.kt\nio/ktor/websocket/RawWebSocketJvm\n+ 2 Delegates.kt\nkotlin/properties/Delegates\n*L\n1#1,100:1\n33#2,3:101\n33#2,3:104\n*S KotlinDebug\n*F\n+ 1 RawWebSocketJvm.kt\nio/ktor/websocket/RawWebSocketJvm\n*L\n53#1:101,3\n57#1:104,3\n*E\n"})
public final class RawWebSocketJvm implements WebSocketSession {
    public static final /* synthetic */ KProperty[] f;

    /* renamed from: a  reason: collision with root package name */
    public final Channel f9135a;
    public final CoroutineContext b;
    public final ReadWriteProperty c;
    public final WebSocketWriter d;
    public final WebSocketReader e;

    static {
        Class<RawWebSocketJvm> cls = RawWebSocketJvm.class;
        f = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "maxFrameSize", "getMaxFrameSize()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "masking", "getMasking()Z", 0))};
    }

    public final WebSocketReader c() {
        return this.e;
    }

    public final WebSocketWriter d() {
        return this.d;
    }

    public void d0(long j) {
        this.c.setValue(this, f[0], Long.valueOf(j));
    }

    public CoroutineContext getCoroutineContext() {
        return this.b;
    }

    public ReceiveChannel i() {
        return this.f9135a;
    }

    public SendChannel o() {
        return this.d.o();
    }

    public Object q0(Frame frame, Continuation continuation) {
        return WebSocketSession.DefaultImpls.a(this, frame, continuation);
    }

    public Object u(Continuation continuation) {
        Object u = this.d.u(continuation);
        return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
    }

    public long z() {
        return ((Number) this.c.getValue(this, f[0])).longValue();
    }
}

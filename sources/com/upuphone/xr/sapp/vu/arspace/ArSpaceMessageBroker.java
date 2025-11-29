package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import zmq.SocketBase;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006!"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageBroker;", "Ljava/lang/Thread;", "Lorg/zeromq/ZContext;", "zmqContext", "<init>", "(Lorg/zeromq/ZContext;)V", "", "d", "()Z", "", "run", "()V", "a", "Lorg/zeromq/ZContext;", "Lorg/zeromq/ZMQ$Socket;", "b", "Lorg/zeromq/ZMQ$Socket;", "subSocket", "c", "pubSocket", "controlSocket", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "setSubEndpoint", "(Ljava/lang/String;)V", "subEndpoint", "f", "setPubEndpoint", "pubEndpoint", "g", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceMessageBroker extends Thread {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final ZContext f8050a;
    public ZMQ.Socket b;
    public ZMQ.Socket c;
    public ZMQ.Socket d;
    public String e = "";
    public String f = "";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageBroker$Companion;", "", "()V", "TAG", "", "ZMQ_ADDR", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArSpaceMessageBroker(ZContext zContext) {
        super("arspace-message-broker");
        Intrinsics.checkNotNullParameter(zContext, "zmqContext");
        this.f8050a = zContext;
    }

    public final void a() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ArSpaceMessageBroker", "exit start");
        ZMQ.Socket socket = this.d;
        ZMQ.Socket socket2 = null;
        if (socket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlSocket");
            socket = null;
        }
        socket.w(ZMQ.e);
        join();
        ZMQ.Socket socket3 = this.b;
        if (socket3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subSocket");
            socket3 = null;
        }
        socket3.close();
        ZMQ.Socket socket4 = this.c;
        if (socket4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubSocket");
        } else {
            socket2 = socket4;
        }
        socket2.close();
        delegate.a("ArSpaceMessageBroker", "exit end");
    }

    public final String b() {
        return this.f;
    }

    public final String c() {
        return this.e;
    }

    public final boolean d() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ArSpaceMessageBroker", "initBroker");
        ZMQ.Socket b2 = this.f8050a.b(SocketType.XSUB);
        Intrinsics.checkNotNullExpressionValue(b2, "createSocket(...)");
        this.b = b2;
        ZMQ.Socket socket = null;
        if (b2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subSocket");
            b2 = null;
        }
        if (!b2.c("tcp://127.0.0.1:*")) {
            delegate.c("ArSpaceMessageBroker", "subSocket bind failed");
            return false;
        }
        ZMQ.Socket socket2 = this.b;
        if (socket2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subSocket");
            socket2 = null;
        }
        delegate.g("ArSpaceMessageBroker", "start: subSocket addr: " + socket2.g());
        ZMQ.Socket socket3 = this.b;
        if (socket3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subSocket");
            socket3 = null;
        }
        String g2 = socket3.g();
        Intrinsics.checkNotNullExpressionValue(g2, "getLastEndpoint(...)");
        this.f = g2;
        ZMQ.Socket b3 = this.f8050a.b(SocketType.XPUB);
        Intrinsics.checkNotNullExpressionValue(b3, "createSocket(...)");
        this.c = b3;
        if (b3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubSocket");
            b3 = null;
        }
        if (!b3.c("tcp://127.0.0.1:*")) {
            delegate.c("ArSpaceMessageBroker", "pubSocket bind failed");
            return false;
        }
        ZMQ.Socket socket4 = this.c;
        if (socket4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubSocket");
            socket4 = null;
        }
        delegate.g("ArSpaceMessageBroker", "start pubSocket: " + socket4.g());
        ZMQ.Socket socket5 = this.c;
        if (socket5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubSocket");
            socket5 = null;
        }
        String g3 = socket5.g();
        Intrinsics.checkNotNullExpressionValue(g3, "getLastEndpoint(...)");
        this.e = g3;
        ZMQ.Socket b4 = this.f8050a.b(SocketType.PAIR);
        Intrinsics.checkNotNullExpressionValue(b4, "createSocket(...)");
        this.d = b4;
        if (b4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlSocket");
        } else {
            socket = b4;
        }
        socket.c("inproc://control");
        start();
        return true;
    }

    public void run() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ArSpaceMessageBroker", "proxy: run");
        ZMQ.Socket b2 = this.f8050a.b(SocketType.PAIR);
        b2.d("inproc://control");
        ZMQ.Socket socket = this.b;
        if (socket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subSocket");
            socket = null;
        }
        SocketBase b3 = socket.b();
        ZMQ.Socket socket2 = this.c;
        if (socket2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubSocket");
            socket2 = null;
        }
        zmq.ZMQ.g(b3, socket2.b(), (SocketBase) null, b2.b());
        delegate.g("ArSpaceMessageBroker", "proxy: end");
    }
}

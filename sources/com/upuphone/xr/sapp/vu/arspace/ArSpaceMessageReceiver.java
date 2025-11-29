package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageReceiver;", "Ljava/lang/Thread;", "Lorg/zeromq/ZContext;", "zmqContext", "", "endPoint", "topic", "Lcom/upuphone/xr/sapp/vu/arspace/IArSpaceMessageReceiver;", "msgHandler", "<init>", "(Lorg/zeromq/ZContext;Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/sapp/vu/arspace/IArSpaceMessageReceiver;)V", "", "b", "()Z", "", "run", "()V", "a", "Lorg/zeromq/ZContext;", "Ljava/lang/String;", "c", "d", "Lcom/upuphone/xr/sapp/vu/arspace/IArSpaceMessageReceiver;", "e", "Z", "quit", "Lorg/zeromq/ZMQ$Socket;", "f", "Lorg/zeromq/ZMQ$Socket;", "subSocket", "g", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceMessageReceiver extends Thread {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final ZContext f8051a;
    public final String b;
    public final String c;
    public final IArSpaceMessageReceiver d;
    public boolean e;
    public ZMQ.Socket f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageReceiver$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArSpaceMessageReceiver(ZContext zContext, String str, String str2, IArSpaceMessageReceiver iArSpaceMessageReceiver) {
        super("arspace-message-receiver");
        Intrinsics.checkNotNullParameter(zContext, "zmqContext");
        Intrinsics.checkNotNullParameter(str, "endPoint");
        Intrinsics.checkNotNullParameter(str2, "topic");
        Intrinsics.checkNotNullParameter(iArSpaceMessageReceiver, "msgHandler");
        this.f8051a = zContext;
        this.b = str;
        this.c = str2;
        this.d = iArSpaceMessageReceiver;
    }

    public final void a() {
        this.e = true;
        join();
        ULog.f6446a.a("ArSpaceMessageReceiver", "exit");
    }

    public final boolean b() {
        ZMQ.Socket b2 = this.f8051a.b(SocketType.SUB);
        Intrinsics.checkNotNullExpressionValue(b2, "createSocket(...)");
        this.f = b2;
        ZMQ.Socket socket = null;
        if (b2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subSocket");
            b2 = null;
        }
        if (!b2.d0(this.c)) {
            ULog.f6446a.c("ArSpaceMessageReceiver", "subscribe failed");
            return false;
        }
        ZMQ.Socket socket2 = this.f;
        if (socket2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subSocket");
            socket2 = null;
        }
        if (!socket2.T(300)) {
            ULog.f6446a.c("ArSpaceMessageReceiver", "setReceiveTimeOut failed");
            return false;
        }
        ZMQ.Socket socket3 = this.f;
        if (socket3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subSocket");
            socket3 = null;
        }
        if (!socket3.d(this.b)) {
            ULog.f6446a.c("ArSpaceMessageReceiver", "connect failed");
            return false;
        }
        ULog.Delegate delegate = ULog.f6446a;
        String str = this.c;
        ZMQ.Socket socket4 = this.f;
        if (socket4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subSocket");
        } else {
            socket = socket4;
        }
        delegate.g("ArSpaceMessageReceiver", "initRecvSocket: topic:" + str + " endPoint: " + socket.g());
        start();
        return true;
    }

    public void run() {
        ZMQ.Socket socket;
        while (true) {
            socket = null;
            if (this.e) {
                break;
            }
            try {
                ZMQ.Socket socket2 = this.f;
                if (socket2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subSocket");
                    socket2 = null;
                }
                byte[] o = socket2.o();
                if (o != null) {
                    String str = new String(o, Charsets.UTF_8);
                    ZMQ.Socket socket3 = this.f;
                    if (socket3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("subSocket");
                        socket3 = null;
                    }
                    byte[] o2 = socket3.o();
                    if (o2 != null) {
                        this.d.a(str, o2);
                    }
                }
            } catch (InterruptedException unused) {
                ULog.f6446a.c("ArSpaceMessageReceiver", "thread interrupted");
            } catch (Exception unused2) {
                ULog.f6446a.c("ArSpaceMessageReceiver", "recv error");
            }
        }
        ZMQ.Socket socket4 = this.f;
        if (socket4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subSocket");
        } else {
            socket = socket4;
        }
        socket.close();
        ULog.f6446a.g("ArSpaceMessageReceiver", "messageReceiver end");
    }
}

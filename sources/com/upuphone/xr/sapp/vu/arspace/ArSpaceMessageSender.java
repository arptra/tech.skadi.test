package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageSender;", "", "Lorg/zeromq/ZContext;", "zmqContext", "", "endPoint", "<init>", "(Lorg/zeromq/ZContext;Ljava/lang/String;)V", "", "b", "()Z", "topic", "", "data", "c", "(Ljava/lang/String;[B)Z", "", "a", "()V", "Lorg/zeromq/ZContext;", "Ljava/lang/String;", "Lorg/zeromq/ZMQ$Socket;", "Lorg/zeromq/ZMQ$Socket;", "pubSocket", "d", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceMessageSender {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final ZContext f8052a;
    public final String b;
    public ZMQ.Socket c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageSender$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public ArSpaceMessageSender(ZContext zContext, String str) {
        Intrinsics.checkNotNullParameter(zContext, "zmqContext");
        Intrinsics.checkNotNullParameter(str, "endPoint");
        this.f8052a = zContext;
        this.b = str;
    }

    public final void a() {
        ZMQ.Socket socket = this.c;
        if (socket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubSocket");
            socket = null;
        }
        socket.close();
        ULog.f6446a.a("ArSpaceMessageSender", "exit");
    }

    public final boolean b() {
        ZMQ.Socket b2 = this.f8052a.b(SocketType.PUB);
        Intrinsics.checkNotNullExpressionValue(b2, "createSocket(...)");
        this.c = b2;
        ZMQ.Socket socket = null;
        if (b2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubSocket");
            b2 = null;
        }
        if (!b2.d(this.b)) {
            ULog.f6446a.c("ArSpaceMessageSender", "initSendSocket: connect failed");
            return false;
        }
        ULog.Delegate delegate = ULog.f6446a;
        ZMQ.Socket socket2 = this.c;
        if (socket2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubSocket");
        } else {
            socket = socket2;
        }
        delegate.g("ArSpaceMessageSender", "initSendSocket: connected: lastEndPoint: " + socket.g());
        return true;
    }

    public final boolean c(String str, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "topic");
        Intrinsics.checkNotNullParameter(bArr, "data");
        ZMQ.Socket socket = this.c;
        ZMQ.Socket socket2 = null;
        if (socket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubSocket");
            socket = null;
        }
        if (!socket.J(str)) {
            ULog.f6446a.c("ArSpaceMessageSender", "sendMesg: sendMore failed");
            return false;
        }
        ZMQ.Socket socket3 = this.c;
        if (socket3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pubSocket");
        } else {
            socket2 = socket3;
        }
        if (!socket2.w(bArr)) {
            ULog.f6446a.c("ArSpaceMessageSender", "sendMesg: send failed");
            return false;
        }
        ULog.f6446a.a("ArSpaceMessageSender", "sendMesg: topic: " + str);
        return true;
    }
}

package com.xjsd.ai.assistant.net.ws;

import com.honey.account.fa.a;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.net.ws.engine.CloudClientListener;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"com/xjsd/ai/assistant/net/ws/VirtualWebSocket$mCloudClientListener$1", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudClientListener;", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "response", "", "c", "(Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;)V", "", "byteArray", "e", "([B)V", "", "code", "", "msg", "d", "(ILjava/lang/String;)V", "b", "()V", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public final class VirtualWebSocket$mCloudClientListener$1 implements CloudClientListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VirtualWebSocket f8506a;

    public VirtualWebSocket$mCloudClientListener$1(VirtualWebSocket virtualWebSocket) {
        this.f8506a = virtualWebSocket;
    }

    public static final void f(VirtualWebSocket virtualWebSocket) {
        Intrinsics.checkNotNullParameter(virtualWebSocket, "this$0");
        if (virtualWebSocket.isActiveDisconnect) {
            ILog.a("VirtualWebSocket", "scheduleReconnect: 已主动断开连接，重连任务取消");
        } else if (virtualWebSocket.connect(virtualWebSocket.mSessionId, true)) {
            virtualWebSocket.onReconnectSuccess();
        } else {
            ILog.a("VirtualWebSocket", "scheduleReconnect: 重连失败，回调onClose");
            virtualWebSocket.onClose(10011);
        }
    }

    public final void b() {
        ILog.a("VirtualWebSocket", "scheduleReconnect: 1S后重连");
        this.f8506a.y().postDelayed(new a(this.f8506a), 1000);
    }

    public void c(EndToEndResponse endToEndResponse) {
        Intrinsics.checkNotNullParameter(endToEndResponse, "response");
        this.f8506a.onMsg(endToEndResponse);
    }

    public void d(int i, String str) {
        if (i != 10011 || !this.f8506a.mAutoReconnect) {
            this.f8506a.onClose(i);
        } else {
            b();
        }
    }

    public void e(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        this.f8506a.onData(bArr);
    }
}

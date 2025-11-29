package com.xjsd.ai.assistant.net.ws.engine;

import com.upuphone.starrynet.payload.PayloadConstant;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.net.ws.engine.CloudWebSocket;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import java.net.URI;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001)B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u000bJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010'¨\u0006*"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/engine/CloudClientImpl;", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudClient;", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudWebSocket$WebSocketListener;", "Ljava/net/URI;", "serverUri", "<init>", "(Ljava/net/URI;)V", "", "msg", "", "f", "(Ljava/lang/String;)V", "Ljava/nio/ByteBuffer;", "bytes", "e", "(Ljava/nio/ByteBuffer;)V", "", "code", "d", "(ILjava/lang/String;)V", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudClientListener;", "listener", "c", "(Lcom/xjsd/ai/assistant/net/ws/engine/CloudClientListener;)V", "", "isOpen", "()Z", "connect", "()I", "a", "", "data", "b", "([B)V", "close", "()V", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudWebSocket;", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudWebSocket;", "mCloudWebSocket", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudClientListener;", "mCloudClientListener", "Companion", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public final class CloudClientImpl implements CloudClient, CloudWebSocket.WebSocketListener {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final CloudWebSocket f8509a;
    public CloudClientListener b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/engine/CloudClientImpl$Companion;", "", "()V", "TAG", "", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public CloudClientImpl(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "serverUri");
        CloudWebSocket cloudWebSocket = new CloudWebSocket(uri);
        this.f8509a = cloudWebSocket;
        cloudWebSocket.o0(this);
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.f8509a.h0(str);
    }

    public void b(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.f8509a.i0(bArr);
    }

    public void c(CloudClientListener cloudClientListener) {
        this.b = cloudClientListener;
    }

    public void close() {
        if (this.f8509a.V()) {
            this.f8509a.M();
        }
    }

    public int connect() {
        return this.f8509a.l0();
    }

    public void d(int i, String str) {
        CloudClientListener cloudClientListener = this.b;
        if (cloudClientListener != null) {
            cloudClientListener.d(i, str);
        }
    }

    public void e(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "bytes");
        byte[] array = byteBuffer.array();
        CloudClientListener cloudClientListener = this.b;
        if (cloudClientListener != null) {
            Intrinsics.checkNotNull(array);
            cloudClientListener.e(array);
        }
    }

    public void f(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        EndToEndResponse endToEndResponse = (EndToEndResponse) GsonUtils.a(str, EndToEndResponse.class);
        if (endToEndResponse.getType() == null || endToEndResponse.getPayload() == null) {
            ILog.a("CloudClientImpl", "onMsg: 反序列化数据出错");
            return;
        }
        CloudClientListener cloudClientListener = this.b;
        if (cloudClientListener != null) {
            cloudClientListener.c(endToEndResponse);
        }
    }

    public boolean isOpen() {
        return this.f8509a.V();
    }
}

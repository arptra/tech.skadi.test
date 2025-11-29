package com.xjsd.ai.assistant.asr.engine;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudResponse;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001d\u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010#\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001dR\u0018\u0010-\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientWrapper;", "Lorg/java_websocket/client/WebSocketClient;", "Ljava/net/URI;", "serverUri", "<init>", "(Ljava/net/URI;)V", "Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientListener;", "listener", "", "m0", "(Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientListener;)V", "", "l0", "()I", "Lorg/java_websocket/handshake/ServerHandshake;", "shake", "c0", "(Lorg/java_websocket/handshake/ServerHandshake;)V", "", "msg", "a0", "(Ljava/lang/String;)V", "Ljava/nio/ByteBuffer;", "bytes", "b0", "(Ljava/nio/ByteBuffer;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Z", "(Ljava/lang/Exception;)V", "code", "reason", "", "remote", "W", "(ILjava/lang/String;Z)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "x", "Ljava/util/concurrent/atomic/AtomicBoolean;", "connectFlag", "y", "hasReceiveError", "z", "Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientListener;", "mAsrWsClientListener", "A", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AsrWsClientWrapper extends WebSocketClient {
    public static final Companion A = new Companion((DefaultConstructorMarker) null);
    public AtomicBoolean x = new AtomicBoolean(false);
    public boolean y;
    public AsrWsClientListener z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientWrapper$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsrWsClientWrapper(URI uri) {
        super(uri);
        Intrinsics.checkNotNullParameter(uri, "serverUri");
    }

    public void W(int i, String str, boolean z2) {
        ILog.j("WsClientWrapper", "onClose, code->" + i + ", reason->" + str + ", remote->" + z2);
        if (this.x.get()) {
            this.x.set(false);
            AsrWsClientListener asrWsClientListener = this.z;
            if (asrWsClientListener != null) {
                asrWsClientListener.onError(10005, "链接已关闭");
            }
        }
    }

    public void Z(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        ILog.j("WsClientWrapper", "onError, e->" + exc);
        this.y = true;
        if (this.x.get()) {
            this.x.set(false);
            AsrWsClientListener asrWsClientListener = this.z;
            if (asrWsClientListener != null) {
                asrWsClientListener.onError(MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_CONTENT, exc.getMessage());
            }
        }
    }

    public void a0(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        ILog.j("WsClientWrapper", "onMessage: " + str);
        AsrCloudResponse asrCloudResponse = (AsrCloudResponse) GsonUtils.a(str, AsrCloudResponse.class);
        AsrWsClientListener asrWsClientListener = this.z;
        if (asrWsClientListener != null) {
            asrWsClientListener.a(asrCloudResponse);
        }
    }

    public void b0(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "bytes");
        try {
            byte[] array = byteBuffer.array();
            Intrinsics.checkNotNullExpressionValue(array, "array(...)");
            Charset forName = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
            String str = new String(array, forName);
            ILog.j("WsClientWrapper", "onMessage, convert to string->" + str);
        } catch (UnsupportedEncodingException e) {
            ILog.h("WsClientWrapper", "onMessage, convert to string error", e);
        }
    }

    public void c0(ServerHandshake serverHandshake) {
        Intrinsics.checkNotNullParameter(serverHandshake, "shake");
        short f = serverHandshake.f();
        String b = serverHandshake.b();
        ILog.j("WsClientWrapper", "onOpen, status->" + f + ", msg->" + b);
    }

    public final int l0() {
        this.x.set(false);
        this.y = false;
        try {
            if (P(3, TimeUnit.SECONDS)) {
                ILog.j("WsClientWrapper", "连接成功");
                this.x.set(true);
                return 0;
            } else if (this.y) {
                return MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_UNKNOW;
            } else {
                return 10004;
            }
        } catch (InterruptedException e) {
            ILog.n("WsClientWrapper", "建立连接异常", e);
            Thread.currentThread().interrupt();
            return MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_UNKNOW;
        }
    }

    public final void m0(AsrWsClientListener asrWsClientListener) {
        this.z = asrWsClientListener;
    }
}

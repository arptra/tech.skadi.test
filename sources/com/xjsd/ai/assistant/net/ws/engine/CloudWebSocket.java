package com.xjsd.ai.assistant.net.ws.engine;

import com.meizu.common.widget.MzContactsContract;
import com.meizu.net.pedometerprovider.manager.StepListener;
import com.upuphone.runasone.api.ApiConstant;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.env.EnvAbility;
import com.xjsd.ai.assistant.env.Environment;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.net.http.TokenGenerator;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 =2\u00020\u0001:\u0002>?B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u0013J\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001b\u0010%\u001a\u00020\u00062\n\u0010$\u001a\u00060\"j\u0002`#H\u0016¢\u0006\u0004\b%\u0010&J)\u0010+\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\rH\u0002¢\u0006\u0004\b-\u0010\u000fJ\u000f\u0010.\u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010\u000fR\u0018\u00101\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010%R\u0016\u0010<\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/engine/CloudWebSocket;", "Lorg/java_websocket/client/WebSocketClient;", "Ljava/net/URI;", "serverUri", "<init>", "(Ljava/net/URI;)V", "", "p0", "()V", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudWebSocket$WebSocketListener;", "listener", "o0", "(Lcom/xjsd/ai/assistant/net/ws/engine/CloudWebSocket$WebSocketListener;)V", "", "l0", "()I", "", "text", "h0", "(Ljava/lang/String;)V", "", "data", "i0", "([B)V", "Lorg/java_websocket/handshake/ServerHandshake;", "shake", "c0", "(Lorg/java_websocket/handshake/ServerHandshake;)V", "msg", "a0", "Ljava/nio/ByteBuffer;", "bytes", "b0", "(Ljava/nio/ByteBuffer;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Z", "(Ljava/lang/Exception;)V", "code", "reason", "", "remote", "W", "(ILjava/lang/String;Z)V", "m0", "n0", "x", "Lcom/xjsd/ai/assistant/net/ws/engine/CloudWebSocket$WebSocketListener;", "mWebSocketListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", "y", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mConnectedRef", "z", "mAuthFailRetried", "A", "hasError", "B", "I", "mState", "C", "Companion", "WebSocketListener", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public final class CloudWebSocket extends WebSocketClient {
    public static final Companion C = new Companion((DefaultConstructorMarker) null);
    public boolean A;
    public int B = -1;
    public WebSocketListener x;
    public AtomicBoolean y = new AtomicBoolean(false);
    public AtomicBoolean z = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/engine/CloudWebSocket$Companion;", "", "()V", "TAG", "", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/engine/CloudWebSocket$WebSocketListener;", "", "", "msg", "", "f", "(Ljava/lang/String;)V", "Ljava/nio/ByteBuffer;", "bytes", "e", "(Ljava/nio/ByteBuffer;)V", "", "code", "d", "(ILjava/lang/String;)V", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
    public interface WebSocketListener {
        void d(int i, String str);

        void e(ByteBuffer byteBuffer);

        void f(String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloudWebSocket(URI uri) {
        super(uri);
        Intrinsics.checkNotNullParameter(uri, "serverUri");
    }

    private final void p0() {
        if (Q() instanceof WebSocketImpl) {
            WebSocket Q = Q();
            Intrinsics.checkNotNull(Q, "null cannot be cast to non-null type org.java_websocket.WebSocketImpl");
            ((WebSocketImpl) Q).M();
        }
    }

    public void W(int i, String str, boolean z2) {
        ILog.j("CloudWebSocket", "onClose: code->" + i + ", reason->" + str + ", remote->" + z2);
        boolean z3 = this.y.get();
        int i2 = StepListener.LISTENER_TYPE_WIDGET;
        if (z3) {
            this.y.set(false);
            if (i == 1000) {
                WebSocketListener webSocketListener = this.x;
                if (webSocketListener != null) {
                    webSocketListener.d(10005, "链接已关闭");
                }
            } else if (i == 1002) {
                WebSocketListener webSocketListener2 = this.x;
                if (webSocketListener2 != null) {
                    webSocketListener2.d(StepListener.LISTENER_TYPE_WIDGET, str);
                }
            } else if (i != 1006) {
                WebSocketListener webSocketListener3 = this.x;
                if (webSocketListener3 != null) {
                    webSocketListener3.d(MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_UNKNOW, "发生异常");
                }
            } else {
                WebSocketListener webSocketListener4 = this.x;
                if (webSocketListener4 != null) {
                    webSocketListener4.d(10011, "网络切换");
                }
            }
        } else {
            if (i != 1002) {
                i2 = 10004;
            }
            this.B = i2;
        }
    }

    public void Z(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        ILog.j("CloudWebSocket", "onError: e->" + exc);
        this.A = true;
        if (this.y.get()) {
            this.y.set(false);
            WebSocketListener webSocketListener = this.x;
            if (webSocketListener != null) {
                webSocketListener.d(MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_CONTENT, exc.getMessage());
                return;
            }
            return;
        }
        this.B = MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_UNKNOW;
    }

    public void a0(String str) {
        WebSocketListener webSocketListener;
        ILog.j("CloudWebSocket", "onMessage: " + str);
        p0();
        if (str != null && (webSocketListener = this.x) != null) {
            webSocketListener.f(str);
        }
    }

    public void b0(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "bytes");
        p0();
        WebSocketListener webSocketListener = this.x;
        if (webSocketListener != null) {
            webSocketListener.e(byteBuffer);
        }
    }

    public void c0(ServerHandshake serverHandshake) {
        Intrinsics.checkNotNullParameter(serverHandshake, "shake");
        short f = serverHandshake.f();
        String b = serverHandshake.b();
        ILog.j("CloudWebSocket", "onOpen: status->" + f + ", msg->" + b);
    }

    public void h0(String str) {
        ILog.a("CloudWebSocket", "send: 发送数据->" + str);
        super.h0(str);
    }

    public void i0(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        super.i0(bArr);
    }

    public final int l0() {
        this.z.set(false);
        return m0();
    }

    public final int m0() {
        int n0 = n0();
        if (n0 != 10010) {
            return n0;
        }
        this.z.set(true);
        String c = TokenGenerator.f8505a.c();
        ILog.a("CloudWebSocket", "connectServer2: 刷新token返回->" + c);
        return n0();
    }

    public final int n0() {
        String str;
        Environment currentEnv;
        A(8);
        this.y.set(false);
        this.A = false;
        this.B = -1;
        try {
            AbilityManager abilityManager = AbilityManager.b;
            CacheAbility cacheAbility = (CacheAbility) abilityManager.b(CacheAbility.class);
            if (cacheAbility != null) {
                String persistValue = cacheAbility.getPersistValue(ApiConstant.KEY_TOKEN);
                String a2 = DeviceUtils.a();
                EnvAbility envAbility = (EnvAbility) abilityManager.b(EnvAbility.class);
                if (!(envAbility == null || (currentEnv = envAbility.getCurrentEnv()) == null)) {
                    str = currentEnv.getUserKey();
                    if (str == null) {
                    }
                    K("WR-Authorization", persistValue);
                    K("WR-Client-Id", a2);
                    K("WR-ukey", str);
                }
                str = "";
                K("WR-Authorization", persistValue);
                K("WR-Client-Id", a2);
                K("WR-ukey", str);
            }
            boolean f0 = this.z.get() ? f0() : P(3, TimeUnit.SECONDS);
            URI uri = this.j;
            ILog.j("CloudWebSocket", "ws连接url->" + uri + ", result->" + f0);
            if (f0) {
                this.y.set(true);
                this.B = 0;
            }
        } catch (InterruptedException e) {
            ILog.n("CloudWebSocket", "建立连接异常", e);
            Thread.currentThread().interrupt();
            this.B = MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_UNKNOW;
        }
        if (this.B == -1) {
            this.B = 10004;
        }
        return this.B;
    }

    public final void o0(WebSocketListener webSocketListener) {
        this.x = webSocketListener;
    }
}

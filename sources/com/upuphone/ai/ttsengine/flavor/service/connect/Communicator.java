package com.upuphone.ai.ttsengine.flavor.service.connect;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceOperator;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u000336:\u0018\u0000 >2\u00020\u0001:\u0003?@AB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR8\u0010 \u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\r0\r \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\r0\r\u0018\u00010\u001d0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR8\u0010\"\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00110\u0011 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u001d0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010/R\u0016\u00102\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006B"}, d2 = {"Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator;", "", "", "pkg", "<init>", "(Ljava/lang/String;)V", "", "data", "msg", "pkgName", "", "i", "([BLjava/lang/String;Ljava/lang/String;)V", "Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$OnDataRcvListener;", "listener", "g", "(Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$OnDataRcvListener;)V", "Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$OnConnectListener;", "f", "(Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$OnConnectListener;)V", "", "h", "()Z", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "a", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "logger", "", "", "b", "Ljava/util/List;", "dataRcvListeners", "c", "connectListeners", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "d", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "msgOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceOperator;", "e", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceOperator;", "deviceOperator", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "operatorManager", "Landroid/os/Handler;", "Landroid/os/Handler;", "messageHandler", "Z", "isReady", "com/upuphone/ai/ttsengine/flavor/service/connect/Communicator$messageReceiver$1", "Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$messageReceiver$1;", "messageReceiver", "com/upuphone/ai/ttsengine/flavor/service/connect/Communicator$deviceConnectionListener$1", "j", "Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$deviceConnectionListener$1;", "deviceConnectionListener", "com/upuphone/ai/ttsengine/flavor/service/connect/Communicator$p2pStateListener$1", "k", "Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$p2pStateListener$1;", "p2pStateListener", "l", "Companion", "OnConnectListener", "OnDataRcvListener", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class Communicator {
    public static final Companion l = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final AILOG f5565a;
    public final List b = Collections.synchronizedList(new ArrayList());
    public final List c = Collections.synchronizedList(new ArrayList());
    public StarryNetMessageOperator d;
    public StarryNetDeviceOperator e;
    public OperatorManager f;
    public Handler g;
    public volatile boolean h;
    public final Communicator$messageReceiver$1 i;
    public final Communicator$deviceConnectionListener$1 j;
    public final Communicator$p2pStateListener$1 k;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$Companion;", "", "()V", "CONNECT_CHANGE", "", "MESSAGE_RECEIVE", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$OnConnectListener;", "", "", "isConn", "", "a", "(Z)V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnConnectListener {
        void a(boolean z);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator$OnDataRcvListener;", "", "", "bytes", "", "a", "([B)V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnDataRcvListener {
        void a(byte[] bArr);
    }

    public Communicator(String str) {
        StarryNetDevice connectedDevice;
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_PKG);
        AILOG a2 = AILOG.a("Communicator");
        this.f5565a = a2;
        Communicator$messageReceiver$1 communicator$messageReceiver$1 = new Communicator$messageReceiver$1(this);
        this.i = communicator$messageReceiver$1;
        Communicator$deviceConnectionListener$1 communicator$deviceConnectionListener$1 = new Communicator$deviceConnectionListener$1(this);
        this.j = communicator$deviceConnectionListener$1;
        Communicator$p2pStateListener$1 communicator$p2pStateListener$1 = new Communicator$p2pStateListener$1(this);
        this.k = communicator$p2pStateListener$1;
        HandlerThread handlerThread = new HandlerThread("TTS-Connect-thread");
        handlerThread.start();
        this.g = new Handler(this, handlerThread.getLooper()) {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Communicator f5566a;

            {
                this.f5566a = r1;
            }

            public void handleMessage(Message message) {
                Intrinsics.checkNotNullParameter(message, "message");
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        AILOG c = this.f5566a.f5565a;
                        int i2 = message.what;
                        c.h("un support message:" + i2, new Object[0]);
                        return;
                    }
                    List<OnConnectListener> a2 = this.f5566a.c;
                    Intrinsics.checkNotNullExpressionValue(a2, "access$getConnectListeners$p(...)");
                    for (OnConnectListener a3 : a2) {
                        Object obj = message.obj;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                        a3.a(((Boolean) obj).booleanValue());
                    }
                } else if (this.f5566a.b != null && this.f5566a.b.size() > 0) {
                    for (OnDataRcvListener a4 : this.f5566a.b) {
                        Object obj2 = message.obj;
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
                        a4.a((byte[]) obj2);
                    }
                }
            }
        };
        a2.m("#### interconnect init start#####", new Object[0]);
        OperatorManager init = SuperAppServiceManager.getInstance().init(str);
        this.f = init;
        StarryNetDeviceOperator starryNetDeviceOperator = null;
        StarryNetMessageOperator messageOperator = init != null ? init.getMessageOperator() : null;
        this.d = messageOperator;
        if (messageOperator != null) {
            messageOperator.registerMessageReceiver(communicator$messageReceiver$1);
        }
        OperatorManager operatorManager = this.f;
        starryNetDeviceOperator = operatorManager != null ? operatorManager.getDeviceOperator() : starryNetDeviceOperator;
        this.e = starryNetDeviceOperator;
        if (starryNetDeviceOperator != null) {
            starryNetDeviceOperator.registerDeviceConnectionListener(communicator$deviceConnectionListener$1);
        }
        StarryNetDeviceOperator starryNetDeviceOperator2 = this.e;
        if (starryNetDeviceOperator2 != null) {
            starryNetDeviceOperator2.registerP2pStateListener(communicator$p2pStateListener$1);
        }
        StarryNetDeviceOperator starryNetDeviceOperator3 = this.e;
        if (starryNetDeviceOperator3 != null && (connectedDevice = starryNetDeviceOperator3.getConnectedDevice()) != null && StarryNetDeviceExt.isXrDevice(connectedDevice)) {
            this.h = true;
        }
    }

    public static /* synthetic */ void j(Communicator communicator, byte[] bArr, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        communicator.i(bArr, str, str2);
    }

    public final void f(OnConnectListener onConnectListener) {
        Intrinsics.checkNotNullParameter(onConnectListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c.add(onConnectListener);
    }

    public final void g(OnDataRcvListener onDataRcvListener) {
        Intrinsics.checkNotNullParameter(onDataRcvListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b.add(onDataRcvListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r2 = r2.getConnectedDevice();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h() {
        /*
            r2 = this;
            com.upuphone.xr.interconnect.api.StarryNetDeviceOperator r2 = r2.e
            r0 = 0
            if (r2 == 0) goto L_0x0015
            com.upuphone.xr.interconnect.entity.StarryNetDevice r2 = r2.getConnectedDevice()
            if (r2 == 0) goto L_0x0015
            int r2 = r2.getStatus()
            r1 = 8
            r2 = r2 & r1
            if (r2 != r1) goto L_0x0015
            r0 = 1
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.flavor.service.connect.Communicator.h():boolean");
    }

    public final void i(byte[] bArr, String str, String str2) {
        if (this.h) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            StarryNetMessage starryNetMessage = new StarryNetMessage();
            starryNetMessage.setMessage(str);
            starryNetMessage.setData(bArr);
            starryNetMessage.setId(uuid);
            AILOG ailog = this.f5565a;
            ailog.m("send data byte， msgID=" + uuid, new Object[0]);
            starryNetMessage.setReceiverPkg(str2);
            StarryNetMessageOperator starryNetMessageOperator = this.d;
            if (starryNetMessageOperator != null) {
                starryNetMessageOperator.sendMessage2(starryNetMessage, (SendMessageListener) null);
                return;
            }
            return;
        }
        this.f5565a.m(" @_@ no connected device currently", new Object[0]);
    }
}

package com.upuphone.xr.sapp.monitor.starry;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.honey.account.p8.a;
import com.honey.account.view.web.WebJs;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceOperator;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001b\u001a\u00020\r\"\u0004\b\u0000\u0010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\u001e\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b$\u0010%J+\u0010'\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b'\u0010(J)\u0010)\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b)\u0010*J'\u0010/\u001a\u00020\r2\u0018\u0010.\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020\r0+j\u0002`-¢\u0006\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R$\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000b04j\b\u0012\u0004\u0012\u00020\u000b`58\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020 098\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010:R,\u0010=\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020\r0+j\u0002`-098\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010@\u001a\u0004\u0018\u00010>8BX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010?¨\u0006A"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/starry/StarryMessageHelper;", "", "<init>", "()V", "", "g", "()Z", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "f", "()Lcom/upuphone/xr/interconnect/api/OperatorManager;", "h", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "listener", "", "i", "(Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;)V", "", "msg", "", "data", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "receiverPkg", "q", "(Ljava/lang/String;[BLcom/upuphone/xr/interconnect/listener/SendMessageListener;Ljava/lang/String;)V", "T", "mByteArray", "Lcom/upuphone/xr/sapp/monitor/starry/StarryNotificationBase;", "s", "([BLcom/upuphone/xr/sapp/monitor/starry/StarryNotificationBase;Lcom/upuphone/xr/interconnect/listener/SendMessageListener;)V", "action", "n", "([BLjava/lang/String;Ljava/lang/Object;Lcom/upuphone/xr/interconnect/listener/SendMessageListener;Ljava/lang/String;)V", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "messageReceiver", "j", "(Lcom/upuphone/xr/interconnect/listener/MessageReceiver;)V", "k", "(Ljava/lang/String;Lcom/upuphone/xr/interconnect/listener/SendMessageListener;)V", "bytes", "m", "(Ljava/lang/String;[BLcom/upuphone/xr/interconnect/listener/SendMessageListener;)V", "l", "(Ljava/lang/String;Lcom/upuphone/xr/interconnect/listener/SendMessageListener;Ljava/lang/String;)V", "Lkotlin/Function1;", "", "Lcom/upuphone/xr/sapp/monitor/starry/PeerVersionCallback;", "callback", "d", "(Lkotlin/jvm/functions/Function1;)V", "b", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "mOperatorManager", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "mDeviceConnectionListenerArray", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "messageReceivers", "e", "peerVersionCallbacks", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "()Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "messageOperator", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStarryMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StarryMessageHelper.kt\ncom/upuphone/xr/sapp/monitor/starry/StarryMessageHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,267:1\n1855#2,2:268\n1855#2,2:270\n*S KotlinDebug\n*F\n+ 1 StarryMessageHelper.kt\ncom/upuphone/xr/sapp/monitor/starry/StarryMessageHelper\n*L\n39#1:268,2\n43#1:270,2\n*E\n"})
public final class StarryMessageHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final StarryMessageHelper f7799a = new StarryMessageHelper();
    public static OperatorManager b;
    public static final ArrayList c = new ArrayList();
    public static final CopyOnWriteArraySet d = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet e = new CopyOnWriteArraySet();

    static {
        SuperAppServiceManager.getInstance().init("com.upuphone.star.launcher", new a());
    }

    public static final void b(OperatorManager operatorManager) {
        StarryNetDeviceOperator deviceOperator;
        Intrinsics.checkNotNullParameter(operatorManager, "operatorManager");
        ULog.f6446a.g("StarryMessageHelper", "operatorManager init call");
        b = operatorManager;
        for (DeviceConnectionListener deviceConnectionListener : c) {
            OperatorManager operatorManager2 = b;
            if (!(operatorManager2 == null || (deviceOperator = operatorManager2.getDeviceOperator()) == null)) {
                deviceOperator.registerDeviceConnectionListener(deviceConnectionListener);
            }
        }
        ULog.f6446a.g("StarryMessageHelper", "operatorManager init call, registerMessageReceiver");
        for (MessageReceiver registerMessageReceiver : d) {
            operatorManager.getMessageOperator().registerMessageReceiver(registerMessageReceiver);
        }
        operatorManager.getInfoOperator().getPeer().getVersion().subscribe(StarryMessageHelper$1$3.INSTANCE);
    }

    public static /* synthetic */ void o(StarryMessageHelper starryMessageHelper, String str, SendMessageListener sendMessageListener, int i, Object obj) {
        if ((i & 2) != 0) {
            sendMessageListener = null;
        }
        starryMessageHelper.k(str, sendMessageListener);
    }

    public static /* synthetic */ void p(StarryMessageHelper starryMessageHelper, byte[] bArr, String str, Object obj, SendMessageListener sendMessageListener, String str2, int i, Object obj2) {
        byte[] bArr2 = (i & 1) != 0 ? null : bArr;
        SendMessageListener sendMessageListener2 = (i & 8) != 0 ? null : sendMessageListener;
        if ((i & 16) != 0) {
            str2 = "com.upuphone.star.launcher";
        }
        starryMessageHelper.n(bArr2, str, obj, sendMessageListener2, str2);
    }

    public static /* synthetic */ void r(StarryMessageHelper starryMessageHelper, String str, byte[] bArr, SendMessageListener sendMessageListener, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr = null;
        }
        if ((i & 4) != 0) {
            sendMessageListener = null;
        }
        if ((i & 8) != 0) {
            str2 = "com.upuphone.star.launcher";
        }
        starryMessageHelper.q(str, bArr, sendMessageListener, str2);
    }

    public static /* synthetic */ void t(StarryMessageHelper starryMessageHelper, byte[] bArr, StarryNotificationBase starryNotificationBase, SendMessageListener sendMessageListener, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = null;
        }
        if ((i & 4) != 0) {
            sendMessageListener = null;
        }
        starryMessageHelper.s(bArr, starryNotificationBase, sendMessageListener);
    }

    public final void d(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        e.add(function1);
    }

    public final StarryNetMessageOperator e() {
        OperatorManager operatorManager = b;
        if (operatorManager != null) {
            return operatorManager.getMessageOperator();
        }
        return null;
    }

    public final OperatorManager f() {
        return b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getDeviceOperator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g() {
        /*
            r0 = this;
            com.upuphone.xr.interconnect.api.OperatorManager r0 = b
            if (r0 == 0) goto L_0x000f
            com.upuphone.xr.interconnect.api.StarryNetDeviceOperator r0 = r0.getDeviceOperator()
            if (r0 == 0) goto L_0x000f
            com.upuphone.xr.interconnect.entity.StarryNetDevice r0 = r0.getConnectedDevice()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 == 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper.g():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r3 = r3.getDeviceOperator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h() {
        /*
            r3 = this;
            com.upuphone.xr.interconnect.api.OperatorManager r3 = b
            r0 = 0
            if (r3 == 0) goto L_0x0010
            com.upuphone.xr.interconnect.api.StarryNetDeviceOperator r3 = r3.getDeviceOperator()
            if (r3 == 0) goto L_0x0010
            com.upuphone.xr.interconnect.entity.StarryNetDevice r3 = r3.getConnectedDevice()
            goto L_0x0011
        L_0x0010:
            r3 = r0
        L_0x0011:
            if (r3 == 0) goto L_0x0017
            java.lang.String r0 = r3.getModelId()
        L_0x0017:
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = ""
        L_0x001b:
            boolean r3 = com.upuphone.xr.sapp.utils.ModelIdExtKt.a(r0)
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isAirGlass:"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "StarryMessageHelper"
            r0.g(r2, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper.h():boolean");
    }

    public final void i(DeviceConnectionListener deviceConnectionListener) {
        Intrinsics.checkNotNullParameter(deviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (b == null) {
            c.add(deviceConnectionListener);
        }
        OperatorManager operatorManager = b;
        if (operatorManager != null) {
            operatorManager.getDeviceOperator().registerDeviceConnectionListener(deviceConnectionListener);
        }
    }

    public final void j(MessageReceiver messageReceiver) {
        Intrinsics.checkNotNullParameter(messageReceiver, "messageReceiver");
        StarryNetMessageOperator e2 = e();
        if (e2 == null) {
            ULog.f6446a.c("StarryMessageHelper", "registerMessageReceiver, messageOperator is null");
            d.add(messageReceiver);
            return;
        }
        e2.registerMessageReceiver(messageReceiver);
    }

    public final void k(String str, SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        m(str, (byte[]) null, sendMessageListener);
    }

    public final void l(String str, SendMessageListener sendMessageListener, String str2) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        Intrinsics.checkNotNullParameter(str2, "receiverPkg");
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setSenderPkg("com.upuphone.star.launcher");
        starryNetMessage.setMessage(str);
        starryNetMessage.setReceiverPkg(str2);
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(starryNetMessage, sendMessageListener);
    }

    public final void m(String str, byte[] bArr, SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setSenderPkg("com.upuphone.star.launcher");
        starryNetMessage.setMessage(str);
        starryNetMessage.setData(bArr);
        starryNetMessage.setReceiverPkg("com.upuphone.star.launcher");
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(starryNetMessage, sendMessageListener);
    }

    public final void n(byte[] bArr, String str, Object obj, SendMessageListener sendMessageListener, String str2) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(str2, "receiverPkg");
        String json = new Gson().toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, str), TuplesKt.to("data", obj)));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        q(json, bArr, sendMessageListener, str2);
    }

    public final void q(String str, byte[] bArr, SendMessageListener sendMessageListener, String str2) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        Intrinsics.checkNotNullParameter(str2, "receiverPkg");
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setMessage(str);
        starryNetMessage.setData(bArr);
        starryNetMessage.setReceiverPkg(str2);
        StarryNetMessageOperator e2 = e();
        if (Intrinsics.areEqual((Object) e2 != null ? e2.sendMessage2(starryNetMessage, new StarryMessageHelper$sendStarryMessage$messageId$1(sendMessageListener)) : null, (Object) "-1")) {
            ULog.f6446a.g("StarryMessageHelper", "消息发送失败 messageId == -1");
            if (sendMessageListener != null) {
                sendMessageListener.onFail("-1", -1);
            }
        }
    }

    public final void s(byte[] bArr, StarryNotificationBase starryNotificationBase, SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(starryNotificationBase, "data");
        String json = new Gson().toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "notification"), TuplesKt.to("data", starryNotificationBase)));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        r(this, json, bArr, sendMessageListener, (String) null, 8, (Object) null);
    }
}

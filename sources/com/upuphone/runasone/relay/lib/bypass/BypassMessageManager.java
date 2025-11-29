package com.upuphone.runasone.relay.lib.bypass;

import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.relay.api.ApiRelayBypassMsg;
import com.upuphone.runasone.relay.api.BypassCallback;
import com.upuphone.runasone.relay.lib.device.AbilityBean;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J(\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J:\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0016J \u0010!\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J(\u0010\"\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0006H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/upuphone/runasone/relay/lib/bypass/BypassMessageManager;", "Lcom/upuphone/runasone/relay/api/ApiRelayBypassMsg;", "()V", "callbackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/upuphone/runasone/relay/api/BypassCallback;", "iMultiCallbackMap", "mDeviceMap", "Lcom/upuphone/runasone/relay/lib/device/AbilityBean;", "onReceiveMessage", "", "deviceId", "serviceUuid", "characterUuid", "messageType", "", "msg", "Lcom/upuphone/runasone/ArrayData;", "putDevice", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "observer", "Lcom/upuphone/runasone/host/core/api/IAbilitySlot$SlotObserver;", "removeDevice", "devId", "removeRelayListener", "removeRelayListenerByCallback", "callBackTag", "callBack", "sendMessage", "msgType", "Lcom/upuphone/runasone/relay/api/SendRelayMessageCallBack;", "setRelayListener", "setRelayListenerByCallback", "Companion", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BypassMessageManager implements ApiRelayBypassMsg {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<BypassMessageManager> Intance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, BypassMessageManager$Companion$Intance$2.INSTANCE);
    private static final String TAG = BypassMessageManager.class.getSimpleName();
    @NotNull
    private final ConcurrentHashMap<String, BypassCallback> callbackMap = new ConcurrentHashMap<>();
    @NotNull
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, BypassCallback>> iMultiCallbackMap = new ConcurrentHashMap<>();
    @NotNull
    private final ConcurrentHashMap<String, AbilityBean> mDeviceMap = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/upuphone/runasone/relay/lib/bypass/BypassMessageManager$Companion;", "", "()V", "Intance", "Lcom/upuphone/runasone/relay/lib/bypass/BypassMessageManager;", "getIntance", "()Lcom/upuphone/runasone/relay/lib/bypass/BypassMessageManager;", "Intance$delegate", "Lkotlin/Lazy;", "TAG", "", "kotlin.jvm.PlatformType", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BypassMessageManager getIntance() {
            return (BypassMessageManager) BypassMessageManager.Intance$delegate.getValue();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void onReceiveMessage$default(BypassMessageManager bypassMessageManager, String str, String str2, String str3, int i, ArrayData arrayData, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        bypassMessageManager.onReceiveMessage(str, str2, str3, i, arrayData);
    }

    public final void onReceiveMessage(@NotNull String str, @Nullable String str2, @Nullable String str3, int i, @NotNull ArrayData arrayData) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(arrayData, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        ConcurrentHashMap<String, BypassCallback> concurrentHashMap = this.callbackMap;
        BypassCallback bypassCallback = concurrentHashMap.get(str2 + '%' + str3);
        if (bypassCallback != null) {
            bypassCallback.onReceiveMessage(str, str2, str3, i, arrayData);
        } else {
            LogUtil.ePrimary(TAG, "---onReceiveMessage   callBack is null");
        }
        ConcurrentHashMap<String, ConcurrentHashMap<String, BypassCallback>> concurrentHashMap2 = this.iMultiCallbackMap;
        ConcurrentHashMap concurrentHashMap3 = concurrentHashMap2.get(str2 + '%' + str3);
        if (concurrentHashMap3 != null && !concurrentHashMap3.isEmpty()) {
            for (Map.Entry entry : concurrentHashMap3.entrySet()) {
                String str4 = (String) entry.getKey();
                ((BypassCallback) entry.getValue()).onReceiveMessage(str, str2, str3, i, arrayData);
            }
        }
    }

    public final void putDevice(@NotNull StarryDevice starryDevice, @NotNull IAbilitySlot.SlotObserver slotObserver) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        Intrinsics.checkNotNullParameter(slotObserver, "observer");
        AbilityBean abilityBean = new AbilityBean();
        abilityBean.setDevice(starryDevice);
        abilityBean.setObserver(slotObserver);
        ConcurrentHashMap<String, AbilityBean> concurrentHashMap = this.mDeviceMap;
        String id = starryDevice.getId();
        Intrinsics.checkNotNullExpressionValue(id, "device.id");
        concurrentHashMap.put(id, abilityBean);
    }

    public final void removeDevice(@Nullable String str) {
        TypeIntrinsics.asMutableMap(this.mDeviceMap).remove(str);
    }

    public void removeRelayListener(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        Intrinsics.checkNotNullParameter(str2, "characterUuid");
        String str3 = TAG;
        LogUtil.ePrimary(str3, "---removeRelayListener  serviceUuid=" + str + " characterUuid=" + str2);
        ConcurrentHashMap<String, BypassCallback> concurrentHashMap = this.callbackMap;
        concurrentHashMap.remove(str + '%' + str2);
    }

    public void removeRelayListenerByCallback(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull BypassCallback bypassCallback) {
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        Intrinsics.checkNotNullParameter(str2, "characterUuid");
        Intrinsics.checkNotNullParameter(str3, "callBackTag");
        Intrinsics.checkNotNullParameter(bypassCallback, "callBack");
        String str4 = TAG;
        LogUtil.ePrimary(str4, "---removeRelayListenerByCallback  serviceUuid=" + str + " characterUuid=" + str2 + "  callBackTag=" + str3);
        ConcurrentHashMap<String, ConcurrentHashMap<String, BypassCallback>> concurrentHashMap = this.iMultiCallbackMap;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('%');
        sb.append(str2);
        ConcurrentHashMap concurrentHashMap2 = concurrentHashMap.get(sb.toString());
        if (concurrentHashMap2 != null && !concurrentHashMap2.isEmpty()) {
            concurrentHashMap2.remove(str3);
            if (concurrentHashMap2.isEmpty()) {
                ConcurrentHashMap<String, ConcurrentHashMap<String, BypassCallback>> concurrentHashMap3 = this.iMultiCallbackMap;
                concurrentHashMap3.remove(str + '%' + str2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x004e, code lost:
        r5 = r3.getObserver();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendMessage(@org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.NotNull java.lang.String r4, @org.jetbrains.annotations.NotNull java.lang.String r5, int r6, @org.jetbrains.annotations.NotNull com.upuphone.runasone.ArrayData r7, @org.jetbrains.annotations.Nullable com.upuphone.runasone.relay.api.SendRelayMessageCallBack r8) {
        /*
            r2 = this;
            java.lang.String r2 = "deviceId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "serviceUuid"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            java.lang.String r2 = "characterUuid"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.lang.String r2 = "msg"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            java.lang.String r2 = TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "---sendMessage  deviceId="
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = "  serviceUuid="
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = "  characterUuid="
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.upuphone.runasone.relay.lib.utils.LogUtil.ePrimary(r2, r0)
            com.upuphone.runasone.host.core.api.AbilityMessage r0 = new com.upuphone.runasone.host.core.api.AbilityMessage
            byte[] r7 = r7.getData()
            r0.<init>(r4, r5, r6, r7)
            com.upuphone.runasone.relay.lib.device.RelayDeviceManager r4 = com.upuphone.runasone.relay.lib.device.RelayDeviceManager.getInstance()
            com.upuphone.runasone.relay.lib.device.AbilityBean r3 = r4.getDeviceById(r3)
            r4 = 0
            if (r3 == 0) goto L_0x0061
            com.upuphone.runasone.host.core.api.IAbilitySlot$SlotObserver r5 = r3.getObserver()
            if (r5 == 0) goto L_0x0061
            com.upuphone.runasone.device.StarryDevice r6 = r3.getDevice()
            int r5 = r5.output(r6, r0)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0062
        L_0x0061:
            r5 = r4
        L_0x0062:
            if (r5 != 0) goto L_0x009b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "bean==null="
            r5.append(r6)
            r6 = 0
            r7 = 1
            if (r3 != 0) goto L_0x0074
            r0 = r7
            goto L_0x0075
        L_0x0074:
            r0 = r6
        L_0x0075:
            r5.append(r0)
            java.lang.String r0 = "   bean?.observer==null="
            r5.append(r0)
            if (r3 == 0) goto L_0x0083
            com.upuphone.runasone.host.core.api.IAbilitySlot$SlotObserver r4 = r3.getObserver()
        L_0x0083:
            if (r4 != 0) goto L_0x0086
            r6 = r7
        L_0x0086:
            r5.append(r6)
            java.lang.String r3 = r5.toString()
            com.upuphone.runasone.relay.lib.utils.LogUtil.ePrimary(r2, r3)
            if (r8 == 0) goto L_0x009a
            r2 = 10
            java.lang.String r3 = "连接设备对象为空"
            r8.onError(r2, r3)
        L_0x009a:
            return
        L_0x009b:
            int r2 = r5.intValue()
            if (r2 == 0) goto L_0x00ad
            if (r8 == 0) goto L_0x00b2
            int r2 = r5.intValue()
            java.lang.String r3 = ""
            r8.onError(r2, r3)
            goto L_0x00b2
        L_0x00ad:
            if (r8 == 0) goto L_0x00b2
            r8.onSuccess()
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.relay.lib.bypass.BypassMessageManager.sendMessage(java.lang.String, java.lang.String, java.lang.String, int, com.upuphone.runasone.ArrayData, com.upuphone.runasone.relay.api.SendRelayMessageCallBack):void");
    }

    public void setRelayListener(@NotNull String str, @NotNull String str2, @NotNull BypassCallback bypassCallback) {
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        Intrinsics.checkNotNullParameter(str2, "characterUuid");
        Intrinsics.checkNotNullParameter(bypassCallback, "callBack");
        String str3 = TAG;
        LogUtil.ePrimary(str3, "---setRelayListener  serviceUuid=" + str + " characterUuid=" + str2 + "  callBack=" + bypassCallback.hashCode());
        ConcurrentHashMap<String, BypassCallback> concurrentHashMap = this.callbackMap;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('%');
        sb.append(str2);
        concurrentHashMap.put(sb.toString(), bypassCallback);
    }

    public void setRelayListenerByCallback(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull BypassCallback bypassCallback) {
        Intrinsics.checkNotNullParameter(str, "serviceUuid");
        Intrinsics.checkNotNullParameter(str2, "characterUuid");
        Intrinsics.checkNotNullParameter(str3, "callBackTag");
        Intrinsics.checkNotNullParameter(bypassCallback, "callBack");
        String str4 = TAG;
        LogUtil.ePrimary(str4, "---setRelayListenerByCallback  serviceUuid=" + str + " characterUuid=" + str2 + "  callBackTag=" + str3);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap<String, ConcurrentHashMap<String, BypassCallback>> concurrentHashMap2 = this.iMultiCallbackMap;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('%');
        sb.append(str2);
        ConcurrentHashMap concurrentHashMap3 = concurrentHashMap2.get(sb.toString());
        if (concurrentHashMap3 != null) {
            concurrentHashMap3.put(str3, bypassCallback);
            ConcurrentHashMap<String, ConcurrentHashMap<String, BypassCallback>> concurrentHashMap4 = this.iMultiCallbackMap;
            concurrentHashMap4.put(str + '%' + str2, concurrentHashMap3);
            return;
        }
        concurrentHashMap.put(str3, bypassCallback);
        ConcurrentHashMap<String, ConcurrentHashMap<String, BypassCallback>> concurrentHashMap5 = this.iMultiCallbackMap;
        concurrentHashMap5.put(str + '%' + str2, concurrentHashMap);
    }
}

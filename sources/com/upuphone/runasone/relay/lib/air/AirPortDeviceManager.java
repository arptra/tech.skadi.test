package com.upuphone.runasone.relay.lib.air;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.RelayCallback;
import com.upuphone.runasone.relay.api.SendRelayMessageCallBack;
import com.upuphone.runasone.relay.error.RelayErrorCode;
import com.upuphone.runasone.relay.lib.device.AbilityBean;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import com.upuphone.runasone.relay.lib.utils.UtilUse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u00019B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000bJ,\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J*\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u001e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#J\u0010\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020\u0005J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 J\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0(2\u0006\u0010)\u001a\u00020\u0005J\u001d\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\nJ\u0010\u0010-\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\nJ\u0012\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\bH\u0002J*\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020!2\u0006\u00103\u001a\u0002042\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050(J\u000e\u00106\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0005J\u0010\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u00108\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\nR\u001e\u0010\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/upuphone/runasone/relay/lib/air/AirPortDeviceManager;", "", "()V", "listenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/upuphone/runasone/relay/api/RelayCallback;", "mDeviceMap", "Lcom/upuphone/runasone/relay/lib/device/AbilityBean;", "sendListenerMap", "", "Lcom/upuphone/runasone/relay/api/SendRelayMessageCallBack;", "addRelayCallback", "", "appUniqueKey", "callback", "addSendMessageListener", "uniqueKey", "listener", "callIRelayBack", "starryTag", "Lcom/upuphone/runasone/relay/StarryTag;", "callBack", "code", "param", "Lcom/upuphone/runasone/relay/StarryParam;", "callRemoteListener", "devAuc", "removeHandler", "", "callSendMessageListener", "getBroadcastDeviceList", "", "Lcom/upuphone/runasone/device/StarryDevice;", "keySet", "", "getDevice", "deviceId", "getDeviceList", "getDeviceMap", "", "appUniteCode", "getMappingCode", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "getMappingString", "getRelayCallback", "getSendMessageListener", "onDeviceStateChange", "bean", "putDevice", "device", "observer", "Lcom/upuphone/runasone/host/core/api/IAbilitySlot$SlotObserver;", "metaMap", "removeDevice", "removeRelayCallback", "removeSendMessageListener", "Companion", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AirPortDeviceManager {
    @NotNull
    public static final Companion Companion;
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<AirPortDeviceManager> SIntance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AirPortDeviceManager$Companion$SIntance$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final String TAG;
    @NotNull
    private final ConcurrentHashMap<String, RelayCallback> listenerMap = new ConcurrentHashMap<>();
    @NotNull
    private final ConcurrentHashMap<String, AbilityBean> mDeviceMap = new ConcurrentHashMap<>();
    @NotNull
    private final ConcurrentHashMap<Integer, SendRelayMessageCallBack> sendListenerMap = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/runasone/relay/lib/air/AirPortDeviceManager$Companion;", "", "()V", "SIntance", "Lcom/upuphone/runasone/relay/lib/air/AirPortDeviceManager;", "getSIntance", "()Lcom/upuphone/runasone/relay/lib/air/AirPortDeviceManager;", "SIntance$delegate", "Lkotlin/Lazy;", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AirPortDeviceManager getSIntance() {
            return (AirPortDeviceManager) AirPortDeviceManager.SIntance$delegate.getValue();
        }

        public final String getTAG() {
            return AirPortDeviceManager.TAG;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        TAG = companion.getClass().getSimpleName();
    }

    private final void callIRelayBack(StarryTag starryTag, RelayCallback relayCallback, int i, StarryParam starryParam) {
        if (relayCallback == null) {
            return;
        }
        if (i > 0) {
            String str = TAG;
            LogUtil.dPrimary(str, "------REMOTE_FAILED:   " + i);
            relayCallback.onRemoteError(starryTag, i, RelayErrorCode.getErrorText(i), starryParam);
        } else if (i == 0) {
            String str2 = TAG;
            LogUtil.dPrimary(str2, "------REMOTE_STOP:   " + i);
            relayCallback.onRemoteStop(starryTag, starryParam);
        } else {
            String str3 = TAG;
            LogUtil.dPrimary(str3, "------REMOTE_START:   " + i);
            relayCallback.onRemoteStart(starryTag, starryParam);
        }
    }

    private final void onDeviceStateChange(AbilityBean abilityBean) {
        if (abilityBean != null) {
            List<StarryDevice> deviceList = getDeviceList();
            List<String> keyList = abilityBean.getKeyList();
            if (keyList != null) {
                Intrinsics.checkNotNullExpressionValue(keyList, "keyList");
                for (String str : keyList) {
                    RelayCallback relayCallback = this.listenerMap.get(str);
                    if (relayCallback != null) {
                        relayCallback.onDeviceListChanged(str, deviceList);
                    }
                }
            }
        }
    }

    public final void addRelayCallback(@NotNull String str, @NotNull RelayCallback relayCallback) {
        Intrinsics.checkNotNullParameter(str, "appUniqueKey");
        Intrinsics.checkNotNullParameter(relayCallback, "callback");
        this.listenerMap.put(str, relayCallback);
    }

    public final void addSendMessageListener(int i, @NotNull SendRelayMessageCallBack sendRelayMessageCallBack) {
        Intrinsics.checkNotNullParameter(sendRelayMessageCallBack, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.sendListenerMap.put(Integer.valueOf(i), sendRelayMessageCallBack);
    }

    public final void callRemoteListener(@Nullable String str, int i, boolean z, @Nullable StarryParam starryParam) {
        if (z) {
            AirPortMessageManager.Companion.getSIntance().getTimeOut().sendRemoveRemote(false, str, starryParam != null ? starryParam.getListenerId() : 0);
        }
        if (str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "%", false, 2, (Object) null)) {
            StarryTag starryTag = UtilUse.getStarryTag(str);
            Intrinsics.checkNotNullExpressionValue(starryTag, "starryTag");
            String sendAppUniteCode = starryTag.getSendAppUniteCode();
            Intrinsics.checkNotNullExpressionValue(sendAppUniteCode, "starryTag.sendAppUniteCode");
            callIRelayBack(starryTag, getRelayCallback(sendAppUniteCode), i, starryParam);
        }
    }

    public final void callSendMessageListener(int i, int i2, boolean z) {
        if (z) {
            AirPortMessageManager.Companion.getSIntance().getTimeOut().sendRemoveMessage(false, i);
        }
        SendRelayMessageCallBack removeSendMessageListener = removeSendMessageListener(i);
        if (removeSendMessageListener == null) {
            String str = TAG;
            LogUtil.dPrimary(str, "------消息回调，没有回调方法   uniqueKey=" + i);
        } else if (i2 > 0) {
            String str2 = TAG;
            LogUtil.dPrimary(str2, "------MSG_FAILED:" + i2 + "   uniqueKey=" + i);
            removeSendMessageListener.onError(i2, RelayErrorCode.getErrorText(i2));
        } else {
            String str3 = TAG;
            LogUtil.dPrimary(str3, "------MSG_SUCCESS   uniqueKey=" + i);
            removeSendMessageListener.onSuccess();
        }
    }

    @NotNull
    public final List<StarryDevice> getBroadcastDeviceList(@NotNull Collection<String> collection) {
        Intrinsics.checkNotNullParameter(collection, "keySet");
        ArrayList arrayList = new ArrayList();
        for (AbilityBean next : this.mDeviceMap.values()) {
            Iterator<String> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (next.getKeyList().contains(it.next())) {
                    StarryDevice device = next.getDevice();
                    Intrinsics.checkNotNullExpressionValue(device, "dev.device");
                    arrayList.add(device);
                    break;
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final AbilityBean getDevice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        return this.mDeviceMap.get(str);
    }

    @NotNull
    public final List<StarryDevice> getDeviceList() {
        ArrayList arrayList = new ArrayList();
        for (AbilityBean device : this.mDeviceMap.values()) {
            StarryDevice device2 = device.getDevice();
            Intrinsics.checkNotNullExpressionValue(device2, "dev.device");
            arrayList.add(device2);
        }
        return arrayList;
    }

    @NotNull
    public final Map<String, StarryDevice> getDeviceMap(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appUniteCode");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AbilityBean next : this.mDeviceMap.values()) {
            if (next.getKeyList().contains(str)) {
                String id = next.getDevice().getId();
                Intrinsics.checkNotNullExpressionValue(id, "dev.device.id");
                StarryDevice device = next.getDevice();
                Intrinsics.checkNotNullExpressionValue(device, "dev.device");
                linkedHashMap.put(id, device);
            }
        }
        return linkedHashMap;
    }

    @Nullable
    public final Integer getMappingCode(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "appUniteCode");
        AbilityBean device = getDevice(str);
        Map<String, Integer> metaMap = device != null ? device.getMetaMap() : null;
        Intrinsics.checkNotNull(metaMap);
        return metaMap.get(str2);
    }

    @Nullable
    public final String getMappingString(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        AbilityBean device = getDevice(str);
        Map<Integer, String> codeMap = device != null ? device.getCodeMap() : null;
        Intrinsics.checkNotNull(codeMap);
        return codeMap.get(Integer.valueOf(i));
    }

    @Nullable
    public final RelayCallback getRelayCallback(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appUniqueKey");
        return this.listenerMap.get(str);
    }

    @Nullable
    public final SendRelayMessageCallBack getSendMessageListener(int i) {
        return this.sendListenerMap.get(Integer.valueOf(i));
    }

    public final void putDevice(@NotNull StarryDevice starryDevice, @NotNull IAbilitySlot.SlotObserver slotObserver, @NotNull Map<Integer, String> map) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        Intrinsics.checkNotNullParameter(slotObserver, "observer");
        Intrinsics.checkNotNullParameter(map, "metaMap");
        AbilityBean abilityBean = new AbilityBean();
        abilityBean.setDevice(starryDevice);
        abilityBean.setObserver(slotObserver);
        abilityBean.setCodeMap(map);
        if (abilityBean.getKeyList() == null) {
            abilityBean.setKeyList(new ArrayList());
        }
        for (Map.Entry next : map.entrySet()) {
            int intValue = ((Number) next.getKey()).intValue();
            String str = (String) next.getValue();
            Map<String, Integer> metaMap = abilityBean.getMetaMap();
            Intrinsics.checkNotNullExpressionValue(metaMap, "dev.metaMap");
            metaMap.put(str, Integer.valueOf(intValue));
            abilityBean.getKeyList().add(str);
        }
        ConcurrentHashMap<String, AbilityBean> concurrentHashMap = this.mDeviceMap;
        String id = starryDevice.getId();
        Intrinsics.checkNotNullExpressionValue(id, "device.id");
        concurrentHashMap.put(id, abilityBean);
        onDeviceStateChange(abilityBean);
    }

    public final void removeDevice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        onDeviceStateChange(this.mDeviceMap.remove(str));
    }

    @Nullable
    public final RelayCallback removeRelayCallback(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appUniqueKey");
        return this.listenerMap.remove(str);
    }

    @Nullable
    public final SendRelayMessageCallBack removeSendMessageListener(int i) {
        return this.sendListenerMap.remove(Integer.valueOf(i));
    }
}

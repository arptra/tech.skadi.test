package com.upuphone.runasone.relay.lib.air;

import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.Gson;
import com.honey.account.g6.a;
import com.honey.account.g6.b;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.ComponentProperty;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.RelayCallback;
import com.upuphone.runasone.relay.error.RelayErrorCode;
import com.upuphone.runasone.relay.lib.manager.AppConfigManager;
import com.upuphone.runasone.relay.lib.utils.KtExtensionKt;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0016J\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0017J\u001c\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0007J\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!J\u001c\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/upuphone/runasone/relay/lib/air/AirPort;", "Lcom/upuphone/runasone/host/core/api/IAbilitySlot;", "()V", "appChangeCall", "Ljava/util/function/BiConsumer;", "", "", "", "appStateChanged", "", "pid", "packageName", "uniteCode", "state", "attach", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "observer", "Lcom/upuphone/runasone/host/core/api/IAbilitySlot$SlotObserver;", "remoteJson", "Lcom/upuphone/runasone/host/core/api/ComponentProperty;", "detach", "getDeviceList", "", "input", "message", "Lcom/upuphone/runasone/host/core/api/AbilityMessage;", "isBinderExit", "", "removeRelayListener", "appUniteCode", "setRelayListener", "listener", "Lcom/upuphone/runasone/relay/api/RelayCallback;", "transfer", "inBundle", "Landroid/os/Bundle;", "outBundle", "Companion", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AirPort implements IAbilitySlot {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<AirPort> SIntance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AirPort$Companion$SIntance$2.INSTANCE);
    private static final String TAG = AirPort.class.getSimpleName();
    private static final Set<String> binderSet = Collections.synchronizedSet(new LinkedHashSet());
    /* access modifiers changed from: private */
    @NotNull
    public static final Set<String> deviceSet;
    @NotNull
    private final BiConsumer<Integer, Map<String, Integer>> appChangeCall;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/runasone/relay/lib/air/AirPort$Companion;", "", "()V", "SIntance", "Lcom/upuphone/runasone/relay/lib/air/AirPort;", "getSIntance", "()Lcom/upuphone/runasone/relay/lib/air/AirPort;", "SIntance$delegate", "Lkotlin/Lazy;", "TAG", "", "kotlin.jvm.PlatformType", "binderSet", "", "", "deviceSet", "getDeviceSet$annotations", "getDeviceSet", "()Ljava/util/Set;", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDeviceSet$annotations() {
        }

        @NotNull
        public final Set<String> getDeviceSet() {
            return AirPort.deviceSet;
        }

        @NotNull
        public final AirPort getSIntance() {
            return (AirPort) AirPort.SIntance$delegate.getValue();
        }

        private Companion() {
        }
    }

    static {
        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet());
        Intrinsics.checkNotNullExpressionValue(synchronizedSet, "synchronizedSet(HashSet<String>())");
        deviceSet = synchronizedSet;
    }

    public AirPort() {
        a aVar = new a();
        this.appChangeCall = aVar;
        AppConfigManager.getInstance().addAppChangeCall(aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: appChangeCall$lambda-0  reason: not valid java name */
    public static final void m1676appChangeCall$lambda0(int i, Map map) {
        Intrinsics.checkNotNullParameter(map, "keyList");
        if (1 == i) {
            AirPortMessageManager.Companion.getSIntance().updateAbility(KtExtensionKt.reverseKV(map), 1);
        } else if (2 == i) {
            AirPortMessageManager.Companion.getSIntance().updateAbility(KtExtensionKt.reverseKV(map), 2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: appStateChanged$lambda-1  reason: not valid java name */
    public static final void m1677appStateChanged$lambda1(int i, String str, StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, "$uniteCode");
        Intrinsics.checkNotNullParameter(starryDevice, "coreDevice");
        if (i == 0) {
            String str2 = TAG;
            LogUtil.dPrimary(str2, "binder STATE_DISCONNECT " + str);
            AirPortMessageManager.Companion.getSIntance().sendRemoteFailed(new StarryTag(starryDevice.getId(), str, ""), RelayErrorCode.BINDER_UN_CONNECT);
            AirPortDeviceManager.Companion.getSIntance().removeRelayCallback(str);
        } else if (i == 1) {
            String str3 = TAG;
            LogUtil.dPrimary(str3, "binder STATE_CONNECT " + str);
            AirPortMessageManager.Companion.getSIntance().sendRemoteSuccess(new StarryTag(starryDevice.getId(), str, ""));
        }
    }

    @NotNull
    public static final Set<String> getDeviceSet() {
        return Companion.getDeviceSet();
    }

    public void appStateChanged(int i, @Nullable String str, @NotNull String str2, int i2) {
        Intrinsics.checkNotNullParameter(str2, "uniteCode");
        if (i2 == 0) {
            binderSet.remove(str2);
        } else if (i2 == 1) {
            binderSet.add(str2);
        }
        AirPortDeviceManager.Companion.getSIntance().getBroadcastDeviceList(SetsKt.setOf(str2)).forEach(new b(i2, str2));
    }

    public void attach(@NotNull StarryDevice starryDevice, @NotNull IAbilitySlot.SlotObserver slotObserver, @Nullable ComponentProperty componentProperty) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        Intrinsics.checkNotNullParameter(slotObserver, "observer");
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("attach ");
        sb.append(starryDevice.getId());
        sb.append("agreementType ");
        sb.append(componentProperty != null ? Integer.valueOf(componentProperty.getAgreementType()) : null);
        LogUtil.dPrimary(str, sb.toString());
        if (componentProperty != null && componentProperty.getAgreementType() == 1 && componentProperty.isSupportTlv()) {
            Set<String> set = deviceSet;
            String id = starryDevice.getId();
            Intrinsics.checkNotNullExpressionValue(id, "device.id");
            set.add(id);
            LogUtil.dPrimary(str, "deviceSet add  " + starryDevice.getId());
            AirPortDeviceManager sIntance = AirPortDeviceManager.Companion.getSIntance();
            Map<Integer, String> airMapping = ((AirBean) new Gson().fromJson(componentProperty.getJson(), AirBean.class)).getAirMapping();
            Intrinsics.checkNotNullExpressionValue(airMapping, "bean.airMapping");
            sIntance.putDevice(starryDevice, slotObserver, airMapping);
        }
    }

    public void detach(@NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        String str = TAG;
        LogUtil.dPrimary(str, "detach " + starryDevice.getId());
        deviceSet.remove(starryDevice.getId());
        LogUtil.dPrimary(str, "deviceSet remove  " + starryDevice.getId());
        AirPortDeviceManager sIntance = AirPortDeviceManager.Companion.getSIntance();
        String id = starryDevice.getId();
        Intrinsics.checkNotNullExpressionValue(id, "device.id");
        sIntance.removeDevice(id);
    }

    @Nullable
    public final List<StarryDevice> getDeviceList() {
        return AirPortDeviceManager.Companion.getSIntance().getDeviceList();
    }

    public void input(@NotNull StarryDevice starryDevice, @NotNull AbilityMessage<?> abilityMessage) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        Intrinsics.checkNotNullParameter(abilityMessage, "message");
        AirPortMessageManager.Companion.getSIntance().input(starryDevice, abilityMessage);
    }

    public final boolean isBinderExit(@Nullable String str) {
        return binderSet.contains(str);
    }

    public final void removeRelayListener(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appUniteCode");
        AirPortDeviceManager.Companion.getSIntance().removeRelayCallback(str);
    }

    public final void setRelayListener(@NotNull String str, @NotNull RelayCallback relayCallback) {
        Intrinsics.checkNotNullParameter(str, "appUniteCode");
        Intrinsics.checkNotNullParameter(relayCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AirPortDeviceManager.Companion.getSIntance().addRelayCallback(str, relayCallback);
    }

    public void transfer(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
    }
}

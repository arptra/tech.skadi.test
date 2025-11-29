package com.upuphone.runasone.relay.lib.bypass;

import android.os.Bundle;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.ComponentProperty;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.relay.api.ApiRelayBypassMsgAdapter;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010\u0019\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006!"}, d2 = {"Lcom/upuphone/runasone/relay/lib/bypass/RelayBypassPort;", "Lcom/upuphone/runasone/host/core/api/IAbilitySlot;", "()V", "adapter", "Lcom/upuphone/runasone/relay/api/ApiRelayBypassMsgAdapter;", "getAdapter", "()Lcom/upuphone/runasone/relay/api/ApiRelayBypassMsgAdapter;", "setAdapter", "(Lcom/upuphone/runasone/relay/api/ApiRelayBypassMsgAdapter;)V", "appStateChanged", "", "pid", "", "packageName", "", "uniteCode", "state", "attach", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "observer", "Lcom/upuphone/runasone/host/core/api/IAbilitySlot$SlotObserver;", "remoteJson", "Lcom/upuphone/runasone/host/core/api/ComponentProperty;", "detach", "input", "message", "Lcom/upuphone/runasone/host/core/api/AbilityMessage;", "transfer", "inBundle", "Landroid/os/Bundle;", "outBundle", "Companion", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RelayBypassPort implements IAbilitySlot {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<RelayBypassPort> SIntance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, RelayBypassPort$Companion$SIntance$2.INSTANCE);
    private static final String TAG = RelayBypassPort.class.getSimpleName();
    @Nullable
    private ApiRelayBypassMsgAdapter adapter;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/upuphone/runasone/relay/lib/bypass/RelayBypassPort$Companion;", "", "()V", "SIntance", "Lcom/upuphone/runasone/relay/lib/bypass/RelayBypassPort;", "getSIntance", "()Lcom/upuphone/runasone/relay/lib/bypass/RelayBypassPort;", "SIntance$delegate", "Lkotlin/Lazy;", "TAG", "", "kotlin.jvm.PlatformType", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RelayBypassPort getSIntance() {
            return (RelayBypassPort) RelayBypassPort.SIntance$delegate.getValue();
        }

        private Companion() {
        }
    }

    public void appStateChanged(int i, @Nullable String str, @Nullable String str2, int i2) {
    }

    public void attach(@NotNull StarryDevice starryDevice, @NotNull IAbilitySlot.SlotObserver slotObserver, @Nullable ComponentProperty componentProperty) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        Intrinsics.checkNotNullParameter(slotObserver, "observer");
        BypassMessageManager.Companion.getIntance().putDevice(starryDevice, slotObserver);
        LogUtil.ePrimary(TAG, "---attach");
    }

    public void detach(@Nullable StarryDevice starryDevice) {
        LogUtil.ePrimary(TAG, "---detach");
        BypassMessageManager.Companion.getIntance().removeDevice(starryDevice != null ? starryDevice.getId() : null);
    }

    @Nullable
    public final ApiRelayBypassMsgAdapter getAdapter() {
        return this.adapter;
    }

    public void input(@Nullable StarryDevice starryDevice, @Nullable AbilityMessage<?> abilityMessage) {
        BypassMessageManager intance = BypassMessageManager.Companion.getIntance();
        Integer num = null;
        String id = starryDevice != null ? starryDevice.getId() : null;
        Intrinsics.checkNotNull(id);
        String serviceUuid = abilityMessage != null ? abilityMessage.getServiceUuid() : null;
        String characterUuid = abilityMessage != null ? abilityMessage.getCharacterUuid() : null;
        if (abilityMessage != null) {
            num = Integer.valueOf(abilityMessage.getMsgType());
        }
        Intrinsics.checkNotNull(num);
        intance.onReceiveMessage(id, serviceUuid, characterUuid, num.intValue(), new ArrayData(abilityMessage.getBypass()));
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("input deviceId=");
        String id2 = starryDevice.getId();
        Intrinsics.checkNotNull(id2);
        sb.append(id2);
        sb.append("  serviceUuid=");
        sb.append(abilityMessage.getServiceUuid());
        sb.append("  characterUuid=");
        sb.append(abilityMessage.getCharacterUuid());
        sb.append("  msgType=");
        sb.append(abilityMessage.getMsgType());
        LogUtil.ePrimary(str, sb.toString());
    }

    public final void setAdapter(@Nullable ApiRelayBypassMsgAdapter apiRelayBypassMsgAdapter) {
        this.adapter = apiRelayBypassMsgAdapter;
    }

    public void transfer(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (this.adapter == null) {
            this.adapter = new ApiRelayBypassMsgAdapter(BypassMessageManager.Companion.getIntance());
        }
        ApiRelayBypassMsgAdapter apiRelayBypassMsgAdapter = this.adapter;
        if (apiRelayBypassMsgAdapter != null) {
            apiRelayBypassMsgAdapter.adapt(bundle, bundle2);
        }
    }
}

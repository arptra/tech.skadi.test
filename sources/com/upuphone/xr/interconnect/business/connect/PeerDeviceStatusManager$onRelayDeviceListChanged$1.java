package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.ability.relay.RelayAbility;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerDeviceStatusManager$onRelayDeviceListChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $uniteCode;
    final /* synthetic */ PeerDeviceStatusManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerDeviceStatusManager$onRelayDeviceListChanged$1(PeerDeviceStatusManager peerDeviceStatusManager, String str) {
        super(0);
        this.this$0 = peerDeviceStatusManager;
        this.$uniteCode = str;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$uniteCode;
        ILog.d(access$getTag, str + " changed on devices , new do not handleDeviceListChange");
        if (Intrinsics.areEqual((Object) this.$uniteCode, (Object) InterconnectManager.getInstance().getPeerPackageName())) {
            RelayAbility relayAbility = StarryNetAbilityManager.getInstance().getRelayAbility();
            ArrayList<StarryDevice> glassDevice = XrSdkBondDeviceUtil.INSTANCE.getGlassDevice(relayAbility != null ? relayAbility.getRelayDeviceList(InterconnectManager.getInstance().getPeerPackageName()) : null);
            if (glassDevice.isEmpty()) {
                ILog.d(this.this$0.getTag(), "glassDeviceList.isNullOrEmpty() clear peerState");
                this.this$0.handleDeviceListChange(glassDevice);
            }
        }
    }
}

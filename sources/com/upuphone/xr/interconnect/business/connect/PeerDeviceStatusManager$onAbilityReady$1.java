package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.ability.relay.RelayAbility;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nPeerDeviceStatusManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PeerDeviceStatusManager.kt\ncom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager$onAbilityReady$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,441:1\n1855#2,2:442\n*S KotlinDebug\n*F\n+ 1 PeerDeviceStatusManager.kt\ncom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager$onAbilityReady$1\n*L\n266#1:442,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerDeviceStatusManager$onAbilityReady$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RelayAbility $relayAbility;
    final /* synthetic */ PeerDeviceStatusManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerDeviceStatusManager$onAbilityReady$1(PeerDeviceStatusManager peerDeviceStatusManager, RelayAbility relayAbility) {
        super(0);
        this.this$0 = peerDeviceStatusManager;
        this.$relayAbility = relayAbility;
    }

    public final void invoke() {
        ILog.d(this.this$0.getTag(), "onAbilityReady Initializing after ability readied.");
        int registerRelayListener = this.$relayAbility.registerRelayListener(this.this$0, new String[0]);
        String access$getTag = this.this$0.getTag();
        ILog.d(access$getTag, "onAbilityReady Registration returned with code " + registerRelayListener + ". , new do not handleDeviceListChange");
        List<StarryDevice> relayDeviceList = this.$relayAbility.getRelayDeviceList(InterconnectManager.getInstance().getPeerPackageName());
        ArrayList<StarryDevice> glassDevice = XrSdkBondDeviceUtil.INSTANCE.getGlassDevice(relayDeviceList);
        String access$getTag2 = this.this$0.getTag();
        int size = relayDeviceList.size();
        int size2 = glassDevice.size();
        ILog.d(access$getTag2, "onAbilityReady deviceList size = " + size + ",glassDeviceList size = " + size2);
        if (!glassDevice.isEmpty()) {
            PeerDeviceStatusManager peerDeviceStatusManager = this.this$0;
            for (StarryDevice starryDevice : glassDevice) {
                String access$getTag3 = peerDeviceStatusManager.getTag();
                ILog.d(access$getTag3, "onAbilityReady device = " + starryDevice);
            }
        }
        this.this$0.handleDeviceListChange(glassDevice);
    }
}

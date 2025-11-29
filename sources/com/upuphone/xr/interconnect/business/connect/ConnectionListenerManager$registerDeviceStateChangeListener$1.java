package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.entity.DeviceWrapper;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$registerDeviceStateChangeListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,492:1\n1855#2,2:493\n1855#2,2:495\n1855#2,2:497\n*S KotlinDebug\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$registerDeviceStateChangeListener$1\n*L\n167#1:493,2\n175#1:495,2\n185#1:497,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$registerDeviceStateChangeListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryNetDeviceStateChangeListener $listener;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$registerDeviceStateChangeListener$1(ConnectionListenerManager connectionListenerManager, StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener) {
        super(0);
        this.this$0 = connectionListenerManager;
        this.$listener = starryNetDeviceStateChangeListener;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        int size = this.this$0.deviceStateChangeListeners.size();
        String stringify = PrettyPrintExtKt.stringify(this.$listener);
        ILog.d(access$getTag, "Adding to " + size + " stat listeners: " + stringify + ".");
        if (this.this$0.deviceStateChangeListeners.add(this.$listener)) {
            Collection<StarryNetDevice> values = this.this$0.bondStateManager.getBoundGlassDeviceMap().values();
            ConnectionListenerManager connectionListenerManager = this.this$0;
            StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener = this.$listener;
            for (StarryNetDevice connectionListenerManager$registerDeviceStateChangeListener$1$1$1 : values) {
                connectionListenerManager.safeCallRemoteListener(starryNetDeviceStateChangeListener, new ConnectionListenerManager$registerDeviceStateChangeListener$1$1$1(connectionListenerManager$registerDeviceStateChangeListener$1$1$1));
            }
            Set<DeviceWrapper> connectedPrimaryDevices = this.this$0.connectionStateManager.getConnectedPrimaryDevices();
            ConnectionListenerManager connectionListenerManager2 = this.this$0;
            StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener2 = this.$listener;
            for (DeviceWrapper deviceWrapper : connectedPrimaryDevices) {
                if (connectionListenerManager2.peerDeviceStatusManager.isDeviceNegotiated(deviceWrapper.getId())) {
                    connectionListenerManager2.safeCallRemoteListener(starryNetDeviceStateChangeListener2, new ConnectionListenerManager$registerDeviceStateChangeListener$1$2$1(deviceWrapper));
                }
            }
            Collection<DeviceWrapper> connectedSecondaryDevices = this.this$0.connectionStateManager.getConnectedSecondaryDevices();
            ConnectionListenerManager connectionListenerManager3 = this.this$0;
            StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener3 = this.$listener;
            for (DeviceWrapper connectionListenerManager$registerDeviceStateChangeListener$1$3$1 : connectedSecondaryDevices) {
                connectionListenerManager3.safeCallRemoteListener(starryNetDeviceStateChangeListener3, new ConnectionListenerManager$registerDeviceStateChangeListener$1$3$1(connectionListenerManager$registerDeviceStateChangeListener$1$3$1));
            }
            StarryNetDevice connectedPrimaryRingStarryNetDevice = this.this$0.connectionStateManager.getConnectedPrimaryRingStarryNetDevice();
            if (connectedPrimaryRingStarryNetDevice != null) {
                ConnectionListenerManager connectionListenerManager4 = this.this$0;
                StarryNetDeviceStateChangeListener starryNetDeviceStateChangeListener4 = this.$listener;
                ULog.f6446a.c("PetaStepSerializer", "onConnectStateChanged ring data");
                connectionListenerManager4.safeCallRemoteListener(starryNetDeviceStateChangeListener4, new ConnectionListenerManager$registerDeviceStateChangeListener$1$4$1(connectedPrimaryRingStarryNetDevice));
            }
        }
    }
}

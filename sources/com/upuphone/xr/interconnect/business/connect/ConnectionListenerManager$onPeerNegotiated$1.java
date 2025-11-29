package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.common.IDeviceConnectionListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onPeerNegotiated$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,492:1\n1855#2,2:493\n1855#2,2:495\n1855#2,2:497\n*S KotlinDebug\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onPeerNegotiated$1\n*L\n469#1:493,2\n472#1:495,2\n475#1:497,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$onPeerNegotiated$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$onPeerNegotiated$1(ConnectionListenerManager connectionListenerManager, String str) {
        super(0);
        this.this$0 = connectionListenerManager;
        this.$deviceId = str;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        int size = this.this$0.deviceConnectionListeners.size();
        ILog.d(access$getTag, "Dispatching #" + str + " negotiated event to " + size + " conn listeners.");
        StarryNetDevice connectedPrimaryDevice = this.this$0.connectionStateManager.getConnectedPrimaryDevice(this.$deviceId);
        if (connectedPrimaryDevice != null) {
            ConnectionListenerManager connectionListenerManager = this.this$0;
            String str2 = this.$deviceId;
            String access$getTag2 = connectionListenerManager.getTag();
            int size2 = connectionListenerManager.deviceConnectionPriorityListeners.size();
            ILog.d(access$getTag2, "Dispatching #" + str2 + " negotiated event to " + size2 + " Priority conn stat listeners.");
            for (IDeviceConnectionListener access$safeCallRemoteListener : connectionListenerManager.deviceConnectionPriorityListeners) {
                connectionListenerManager.safeCallRemoteListener(access$safeCallRemoteListener, new ConnectionListenerManager$onPeerNegotiated$1$1$1$1(connectedPrimaryDevice));
            }
            for (IDeviceConnectionListener access$safeCallRemoteListener2 : connectionListenerManager.deviceConnectionListeners) {
                connectionListenerManager.safeCallRemoteListener(access$safeCallRemoteListener2, new ConnectionListenerManager$onPeerNegotiated$1$1$2$1(connectedPrimaryDevice));
            }
            for (StarryNetDeviceStateChangeListener access$safeCallRemoteListener3 : connectionListenerManager.deviceStateChangeListeners) {
                connectionListenerManager.safeCallRemoteListener(access$safeCallRemoteListener3, new ConnectionListenerManager$onPeerNegotiated$1$1$3$1(connectedPrimaryDevice));
            }
        }
    }
}

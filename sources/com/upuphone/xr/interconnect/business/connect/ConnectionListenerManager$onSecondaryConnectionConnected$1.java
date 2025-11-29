package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.ConnectionListener;
import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.common.IDeviceConnectionListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onSecondaryConnectionConnected$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,492:1\n1855#2,2:493\n1855#2,2:495\n1855#2,2:497\n1855#2,2:499\n*S KotlinDebug\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onSecondaryConnectionConnected$1\n*L\n406#1:493,2\n410#1:495,2\n411#1:497,2\n414#1:499,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$onSecondaryConnectionConnected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryNetDevice $device;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$onSecondaryConnectionConnected$1(ConnectionListenerManager connectionListenerManager, StarryNetDevice starryNetDevice) {
        super(0);
        this.this$0 = connectionListenerManager;
        this.$device = starryNetDevice;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String deviceId = this.$device.getDeviceId();
        int size = this.this$0.deviceConnectionListeners.size();
        int size2 = this.this$0.deviceStateChangeListeners.size();
        ILog.d(access$getTag, "Dispatching #" + deviceId + "(secondary) connected event to " + size + " conn, " + size2 + " stat listeners.");
        String access$getTag2 = this.this$0.getTag();
        String deviceId2 = this.$device.getDeviceId();
        int size3 = this.this$0.deviceConnectionPriorityListeners.size();
        ILog.d(access$getTag2, "Dispatching #" + deviceId2 + "(secondary) connected event to " + size3 + " Priority conn stat listeners.");
        Set<IDeviceConnectionListener> access$getDeviceConnectionPriorityListeners$p = this.this$0.deviceConnectionPriorityListeners;
        ConnectionListenerManager connectionListenerManager = this.this$0;
        StarryNetDevice starryNetDevice = this.$device;
        for (IDeviceConnectionListener access$safeCallRemoteListener : access$getDeviceConnectionPriorityListeners$p) {
            connectionListenerManager.safeCallRemoteListener(access$safeCallRemoteListener, new ConnectionListenerManager$onSecondaryConnectionConnected$1$1$1(starryNetDevice));
        }
        Set<ConnectionListener> access$getConnectionListeners$p = this.this$0.connectionListeners;
        ConnectionListenerManager connectionListenerManager2 = this.this$0;
        StarryNetDevice starryNetDevice2 = this.$device;
        for (ConnectionListener access$safeCallRemoteListener2 : access$getConnectionListeners$p) {
            connectionListenerManager2.safeCallRemoteListener(access$safeCallRemoteListener2, new ConnectionListenerManager$onSecondaryConnectionConnected$1$2$1(starryNetDevice2));
        }
        Set<IDeviceConnectionListener> access$getDeviceConnectionListeners$p = this.this$0.deviceConnectionListeners;
        ConnectionListenerManager connectionListenerManager3 = this.this$0;
        StarryNetDevice starryNetDevice3 = this.$device;
        for (IDeviceConnectionListener access$safeCallRemoteListener3 : access$getDeviceConnectionListeners$p) {
            connectionListenerManager3.safeCallRemoteListener(access$safeCallRemoteListener3, new ConnectionListenerManager$onSecondaryConnectionConnected$1$3$1(starryNetDevice3));
        }
        Set<StarryNetDeviceStateChangeListener> access$getDeviceStateChangeListeners$p = this.this$0.deviceStateChangeListeners;
        ConnectionListenerManager connectionListenerManager4 = this.this$0;
        StarryNetDevice starryNetDevice4 = this.$device;
        for (StarryNetDeviceStateChangeListener access$safeCallRemoteListener4 : access$getDeviceStateChangeListeners$p) {
            connectionListenerManager4.safeCallRemoteListener(access$safeCallRemoteListener4, new ConnectionListenerManager$onSecondaryConnectionConnected$1$4$1(starryNetDevice4));
        }
    }
}

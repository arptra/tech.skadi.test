package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onConnectionBound$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,492:1\n1855#2,2:493\n1855#2,2:495\n*S KotlinDebug\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onConnectionBound$1\n*L\n261#1:493,2\n264#1:495,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$onConnectionBound$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryNetDevice $device;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$onConnectionBound$1(ConnectionListenerManager connectionListenerManager, StarryNetDevice starryNetDevice) {
        super(0);
        this.this$0 = connectionListenerManager;
        this.$device = starryNetDevice;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String deviceId = this.$device.getDeviceId();
        int size = this.this$0.deviceStateChangeListeners.size();
        int size2 = this.this$0.deviceBondStateListeners.size();
        ILog.d(access$getTag, "Dispatching #" + deviceId + " bound event to " + size + " stat, " + size2 + " bond listeners.");
        Set<StarryNetDeviceStateChangeListener> access$getDeviceStateChangeListeners$p = this.this$0.deviceStateChangeListeners;
        ConnectionListenerManager connectionListenerManager = this.this$0;
        StarryNetDevice starryNetDevice = this.$device;
        for (StarryNetDeviceStateChangeListener access$safeCallRemoteListener : access$getDeviceStateChangeListeners$p) {
            connectionListenerManager.safeCallRemoteListener(access$safeCallRemoteListener, new ConnectionListenerManager$onConnectionBound$1$1$1(starryNetDevice));
        }
        Set<IDeviceBondStateListener> access$getDeviceBondStateListeners$p = this.this$0.deviceBondStateListeners;
        ConnectionListenerManager connectionListenerManager2 = this.this$0;
        StarryNetDevice starryNetDevice2 = this.$device;
        for (IDeviceBondStateListener access$safeCallRemoteListener2 : access$getDeviceBondStateListeners$p) {
            connectionListenerManager2.safeCallRemoteListener(access$safeCallRemoteListener2, new ConnectionListenerManager$onConnectionBound$1$2$1(starryNetDevice2));
        }
    }
}

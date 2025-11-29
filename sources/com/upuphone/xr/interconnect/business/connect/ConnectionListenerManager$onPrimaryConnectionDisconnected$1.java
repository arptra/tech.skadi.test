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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nConnectionListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onPrimaryConnectionDisconnected$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,492:1\n1855#2,2:493\n1855#2,2:495\n1855#2,2:497\n1855#2,2:499\n*S KotlinDebug\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onPrimaryConnectionDisconnected$1\n*L\n376#1:493,2\n380#1:495,2\n382#1:497,2\n385#1:499,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$onPrimaryConnectionDisconnected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryNetDevice $device;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$onPrimaryConnectionDisconnected$1(ConnectionListenerManager connectionListenerManager, StarryNetDevice starryNetDevice) {
        super(0);
        this.this$0 = connectionListenerManager;
        this.$device = starryNetDevice;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String deviceId = this.$device.getDeviceId();
        int size = this.this$0.deviceConnectionListeners.size();
        int size2 = this.this$0.deviceStateChangeListeners.size();
        ILog.d(access$getTag, "Dispatching #" + deviceId + "(primary) disconnected event to " + size + " conn, " + size2 + " stat listeners.");
        String access$getTag2 = this.this$0.getTag();
        String deviceId2 = this.$device.getDeviceId();
        int size3 = this.this$0.deviceConnectionPriorityListeners.size();
        ILog.d(access$getTag2, "Dispatching #" + deviceId2 + "(primary) disconnected event to " + size3 + " Priority conn stat listeners.");
        Set<IDeviceConnectionListener> access$getDeviceConnectionPriorityListeners$p = this.this$0.deviceConnectionPriorityListeners;
        ConnectionListenerManager connectionListenerManager = this.this$0;
        StarryNetDevice starryNetDevice = this.$device;
        for (IDeviceConnectionListener access$safeCallRemoteListener : access$getDeviceConnectionPriorityListeners$p) {
            connectionListenerManager.safeCallRemoteListener(access$safeCallRemoteListener, new ConnectionListenerManager$onPrimaryConnectionDisconnected$1$1$1(starryNetDevice));
        }
        Set<ConnectionListener> access$getConnectionListeners$p = this.this$0.connectionListeners;
        ConnectionListenerManager connectionListenerManager2 = this.this$0;
        StarryNetDevice starryNetDevice2 = this.$device;
        for (ConnectionListener access$safeCallRemoteListener2 : access$getConnectionListeners$p) {
            connectionListenerManager2.safeCallRemoteListener(access$safeCallRemoteListener2, new ConnectionListenerManager$onPrimaryConnectionDisconnected$1$2$1(starryNetDevice2));
        }
        IDeviceConnectionListener mainDeviceConnectionListener = this.this$0.getMainDeviceConnectionListener();
        if (mainDeviceConnectionListener != null) {
            ConnectionListenerManager connectionListenerManager3 = this.this$0;
            final StarryNetDevice starryNetDevice3 = this.$device;
            connectionListenerManager3.safeCallRemoteListener(mainDeviceConnectionListener, new Function1<IDeviceConnectionListener, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((IDeviceConnectionListener) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull IDeviceConnectionListener iDeviceConnectionListener) {
                    Intrinsics.checkNotNullParameter(iDeviceConnectionListener, "$this$safeCallRemoteListener");
                    iDeviceConnectionListener.onDeviceDisconnected(starryNetDevice3);
                }
            });
        }
        Set<IDeviceConnectionListener> access$getDeviceConnectionListeners$p = this.this$0.deviceConnectionListeners;
        ConnectionListenerManager connectionListenerManager4 = this.this$0;
        StarryNetDevice starryNetDevice4 = this.$device;
        for (IDeviceConnectionListener access$safeCallRemoteListener3 : access$getDeviceConnectionListeners$p) {
            connectionListenerManager4.safeCallRemoteListener(access$safeCallRemoteListener3, new ConnectionListenerManager$onPrimaryConnectionDisconnected$1$4$1(starryNetDevice4));
        }
        Set<StarryNetDeviceStateChangeListener> access$getDeviceStateChangeListeners$p = this.this$0.deviceStateChangeListeners;
        ConnectionListenerManager connectionListenerManager5 = this.this$0;
        StarryNetDevice starryNetDevice5 = this.$device;
        for (StarryNetDeviceStateChangeListener access$safeCallRemoteListener4 : access$getDeviceStateChangeListeners$p) {
            connectionListenerManager5.safeCallRemoteListener(access$safeCallRemoteListener4, new ConnectionListenerManager$onPrimaryConnectionDisconnected$1$5$1(starryNetDevice5));
        }
    }
}

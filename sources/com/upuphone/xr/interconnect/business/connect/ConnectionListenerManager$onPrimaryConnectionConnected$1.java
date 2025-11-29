package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.api.ConnectionListener;
import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.common.IDeviceConnectionListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
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

@SourceDebugExtension({"SMAP\nConnectionListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onPrimaryConnectionConnected$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,492:1\n1855#2,2:493\n1855#2,2:495\n1855#2,2:497\n1855#2,2:499\n1855#2,2:501\n1855#2,2:503\n1855#2,2:505\n*S KotlinDebug\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onPrimaryConnectionConnected$1\n*L\n317#1:493,2\n321#1:495,2\n325#1:497,2\n342#1:499,2\n347#1:501,2\n350#1:503,2\n353#1:505,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$onPrimaryConnectionConnected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryNetDevice $device;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$onPrimaryConnectionConnected$1(ConnectionListenerManager connectionListenerManager, StarryNetDevice starryNetDevice) {
        super(0);
        this.this$0 = connectionListenerManager;
        this.$device = starryNetDevice;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String deviceId = this.$device.getDeviceId();
        int size = this.this$0.deviceConnectionListeners.size();
        int size2 = this.this$0.deviceStateChangeListeners.size();
        ILog.d(access$getTag, "Dispatching #" + deviceId + "(primary) connected event to " + size + " conn, " + size2 + " stat listeners.");
        if (XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsRing(this.$device.getTerminalType())) {
            ULog.Delegate delegate = ULog.f6446a;
            int size3 = this.this$0.deviceConnectionListeners.size();
            delegate.c("PetaStepSerializer", "onPrimaryConnectionConnected is ring deviceConnectionListeners size = " + size3);
            Set<IDeviceConnectionListener> access$getDeviceConnectionPriorityListeners$p = this.this$0.deviceConnectionPriorityListeners;
            ConnectionListenerManager connectionListenerManager = this.this$0;
            StarryNetDevice starryNetDevice = this.$device;
            for (IDeviceConnectionListener access$safeCallRemoteListener : access$getDeviceConnectionPriorityListeners$p) {
                connectionListenerManager.safeCallRemoteListener(access$safeCallRemoteListener, new ConnectionListenerManager$onPrimaryConnectionConnected$1$1$1(starryNetDevice));
            }
            IDeviceConnectionListener mainDeviceConnectionListener = this.this$0.getMainDeviceConnectionListener();
            if (mainDeviceConnectionListener != null) {
                ConnectionListenerManager connectionListenerManager2 = this.this$0;
                final StarryNetDevice starryNetDevice2 = this.$device;
                connectionListenerManager2.safeCallRemoteListener(mainDeviceConnectionListener, new Function1<IDeviceConnectionListener, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((IDeviceConnectionListener) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IDeviceConnectionListener iDeviceConnectionListener) {
                        Intrinsics.checkNotNullParameter(iDeviceConnectionListener, "$this$safeCallRemoteListener");
                        iDeviceConnectionListener.onDeviceConnected(starryNetDevice2);
                    }
                });
            }
            Set<IDeviceConnectionListener> access$getDeviceConnectionListeners$p = this.this$0.deviceConnectionListeners;
            ConnectionListenerManager connectionListenerManager3 = this.this$0;
            StarryNetDevice starryNetDevice3 = this.$device;
            for (IDeviceConnectionListener access$safeCallRemoteListener2 : access$getDeviceConnectionListeners$p) {
                connectionListenerManager3.safeCallRemoteListener(access$safeCallRemoteListener2, new ConnectionListenerManager$onPrimaryConnectionConnected$1$3$1(starryNetDevice3));
            }
            ULog.Delegate delegate2 = ULog.f6446a;
            int size4 = this.this$0.deviceStateChangeListeners.size();
            delegate2.c("PetaStepSerializer", "onPrimaryConnectionConnected is ring deviceStateChangeListeners size = " + size4);
            Set<StarryNetDeviceStateChangeListener> access$getDeviceStateChangeListeners$p = this.this$0.deviceStateChangeListeners;
            ConnectionListenerManager connectionListenerManager4 = this.this$0;
            StarryNetDevice starryNetDevice4 = this.$device;
            for (StarryNetDeviceStateChangeListener access$safeCallRemoteListener3 : access$getDeviceStateChangeListeners$p) {
                connectionListenerManager4.safeCallRemoteListener(access$safeCallRemoteListener3, new ConnectionListenerManager$onPrimaryConnectionConnected$1$4$1(starryNetDevice4));
            }
            return;
        }
        ULog.f6446a.c("PetaStepSerializer", "onPrimaryConnectionConnected is glass");
        String access$getTag2 = this.this$0.getTag();
        String deviceId2 = this.$device.getDeviceId();
        int size5 = this.this$0.deviceConnectionPriorityListeners.size();
        ILog.d(access$getTag2, "Dispatching #" + deviceId2 + "(primary) connected event to " + size5 + " Priority conn stat listeners.");
        if (this.this$0.peerDeviceStatusManager.isDeviceNegotiated(this.$device.getDeviceId())) {
            Set<IDeviceConnectionListener> access$getDeviceConnectionPriorityListeners$p2 = this.this$0.deviceConnectionPriorityListeners;
            ConnectionListenerManager connectionListenerManager5 = this.this$0;
            StarryNetDevice starryNetDevice5 = this.$device;
            for (IDeviceConnectionListener access$safeCallRemoteListener4 : access$getDeviceConnectionPriorityListeners$p2) {
                connectionListenerManager5.safeCallRemoteListener(access$safeCallRemoteListener4, new ConnectionListenerManager$onPrimaryConnectionConnected$1$5$1(starryNetDevice5));
            }
        }
        Set<ConnectionListener> access$getConnectionListeners$p = this.this$0.connectionListeners;
        ConnectionListenerManager connectionListenerManager6 = this.this$0;
        StarryNetDevice starryNetDevice6 = this.$device;
        for (ConnectionListener access$safeCallRemoteListener5 : access$getConnectionListeners$p) {
            connectionListenerManager6.safeCallRemoteListener(access$safeCallRemoteListener5, new ConnectionListenerManager$onPrimaryConnectionConnected$1$6$1(starryNetDevice6));
        }
        IDeviceConnectionListener mainDeviceConnectionListener2 = this.this$0.getMainDeviceConnectionListener();
        if (mainDeviceConnectionListener2 != null) {
            ConnectionListenerManager connectionListenerManager7 = this.this$0;
            final StarryNetDevice starryNetDevice7 = this.$device;
            connectionListenerManager7.safeCallRemoteListener(mainDeviceConnectionListener2, new Function1<IDeviceConnectionListener, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((IDeviceConnectionListener) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull IDeviceConnectionListener iDeviceConnectionListener) {
                    Intrinsics.checkNotNullParameter(iDeviceConnectionListener, "$this$safeCallRemoteListener");
                    iDeviceConnectionListener.onDeviceConnected(starryNetDevice7);
                }
            });
        }
        if (this.this$0.peerDeviceStatusManager.isDeviceNegotiated(this.$device.getDeviceId())) {
            Set<IDeviceConnectionListener> access$getDeviceConnectionListeners$p2 = this.this$0.deviceConnectionListeners;
            ConnectionListenerManager connectionListenerManager8 = this.this$0;
            StarryNetDevice starryNetDevice8 = this.$device;
            for (IDeviceConnectionListener access$safeCallRemoteListener6 : access$getDeviceConnectionListeners$p2) {
                connectionListenerManager8.safeCallRemoteListener(access$safeCallRemoteListener6, new ConnectionListenerManager$onPrimaryConnectionConnected$1$8$1(starryNetDevice8));
            }
            Set<StarryNetDeviceStateChangeListener> access$getDeviceStateChangeListeners$p2 = this.this$0.deviceStateChangeListeners;
            ConnectionListenerManager connectionListenerManager9 = this.this$0;
            StarryNetDevice starryNetDevice9 = this.$device;
            for (StarryNetDeviceStateChangeListener access$safeCallRemoteListener7 : access$getDeviceStateChangeListeners$p2) {
                connectionListenerManager9.safeCallRemoteListener(access$safeCallRemoteListener7, new ConnectionListenerManager$onPrimaryConnectionConnected$1$9$1(starryNetDevice9));
            }
        }
    }
}

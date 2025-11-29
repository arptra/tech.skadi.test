package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.ConnectionListener;
import com.upuphone.xr.interconnect.entity.DeviceWrapper;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$registerConnectionListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,492:1\n1855#2,2:493\n1855#2,2:495\n*S KotlinDebug\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$registerConnectionListener$1\n*L\n60#1:493,2\n63#1:495,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$registerConnectionListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConnectionListener $listener;
    final /* synthetic */ boolean $prewarm;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$registerConnectionListener$1(ConnectionListenerManager connectionListenerManager, ConnectionListener connectionListener, boolean z) {
        super(0);
        this.this$0 = connectionListenerManager;
        this.$listener = connectionListener;
        this.$prewarm = z;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        int size = this.this$0.connectionListeners.size();
        String stringify = PrettyPrintExtKt.stringify(this.$listener);
        ILog.d(access$getTag, "Adding to " + size + " connection listeners: " + stringify + ".");
        if (this.this$0.connectionListeners.add(this.$listener) && this.$prewarm) {
            Set<DeviceWrapper> connectedPrimaryDevices = this.this$0.connectionStateManager.getConnectedPrimaryDevices();
            ConnectionListenerManager connectionListenerManager = this.this$0;
            ConnectionListener connectionListener = this.$listener;
            for (DeviceWrapper connectionListenerManager$registerConnectionListener$1$1$1 : connectedPrimaryDevices) {
                connectionListenerManager.safeCallRemoteListener(connectionListener, new ConnectionListenerManager$registerConnectionListener$1$1$1(connectionListenerManager$registerConnectionListener$1$1$1));
            }
            Collection<DeviceWrapper> connectedSecondaryDevices = this.this$0.connectionStateManager.getConnectedSecondaryDevices();
            ConnectionListenerManager connectionListenerManager2 = this.this$0;
            ConnectionListener connectionListener2 = this.$listener;
            for (DeviceWrapper connectionListenerManager$registerConnectionListener$1$2$1 : connectedSecondaryDevices) {
                connectionListenerManager2.safeCallRemoteListener(connectionListener2, new ConnectionListenerManager$registerConnectionListener$1$2$1(connectionListenerManager$registerConnectionListener$1$2$1));
            }
        }
    }
}

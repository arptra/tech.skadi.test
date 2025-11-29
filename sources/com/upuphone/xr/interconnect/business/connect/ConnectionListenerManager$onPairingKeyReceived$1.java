package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onPairingKeyReceived$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,492:1\n1855#2,2:493\n*S KotlinDebug\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onPairingKeyReceived$1\n*L\n218#1:493,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$onPairingKeyReceived$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceName;
    final /* synthetic */ int $pairingKey;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$onPairingKeyReceived$1(ConnectionListenerManager connectionListenerManager, int i, String str) {
        super(0);
        this.this$0 = connectionListenerManager;
        this.$pairingKey = i;
        this.$deviceName = str;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        int i = this.$pairingKey;
        String str = this.$deviceName;
        int size = this.this$0.deviceStateChangeListeners.size();
        ILog.d(access$getTag, "Dispatching pairing key " + i + " from " + str + " event to " + size + " stat listeners.");
        Set<StarryNetDeviceStateChangeListener> access$getDeviceStateChangeListeners$p = this.this$0.deviceStateChangeListeners;
        ConnectionListenerManager connectionListenerManager = this.this$0;
        int i2 = this.$pairingKey;
        String str2 = this.$deviceName;
        for (StarryNetDeviceStateChangeListener access$safeCallRemoteListener : access$getDeviceStateChangeListeners$p) {
            connectionListenerManager.safeCallRemoteListener(access$safeCallRemoteListener, new ConnectionListenerManager$onPairingKeyReceived$1$1$1(i2, str2));
        }
    }
}

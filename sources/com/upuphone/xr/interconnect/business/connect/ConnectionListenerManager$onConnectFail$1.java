package com.upuphone.xr.interconnect.business.connect;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionListenerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onConnectFail$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,492:1\n1855#2,2:493\n*S KotlinDebug\n*F\n+ 1 ConnectionListenerManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionListenerManager$onConnectFail$1\n*L\n233#1:493,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$onConnectFail$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $code;
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ int $type;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$onConnectFail$1(ConnectionListenerManager connectionListenerManager, StarryDevice starryDevice, int i, int i2) {
        super(0);
        this.this$0 = connectionListenerManager;
        this.$device = starryDevice;
        this.$type = i;
        this.$code = i2;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String id = this.$device.getId();
        int i = this.$type;
        int i2 = this.$code;
        int size = this.this$0.deviceStateChangeListeners.size();
        ILog.d(access$getTag, "Dispatching #$" + id + " connect fail " + i + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + i2 + " event to " + size + " stat listeners.");
        Set<StarryNetDeviceStateChangeListener> access$getDeviceStateChangeListeners$p = this.this$0.deviceStateChangeListeners;
        ConnectionListenerManager connectionListenerManager = this.this$0;
        int i3 = this.$type;
        StarryDevice starryDevice = this.$device;
        int i4 = this.$code;
        for (StarryNetDeviceStateChangeListener access$safeCallRemoteListener : access$getDeviceStateChangeListeners$p) {
            connectionListenerManager.safeCallRemoteListener(access$safeCallRemoteListener, new ConnectionListenerManager$onConnectFail$1$1$1(i3, starryDevice, i4));
        }
    }
}

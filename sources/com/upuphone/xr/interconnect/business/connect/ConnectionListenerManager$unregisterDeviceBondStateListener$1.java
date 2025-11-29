package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionListenerManager$unregisterDeviceBondStateListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IDeviceBondStateListener $listener;
    final /* synthetic */ ConnectionListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionListenerManager$unregisterDeviceBondStateListener$1(ConnectionListenerManager connectionListenerManager, IDeviceBondStateListener iDeviceBondStateListener) {
        super(0);
        this.this$0 = connectionListenerManager;
        this.$listener = iDeviceBondStateListener;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        int size = this.this$0.deviceBondStateListeners.size();
        String stringify = PrettyPrintExtKt.stringify(this.$listener);
        ILog.d(access$getTag, "Removing from " + size + " bond listeners: " + stringify + ".");
        this.this$0.deviceBondStateListeners.remove(this.$listener);
    }
}

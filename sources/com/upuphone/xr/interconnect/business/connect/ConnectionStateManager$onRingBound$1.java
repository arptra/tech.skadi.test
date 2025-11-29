package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onRingBound$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,312:1\n1855#2,2:313\n*S KotlinDebug\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onRingBound$1\n*L\n300#1:313,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionStateManager$onRingBound$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ ConnectionStateManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionStateManager$onRingBound$1(String str, ConnectionStateManager connectionStateManager, StarryDevice starryDevice) {
        super(0);
        this.$deviceId = str;
        this.this$0 = connectionStateManager;
        this.$device = starryDevice;
    }

    public final void invoke() {
        String str = this.$deviceId;
        ILog.e("PetaStepSerializer", "onRingBound deviceId = " + str);
        Set<ConnectionStateListener> access$getListeners = this.this$0.getListeners();
        StarryDevice starryDevice = this.$device;
        for (ConnectionStateListener onConnectionBound : access$getListeners) {
            onConnectionBound.onConnectionBound(StarryDeviceExt.wrapForConnection(starryDevice));
        }
    }
}

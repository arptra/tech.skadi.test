package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nBaseConnectionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/BaseConnectionManager$onConnectStateChangeForRing$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1855#2,2:195\n1855#2,2:197\n*S KotlinDebug\n*F\n+ 1 BaseConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/BaseConnectionManager$onConnectStateChangeForRing$1\n*L\n116#1:195,2\n118#1:197,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BaseConnectionManager$onConnectStateChangeForRing$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ int $newState;
    final /* synthetic */ BaseConnectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseConnectionManager$onConnectStateChangeForRing$1(BaseConnectionManager baseConnectionManager, StarryDevice starryDevice, int i) {
        super(0);
        this.this$0 = baseConnectionManager;
        this.$device = starryDevice;
        this.$newState = i;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String id = this.$device.getId();
        int i = this.$newState;
        boolean z = i == 1;
        ILog.w(access$getTag, "onConnectStateChangeForRing device id = " + id + ",state = " + i + ",newState == RING_DEVICE_CONNECTED = " + z);
        if (this.$newState == 1) {
            Set<BaseConnectionListener> access$getListeners = this.this$0.getListeners();
            StarryDevice starryDevice = this.$device;
            for (BaseConnectionListener onRingConnected : access$getListeners) {
                String id2 = starryDevice.getId();
                Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                onRingConnected.onRingConnected(id2, starryDevice);
            }
            return;
        }
        Set<BaseConnectionListener> access$getListeners2 = this.this$0.getListeners();
        StarryDevice starryDevice2 = this.$device;
        for (BaseConnectionListener onRingDisconnected : access$getListeners2) {
            String id3 = starryDevice2.getId();
            Intrinsics.checkNotNullExpressionValue(id3, "getId(...)");
            onRingDisconnected.onRingDisconnected(id3, starryDevice2);
        }
    }
}

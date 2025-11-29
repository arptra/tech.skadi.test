package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.entity.DeviceWrapper;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onGlassBrDisconnected$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,312:1\n288#2,2:313\n*S KotlinDebug\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onGlassBrDisconnected$1\n*L\n208#1:313,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionStateManager$onGlassBrDisconnected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ boolean $isBleConnected;
    final /* synthetic */ ConnectionStateManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionStateManager$onGlassBrDisconnected$1(StarryDevice starryDevice, ConnectionStateManager connectionStateManager, String str, boolean z) {
        super(0);
        this.$device = starryDevice;
        this.this$0 = connectionStateManager;
        this.$deviceId = str;
        this.$isBleConnected = z;
    }

    public final void invoke() {
        Object obj;
        byte terminalType = this.$device.getTerminalType();
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        ILog.d(access$getTag, "#" + str + " of type " + terminalType + " has disconnected via br.");
        if (terminalType != 1 && terminalType != 2 && terminalType != 4) {
            if (terminalType == 6) {
                Set access$get_connectedPrimaryDevices$p = this.this$0._connectedPrimaryDevices;
                String str2 = this.$deviceId;
                Iterator it = access$get_connectedPrimaryDevices$p.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((DeviceWrapper) obj).getId(), (Object) str2)) {
                        break;
                    }
                }
                DeviceWrapper deviceWrapper = (DeviceWrapper) obj;
                if (deviceWrapper != null) {
                    this.this$0.removePrimaryGlassDevice(deviceWrapper);
                }
                this.this$0.getConnectingIosDeviceIds().remove(this.$deviceId);
            } else if (!this.$isBleConnected) {
                this.this$0.removeSecondaryGlassDevice(terminalType, this.$deviceId, this.$device);
            }
        }
    }
}

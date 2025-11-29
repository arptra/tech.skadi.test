package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onGlassBleDisconnected$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,312:1\n288#2,2:313\n288#2,2:315\n*S KotlinDebug\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onGlassBleDisconnected$1\n*L\n183#1:313,2\n189#1:315,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionStateManager$onGlassBleDisconnected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ boolean $isBrConnected;
    final /* synthetic */ ConnectionStateManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionStateManager$onGlassBleDisconnected$1(StarryDevice starryDevice, ConnectionStateManager connectionStateManager, String str, boolean z) {
        super(0);
        this.$device = starryDevice;
        this.this$0 = connectionStateManager;
        this.$deviceId = str;
        this.$isBrConnected = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.upuphone.xr.interconnect.entity.DeviceWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.upuphone.xr.interconnect.entity.DeviceWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.upuphone.xr.interconnect.entity.DeviceWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: com.upuphone.xr.interconnect.entity.DeviceWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: com.upuphone.xr.interconnect.entity.DeviceWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.upuphone.xr.interconnect.entity.DeviceWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: com.upuphone.xr.interconnect.entity.DeviceWrapper} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r5 = this;
            com.upuphone.runasone.device.StarryDevice r0 = r5.$device
            byte r0 = r0.getTerminalType()
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r1 = r5.this$0
            java.lang.String r1 = r1.getTag()
            java.lang.String r2 = r5.$deviceId
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "#"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " of type "
            r3.append(r2)
            r3.append(r0)
            java.lang.String r2 = " has disconnected via ble."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r1, r2)
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L_0x0034
            goto L_0x003b
        L_0x0034:
            r1 = 2
            if (r0 != r1) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            r1 = 4
            if (r0 != r1) goto L_0x0069
        L_0x003b:
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r0 = r5.this$0
            java.util.Set r0 = r0._connectedPrimaryDevices
            java.lang.String r1 = r5.$deviceId
            java.util.Iterator r0 = r0.iterator()
        L_0x0047:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x005f
            java.lang.Object r3 = r0.next()
            r4 = r3
            com.upuphone.xr.interconnect.entity.DeviceWrapper r4 = (com.upuphone.xr.interconnect.entity.DeviceWrapper) r4
            java.lang.String r4 = r4.getId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
            if (r4 == 0) goto L_0x0047
            r2 = r3
        L_0x005f:
            com.upuphone.xr.interconnect.entity.DeviceWrapper r2 = (com.upuphone.xr.interconnect.entity.DeviceWrapper) r2
            if (r2 == 0) goto L_0x00c1
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r5 = r5.this$0
            r5.removePrimaryGlassDevice(r2)
            goto L_0x00c1
        L_0x0069:
            r1 = 6
            if (r0 != r1) goto L_0x00a8
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r0 = r5.this$0
            java.util.Set r0 = r0.getConnectingIosDeviceIds()
            java.lang.String r1 = r5.$deviceId
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x00c1
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r0 = r5.this$0
            java.util.Set r0 = r0._connectedPrimaryDevices
            java.lang.String r1 = r5.$deviceId
            java.util.Iterator r0 = r0.iterator()
        L_0x0086:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x009e
            java.lang.Object r3 = r0.next()
            r4 = r3
            com.upuphone.xr.interconnect.entity.DeviceWrapper r4 = (com.upuphone.xr.interconnect.entity.DeviceWrapper) r4
            java.lang.String r4 = r4.getId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
            if (r4 == 0) goto L_0x0086
            r2 = r3
        L_0x009e:
            com.upuphone.xr.interconnect.entity.DeviceWrapper r2 = (com.upuphone.xr.interconnect.entity.DeviceWrapper) r2
            if (r2 == 0) goto L_0x00c1
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r5 = r5.this$0
            r5.removePrimaryGlassDevice(r2)
            goto L_0x00c1
        L_0x00a8:
            boolean r1 = r5.$isBrConnected
            if (r1 == 0) goto L_0x00b8
            com.upuphone.runasone.device.StarryDevice r1 = r5.$device
            com.upuphone.xr.interconnect.business.connect.behavior.DeviceTraits r1 = com.upuphone.xr.interconnect.business.connect.behavior.DeviceTraitsKt.getTraits((com.upuphone.runasone.device.StarryDevice) r1)
            boolean r1 = r1.getBrEnabled()
            if (r1 != 0) goto L_0x00c1
        L_0x00b8:
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r1 = r5.this$0
            java.lang.String r2 = r5.$deviceId
            com.upuphone.runasone.device.StarryDevice r5 = r5.$device
            r1.removeSecondaryGlassDevice(r0, r2, r5)
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.ConnectionStateManager$onGlassBleDisconnected$1.invoke():void");
    }
}

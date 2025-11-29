package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectionStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onGlassBleConnectedDeviceUpdate$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,312:1\n288#2,2:313\n*S KotlinDebug\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager$onGlassBleConnectedDeviceUpdate$1\n*L\n162#1:313,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectionStateManager$onGlassBleConnectedDeviceUpdate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ ConnectionStateManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionStateManager$onGlassBleConnectedDeviceUpdate$1(StarryDevice starryDevice, ConnectionStateManager connectionStateManager, String str) {
        super(0);
        this.$device = starryDevice;
        this.this$0 = connectionStateManager;
        this.$deviceId = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.upuphone.xr.interconnect.entity.DeviceWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r6 = this;
            com.upuphone.runasone.device.StarryDevice r0 = r6.$device
            byte r0 = r0.getTerminalType()
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r1 = r6.this$0
            java.lang.String r1 = r1.getTag()
            java.lang.String r2 = r6.$deviceId
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "#"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " of type "
            r3.append(r2)
            r3.append(r0)
            java.lang.String r2 = " has updated info for ble connection."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r1, r2)
            com.upuphone.runasone.device.StarryDevice r1 = r6.$device
            boolean r1 = com.upuphone.xr.interconnect.business.connect.behavior.DeviceTraitsKt.isPrimary(r1)
            r2 = 0
            if (r1 == 0) goto L_0x008b
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r0 = r6.this$0
            java.util.Set r0 = r0._connectedPrimaryDevices
            java.lang.String r1 = r6.$deviceId
            java.util.Iterator r0 = r0.iterator()
        L_0x0044:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x005c
            java.lang.Object r3 = r0.next()
            r4 = r3
            com.upuphone.xr.interconnect.entity.DeviceWrapper r4 = (com.upuphone.xr.interconnect.entity.DeviceWrapper) r4
            java.lang.String r4 = r4.getId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
            if (r4 == 0) goto L_0x0044
            r2 = r3
        L_0x005c:
            com.upuphone.xr.interconnect.entity.DeviceWrapper r2 = (com.upuphone.xr.interconnect.entity.DeviceWrapper) r2
            if (r2 != 0) goto L_0x0061
            goto L_0x0066
        L_0x0061:
            com.upuphone.runasone.device.StarryDevice r0 = r6.$device
            r2.setOriginDevice(r0)
        L_0x0066:
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r0 = r6.this$0
            com.upuphone.xr.interconnect.entity.DeviceWrapper r0 = r0.connectedGlassDevice
            if (r0 == 0) goto L_0x00d7
            java.lang.String r1 = r6.$deviceId
            com.upuphone.runasone.device.StarryDevice r6 = r6.$device
            java.lang.String r2 = r0.getId()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x00d7
            com.upuphone.xr.interconnect.entity.StarryNetDevice r1 = r0.getDevice()
            int r2 = r6.getStatus()
            r1.setStatus(r2)
            r0.setOriginDevice(r6)
            goto L_0x00d7
        L_0x008b:
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r1 = r6.this$0
            java.util.concurrent.ConcurrentHashMap r1 = r1.connectedSecondaryDeviceMap
            java.lang.Byte r3 = java.lang.Byte.valueOf(r0)
            java.lang.Object r1 = r1.get(r3)
            com.upuphone.xr.interconnect.entity.DeviceWrapper r1 = (com.upuphone.xr.interconnect.entity.DeviceWrapper) r1
            if (r1 == 0) goto L_0x00a1
            java.lang.String r2 = r1.getId()
        L_0x00a1:
            java.lang.String r3 = r6.$deviceId
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x00d7
            com.upuphone.xr.interconnect.business.connect.ConnectionStateManager r2 = r6.this$0
            java.lang.String r2 = r2.getTag()
            java.lang.String r3 = r6.$deviceId
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Updating connected type-"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = " device #"
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = " info."
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.upuphone.xr.interconnect.util.log.ILog.d(r2, r0)
            com.upuphone.runasone.device.StarryDevice r6 = r6.$device
            r1.setOriginDevice(r6)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.ConnectionStateManager$onGlassBleConnectedDeviceUpdate$1.invoke():void");
    }
}

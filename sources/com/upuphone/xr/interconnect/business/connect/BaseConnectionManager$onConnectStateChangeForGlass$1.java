package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nBaseConnectionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/BaseConnectionManager$onConnectStateChangeForGlass$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1855#2,2:195\n*S KotlinDebug\n*F\n+ 1 BaseConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/BaseConnectionManager$onConnectStateChangeForGlass$1\n*L\n91#1:195,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BaseConnectionManager$onConnectStateChangeForGlass$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ boolean $isBleConnected;
    final /* synthetic */ boolean $isBrConnected;
    final /* synthetic */ BaseConnectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseConnectionManager$onConnectStateChangeForGlass$1(StarryDevice starryDevice, BaseConnectionManager baseConnectionManager, boolean z, boolean z2) {
        super(0);
        this.$device = starryDevice;
        this.this$0 = baseConnectionManager;
        this.$isBleConnected = z;
        this.$isBrConnected = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r11 = this;
            com.upuphone.runasone.device.StarryDevice r0 = r11.$device
            java.lang.String r0 = r0.getId()
            if (r0 != 0) goto L_0x0014
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r11 = r11.this$0
            java.lang.String r11 = r11.getTag()
            java.lang.String r0 = "Dropping null-id-device when handling connect state change."
            com.upuphone.xr.interconnect.util.log.ILog.w(r11, r0)
            return
        L_0x0014:
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            java.lang.String r1 = r1.getTag()
            boolean r2 = r11.$isBleConnected
            boolean r3 = r11.$isBrConnected
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "#"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r6 = " connect state update: BLE("
            r4.append(r6)
            r4.append(r2)
            java.lang.String r2 = ") BR("
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = ")."
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.upuphone.xr.interconnect.util.log.ILog.i(r1, r2)
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            java.util.Map r1 = r1.getGlassDeviceInfoMap()
            com.upuphone.runasone.device.StarryDevice r2 = r11.$device
            r1.put(r0, r2)
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            java.lang.String r1 = r1.getTag()
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r2 = r11.this$0
            java.util.Set r2 = r2.getBleConnectedGlassDeviceIds()
            boolean r2 = r2.contains(r0)
            r3 = 1
            r2 = r2 ^ r3
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r4 = r11.this$0
            java.util.Set r4 = r4.getBleConnectedGlassDeviceIds()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r0)
            java.lang.String r7 = ",in bleConnectDevices = "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = ",bleConnectedDeviceIds = "
            r6.append(r2)
            r6.append(r4)
            java.lang.String r2 = r6.toString()
            com.upuphone.xr.interconnect.util.log.ILog.i(r1, r2)
            boolean r1 = r11.$isBleConnected
            r2 = 0
            if (r1 == 0) goto L_0x00bd
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            java.util.Set r1 = r1.getBleConnectedGlassDeviceIds()
            boolean r1 = r1.contains(r0)
            if (r1 != 0) goto L_0x009f
            r7 = r3
            goto L_0x00be
        L_0x009f:
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            java.util.Set r1 = r1.getListeners()
            com.upuphone.runasone.device.StarryDevice r4 = r11.$device
            boolean r6 = r11.$isBrConnected
            java.util.Iterator r1 = r1.iterator()
        L_0x00ad:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00bd
            java.lang.Object r7 = r1.next()
            com.upuphone.xr.interconnect.business.connect.BaseConnectionListener r7 = (com.upuphone.xr.interconnect.business.connect.BaseConnectionListener) r7
            r7.onGlassBleConnectedDeviceUpdate(r0, r4, r6)
            goto L_0x00ad
        L_0x00bd:
            r7 = r2
        L_0x00be:
            boolean r1 = r11.$isBleConnected
            if (r1 != 0) goto L_0x00d0
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            java.util.Set r1 = r1.getBleConnectedGlassDeviceIds()
            boolean r1 = r1.contains(r0)
            if (r1 == 0) goto L_0x00d0
            r8 = r3
            goto L_0x00d1
        L_0x00d0:
            r8 = r2
        L_0x00d1:
            boolean r1 = r11.$isBrConnected
            if (r1 == 0) goto L_0x00e3
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            java.util.Set r1 = r1.brConnectedGlassDeviceIds
            boolean r1 = r1.contains(r0)
            if (r1 != 0) goto L_0x00e3
            r9 = r3
            goto L_0x00e4
        L_0x00e3:
            r9 = r2
        L_0x00e4:
            boolean r1 = r11.$isBrConnected
            if (r1 != 0) goto L_0x00f6
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            java.util.Set r1 = r1.brConnectedGlassDeviceIds
            boolean r1 = r1.contains(r0)
            if (r1 == 0) goto L_0x00f6
            r10 = r3
            goto L_0x00f7
        L_0x00f6:
            r10 = r2
        L_0x00f7:
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            java.lang.String r1 = r1.getTag()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r0)
            java.lang.String r3 = ",isBleConnectEvent = "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = ",isBleDisconnectEvent = "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = ",isBrConnectEvent = "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r3 = ",isBrDisconnectEvent = "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r3 = ","
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.upuphone.xr.interconnect.util.log.ILog.i(r1, r2)
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            r2 = r0
            r3 = r7
            r4 = r8
            r5 = r9
            r6 = r10
            r1.updateSavedGlassDeviceIds(r2, r3, r4, r5, r6)
            com.upuphone.xr.interconnect.business.connect.BaseConnectionManager r1 = r11.this$0
            com.upuphone.runasone.device.StarryDevice r3 = r11.$device
            boolean r4 = r11.$isBleConnected
            boolean r5 = r11.$isBrConnected
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r1.reportGlassEvents(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.BaseConnectionManager$onConnectStateChangeForGlass$1.invoke():void");
    }
}

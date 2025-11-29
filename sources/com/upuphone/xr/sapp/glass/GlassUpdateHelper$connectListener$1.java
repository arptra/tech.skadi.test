package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import com.upuphone.xr.sapp.bluetooth.BluetoothHelper;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nGlassUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassUpdateHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateHelper$connectListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1750:1\n1855#2,2:1751\n*S KotlinDebug\n*F\n+ 1 GlassUpdateHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateHelper$connectListener$1\n*L\n141#1:1751,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/glass/GlassUpdateHelper$connectListener$1", "Lcom/upuphone/xr/sapp/glass/DeviceConnectListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateHelper$connectListener$1 implements DeviceConnectListener {
    public void onDeviceConnected(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.d1("onDeviceConnected: " + starryNetDevice);
        if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            GlassUpdateHelper.n = starryNetDevice;
            for (Runnable run : GlassUpdateHelper.m) {
                run.run();
            }
            GlassUpdateHelper.m.clear();
            GlassUpdateHelper glassUpdateHelper2 = GlassUpdateHelper.b;
            GlassUpdateHelper.k0(glassUpdateHelper2, 0, false, 3, (Object) null);
            GlassUpdateHelper.i0(glassUpdateHelper2, 0, false, 3, (Object) null);
        }
    }

    public void onDeviceDisconnected(StarryNetDevice starryNetDevice) {
        String str;
        int i;
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.d1("onDeviceDisconnected: " + starryNetDevice);
        if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            GlassUpdateState L0 = glassUpdateHelper.L0();
            if (L0 != null) {
                glassUpdateHelper.d1("onDeviceDisconnected, glassUpdateState: " + L0);
                if (L0 instanceof GlassUpdateState.AirTransferring) {
                    glassUpdateHelper.d1("onDeviceDisconnected, TransferFail");
                    if (BluetoothHelper.f6650a.g()) {
                        i = 120;
                        str = null;
                    } else {
                        i = 124;
                        str = "disconnectReason: unknown";
                    }
                    String uuid = UUID.randomUUID().toString();
                    Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                    glassUpdateHelper.v1(new GlassUpdateState.TransferFail(uuid, ((GlassUpdateState.AirTransferring) L0).getGlassUpdateInfo(), i, str));
                } else if (L0 instanceof GlassUpdateState.WaitingUpdateDialogResult) {
                    glassUpdateHelper.d1("onDeviceDisconnected, UpdateDisconnected");
                    glassUpdateHelper.v1(new GlassUpdateState.UpdateDisconnected(((GlassUpdateState.WaitingUpdateDialogResult) L0).getGlassUpdateInfo()));
                } else if (L0 instanceof GlassUpdateState.Installing) {
                    glassUpdateHelper.d1("onDeviceDisconnected, UpdateDisconnected");
                    glassUpdateHelper.v1(new GlassUpdateState.UpdateDisconnected(((GlassUpdateState.Installing) L0).getGlassUpdateInfo()));
                }
            }
            Job unused = BuildersKt__Builders_commonKt.d(glassUpdateHelper, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateHelper$connectListener$1$onDeviceDisconnected$2((Continuation<? super GlassUpdateHelper$connectListener$1$onDeviceDisconnected$2>) null), 3, (Object) null);
        }
    }
}

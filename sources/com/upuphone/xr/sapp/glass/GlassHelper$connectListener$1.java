package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.interconnect.common.IDeviceConnectionListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nGlassHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$connectListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,649:1\n1855#2,2:650\n1855#2,2:652\n*S KotlinDebug\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$connectListener$1\n*L\n81#1:650,2\n89#1:652,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/glass/GlassHelper$connectListener$1", "Lcom/upuphone/xr/interconnect/common/IDeviceConnectionListener$Stub;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassHelper$connectListener$1 extends IDeviceConnectionListener.Stub {
    public void onDeviceConnected(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            for (DeviceConnectListener onDeviceConnected : GlassHelper.d) {
                onDeviceConnected.onDeviceConnected(starryNetDevice);
            }
        }
    }

    public void onDeviceDisconnected(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            for (DeviceConnectListener onDeviceDisconnected : GlassHelper.d) {
                onDeviceDisconnected.onDeviceDisconnected(starryNetDevice);
            }
        }
    }
}

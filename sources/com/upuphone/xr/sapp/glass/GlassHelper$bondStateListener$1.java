package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceBondStateListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nGlassHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$bondStateListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,649:1\n1855#2,2:650\n*S KotlinDebug\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$bondStateListener$1\n*L\n100#1:650,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/glass/GlassHelper$bondStateListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceBondStateListener;", "onDeviceBondStateChange", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "newState", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassHelper$bondStateListener$1 extends DeviceBondStateListener {
    public void onDeviceBondStateChange(@NotNull StarryNetDevice starryNetDevice, int i) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassHelper", "onDeviceBondStateChange, device: " + starryNetDevice + ", newState: " + i);
        if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            for (DeviceBoundListener onDeviceBondStateChange : GlassHelper.i) {
                onDeviceBondStateChange.onDeviceBondStateChange(starryNetDevice, i);
            }
        }
    }
}

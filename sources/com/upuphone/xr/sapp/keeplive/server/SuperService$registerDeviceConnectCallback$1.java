package com.upuphone.xr.sapp.keeplive.server;

import android.os.Handler;
import com.honey.account.m8.a;
import com.upuphone.ar.translation.interconnect.entity.InterConnectDeviceExtKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/keeplive/server/SuperService$registerDeviceConnectCallback$1", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SuperService$registerDeviceConnectCallback$1 extends DeviceConnectionListener {
    final /* synthetic */ SuperService this$0;

    public SuperService$registerDeviceConnectCallback$1(SuperService superService) {
        this.this$0 = superService;
    }

    /* access modifiers changed from: private */
    public static final void onDeviceConnected$lambda$0(SuperService superService) {
        Intrinsics.checkNotNullParameter(superService, "this$0");
        superService.q(true, true);
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        String deviceName = starryNetDevice != null ? starryNetDevice.getDeviceName() : null;
        delegate.a("SuperService", "onDeviceConnected device is: " + deviceName);
        if (starryNetDevice != null && InterConnectDeviceExtKt.isXRDevice(starryNetDevice)) {
            this.this$0.g = true;
            Handler k = this.this$0.i;
            if (k != null) {
                k.postDelayed(new a(this.this$0), 400);
            }
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        String deviceName = starryNetDevice != null ? starryNetDevice.getDeviceName() : null;
        delegate.a("SuperService", "onDeviceDisconnected device is: " + deviceName);
        if (starryNetDevice != null && InterConnectDeviceExtKt.isXRDevice(starryNetDevice)) {
            this.this$0.g = false;
            this.this$0.q(false, true);
        }
    }
}

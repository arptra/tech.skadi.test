package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/xjmz/myvu/flutter/pigeon/impl/StarryNetApiHandler$initListener$3", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarryNetApiHandler$initListener$3 extends DeviceConnectionListener {
    final /* synthetic */ StarryNetApiHandler this$0;

    public StarryNetApiHandler$initListener$3(StarryNetApiHandler starryNetApiHandler) {
        this.this$0 = starryNetApiHandler;
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        if (starryNetDevice != null && XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsRing(starryNetDevice)) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("StarryNetApiHandler", "onDeviceConnected device: " + starryNetDevice);
            AndroidRingStarryNetApi.FlutterStarryNetApi P = this.this$0.m0();
            if (P != null) {
                P.m(this.this$0.p0(starryNetDevice), 1L, new StarryVoidResult());
            }
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        if (starryNetDevice != null && XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsRing(starryNetDevice)) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("StarryNetApiHandler", "onDeviceDisconnected device: " + starryNetDevice);
            AndroidRingStarryNetApi.FlutterStarryNetApi P = this.this$0.m0();
            if (P != null) {
                P.m(this.this$0.p0(starryNetDevice), 0L, new StarryVoidResult());
            }
        }
    }
}

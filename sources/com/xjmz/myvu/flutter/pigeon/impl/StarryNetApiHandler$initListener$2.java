package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.ring2.SportService;
import com.upuphone.xr.sapp.vu.utils.GlassDataStoreHelper;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/xjmz/myvu/flutter/pigeon/impl/StarryNetApiHandler$initListener$2", "Lcom/upuphone/xr/interconnect/common/IDeviceBondStateListener$Stub;", "onDeviceBondStateChange", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "newState", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarryNetApiHandler$initListener$2 extends IDeviceBondStateListener.Stub {
    final /* synthetic */ StarryNetApiHandler this$0;

    public StarryNetApiHandler$initListener$2(StarryNetApiHandler starryNetApiHandler) {
        this.this$0 = starryNetApiHandler;
    }

    public void onDeviceBondStateChange(@Nullable StarryNetDevice starryNetDevice, int i) {
        if (starryNetDevice != null && XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsRing(starryNetDevice)) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("StarryNetApiHandler", "onDeviceBondStateChange newState: " + i + " device: " + starryNetDevice);
            if (i != 1) {
                long j = 0;
                if (i == 0) {
                    String modelId = starryNetDevice.getModelId();
                    if (modelId != null) {
                        GlassDataStoreHelper.f8091a.h(ConnectExtKt.o(modelId));
                    }
                    SportService.f7826a.e(MainApplication.k.d());
                } else if (i == 2) {
                    String modelId2 = starryNetDevice.getModelId();
                    if (modelId2 != null) {
                        GlassDataStoreHelper.f8091a.k(ConnectExtKt.o(modelId2));
                    }
                    j = 4;
                }
                AndroidRingStarryNetApi.FlutterStarryNetApi P = this.this$0.m0();
                if (P != null) {
                    P.k(this.this$0.p0(starryNetDevice), Long.valueOf(j), new StarryVoidResult());
                }
                this.this$0.f0();
            }
        }
    }
}

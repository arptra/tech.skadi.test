package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/xjmz/myvu/flutter/pigeon/impl/StarryNetApiHandler$initListener$4", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceStateChangeListener;", "onBondStateChanged", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "newState", "", "onConnectFail", "type", "Lcom/upuphone/runasone/device/StarryDevice;", "code", "onConnectStateChanged", "onReceivePairingKey", "pairingKey", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarryNetApiHandler$initListener$4 implements StarryNetDeviceStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetApiHandler f8357a;

    public StarryNetApiHandler$initListener$4(StarryNetApiHandler starryNetApiHandler) {
        this.f8357a = starryNetApiHandler;
    }

    public void onBondStateChanged(StarryNetDevice starryNetDevice, int i) {
    }

    public void onConnectFail(int i, StarryDevice starryDevice, int i2) {
        if (starryDevice != null && XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsRing(starryDevice)) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("StarryNetApiHandler", "onConnectFail device: " + starryDevice);
            AndroidRingStarryNetApi.FlutterStarryNetApi P = this.f8357a.m0();
            if (P != null) {
                P.l(this.f8357a.o0(starryDevice), Long.valueOf((long) i), Long.valueOf((long) i2), new StarryVoidResult());
            }
        }
    }

    public void onConnectStateChanged(StarryNetDevice starryNetDevice, int i) {
    }

    public void onReceivePairingKey(StarryNetDevice starryNetDevice, String str) {
    }
}

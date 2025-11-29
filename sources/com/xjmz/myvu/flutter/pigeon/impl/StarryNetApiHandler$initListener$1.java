package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.api.StarryNetDeviceDiscoverListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"com/xjmz/myvu/flutter/pigeon/impl/StarryNetApiHandler$initListener$1", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;", "onDeviceFound", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceLose", "onError", "code", "", "onFastFound", "type", "beaconId", "onTimeout", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarryNetApiHandler$initListener$1 implements StarryNetDeviceDiscoverListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetApiHandler f8356a;

    public StarryNetApiHandler$initListener$1(StarryNetApiHandler starryNetApiHandler) {
        this.f8356a = starryNetApiHandler;
    }

    public void onDeviceFound(StarryNetDevice starryNetDevice) {
        if (starryNetDevice != null && XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsRing(starryNetDevice)) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("StarryNetApiHandler", "onDeviceFound: " + starryNetDevice);
            AndroidRingStarryNetApi.ScanDeviceCallback N = this.f8356a.k0();
            if (N != null) {
                N.j(this.f8356a.p0(starryNetDevice), StarryNetApiHandler.Y(this.f8356a, (byte[]) null, 1, (Object) null), this.f8356a.Z(), new StarryVoidResult());
            }
        }
    }

    public void onDeviceLose(StarryNetDevice starryNetDevice) {
        if (starryNetDevice != null && XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsRing(starryNetDevice)) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("StarryNetApiHandler", "onDeviceLose device: " + starryNetDevice);
            AndroidRingStarryNetApi.ScanDeviceCallback N = this.f8356a.k0();
            if (N != null) {
                N.h(this.f8356a.p0(starryNetDevice), new StarryVoidResult());
            }
        }
    }

    public void onError(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryNetApiHandler", "onError code: " + i);
    }

    public void onFastFound(StarryNetDevice starryNetDevice, int i, int i2) {
        if (starryNetDevice != null && XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsRing(starryNetDevice)) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("StarryNetApiHandler", "onFastFound device: " + starryNetDevice + " beaconId: " + i2);
            AndroidRingStarryNetApi.ScanDeviceCallback N = this.f8356a.k0();
            if (N != null) {
                N.i(this.f8356a.p0(starryNetDevice), Long.valueOf((long) i), this.f8356a.Z(), new StarryVoidResult());
            }
        }
    }

    public void onTimeout() {
        ULog.f6446a.g("StarryNetApiHandler", "discover onTimeout");
    }
}

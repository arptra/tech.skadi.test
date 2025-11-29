package com.xjmz.myvu.modules.main.connect;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.api.StarryNetDeviceDiscoverListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.xjmz.myvu.modules.main.connect.ConnectProcess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"com/xjmz/myvu/modules/main/connect/ConnectProcess$discoverListener$1", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "deivce", "", "onDeviceFound", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)V", "device", "", "type", "beaconId", "onFastFound", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;II)V", "onDeviceLose", "onTimeout", "()V", "p0", "onError", "(I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ConnectProcess$discoverListener$1 implements StarryNetDeviceDiscoverListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectProcess f8369a;

    public void onDeviceFound(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "deivce");
    }

    public void onDeviceLose(StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ConnectProcess", "onDeviceLose() called with: device = " + starryNetDevice);
    }

    public void onError(int i) {
        ULog.f6446a.g("ConnectProcess", "onError-> ");
    }

    public void onFastFound(StarryNetDevice starryNetDevice, int i, int i2) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ConnectProcess", "onFastFound() called with: device = " + starryNetDevice + ", type = " + i + ", beaconId = " + i2);
        if (!Intrinsics.areEqual((Object) starryNetDevice.getDeviceId(), (Object) this.f8369a.f) && this.f8369a.e == ConnectProcess.State.INIT && System.currentTimeMillis() - this.f8369a.d > 5000) {
            delegate.g("ConnectProcess", "onFastFound() called with: device = " + starryNetDevice + ", type = " + i + ", beaconId = " + i2);
            this.f8369a.d = System.currentTimeMillis();
            ConnectProcess connectProcess = this.f8369a;
            String deviceId = starryNetDevice.getDeviceId();
            Intrinsics.checkNotNullExpressionValue(deviceId, "getDeviceId(...)");
            connectProcess.f = deviceId;
            if (this.f8369a.k() == null) {
                this.f8369a.l(starryNetDevice);
            }
        }
    }

    public void onTimeout() {
        ULog.f6446a.g("ConnectProcess", "onTimeout-> ");
    }
}

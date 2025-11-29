package com.upuphone.xr.sapp.vm;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.device.connection.ConnectionListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/vm/Ring2ControlViewModel$initConnectionListener$1", "Lcom/upuphone/starrynetsdk/device/connection/ConnectionListener;", "onBondStateChange", "", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "newState", "", "onConnectStateChange", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Ring2ControlViewModel$initConnectionListener$1 implements ConnectionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ring2ControlViewModel f8007a;

    public Ring2ControlViewModel$initConnectionListener$1(Ring2ControlViewModel ring2ControlViewModel) {
        this.f8007a = ring2ControlViewModel;
    }

    public void onBondStateChange(StarryDevice starryDevice, int i) {
    }

    public void onConnectStateChange(StarryDevice starryDevice, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        String str = null;
        String name = starryDevice != null ? starryDevice.getName() : null;
        if (starryDevice != null) {
            str = starryDevice.getId();
        }
        delegate.g("Ring2ControlViewModel", "onConnectStateChange device: " + name + " id: " + str + " newState: " + i);
        if (starryDevice != null && starryDevice.getTerminalType() == 5) {
            if (i == 1) {
                this.f8007a.h(starryDevice);
            } else {
                this.f8007a.p(starryDevice);
            }
        }
    }
}

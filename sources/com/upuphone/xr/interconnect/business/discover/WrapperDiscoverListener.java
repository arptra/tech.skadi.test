package com.upuphone.xr.interconnect.business.discover;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.device.discovery.DiscoverListener;
import com.upuphone.xr.interconnect.api.StarryNetDeviceDiscoverListener;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/interconnect/business/discover/WrapperDiscoverListener;", "Lcom/upuphone/starrynetsdk/device/discovery/DiscoverListener;", "listener", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;", "(Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;)V", "onDeviceFound", "", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "data", "", "onDeviceLose", "onDeviceRequestConnect", "starryDevice", "onError", "code", "", "onFastFound", "type", "beaconId", "onTimeout", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WrapperDiscoverListener implements DiscoverListener {
    @Nullable
    private final StarryNetDeviceDiscoverListener listener;

    public WrapperDiscoverListener(@Nullable StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener) {
        this.listener = starryNetDeviceDiscoverListener;
    }

    public void onDeviceFound(@Nullable StarryDevice starryDevice, @Nullable byte[] bArr) {
        StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener;
        if (starryDevice != null && (starryNetDeviceDiscoverListener = this.listener) != null) {
            starryNetDeviceDiscoverListener.onDeviceFound(StarryDeviceExt.wrapForDiscovery(starryDevice));
        }
    }

    public void onDeviceLose(@Nullable StarryDevice starryDevice) {
        StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener;
        if (starryDevice != null && (starryNetDeviceDiscoverListener = this.listener) != null) {
            starryNetDeviceDiscoverListener.onDeviceLose(StarryDeviceExt.wrapForDiscovery(starryDevice));
        }
    }

    public void onDeviceRequestConnect(@Nullable StarryDevice starryDevice, @Nullable byte[] bArr) {
    }

    public void onError(int i) {
        StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener = this.listener;
        if (starryNetDeviceDiscoverListener != null) {
            starryNetDeviceDiscoverListener.onError(i);
        }
    }

    public void onFastFound(@Nullable StarryDevice starryDevice, int i, int i2) {
        StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener;
        if (starryDevice != null && (starryNetDeviceDiscoverListener = this.listener) != null) {
            starryNetDeviceDiscoverListener.onFastFound(StarryDeviceExt.wrapForDiscovery(starryDevice), i, i2);
        }
    }

    public void onTimeout() {
        StarryNetDeviceDiscoverListener starryNetDeviceDiscoverListener = this.listener;
        if (starryNetDeviceDiscoverListener != null) {
            starryNetDeviceDiscoverListener.onTimeout();
        }
    }
}

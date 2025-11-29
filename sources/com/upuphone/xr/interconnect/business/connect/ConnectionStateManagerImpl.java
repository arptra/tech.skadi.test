package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateManagerImpl;", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateManager;", "bondStateManager", "Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;", "listenerLinkingCollector", "Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateListener;", "primaryDeviceConnectionListenerLinkingCollector", "Lcom/upuphone/xr/interconnect/business/connect/BlePrimaryDeviceConnectionListener;", "(Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;)V", "onGlassBleConnected", "", "deviceId", "", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "isBrConnected", "", "onGlassBrConnected", "isBleConnected", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConnectionStateManagerImpl extends ConnectionStateManager {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionStateManagerImpl(@NotNull BondStateManager bondStateManager, @NotNull ListenerLinkingCollector<ConnectionStateListener> listenerLinkingCollector, @NotNull ListenerLinkingCollector<BlePrimaryDeviceConnectionListener> listenerLinkingCollector2) {
        super(bondStateManager, listenerLinkingCollector, listenerLinkingCollector2);
        Intrinsics.checkNotNullParameter(bondStateManager, "bondStateManager");
        Intrinsics.checkNotNullParameter(listenerLinkingCollector, "listenerLinkingCollector");
        Intrinsics.checkNotNullParameter(listenerLinkingCollector2, "primaryDeviceConnectionListenerLinkingCollector");
    }

    public void onGlassBleConnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("ble connection", new ConnectionStateManagerImpl$onGlassBleConnected$1(starryDevice, this, str, z));
    }

    public void onGlassBrConnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("br connection", new ConnectionStateManagerImpl$onGlassBrConnected$1(starryDevice, this, str, z));
    }
}

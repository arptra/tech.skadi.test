package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0016J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/BondStateManagerImpl;", "Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;", "bondStateListenerLinkingCollector", "Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;", "Lcom/upuphone/xr/interconnect/business/connect/BondStateListener;", "(Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;)V", "onGlassBleBound", "", "deviceId", "", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "isBrBound", "", "onGlassBleUnbound", "onGlassBrBound", "isBleBound", "onGlassBrUnbound", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BondStateManagerImpl extends BondStateManager {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BondStateManagerImpl(@NotNull ListenerLinkingCollector<BondStateListener> listenerLinkingCollector) {
        super(listenerLinkingCollector);
        Intrinsics.checkNotNullParameter(listenerLinkingCollector, "bondStateListenerLinkingCollector");
    }

    public void onGlassBleBound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("ble binding", new BondStateManagerImpl$onGlassBleBound$1(this, str, z, starryDevice));
    }

    public void onGlassBleUnbound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("ble unbinding", new BondStateManagerImpl$onGlassBleUnbound$1(this, str, z, starryDevice));
    }

    public void onGlassBrBound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("br binding", new BondStateManagerImpl$onGlassBrBound$1(this, str, z, starryDevice));
    }

    public void onGlassBrUnbound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("br unbinding", new BondStateManagerImpl$onGlassBrUnbound$1(this, str, z, starryDevice));
    }
}

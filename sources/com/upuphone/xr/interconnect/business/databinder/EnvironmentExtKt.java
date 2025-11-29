package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0002"}, d2 = {"getConnectedDeviceId", "", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class EnvironmentExtKt {
    @Nullable
    public static final String getConnectedDeviceId() {
        StarryNetDeviceManager starryNetDeviceManager;
        StarryDevice connectedDevice;
        InterconnectManager instance = InterconnectManager.getInstance();
        if (instance == null || (starryNetDeviceManager = instance.getStarryNetDeviceManager()) == null || (connectedDevice = starryNetDeviceManager.getConnectedDevice()) == null) {
            return null;
        }
        return connectedDevice.getId();
    }
}

package com.upuphone.starrynetsdk.ability.relay;

import com.upuphone.runasone.device.StarryDevice;
import java.util.List;

public interface RelayListener {
    void onRelay(String str, String str2, byte[] bArr);

    void onRelayDeviceListChanged(String str, List<StarryDevice> list) {
    }

    void onRemoteError(String str, String str2, int i);

    void onRemoteStarted(String str, String str2);

    void onRemoteStopped(String str, String str2);

    @Deprecated
    void onRelayDeviceListChanged(List<StarryDevice> list) {
    }
}

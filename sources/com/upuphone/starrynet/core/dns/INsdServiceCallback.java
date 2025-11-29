package com.upuphone.starrynet.core.dns;

import android.net.nsd.NsdServiceInfo;

public interface INsdServiceCallback {
    void onServiceFound(NsdServiceInfo nsdServiceInfo);

    void onServiceLost(NsdServiceInfo nsdServiceInfo);

    void onServiceRegisterStatus(NsdServiceInfo nsdServiceInfo, int i, boolean z);

    void onServiceResolvedStatus(NsdServiceInfo nsdServiceInfo, int i, boolean z);

    void onServiceUnregisterStatus(NsdServiceInfo nsdServiceInfo, int i, boolean z);

    void onStartDiscoveryStatus(String str, int i, boolean z);

    void onStopDiscoveryStatus(String str, int i, boolean z);
}

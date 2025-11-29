package com.upuphone.xr.interconnect.listener;

import android.os.Bundle;

public interface CastStateListener {
    void onCastError(int i);

    void onChannelConnected();

    void onChannelDisconnected();

    void onReceiveEvent(int i, Bundle bundle);
}

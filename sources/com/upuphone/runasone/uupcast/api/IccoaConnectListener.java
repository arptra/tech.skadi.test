package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;

@Hub
public interface IccoaConnectListener {
    void onConnectEvent(int i, @Parcelable Bundle bundle);
}

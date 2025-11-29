package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;

@Hub
public interface IVirtualDeviceEventListener {
    void onError(int i, String str);

    void onEvent(int i, @Parcelable Bundle bundle);
}

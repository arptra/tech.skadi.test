package com.upuphone.xr.interconnect.main.dispatcher;

import com.upuphone.xr.interconnect.entity.StarryNetFile;

public interface FileTransportEventDispatcher {
    void dispatchFailEvent(String str, String str2, int i);

    void dispatchProgressChangedEvent(String str, String str2, int i);

    void dispatchStartEvent(String str, String str2, StarryNetFile starryNetFile);

    void dispatchSuccessEvent(String str, String str2, String str3);
}

package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.common.IFileSendListener;
import com.upuphone.xr.interconnect.entity.StarryNetFile;

public interface StarryNetFileTransfer {
    void cancel(String str);

    void sendFile(StarryNetFile starryNetFile, IFileSendListener iFileSendListener);
}

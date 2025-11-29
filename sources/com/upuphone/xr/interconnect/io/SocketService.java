package com.upuphone.xr.interconnect.io;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.io.process.SocketMessageSendListener;

public interface SocketService {
    void release();

    void sendMessage(StarryNetMessage starryNetMessage, SocketMessageSendListener socketMessageSendListener);

    void setOnSocketStateChangeListener(OnSocketStateChangeListener onSocketStateChangeListener);

    void start();
}

package com.upuphone.xr.interconnect.main.handler;

import com.upuphone.xr.interconnect.entity.FunctionType;

public interface MessageHandlerManager {
    void addHandler(MessageHandler messageHandler);

    MessageHandler getHandler(@FunctionType int i);
}

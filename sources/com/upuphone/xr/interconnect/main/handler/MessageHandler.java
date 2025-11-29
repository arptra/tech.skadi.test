package com.upuphone.xr.interconnect.main.handler;

import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.FunctionType;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;

public interface MessageHandler {
    @FunctionType
    int getHandleType();

    void handle(StarryNetMessage starryNetMessage, Function function);
}

package com.xjsd.ai.assistant.common.handler;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.protocol.Cmd;

public interface CmdHandler {
    int getHandleCode();

    void handle(StarryNetMessage starryNetMessage, Cmd cmd);
}

package com.xjsd.ai.assistant.phone.cmd;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.helper.ExitTimer;
import com.xjsd.ai.assistant.protocol.Cmd;

public class ResetVrListeningTimeCmdHandler implements CmdHandler {
    public int getHandleCode() {
        return 124;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        ILog.a("ResetVrListeningTimeCmdHandler", "收到重置asr listening计时信息请求->" + starryNetMessage.getMessage());
        ExitTimer.f8563a.d();
    }
}

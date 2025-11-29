package com.xjsd.ai.assistant.phone.cmd;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.WakeupControlDelegate;
import com.xjsd.ai.assistant.protocol.Cmd;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;

public class WakeupReqCmdHandler implements CmdHandler {
    public int getHandleCode() {
        return 3;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        ILog.a("WakeupReqCmdHandler", "收到通用语音唤醒指令->" + starryNetMessage.getMessage());
        WakeupControlDelegate.g.i((WakeupControl) cmd.parsePayload(WakeupControl.class));
    }
}

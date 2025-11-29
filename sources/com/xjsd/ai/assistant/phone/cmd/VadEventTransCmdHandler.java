package com.xjsd.ai.assistant.phone.cmd;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.cloud.CloudAbility;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.Cmd;

public class VadEventTransCmdHandler implements CmdHandler {
    public int getHandleCode() {
        return 104;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        ILog.a("VadEventTransCmdHandler", "收到vad事件通知->" + starryNetMessage.getMessage());
        if (((Integer) cmd.parsePayload(Integer.class)).intValue() == 2) {
            ((CloudAbility) AbilityManager.b.b(CloudAbility.class)).flush();
        }
    }
}

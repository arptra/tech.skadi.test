package com.xjsd.ai.assistant.phone.cmd;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.helper.HotWordMaintainer;
import com.xjsd.ai.assistant.protocol.Cmd;
import com.xjsd.ai.assistant.protocol.stks.StksHotWordTransInfo;

public class HotWordTransCmdHandler implements CmdHandler {
    public int getHandleCode() {
        return 108;
    }

    public void handle(StarryNetMessage starryNetMessage, Cmd cmd) {
        ILog.a("HotWordTransCmdHandler", "收到眼镜上传热词数据->" + starryNetMessage.getMessage());
        HotWordMaintainer.f8564a.b((StksHotWordTransInfo) cmd.parsePayload(StksHotWordTransInfo.class));
    }
}

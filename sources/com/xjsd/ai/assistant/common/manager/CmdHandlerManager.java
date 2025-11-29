package com.xjsd.ai.assistant.common.manager;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.handler.CmdHandler;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.Cmd;
import java.util.HashMap;
import java.util.Map;

public class CmdHandlerManager {

    /* renamed from: a  reason: collision with root package name */
    public final Map f8432a = new HashMap();

    public void a(CmdHandler cmdHandler) {
        ILog.a("CmdHandlerManager", "注册CMD处理器，处理code->" + cmdHandler.getHandleCode());
        this.f8432a.put(Integer.valueOf(cmdHandler.getHandleCode()), cmdHandler);
    }

    public final CmdHandler b(int i) {
        return (CmdHandler) this.f8432a.get(Integer.valueOf(i));
    }

    public void c(StarryNetMessage starryNetMessage, Cmd cmd) {
        CmdHandler b = b(cmd.getCode());
        if (b != null) {
            b.handle(starryNetMessage, cmd);
            return;
        }
        ILog.a("CmdHandlerManager", cmd.getCode() + "对应Handler不存在");
    }
}

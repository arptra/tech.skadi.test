package com.xjsd.ai.assistant.common;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.Cmd;

public class Communicator {
    public static void a(BusinessDataType businessDataType, Object obj, SendMsgCallback sendMsgCallback) {
        b(103, new BusinessData(businessDataType, obj), sendMsgCallback);
    }

    public static void b(int i, Object obj, SendMsgCallback sendMsgCallback) {
        Cmd cmd = new Cmd(i);
        cmd.setPayload(obj);
        d(StarryNetMessageFactory.a(cmd), sendMsgCallback);
    }

    public static void c(int i, Object obj, byte[] bArr, SendMsgCallback sendMsgCallback) {
        Cmd cmd = new Cmd(i);
        cmd.setPayload(obj);
        StarryNetMessage a2 = StarryNetMessageFactory.a(cmd);
        a2.setData(bArr);
        d(a2, sendMsgCallback);
    }

    public static void d(StarryNetMessage starryNetMessage, SendMsgCallback sendMsgCallback) {
        InterconnectAbility interconnectAbility = (InterconnectAbility) AbilityManager.b.b(InterconnectAbility.class);
        if (interconnectAbility != null) {
            interconnectAbility.send(starryNetMessage, sendMsgCallback);
            return;
        }
        ILog.g("Communicator", "send cmd failed, the interconnect ability is null");
        sendMsgCallback.onFail(-1, "The interconnect ability is null");
    }
}

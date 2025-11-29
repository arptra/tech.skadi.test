package com.xjsd.ai.assistant.common;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.protocol.AssistantConstants;

public final class StarryNetMessageFactory {
    public static StarryNetMessage a(Object obj) {
        return b(AssistantConstants.APPLICATION_ID, obj);
    }

    public static StarryNetMessage b(String str, Object obj) {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setReceiverPkg(str);
        starryNetMessage.setMessage(GsonUtils.e(obj));
        return starryNetMessage;
    }
}

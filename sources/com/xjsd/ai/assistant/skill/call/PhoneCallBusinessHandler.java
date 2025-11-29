package com.xjsd.ai.assistant.skill.call;

import com.xjsd.ai.assistant.common.handler.BusinessHandler;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.call.PhoneBusinessData;
import org.greenrobot.eventbus.EventBus;

public class PhoneCallBusinessHandler implements BusinessHandler {
    public void a(BusinessData businessData) {
        ILog.a("PhoneCallBusinessHandler", "收到电话业务数据->" + businessData.getData());
        EventBus.c().k((PhoneBusinessData) businessData.parseData(PhoneBusinessData.class));
    }

    public BusinessDataType getHandleType() {
        return BusinessDataType.PHONE;
    }
}

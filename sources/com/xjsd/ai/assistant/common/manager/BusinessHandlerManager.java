package com.xjsd.ai.assistant.common.manager;

import com.xjsd.ai.assistant.common.handler.BusinessHandler;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import java.util.HashMap;
import java.util.Map;

public class BusinessHandlerManager {

    /* renamed from: a  reason: collision with root package name */
    public final Map f8431a = new HashMap();

    public void a(BusinessHandler businessHandler) {
        ILog.a("BusinessHandlerManager", "注册业务处理器，类型->" + businessHandler.getHandleType());
        this.f8431a.put(businessHandler.getHandleType(), businessHandler);
    }

    public boolean b(BusinessData businessData) {
        BusinessDataType dataType = businessData.getDataType();
        BusinessHandler businessHandler = (BusinessHandler) this.f8431a.get(dataType);
        if (businessHandler != null) {
            businessHandler.a(businessData);
            return true;
        }
        ILog.a("BusinessHandlerManager", dataType + "->对应业务Handler不存在");
        return false;
    }
}

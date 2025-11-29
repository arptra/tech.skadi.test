package com.xjsd.ai.assistant.common.handler;

import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.BusinessDataType;

public interface BusinessHandler {
    void a(BusinessData businessData);

    BusinessDataType getHandleType();
}

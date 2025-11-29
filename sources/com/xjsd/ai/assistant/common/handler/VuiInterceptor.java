package com.xjsd.ai.assistant.common.handler;

import com.xjsd.ai.assistant.protocol.VuiModel;

public interface VuiInterceptor {
    boolean a(VuiModel vuiModel);

    String getIdentifier();
}

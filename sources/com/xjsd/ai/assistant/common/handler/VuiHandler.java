package com.xjsd.ai.assistant.common.handler;

import com.xjsd.ai.assistant.protocol.VuiModel;

public interface VuiHandler {
    boolean a(VuiModel vuiModel);

    String getHandleType();
}

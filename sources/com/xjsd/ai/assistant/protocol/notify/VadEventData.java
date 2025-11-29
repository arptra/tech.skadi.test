package com.xjsd.ai.assistant.protocol.notify;

import com.xjsd.ai.assistant.core.bean.SessionData;

public class VadEventData extends SessionData {
    private int type;

    public VadEventData(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}

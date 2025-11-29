package com.xjsd.ai.assistant.protocol.vui;

import java.io.Serializable;

public class MetaData implements Serializable {
    private String msgId;

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }
}
